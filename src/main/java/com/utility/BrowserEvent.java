package com.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by tolaf on 29/04/2018.
 *  Using Spring to build Automation Framework
 *  Objective: WebDriver Extensions
 */
@Component
public class BrowserEvent {

    @Autowired
    private BrowserContext browserContext;

    public void navigateToURL(final String url){
        browserContext.getBrowser().get(url);
    }

    public List<WebElement> getElements(final By byCriteria){
        return browserContext.getBrowser().findElements(byCriteria);
    }

    public void clickOnElement(final By byCriteria){
        browserContext.getBrowser().findElement(byCriteria).click();
    }

    public void setTextInTextbox(final By byCriteria, final String expectedText){
        browserContext.getBrowser().findElement(byCriteria).clear();
        browserContext.getBrowser().findElement(byCriteria).sendKeys(expectedText);
    }

    public String getText(final By byCriteria){
        return browserContext.getBrowser().findElement(byCriteria).getText();
    }

    public void waitForElementToBePresent(final By byCriteria, final int waitTimeInSeconds){
        try {
            (new WebDriverWait(browserContext.getBrowser(),waitTimeInSeconds))
                    .until(ExpectedConditions.presenceOfElementLocated(byCriteria));
        } catch (TimeoutException te) {
            //  if catches time out exception do nothing
        }
    }
}