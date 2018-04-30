package com.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

/**
 * Created by tolaf on 29/04/2018.
 *  * Using Spring to build Automation Framework
 * Objective: Base Browser Control and WebElement Reference
 */
public class BrowserUtils implements WebDriver {

    private final WebDriver webDriver;

    public BrowserUtils(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Override
    public void close() {
        this.webDriver.close();
    }

    @Override
    public WebElement findElement(By byCriteria) {
        return this.webDriver.findElement(byCriteria);
    }

    @Override
    public List<WebElement> findElements(By byCriteria) {
        return this.webDriver.findElements(byCriteria);
    }

    @Override
    public void get(String expectedText) {
        this.webDriver.get(expectedText);
    }

    @Override
    public String getCurrentUrl() {
        return this.webDriver.getCurrentUrl();
    }

    @Override
    public String getPageSource() {
        return this.webDriver.getPageSource();
    }

    @Override
    public String getTitle() {
        return this.webDriver.getTitle();
    }

    @Override
    public String getWindowHandle() {
        return this.webDriver.getWindowHandle();
    }

    @Override
    public Set<String> getWindowHandles() {
        return this.webDriver.getWindowHandles();
    }

    @Override
    public WebDriver.Options manage() {
        return this.webDriver.manage();
    }

    @Override
    public WebDriver.Navigation navigate() {
        return this.webDriver.navigate();
    }

    @Override
    public void quit() {
        this.webDriver.quit();
    }

    @Override
    public WebDriver.TargetLocator switchTo() {
        return this.webDriver.switchTo();
    }

}
