package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.AddressData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
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

    public void selectAddress(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void deleteSelectAddress() {
        click(By.xpath("//*[@value='Delete']"));
        wd.switchTo().alert().accept();
    }

    public void initAddressModification(int index) {
        wd.findElements(By.xpath("//*[@alt='Edit']")).get(index).click();
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

    public void modify(int index, AddressData contact) {
        initAddressModification(index);
        fillAddressForm(contact,false);
        submitAddressModification();
        returnToHomePage();
    }

    public void delete(int index) {
        selectAddress(index);
        deleteSelectAddress();
    }

    public boolean isThereAnAddress() {
        return isElementPresent(By.xpath("//*[@alt='Edit']"));
    }

    public List<AddressData> list() {
        List<AddressData> contacts = new ArrayList<AddressData>();
        List<WebElement> elements = wd.findElements(By.cssSelector("tr[name=entry]"));
        for (WebElement element : elements) {
            String firstname = element.findElement(By.xpath("td[3]")).getText();;
            String lastname = element.findElement(By.xpath("td[2]")).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
            AddressData contact = new AddressData(id,firstname, null, lastname, null, null, null, null, null, null, null, null, null, null);
            contacts.add(contact);
        }
        return contacts;
    }
}
