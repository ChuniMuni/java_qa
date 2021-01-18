package ru.stqa.pft.addressbook.tests;

import org.junit.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreationTest extends TestBase {

  @Test
  public void addressbook() {
    app.gotoGroupPage();
    app.initGroupCreation();
    app.getGroupHelper().fillGroupForm(new GroupData("test", "test1", "test2"));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
  }
}
