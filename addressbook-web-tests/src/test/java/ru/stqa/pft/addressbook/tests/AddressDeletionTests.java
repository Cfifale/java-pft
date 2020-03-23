package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;

import java.util.Set;

public class AddressDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.address().all().size() == 0) {
            app.address().create(new AddressData()
                    .withFirstname("Иван").withMiddlename("Иванович").withLastname("Иванов").withNickname("ivanov")
                    .withAddress("г. Москва").withHome("+7(495)111-11-11").withMobile("+7(915)111-11-11").withWork("+7(495)100-10-10")
                    .withEmail("ivanov@sitehome.ru").withEmail2("ivanov@sitehome.com").withEmail3("ivanov@sitehome.me")
                    .withHomepage("www.sitehome.ru").withGroup("test2"));
        }
    }

    @Test
    public void testAddressDeletion() {
        Set<AddressData> before = app.address().all();
        AddressData deleteAddress = before.iterator().next();
        app.address().delete(deleteAddress);
        app.goTo().gotoHomePage();
        Set<AddressData> after = app.address().all();

        before.remove(deleteAddress);
        Assert.assertEquals(before, after);
    }
}
