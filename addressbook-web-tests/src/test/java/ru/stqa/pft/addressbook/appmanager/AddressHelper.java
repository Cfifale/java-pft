package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.stqa.pft.addressbook.model.AddressData;

public class AddressHelper extends HelperBase {

    public AddressHelper(ChromeDriver wd) {
        super(wd);
    }

    public void returnToHomePage() {
        click(By.linkText("home page"));
    }

    public void submitAddressCreation() {
        click(By.xpath("//body//input[21]"));
    }

    public void fillAddressForm(AddressData addressData) {
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
    }

    public void initAddressCreation() {
        click(By.linkText("add new"));
    }

    public void selectAddress() {
        click(By.name("selected[]"));
    }

    public void deleteSelectAddress() {
        click(By.xpath("//*[@value='Delete']"));
        wd.switchTo().alert().accept();
    }

    public void initAddressModification() {
        click(By.xpath("//*[@alt='Edit']"));
    }

    public void submitAddressModification() {
        click(By.xpath("//*[@value='Update']"));
    }
}
