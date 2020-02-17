package ru.stqa.pft.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class AddressCreationTests {
    private WebDriver wd;

    @BeforeMethod
    public void setUp() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/");
        login("admin", "secret");
    }

    private void login(String username, String password) {
        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys(username);
        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).sendKeys(password);
        wd.findElement(By.xpath("//input[@value='Login']")).click();
    }

    @Test
    public void testsGroupCreation() {
        initAddressCreation();
        fillAddressForm(new AddressData("Иван", "Иванович", "Иванов", "ivanov", "г. Москва", "+7(495)111-11-11", "+7(915)111-11-11", "+7(495)100-10-10", "ivanov@sitehome.ru", "ivanov@sitehome.com", "ivanov@sitehome.me", "www.sitehome.ru"));
        submitAddressCreation();
        returnToHomePage();
    }

    private void logout() {
        wd.findElement(By.linkText("Logout")).click();
    }

    private void returnToHomePage() {
        wd.findElement(By.linkText("home page")).click();
    }

    private void submitAddressCreation() {
        wd.findElement(By.xpath("//body//input[21]")).click();
    }

    private void fillAddressForm(AddressData addressData) {
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

    private void initAddressCreation() {
        wd.findElement(By.linkText("add new")).click();
    }

    @AfterMethod
    public void tearDown() {
        logout();
        wd.quit();
    }
}
