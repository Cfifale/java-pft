package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;

public class AddressModificationTests extends TestBase{

    @Test
    public void testAddressModification() {
        app.getAddressHelper().initAddressModification();
        app.getAddressHelper().fillAddressForm(new AddressData("Иван1", "Иванович1", "Иванов1", "ivanov1", "г. Москва1", "+7(111)111-11-11", "+7(111)111-11-11", "+7(111)100-10-10", "ivanov1@sitehome.ru", "ivanov1@sitehome.com", "ivanov1@sitehome.me", "www.sitehome1.ru", null), false);
        app.getAddressHelper().submitAddressModification();
        app.getAddressHelper().returnToHomePage();
    }
}
