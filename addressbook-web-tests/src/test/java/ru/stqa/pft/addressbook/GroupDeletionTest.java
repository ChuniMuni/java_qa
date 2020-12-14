package ru.stqa.pft.addressbook;

import org.junit.Test;
import org.openqa.selenium.By;

public class GroupDeletionTest extends TestBase {

  @Test
  public void testGroupDeletion() {
    gotoGroupPage();
    selectGroup();
    deletionSelectedGroups();
    returnGroups();
  }
}
