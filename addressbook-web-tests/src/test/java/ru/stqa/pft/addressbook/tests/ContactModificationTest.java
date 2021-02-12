package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase {

    @Test
    public void ContactModification(){
        app.getContactHelper().editContact();
        app.getContactHelper().addNewContact(new ContactData("Petr", "Sidirivich", "Stepanov", "Gerald", "User2", "Home2", "Verhnie Vasuki", "22322332", "+76543645645", "+49545646456", "+495775675", "modify@gmail.com", "modify1@gmail.com", "modify2@gmail.com", "http://localhost/addressbook/", "Nichnie Vasuki", "Home3", "Test2"));
        app.getContactHelper().updateNewContact();
        app.getNavigationHelper().returnHomePage();
    }
}
