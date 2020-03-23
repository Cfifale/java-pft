package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;

import java.util.Set;

public class AddressCreationTests extends TestBase {

    @Test
    public void testsAddressCreation() {
        Set<AddressData> before = app.address().all();
        AddressData contact = new AddressData()
                .withFirstname("Иван").withMiddlename("Иванович").withLastname("Иванов").withNickname("ivanov")
                .withAddress("г. Москва").withHome("+7(495)111-11-11").withMobile("+7(915)111-11-11").withWork("+7(495)100-10-10")
                .withEmail("ivanov@sitehome.ru").withEmail2("ivanov@sitehome.com").withEmail3("ivanov@sitehome.me")
                .withHomepage("www.sitehome.ru").withGroup("test2");
        app.address().create(contact);
        Set<AddressData> after = app.address().all();

        contact.withId(after.stream().mapToInt((a) -> a.getId()).max().getAsInt());
        before.add(contact);
        Assert.assertEquals(before, after);
    }
}
