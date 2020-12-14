package ru.stqa.pft.addressbook;

import org.junit.Test;

public class GroupCreationTest extends TestBase {

  @Test
  public void addressbook() {
    gotoGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("test", "test1", "test2"));
    submitGroupCreation();
    returnToGroupPage();
  }
}
