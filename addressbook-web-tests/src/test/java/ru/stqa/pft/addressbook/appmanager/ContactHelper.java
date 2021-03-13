package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

    private ContactData contact;

    public ContactHelper(WebDriver driver) {
      super(driver);
  }

  public void addNewContact(ContactData contactData, boolean creation) {
      click(By.name("firstname"));
      type(contactData.getFirstname(), By.name("firstname"));
      click(By.name("middlename"));
      type(contactData.getMidllename(), By.name("middlename"));
      click(By.name("lastname"));
      type(contactData.getLastname(), By.name("lastname"));
      click(By.name("nickname"));
      type(contactData.getNick(), By.name("nickname"));
      click(By.name("title"));
      type(contactData.getTitle(), By.name("title"));
      click(By.name("company"));
      type(contactData.getCompany(), By.name("company"));
      click(By.name("address"));
      type(contactData.getAddress(), By.name("address"));
      click(By.name("home"));
      type(contactData.getTel1(), By.name("home"));
      click(By.name("mobile"));
      type(contactData.getTel2(), By.name("mobile"));
      click(By.name("work"));
      type(contactData.getTel3(), By.name("work"));
      click(By.name("fax"));
      type(contactData.getTel4(), By.name("fax"));
      click(By.name("email"));
      type(contactData.getEmail1(), By.name("email"));
      click(By.name("email2"));
      type(contactData.getEmail2(), By.name("email2"));
      click(By.name("email3"));
      type(contactData.getEmail3(), By.name("email3"));
      click(By.name("homepage"));
      type(contactData.getUrl(), By.name("homepage"));
      //TODO Актуализировать для создания и модификации контакта.
      // birthday("1", "April","1971");
      // anniversary("1", "April","1971");
      newGroup("test", creation);
      click(By.name("address2"));
      type(contactData.getAddress2(), By.name("address2"));
      click(By.name("phone2"));
      type(contactData.getPhone2(), By.name("phone2"));
      click(By.name("notes"));
      type(contactData.getNotes(), By.name("notes"));
    }

    private void birthday(final String day, final String month, String year) {
      click(By.name("bday"));
      {
        WebElement dropdown = find("bday");
        dropdown.findElement(By.xpath("//option[. = '" + day + "']")).click();
      }
      click(By.cssSelector("select:nth-child(61) > option:nth-child(3)"));
      click(By.name("bmonth"));
      {
        WebElement dropdown = find("bmonth");
        dropdown.findElement(By.xpath("//option[. = '" + month + "']")).click();
      }
      click(By.cssSelector("select:nth-child(62) > option:nth-child(5)"));
      click(By.name("byear"));
      type(year, By.name("byear"));
    }

    private void anniversary(final String day, final String month, String year) {
      click(By.name("aday"));
      {
        WebElement dropdown = find("aday");
        dropdown.findElement(By.xpath("//option[. = '" + day + "']")).click();
      }
      click(By.cssSelector("select:nth-child(66) > option:nth-child(3)"));
      click(By.name("amonth"));
      {
        WebElement dropdown = find("amonth");
        dropdown.findElement(By.xpath("//option[. = '" + month + "']")).click();
      }
      click(By.cssSelector("select:nth-child(67) > option:nth-child(5)"));
      click(By.name("ayear"));
      type(year, By.name("ayear"));
    }

    public void createNewContact() {
      click(By.cssSelector("input:nth-child(87)"));
    }

    public void updateNewContact() {
        click(By.xpath("(//input[@name='update'])[2]"));
    }

    public void editContact() {
        click(By.xpath("//img[@alt='Edit']"));
    }

    public void newGroup(final String group, boolean creation) {
        if (creation) {
            click(By.name("new_group"));
            {
                WebElement dropdown = find("new_group");
                dropdown.findElement(By.xpath("//option[. = '" + group + "']")).click();
            }
            click(By.cssSelector("select:nth-child(71) > option:nth-child(2)"));
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void selectContact(int index) {
        driver.findElements(By.xpath("//img[@alt='Edit']")).get(index).click();
    }

    public void deleteContact() {
        click(By.xpath("(//input[@name='update'])[3]"));
    }

    private void confirm() {
        driver.switchTo().alert().accept();
    }

    public void createContact(ContactData contact) {
        addNewContact(contact, true);
        createNewContact();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.xpath("(//input[@name='selected[]'])"));
    }

    public int getContactCount() {
        return driver.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elements = driver.findElements(By.cssSelector("tr[name='entry']"));
        for(WebElement element : elements){
            int id = Integer.parseInt(element.findElement(By.cssSelector("td:nth-child(1) input")).getAttribute("value"));
            String firstname = element.findElement(By.cssSelector("td:nth-child(3)")).getText();
            String lastname = element.findElement(By.cssSelector("td:nth-child(2)")).getText();
            ContactData contact = new ContactData(id, firstname, null, lastname, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
            contacts.add(contact);
        }
        return contacts;
    }

    public void modifyContact(int index) {
        driver.findElements(By.cssSelector("img[alt=\"Edit\"]")).get(index).click();
    }
}
