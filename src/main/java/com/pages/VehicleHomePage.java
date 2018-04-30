package com.pages;

import com.utility.BrowserContext;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.utility.BrowserEvent;

/**
 * Created by tolaf on 29/04/2018.
 */
@Component
public class VehicleHomePage {

    @Autowired
    private BrowserEvent browserEvent;
    @Autowired
    BrowserContext browserContext;

    private String homePageTitle = "Get vehicle information from DVLA - GOV.UK";

    private final By pageBody = By.cssSelector(".mainstream.js-enabled");
    private final By btnStartButton = By.cssSelector(".pub-c-button.pub-c-button--start");

    public void assertHomePage(){
        Assert.assertEquals(browserContext.getBrowser().getTitle(),homePageTitle);
        browserEvent.waitForElementToBePresent(btnStartButton, 10);

        Assert.assertFalse(checkPageBody().contains("Check if a vehicle is taxed and has an MOT"));
        Assert.assertTrue(checkPageBody().contains("Get vehicle information from DVLA"));
    }

    private String checkPageBody(){
        return browserEvent.getText(pageBody);
    }

    public void navigateToPage(String url){
        browserEvent.navigateToURL(url);
    }

    public void clickOnStartNowButton(){
        browserEvent.waitForElementToBePresent(btnStartButton, 10);
        browserEvent.clickOnElement(btnStartButton);
    }
}