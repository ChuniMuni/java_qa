package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public class ApplicationManager {
    public WebDriver driver;
    private SessionHelper sessionHelper;
    private GroupHelper groupHelper;
    private ContactHelper contactHelper;
    private NavigationHelper navigationHelper;
    JavascriptExecutor js;
    private Map<String, Object> vars;

    public void init() {
        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        Map<String, Object> vars = new HashMap<String, Object>();
        driver.get("http://localhost/addressbook/");
        driver.manage().window().setSize(new Dimension(1550, 838));
        sessionHelper = new SessionHelper(driver);
        groupHelper = new GroupHelper(driver);
        navigationHelper = new NavigationHelper(driver);
        contactHelper = new ContactHelper(driver);
        sessionHelper.login("admin", "secret");
    }

    public void initGroupCreation() {
      driver.findElement(By.name("new")).click();
    }

    public void stop() {
        sessionHelper.logout();
        driver.quit();
    }

    public void gotoNewContactPage() {
      driver.findElement(By.linkText("add new")).click();
    }

    public void returnGroups() {
        navigationHelper.gotoGroupPage();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }
}
