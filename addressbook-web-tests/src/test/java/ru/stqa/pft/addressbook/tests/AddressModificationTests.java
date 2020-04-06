package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddressModificationTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().contacts().size() == 0) {
            app.address().create(new AddressData()
                    .withFirstname("Иван").withMiddlename("Иванович").withLastname("Иванов").withNickname("ivanov")
                    .withAddress("г. Москва").withHome("+7(495)111-11-11").withMobile("+7(915)111-11-11").withWork("+7(495)100-10-10")
                    .withEmail("ivanov@sitehome.ru").withEmail2("ivanov@sitehome.com").withEmail3("ivanov@sitehome.me")
                    .withHomepage("www.sitehome.ru").withPhoto(new File("src/test/resources/stru.png")).withGroup("test2"));
        }
    }

    @Test
    public void testAddressModification() {
        app.goTo().gotoHomePage();
        Contacts before = app.db().contacts();
        AddressData modifiedContact = before.iterator().next();
        AddressData contact = new AddressData().withId(modifiedContact.getId())
                .withFirstname("Иван1").withMiddlename("Иванович1").withLastname("Иванов1").withNickname("ivanov1")
                .withAddress("г. Москва1").withHome("+7(111)111-11-11").withMobile("+7(111)111-11-11").withWork("+7(111)100-10-10")
                .withEmail("ivanov1@sitehome.ru").withEmail2("ivanov1@sitehome.com").withEmail3("ivanov1@sitehome.me")
                .withHomepage("www.sitehome1.ru").withPhoto(new File("src/test/resources/stru.png"));
        app.address().modify(contact);
        Contacts after = app.db().contacts();

        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
        verifyContactListInUI();
    }
}
