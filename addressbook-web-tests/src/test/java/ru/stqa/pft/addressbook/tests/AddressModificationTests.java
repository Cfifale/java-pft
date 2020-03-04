package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class AddressModificationTests extends TestBase{

    @Test
    public void testAddressModification() {
        if (! app.getAddressHelper().isThereAnAddress()) {
            app.getAddressHelper().createAddress(new AddressData("Иван", "Иванович", "Иванов", "ivanov", "г. Москва", "+7(495)111-11-11", "+7(915)111-11-11", "+7(495)100-10-10", "ivanov@sitehome.ru", "ivanov@sitehome.com", "ivanov@sitehome.me", "www.sitehome.ru", "test2"));
        }
        List<AddressData> before = app.getAddressHelper().getAddressList();
        app.getAddressHelper().initAddressModification(before.size() - 1);
        AddressData contact = new AddressData(before.get(before.size() - 1).getId(),"Иван1", "Иванович1", "Иванов1", "ivanov1", "г. Москва1", "+7(111)111-11-11", "+7(111)111-11-11", "+7(111)100-10-10", "ivanov1@sitehome.ru", "ivanov1@sitehome.com", "ivanov1@sitehome.me", "www.sitehome1.ru", null);
        app.getAddressHelper().fillAddressForm(contact,false);
        app.getAddressHelper().submitAddressModification();
        app.getAddressHelper().returnToHomePage();
        List<AddressData> after = app.getAddressHelper().getAddressList();

        before.set(before.size() - 1,contact);

        Comparator<? super AddressData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
