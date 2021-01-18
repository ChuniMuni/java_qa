package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.HashMap;
import java.util.Map;

public class ApplicationManager {
    public WebDriver driver;
    private GroupHelper groupHelper;
    JavascriptExecutor js;
    private Map<String, Object> vars;

    public void init() {
        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        Map<String, Object> vars = new HashMap<String, Object>();
        driver.get("http://localhost/addressbook/");
        driver.manage().window().setSize(new Dimension(1550, 838));
        groupHelper = new GroupHelper(driver);
        login("admin", "secret");
    }

    private void login(String username, String password) {
      driver.findElement(By.name("user")).click();
      driver.findElement(By.name("user")).sendKeys(username);
      driver.findElement(By.id("LoginForm")).click();
      driver.findElement(By.name("pass")).click();
      driver.findElement(By.name("pass")).sendKeys(password);
      driver.findElement(By.cssSelector("input:nth-child(7)")).click();
    }

    public void initGroupCreation() {
      driver.findElement(By.name("new")).click();
    }

    public void gotoGroupPage() {
      driver.findElement(By.linkText("groups")).click();
    }

    public void stop() {
        driver.quit();
    }

    public void addNewContact(ContactData contactData) {
      driver.findElement(By.name("firstname")).click();
      driver.findElement(By.name("firstname")).sendKeys(contactData.getFirstname());
      driver.findElement(By.name("middlename")).click();
      driver.findElement(By.name("middlename")).sendKeys(contactData.getMidllename());
      driver.findElement(By.name("lastname")).click();
      driver.findElement(By.name("lastname")).sendKeys(contactData.getLastname());
      driver.findElement(By.name("nickname")).click();
      driver.findElement(By.name("nickname")).sendKeys(contactData.getNick());
      driver.findElement(By.name("title")).click();
      driver.findElement(By.name("title")).sendKeys(contactData.getTitle());
      driver.findElement(By.name("company")).click();
      driver.findElement(By.name("company")).sendKeys(contactData.getCompany());
      driver.findElement(By.name("address")).click();
      driver.findElement(By.name("address")).sendKeys(contactData.getAddress());
      driver.findElement(By.name("home")).click();
      driver.findElement(By.name("home")).sendKeys(contactData.getTel1());
      driver.findElement(By.name("mobile")).click();
      driver.findElement(By.name("mobile")).sendKeys(contactData.getTel2());
      driver.findElement(By.name("work")).click();
      driver.findElement(By.name("work")).sendKeys(contactData.getTel3());
      driver.findElement(By.name("fax")).click();
      driver.findElement(By.name("fax")).sendKeys(contactData.getTel4());
      driver.findElement(By.name("email")).click();
      driver.findElement(By.name("email")).sendKeys(contactData.getEmail1());
      driver.findElement(By.name("email2")).click();
      driver.findElement(By.name("email2")).sendKeys(contactData.getEmail2());
      driver.findElement(By.name("email3")).click();
      driver.findElement(By.name("email3")).sendKeys(contactData.getEmail3());
      driver.findElement(By.name("homepage")).click();
      driver.findElement(By.name("homepage")).sendKeys(contactData.getUrl());
      birthday("1", "April","1971");
      newGroup("test");
      anniversary("1", "April","1971");
      driver.findElement(By.name("address2")).click();
      driver.findElement(By.name("address2")).sendKeys(contactData.getAddress2());
      driver.findElement(By.name("theform")).click();
      driver.findElement(By.name("phone2")).click();
      driver.findElement(By.name("phone2")).sendKeys(contactData.getPhone2());
      driver.findElement(By.name("notes")).click();
      driver.findElement(By.name("notes")).sendKeys(contactData.getNotes());
    }

    private void birthday(final String day, final String month, String year) {
      driver.findElement(By.name("bday")).click();
      {
        WebElement dropdown = driver.findElement(By.name("bday"));
        dropdown.findElement(By.xpath("//option[. = '" + day + "']")).click();
      }
      driver.findElement(By.cssSelector("select:nth-child(61) > option:nth-child(3)")).click();
      driver.findElement(By.name("bmonth")).click();
      {
        WebElement dropdown = driver.findElement(By.name("bmonth"));
        dropdown.findElement(By.xpath("//option[. = '" + month + "']")).click();
      }
      driver.findElement(By.cssSelector("select:nth-child(62) > option:nth-child(5)")).click();
      driver.findElement(By.name("byear")).click();
      driver.findElement(By.name("byear")).sendKeys(year);
    }

    private void anniversary(final String day, final String month, String year) {
      driver.findElement(By.name("aday")).click();
      {
        WebElement dropdown = driver.findElement(By.name("aday"));
        dropdown.findElement(By.xpath("//option[. = '" + day + "']")).click();
      }
      driver.findElement(By.cssSelector("select:nth-child(66) > option:nth-child(3)")).click();
      driver.findElement(By.name("amonth")).click();
      {
        WebElement dropdown = driver.findElement(By.name("amonth"));
        dropdown.findElement(By.xpath("//option[. = '" + month + "']")).click();
      }
      driver.findElement(By.cssSelector("select:nth-child(67) > option:nth-child(5)")).click();
      driver.findElement(By.name("ayear")).click();
      driver.findElement(By.name("ayear")).sendKeys(year);
    }

    private void newGroup(final String group) {
      driver.findElement(By.name("new_group")).click();
      {
        WebElement dropdown = driver.findElement(By.name("new_group"));
        dropdown.findElement(By.xpath("//option[. = '" + group + "']")).click();
      }
      driver.findElement(By.cssSelector("select:nth-child(71) > option:nth-child(2)")).click();
    }

    public void createNewContact() {
      driver.findElement(By.cssSelector("input:nth-child(87)")).click();
    }

    public void gotoNewContactPage() {
      driver.findElement(By.linkText("add new")).click();
    }

    public void returnGroups() {
      driver.findElement(By.linkText("groups")).click();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }
}
