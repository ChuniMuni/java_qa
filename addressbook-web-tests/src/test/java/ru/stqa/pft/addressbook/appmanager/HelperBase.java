package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.*;

public class HelperBase {
    protected WebDriver driver;

    public HelperBase(WebDriver driver) {
        this.driver = driver;
    }

    protected void click(By locator) {
        driver.findElement(locator).click();
    }

    protected void clear(By locator) {
        driver.findElement(locator).clear();
    }

    protected void type(String text, By locator) {
        click(locator);
        if (text != null) {
            String existingText = driver.findElement(locator).getAttribute("value");
            if (! text.equals(existingText)) {
                driver.findElement(locator).clear();
                driver.findElement(locator).sendKeys(text);
            }
        }
    }

    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    protected WebElement find(String name) {
        return driver.findElement(By.name(name));
    }

    protected boolean isElementPresent(By locator) {
      try {
          driver.findElement(locator);
          return true;
      } catch (NoSuchElementException ex) {
          return false;
      }
    }
}
