package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;

import java.util.Set;

public class AddressModificationTests extends TestBase{

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
    public void testAddressModification() {
        Set<AddressData> before = app.address().all();
        AddressData modifiedAddress = before.iterator().next();
//        int index = before.size() - 1;
        AddressData contact = new AddressData().withId(modifiedAddress.getId())
                .withFirstname("Иван1").withMiddlename("Иванович1").withLastname("Иванов1").withNickname("ivanov1")
                .withAddress("г. Москва1").withHome("+7(111)111-11-11").withMobile("+7(111)111-11-11").withWork("+7(111)100-10-10")
                .withEmail("ivanov1@sitehome.ru").withEmail2("ivanov1@sitehome.com").withEmail3("ivanov1@sitehome.me")
                .withHomepage("www.sitehome1.ru");
        app.address().modify(contact);
        Set<AddressData> after = app.address().all();

        before.remove(modifiedAddress);
        before.add(contact);

        Assert.assertEquals(before, after);
    }
}
