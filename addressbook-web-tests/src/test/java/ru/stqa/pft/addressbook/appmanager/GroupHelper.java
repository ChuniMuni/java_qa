package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver driver) {
        super(driver);
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData groupData) {
        clear(By.name("group_name"));
        type(groupData.getName(), By.name("group_name"));
        clear(By.name("group_header"));
        type(groupData.getHeader(), By.name("group_header"));
        clear(By.name("group_footer"));
        type(groupData.getFooter(), By.name("group_footer"));
    }

    public void deletionSelectedGroups() {
        click(By.cssSelector("input:nth-child(12)"));
    }

    public void selectGroup() {
        click(By.name("selected[]"));
    }

    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }
}
