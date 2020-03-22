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
            app.address().create(new AddressData()
                    .withFirstname("Иван").withMiddlename("Иванович").withLastname("Иванов").withNickname("ivanov")
                    .withAddress("г. Москва").withHome("+7(495)111-11-11").withMobile("+7(915)111-11-11").withWork("+7(495)100-10-10")
                    .withEmail("ivanov@sitehome.ru").withEmail2("ivanov@sitehome.com").withEmail3("ivanov@sitehome.me")
                    .withHomepage("www.sitehome.ru").withGroup("test2"));
        }
    }

    @Test
    public void testAddressModification() {
        List<AddressData> before = app.address().list();
        int index = before.size() - 1;
        AddressData contact = new AddressData().withId(before.get(index).getId())
                .withFirstname("Иван1").withMiddlename("Иванович1").withLastname("Иванов1").withNickname("ivanov1")
                .withAddress("г. Москва1").withHome("+7(111)111-11-11").withMobile("+7(111)111-11-11").withWork("+7(111)100-10-10")
                .withEmail("ivanov1@sitehome.ru").withEmail2("ivanov1@sitehome.com").withEmail3("ivanov1@sitehome.me")
                .withHomepage("www.sitehome1.ru");
        app.address().modify(index, contact);
        List<AddressData> after = app.address().list();

        before.set(index,contact);

        Comparator<? super AddressData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
