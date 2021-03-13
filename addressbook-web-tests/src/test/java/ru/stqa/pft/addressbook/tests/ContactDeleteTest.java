package ru.stqa.pft.addressbook.tests;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Set;

public class ContactDeleteTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.contact().all().size() == 0) {
            app.goTo().newContactPage();
            app.contact().create(new ContactData().withFirstname("Ivan").withMidllename("Ivanovich").withLastname("Ivanov").withNick("ChuniMuni").withTitle("User").withCompany("Home").withAddress("Nignie Vasuki").withTel1("22322332").withTel2("+7809332222").withTel3("+4959993322").withTel4("+4959992233").withEmail1("test@gmail.com").withEmail2("test1@gmail.com").withEmail3("test2@gmail.com").withUrl("http://localhost/addressbook/").withGroup("test").withAddress2("Verhnie Vasuki").withPhone2("+4959992233").withNotes("Test"));
        }
    }

    @Test
    public void testDeleteContact() {
        app.goTo().homePage();
        Set<ContactData> before = app.contact().all();
        ContactData deleteContact = before.iterator().next();
        app.contact().delete(deleteContact);
        app.goTo().homePage();
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(deleteContact);
        Assert.assertEquals(before, after);
    }
}
