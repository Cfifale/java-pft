package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;
import ru.stqa.pft.addressbook.model.GroupData;

public class AddressDeletionTests extends TestBase {

    @Test
    public void testAddressDeletion() {
        if (! app.getAddressHelper().isThereAnAddress()) {
            app.getAddressHelper().createAddress(new AddressData("Иван", "Иванович", "Иванов", "ivanov", "г. Москва", "+7(495)111-11-11", "+7(915)111-11-11", "+7(495)100-10-10", "ivanov@sitehome.ru", "ivanov@sitehome.com", "ivanov@sitehome.me", "www.sitehome.ru", "test2"));
        }
        app.getAddressHelper().selectAddress();
        app.getAddressHelper().deleteSelectAddress();
    }
}
