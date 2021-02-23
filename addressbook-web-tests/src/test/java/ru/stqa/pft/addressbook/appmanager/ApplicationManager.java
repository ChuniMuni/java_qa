package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    public WebDriver driver;
    private SessionHelper sessionHelper;
    private GroupHelper groupHelper;
    private ContactHelper contactHelper;
    private NavigationHelper navigationHelper;
    JavascriptExecutor js;
    private Map<String, Object> vars;
    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
        
    }

    public void init() {
        if (browser.equals(BrowserType.FIREFOX)) {
            driver = new FirefoxDriver();
        } else if (browser.equals(BrowserType.CHROME)) {
            driver = new ChromeDriver();
        } else if (browser.equals(BrowserType.IE)) {
            driver = new InternetExplorerDriver();
        }
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
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
