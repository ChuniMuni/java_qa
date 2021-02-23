package ru.stqa.pft.addressbook.tests;


import org.junit.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupModificationTest extends TestBase {

    @Test
    public void testGroupModification() {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("modifi", "test1", "modifi2"));
        app.getGroupHelper().submitGroupModification();
        app.returnGroups();
    }
}
