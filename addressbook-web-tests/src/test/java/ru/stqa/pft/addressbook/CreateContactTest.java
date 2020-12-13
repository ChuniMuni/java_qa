package ru.stqa.pft.addressbook;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.*;

public class CreateContactTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;

  @Before
  public void setUp() {
    driver = new FirefoxDriver();
    js = (JavascriptExecutor) driver;
    Map<String, Object> vars = new HashMap<String, Object>();
    driver.get("http://localhost/addressbook/");
    driver.manage().window().setSize(new Dimension(1550, 838));
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

  @After
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void createcontact() {
    gotoNewContactPage();
    addNewContact(new ContactData("Ivan", "Ivanovich", "Ivanov", "ChuniMuni", "User", "Home", "Nignie Vasuki", "22322332", "+7809332222", "+4959993322", "+4959992233", "test@gmail.com", "test1@gmail.com", "test2@gmail.com", "http://localhost/addressbook/", "Verhnie Vasuki", "Home", "Test"));
    createNewContact();
  }

  private void addNewContact(ContactData contactData) {
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
    bday("1");
    bmonth("April");
    byear("1971");
    newGroup("test");
    aday("1");
    amonth("April");
    ayear("1971");
    driver.findElement(By.name("address2")).click();
    driver.findElement(By.name("address2")).sendKeys(contactData.getAddress2());
    driver.findElement(By.name("theform")).click();
    driver.findElement(By.name("phone2")).click();
    driver.findElement(By.name("phone2")).sendKeys(contactData.getPhone2());
    driver.findElement(By.name("notes")).click();
    driver.findElement(By.name("notes")).sendKeys(contactData.getNotes());
  }

  private void ayear(String year) {
    driver.findElement(By.name("ayear")).click();
    driver.findElement(By.name("ayear")).sendKeys(year);
  }

  private void amonth(final String month) {
    driver.findElement(By.name("amonth")).click();
    {
      WebElement dropdown = driver.findElement(By.name("amonth"));
      dropdown.findElement(By.xpath("//option[. = '" + month + "']")).click();
    }
    driver.findElement(By.cssSelector("select:nth-child(67) > option:nth-child(5)")).click();
  }

  private void aday(final String day) {
    driver.findElement(By.name("aday")).click();
    {
      WebElement dropdown = driver.findElement(By.name("aday"));
      dropdown.findElement(By.xpath("//option[. = '" + day + "']")).click();
    }
    driver.findElement(By.cssSelector("select:nth-child(66) > option:nth-child(3)")).click();
  }

  private void newGroup(final String group) {
    driver.findElement(By.name("new_group")).click();
    {
      WebElement dropdown = driver.findElement(By.name("new_group"));
      dropdown.findElement(By.xpath("//option[. = '" + group + "']")).click();
    }
    driver.findElement(By.cssSelector("select:nth-child(71) > option:nth-child(2)")).click();
  }

  private void byear(String year) {
    driver.findElement(By.name("byear")).click();
    driver.findElement(By.name("byear")).sendKeys(year);
  }

  private void bmonth(final String month) {
    driver.findElement(By.name("bmonth")).click();
    {
      WebElement dropdown = driver.findElement(By.name("bmonth"));
      dropdown.findElement(By.xpath("//option[. = '" + month + "']")).click();
    }
    driver.findElement(By.cssSelector("select:nth-child(62) > option:nth-child(5)")).click();
  }

  private void bday(final String day) {
    driver.findElement(By.name("bday")).click();
    {
      WebElement dropdown = driver.findElement(By.name("bday"));
      dropdown.findElement(By.xpath("//option[. = '" + day + "']")).click();
    }
    driver.findElement(By.cssSelector("select:nth-child(61) > option:nth-child(3)")).click();
  }

  private void createNewContact() {
    driver.findElement(By.cssSelector("input:nth-child(87)")).click();
  }

  private void gotoNewContactPage() {
    driver.findElement(By.linkText("add new")).click();
  }
}
