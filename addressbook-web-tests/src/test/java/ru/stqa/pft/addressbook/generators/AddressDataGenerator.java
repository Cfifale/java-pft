package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.stqa.pft.addressbook.model.AddressData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class AddressDataGenerator {
    @Parameter(names = "-c", description = "Contact count")
    public int count;

    @Parameter(names = "-f", description = "Target file")
    public String file;

    @Parameter(names = "-d", description = "Data format")
    public String format;

    public static void main(String[] args) throws IOException {
        AddressDataGenerator generator = new AddressDataGenerator();
        JCommander jCommander = new JCommander(generator);
        try {
            jCommander.parse(args);
        } catch (ParameterException ex) {
            jCommander.usage();
            return;
        }
        generator.run();
    }

    private void run() throws IOException {
        List<AddressData> contacts = generateContacts(count);
        if (format.equals("json")) {
            saveAsJson(contacts, new File(file));
        } else {
            System.out.println("Unrecognized format " + format);
        }
    }

    private void saveAsJson(List<AddressData> contacts, File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(contacts);
        Writer writer = new FileWriter(file);
        writer.write(json);
        writer.close();
    }

    private List<AddressData> generateContacts(int count) {
        List<AddressData> contacts = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            contacts.add(new AddressData()
                    .withFirstname(String.format("Иван%s", i)).withMiddlename(String.format("Иванович%s", i))
                    .withLastname(String.format("Иванов%s", i)).withNickname(String.format("ivanov%s", i))
                    .withAddress(String.format("г. Москва%s", i)).withHome(String.format("+7(495)111-11-1%s", i))
                    .withMobile(String.format("+7(915)111-11-1%s", i)).withWork(String.format("+7(495)100-10-1%s", i))
                    .withEmail(String.format("ivanov%s@sitehome.ru", i)).withEmail2(String.format("ivanov%s@sitehome.com", i))
                    .withEmail3(String.format("ivanov%s@sitehome.me", i)).withHomepage(String.format("www.sitehome%s.ru", i))
                    .withGroup("test2").withPhoto(new File("src/test/resources/stru.png")));
        }
        return contacts;
    }
}
