package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class AddressCreationTests extends TestBaseAddress {

    @Test
    public void testsGroupCreation() {
        initAddressCreation();
        fillAddressForm(new AddressData("Иван", "Иванович", "Иванов", "ivanov", "г. Москва", "+7(495)111-11-11", "+7(915)111-11-11", "+7(495)100-10-10", "ivanov@sitehome.ru", "ivanov@sitehome.com", "ivanov@sitehome.me", "www.sitehome.ru"));
        submitAddressCreation();
        returnToHomePage();
    }

}
