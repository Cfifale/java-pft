package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;

public class AddressModificationTests extends TestBase{

    @Test
    public void testAddressModification() {
        if (! app.getAddressHelper().isThereAnAddress()) {
            app.getAddressHelper().createAddress(new AddressData("Иван", "Иванович", "Иванов", "ivanov", "г. Москва", "+7(495)111-11-11", "+7(915)111-11-11", "+7(495)100-10-10", "ivanov@sitehome.ru", "ivanov@sitehome.com", "ivanov@sitehome.me", "www.sitehome.ru", "test2"));
        }
        app.getAddressHelper().initAddressModification();
        app.getAddressHelper().fillAddressForm(new AddressData("Иван1", "Иванович1", "Иванов1", "ivanov1", "г. Москва1", "+7(111)111-11-11", "+7(111)111-11-11", "+7(111)100-10-10", "ivanov1@sitehome.ru", "ivanov1@sitehome.com", "ivanov1@sitehome.me", "www.sitehome1.ru", null), false);
        app.getAddressHelper().submitAddressModification();
        app.getAddressHelper().returnToHomePage();
    }
}
