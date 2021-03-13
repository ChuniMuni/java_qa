package ru.stqa.pft.addressbook.tests;

import org.junit.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTest extends TestBase {

    @Test
    public void ContactModification(){
        if (! app.getContactHelper().isThereAContact()) {
            app.getNavigationHelper().gotoNewContactPage();
            app.getContactHelper().createContact(new ContactData
                    ("Ivan", "Ivanovich", "Ivanov", "ChuniMuni", "User", "Home", "Nignie Vasuki", "22322332", "+7809332222", "+4959993322", "+4959992233", "test@gmail.com", "test1@gmail.com", "test2@gmail.com", "http://localhost/addressbook/", "test", "Verhnie Vasuki", "Home", "Test"));
        }
        app.getNavigationHelper().returnHomePage();
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() - 1);
        ContactData contact = new ContactData(before.get(before.size() - 1).getId(),"Ivan", "Petrovich", "Ivanov", "Gerald", "User2", "Home2", "Verhnie Vasuki", "22322332", "+76543645645", "+49545646456", "+495775675", "modify@gmail.com", "modify1@gmail.com", "modify2@gmail.com", "http://localhost/addressbook/", null, "Nichnie Vasuki", "Home3", "Test2");
        app.getContactHelper().addNewContact(contact, false);
        app.getContactHelper().updateNewContact();
        app.getNavigationHelper().returnHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(contact);
        Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
