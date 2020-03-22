package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;

import java.util.Comparator;
import java.util.List;

public class AddressModificationTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.address().list().size() == 0) {
            app.address().create(new AddressData("Иван", "Иванович", "Иванов", "ivanov", "г. Москва", "+7(495)111-11-11", "+7(915)111-11-11", "+7(495)100-10-10", "ivanov@sitehome.ru", "ivanov@sitehome.com", "ivanov@sitehome.me", "www.sitehome.ru", "test2"));
        }
    }

    @Test
    public void testAddressModification() {
        List<AddressData> before = app.address().list();
        int index = before.size() - 1;
        AddressData contact = new AddressData(before.get(index).getId(),"Иван1", "Иванович1", "Иванов1", "ivanov1", "г. Москва1", "+7(111)111-11-11", "+7(111)111-11-11", "+7(111)100-10-10", "ivanov1@sitehome.ru", "ivanov1@sitehome.com", "ivanov1@sitehome.me", "www.sitehome1.ru", null);
        app.address().modify(index, contact);
        List<AddressData> after = app.address().list();

        before.set(index,contact);

        Comparator<? super AddressData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
