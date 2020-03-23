package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.AddressData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;

public class AddressHelper extends HelperBase {

    public AddressHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToHomePage() {
        click(By.linkText("home page"));
    }

    public void submitAddressCreation() {
        click(By.xpath("//body//input[21]"));
    }

    public void fillAddressForm(AddressData addressData, boolean creation) {
        type(By.xpath("//input[@name='firstname']"), addressData.getFirstname());
        type(By.xpath("//input[@name='middlename']"), addressData.getMiddlename());
        type(By.xpath("//input[@name='lastname']"), addressData.getLastname());
        type(By.xpath("//input[@name='nickname']"), addressData.getNickname());
        type(By.xpath("//textarea[@name='address']"), addressData.getAddress());
        type(By.xpath("//input[@name='home']"), addressData.getHome());
        type(By.xpath("//input[@name='mobile']"), addressData.getMobile());
        type(By.xpath("//input[@name='work']"), addressData.getWork());
        type(By.xpath("//input[@name='email']"), addressData.getEmail());
        type(By.xpath("//input[@name='email2']"), addressData.getEmail2());
        type(By.xpath("//input[@name='email3']"), addressData.getEmail3());
        type(By.xpath("//input[@name='homepage']"), addressData.getHomepage());

        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(addressData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void initAddressCreation() {
        click(By.linkText("add new"));
    }

    private void selectAddressById(int id) {
        wd.findElement(By.cssSelector("input[value = '" + id + "']")).click();
    }

    public void deleteSelectAddress() {
        click(By.xpath("//*[@value='Delete']"));
        wd.switchTo().alert().accept();
    }

    public AddressData infoFromEditForm(AddressData contact) {
        initAddressModificationById(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        wd.navigate().back();
        return new AddressData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname)
                .withHome(home).withMobile(mobile).withWork(work);
    }

    public void initAddressModificationById(int id) {
        wd.findElement(By.cssSelector("a[href = 'edit.php?id="+id+"']")).click();
    }

    public void submitAddressModification() {
        click(By.xpath("//*[@value='Update']"));
    }

    public void create(AddressData address) {
        initAddressCreation();
        fillAddressForm(address, true);
        submitAddressCreation();
        returnToHomePage();
    }

    public void modify(AddressData contact) {
        initAddressModificationById(contact.getId());
        fillAddressForm(contact,false);
        submitAddressModification();
        returnToHomePage();
    }

    public void delete(AddressData address) {
        selectAddressById(address.getId());
        deleteSelectAddress();
    }

    public boolean isThereAnAddress() {
        return isElementPresent(By.xpath("//*[@alt='Edit']"));
    }

    public Contacts all() {
        Contacts contacts = new Contacts();
        List<WebElement> elements = wd.findElements(By.cssSelector("tr[name=entry]"));
        for (WebElement element : elements) {
            String lastname = element.findElement(By.xpath("td[2]")).getText();
            String firstname = element.findElement(By.xpath("td[3]")).getText();
            String[] phones = element.findElement(By.xpath("td[6]")).getText().split("\n");
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
            contacts.add(new AddressData().withId(id).withFirstname(firstname).withLastname(lastname)
                    .withHome(phones[0]).withMobile(phones[1]).withWork(phones[2]));
        }
        return contacts;
    }
}
