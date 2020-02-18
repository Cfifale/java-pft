package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.stqa.pft.addressbook.model.AddressData;

import java.util.concurrent.TimeUnit;

public class ApplicationManagerAddress {
    public WebDriver wd;

    public void init() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/");
        login("admin", "secret");
    }

    public void login(String username, String password) {
        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys(username);
        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).sendKeys(password);
        wd.findElement(By.xpath("//input[@value='Login']")).click();
    }

    public void logout() {
        wd.findElement(By.linkText("Logout")).click();
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

    public void stop() {
        logout();
        wd.quit();
    }
}
