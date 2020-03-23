package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddressCreationTests extends TestBase {

    @Test
    public void testsAddressCreation() {
        Contacts before = app.address().all();
        AddressData contact = new AddressData()
                .withFirstname("Иван").withMiddlename("Иванович").withLastname("Иванов").withNickname("ivanov")
                .withAddress("г. Москва").withHome("+7(495)111-11-11").withMobile("+7(915)111-11-11").withWork("+7(495)100-10-10")
                .withEmail("ivanov@sitehome.ru").withEmail2("ivanov@sitehome.com").withEmail3("ivanov@sitehome.me")
                .withHomepage("www.sitehome.ru").withGroup("test2");
        app.address().create(contact);
        Contacts after = app.address().all();

        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((a) -> a.getId()).max().getAsInt()))));
    }
}
