package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.stqa.pft.addressbook.model.AddressData;

public class AddressHelper {
    private ChromeDriver wd;

    public AddressHelper(ChromeDriver wd) {
        this.wd = wd;
    }

    public void returnToHomePage() {
        wd.findElement(By.linkText("home page")).click();
    }

    public void submitAddressCreation() {
        wd.findElement(By.xpath("//body//input[21]")).click();
    }

    public void fillAddressForm(AddressData addressData) {
        wd.findElement(By.xpath("//input[@name='firstname']")).click();
        wd.findElement(By.xpath("//input[@name='firstname']")).clear();
        wd.findElement(By.xpath("//input[@name='firstname']")).sendKeys(addressData.getFirstname());
        wd.findElement(By.xpath("//input[@name='middlename']")).click();
        wd.findElement(By.xpath("//input[@name='middlename']")).clear();
        wd.findElement(By.xpath("//input[@name='middlename']")).sendKeys(addressData.getMiddlename());
        wd.findElement(By.xpath("//input[@name='lastname']")).click();
        wd.findElement(By.xpath("//input[@name='lastname']")).clear();
        wd.findElement(By.xpath("//input[@name='lastname']")).sendKeys(addressData.getLastname());
        wd.findElement(By.xpath("//input[@name='nickname']")).click();
        wd.findElement(By.xpath("//input[@name='nickname']")).clear();
        wd.findElement(By.xpath("//input[@name='nickname']")).sendKeys(addressData.getNickname());
        wd.findElement(By.xpath("//textarea[@name='address']")).click();
        wd.findElement(By.xpath("//textarea[@name='address']")).clear();
        wd.findElement(By.xpath("//textarea[@name='address']")).sendKeys(addressData.getAddress());
        wd.findElement(By.xpath("//input[@name='home']")).click();
        wd.findElement(By.xpath("//input[@name='home']")).clear();
        wd.findElement(By.xpath("//input[@name='home']")).sendKeys(addressData.getHome());
        wd.findElement(By.xpath("//input[@name='mobile']")).click();
        wd.findElement(By.xpath("//input[@name='mobile']")).clear();
        wd.findElement(By.xpath("//input[@name='mobile']")).sendKeys(addressData.getMobile());
        wd.findElement(By.xpath("//input[@name='work']")).click();
        wd.findElement(By.xpath("//input[@name='work']")).clear();
        wd.findElement(By.xpath("//input[@name='work']")).sendKeys(addressData.getWork());
        wd.findElement(By.xpath("//input[@name='email']")).click();
        wd.findElement(By.xpath("//input[@name='email']")).clear();
        wd.findElement(By.xpath("//input[@name='email']")).sendKeys(addressData.getEmail());
        wd.findElement(By.xpath("//input[@name='email2']")).click();
        wd.findElement(By.xpath("//input[@name='email2']")).clear();
        wd.findElement(By.xpath("//input[@name='email2']")).sendKeys(addressData.getEmail2());
        wd.findElement(By.xpath("//input[@name='email3']")).click();
        wd.findElement(By.xpath("//input[@name='email3']")).clear();
        wd.findElement(By.xpath("//input[@name='email3']")).sendKeys(addressData.getEmail3());
        wd.findElement(By.xpath("//input[@name='homepage']")).click();
        wd.findElement(By.xpath("//input[@name='homepage']")).clear();
        wd.findElement(By.xpath("//input[@name='homepage']")).sendKeys(addressData.getHomepage());
    }

    public void initAddressCreation() {
        wd.findElement(By.linkText("add new")).click();
    }
}
