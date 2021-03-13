package ru.stqa.pft.addressbook.tests;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Set;

public class ContactModificationTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.contact().all().size() == 0) {
            app.goTo().newContactPage();
            app.contact().create(new ContactData().withFirstname("Ivan").withMidllename("Ivanovich").withLastname("Ivanov").withNick("ChuniMuni").withTitle("User").withCompany("Home").withAddress("Nignie Vasuki").withTel1("22322332").withTel2("+7809332222").withTel3("+4959993322").withTel4("+4959992233").withEmail1("test@gmail.com").withEmail2("test1@gmail.com").withEmail3("test2@gmail.com").withUrl("http://localhost/addressbook/").withGroup("test").withAddress2("Verhnie Vasuki").withPhone2("+4959992233").withNotes("Test"));
        }
    }

    @Test
    public void ContactModification(){
        app.goTo().homePage();
        Set<ContactData> before = app.contact().all();
        ContactData modifyContact = before.iterator().next();
        ContactData contact = new ContactData().withId(modifyContact.getId()).withFirstname("Ivan").withMidllename("Petrovich").withLastname("Ivanov").withNick("Gerald").withTitle("User2").withCompany("Home2").withAddress("Verhnie Vasuki").withTel1("+75656566665").withTel2("+7586756786856").withTel3("+4955687678").withTel4("+4956575676").withEmail1("modify@gmail.com").withEmail2("modify1@gmail.com").withEmail3("modify2@gmail.com").withUrl("http://localhost:8080").withAddress2("Nignie Vasuki").withPhone2("+495454777").withNotes("Modify");
        app.contact().modify(contact);
        app.goTo().homePage();
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size());

        before.remove(modifyContact);
        before.add(contact);
        Assert.assertEquals(before, after);
    }
}
