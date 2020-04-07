package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddressDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
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
    public void testAddressDeletion() {
        app.goTo().gotoHomePage();
        Contacts before = app.db().contacts();
        AddressData deleteContact = before.iterator().next();
        app.address().delete(deleteContact);
        app.goTo().gotoHomePage();
        Contacts after = app.db().contacts();

        assertThat(after, equalTo(before.without(deleteContact)));
        verifyContactListInUI();
    }
}
