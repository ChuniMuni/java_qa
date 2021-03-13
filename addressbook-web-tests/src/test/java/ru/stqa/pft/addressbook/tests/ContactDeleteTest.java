package ru.stqa.pft.addressbook.tests;

import org.junit.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeleteTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (! app.getContactHelper().isThereAContact()) {
            app.getNavigationHelper().gotoNewContactPage();
            app.getContactHelper().createContact(new ContactData
                    ("Ivan", "Ivanovich", "Ivanov", "ChuniMuni", "User", "Home", "Nignie Vasuki", "22322332", "+7809332222", "+4959993322", "+4959992233", "test@gmail.com", "test1@gmail.com", "test2@gmail.com", "http://localhost/addressbook/", "test", "Verhnie Vasuki", "Home", "Test"));
        }
    }

    @Test
    public void testDeleteContact() {
        app.getNavigationHelper().returnHomePage();
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().deleteContact();
        app.getNavigationHelper().returnHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
    }
}
