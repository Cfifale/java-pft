package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class DeleteAddressFromGroupTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().groups().size() == 0 ) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test1").withHeader("header1").withFooter("footer1"));
        }
        if (app.db().contacts().size() == 0) {
            Groups groups = app.db().groups();
            File photo = new File("src/test/resources/stru.png");
            app.address().create(new AddressData()
                    .withFirstname("Иван").withMiddlename("Иванович").withLastname("Иванов").withNickname("ivanov")
                    .withAddress("г. Москва").withHome("+7(495)111-11-11").withMobile("+7(915)111-11-11").withWork("+7(495)100-10-10")
                    .withEmail("ivanov@sitehome.ru").withEmail2("ivanov@sitehome.com").withEmail3("ivanov@sitehome.me")
                    .withHomepage("www.sitehome.ru").withPhoto(photo).inGroup(groups.iterator().next()));
        }
    }

    @Test
    public void testDeleteAddressFromGroup() {
        int i = 0;
        app.goTo().gotoHomePage();
        Contacts contacts = app.db().contacts();
        for (AddressData contact : contacts) {
            if (contact.getGroups().size() > 0) {
                GroupData group = contact.getGroups().iterator().next();
                app.address().deleteFromGroup(contact, group);
                app.goTo().gotoHomePage();

                Contacts afterContacts = app.db().contacts();
                assertThat(getContact(contact, afterContacts).getGroups(), equalTo(contact.getGroups().without(group)));

                i = 1;
                break;
            }
        }
        if (i == 0) {
            Groups groups = app.db().groups();
            GroupData group = groups.iterator().next();
            AddressData contact = contacts.iterator().next();
            app.address().addToGroup(contact, group);
            app.goTo().gotoHomePage();

            app.address().deleteFromGroup(contact, group);
            app.goTo().gotoHomePage();

            Contacts afterContacts = app.db().contacts();
            assertThat(getContact(contact, afterContacts).getGroups(), equalTo(contact.getGroups().without(group)));
        }
    }
}
