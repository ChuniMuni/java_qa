package ru.stqa.pft.addressbook.tests;

import org.junit.Assert;
import org.junit.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactCreateTest extends TestBase {

  @Test
  public void createContact() {
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getNavigationHelper().gotoNewContactPage();
    app.getContactHelper().addNewContact(new ContactData("Ivan", "Ivanovich", "Ivanov", "ChuniMuni", "User", "Home", "Nignie Vasuki", "22322332", "+7809332222", "+4959993322", "+4959992233", "test@gmail.com", "test1@gmail.com", "test2@gmail.com", "http://localhost/addressbook/", "test","Verhnie Vasuki", "Home", "Test"), true);
    app.getContactHelper().createNewContact();
    app.getNavigationHelper().returnHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);
  }
}
