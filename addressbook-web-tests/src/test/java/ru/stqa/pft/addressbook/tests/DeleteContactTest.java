package ru.stqa.pft.addressbook.tests;

import org.junit.Test;

public class DeleteContactTest extends TestBase {

    @Test
    public void testDeleteContact() {
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteContact();
        app.getNavigationHelper().returnHomePage();

    }
}
