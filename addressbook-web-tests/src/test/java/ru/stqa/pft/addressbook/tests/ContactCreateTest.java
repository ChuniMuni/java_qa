package ru.stqa.pft.addressbook.tests;

import org.junit.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Set;

public class ContactCreateTest extends TestBase {

  @Test
  public void createContact() {
    Set<ContactData> before = app.contact().all();
    app.goTo().newContactPage();
    ContactData contact = new ContactData().withFirstname("Ivan").withMidllename("Ivanovich").withLastname("Ivanov").withNick("ChuniMuni").withTitle("User").withCompany("Home").withAddress("Nignie Vasuki").withTel1("22322332").withTel2("+7809332222").withTel3("+4959993322").withTel4("+4959992233").withEmail1("test@gmail.com").withEmail2("test1@gmail.com").withEmail3("test2@gmail.com").withUrl("http://localhost/addressbook/").withGroup("test").withAddress2("Verhnie Vasuki").withPhone2("+4959992233").withNotes("Test");
    app.contact().addNewContact(contact, true);
    app.contact().createNewContact();
    app.goTo().homePage();
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after);
  }
}
