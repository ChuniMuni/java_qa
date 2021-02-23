package ru.stqa.pft.addressbook.tests;

import org.junit.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase {

    @Test
    public void ContactModification(){
        if (! app.getContactHelper().isThereAContact()) {
            app.getNavigationHelper().gotoNewContactPage();
            app.getContactHelper().createContact(new ContactData
                    ("Ivan", "Ivanovich", "Ivanov", "ChuniMuni", "User", "Home", "Nignie Vasuki", "22322332", "+7809332222", "+4959993322", "+4959992233", "test@gmail.com", "test1@gmail.com", "test2@gmail.com", "http://localhost/addressbook/", "test", "Verhnie Vasuki", "Home", "Test"));
        }
        app.getNavigationHelper().returnHomePage();
        app.getContactHelper().editContact();
        app.getContactHelper().addNewContact(new ContactData("Petr", "Sidirivich", "Stepanov", "Gerald", "User2", "Home2", "Verhnie Vasuki", "22322332", "+76543645645", "+49545646456", "+495775675", "modify@gmail.com", "modify1@gmail.com", "modify2@gmail.com", "http://localhost/addressbook/", null, "Nichnie Vasuki", "Home3", "Test2"), false);
        app.getContactHelper().updateNewContact();
        app.getNavigationHelper().returnHomePage();
    }
}
