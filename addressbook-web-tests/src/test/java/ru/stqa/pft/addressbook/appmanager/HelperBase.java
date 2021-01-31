package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperBase {
    protected WebDriver driver;

    public HelperBase(WebDriver driver) {
        this.driver = driver;
    }

    protected void click(By locator) {
        driver.findElement(locator).click();
    }

    protected void type(String text, By locator) {
        click(locator);
        driver.findElement(locator).sendKeys(text);
    }

    protected WebElement find(String name) {
        return driver.findElement(By.name(name));
    }
}
