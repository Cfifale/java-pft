package ru.stqa.pft.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddressCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validAddressFromJson() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")))) {
            String json = "";
            String line = reader.readLine();
            while (line != null) {
                json += line;
                line = reader.readLine();
            }
            Gson gson = new Gson();
            List<AddressData> contacts = gson.fromJson(json, new TypeToken<List<AddressData>>(){}.getType()); //List<AddressData>.class
            return contacts.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
        }
    }

    @Test(dataProvider = "validAddressFromJson")
    public void testsAddressCreation(AddressData contact) {
        Contacts before = app.address().all();
        app.address().create(contact);
        Contacts after = app.address().all();

        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((a) -> a.getId()).max().getAsInt()))));
    }
}
