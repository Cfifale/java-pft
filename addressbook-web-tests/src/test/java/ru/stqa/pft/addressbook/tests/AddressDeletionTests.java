package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;

import java.util.List;

public class AddressDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.address().list().size() == 0) {
            app.address().create(new AddressData("Иван", "Иванович", "Иванов", "ivanov", "г. Москва", "+7(495)111-11-11", "+7(915)111-11-11", "+7(495)100-10-10", "ivanov@sitehome.ru", "ivanov@sitehome.com", "ivanov@sitehome.me", "www.sitehome.ru", "test2"));
        }
    }

    @Test
    public void testAddressDeletion() {
        List<AddressData> before = app.address().list();
        int index = before.size() - 1;
        app.address().delete(index);
        app.goTo().gotoHomePage();
        List<AddressData> after = app.address().list();

        before.remove(index);
        Assert.assertEquals(before, after);
    }
}
