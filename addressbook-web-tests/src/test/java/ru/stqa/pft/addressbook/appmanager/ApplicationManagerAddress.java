package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManagerAddress {
    public ChromeDriver wd;

    private SessionHelperAddress sessionHelperAddress;
    private AddressHelper addressHelper;

    public void init() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/");
        sessionHelperAddress = new SessionHelperAddress(wd);
        addressHelper = new AddressHelper(wd);
        sessionHelperAddress.login("admin", "secret");
    }

    public AddressHelper getAddressHelper() {
        return addressHelper;
    }

    public void stop() {
        sessionHelperAddress.logout();
        wd.quit();
    }
}
