package ru.stqa.pft.addressbook;

import org.junit.Test;

public class CreateContactTest extends TestBase {

  @Test
  public void createContact() {
    gotoNewContactPage();
    addNewContact(new ContactData("Ivan", "Ivanovich", "Ivanov", "ChuniMuni", "User", "Home", "Nignie Vasuki", "22322332", "+7809332222", "+4959993322", "+4959992233", "test@gmail.com", "test1@gmail.com", "test2@gmail.com", "http://localhost/addressbook/", "Verhnie Vasuki", "Home", "Test"));
    createNewContact();
  }
}
