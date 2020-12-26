package ru.stqa.pft.addressbook.tests;

import org.junit.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class CreateContactTest extends TestBase {

  @Test
  public void createContact() {
    app.gotoNewContactPage();
    app.addNewContact(new ContactData("Ivan", "Ivanovich", "Ivanov", "ChuniMuni", "User", "Home", "Nignie Vasuki", "22322332", "+7809332222", "+4959993322", "+4959992233", "test@gmail.com", "test1@gmail.com", "test2@gmail.com", "http://localhost/addressbook/", "Verhnie Vasuki", "Home", "Test"));
    app.createNewContact();
  }
}
