package ru.stqa.pft.addressbook.tests;

import org.junit.Test;

public class GroupDeletionTest extends TestBase {

  @Test
  public void testGroupDeletion() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deletionSelectedGroups();
    app.returnGroups();
  }
}
