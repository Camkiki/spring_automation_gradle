package com.pages;

import com.utility.BrowserEvent;
import org.junit.Assert;
import com.utility.BrowserContext;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by tolaf on 29/04/2018.
 */

@Component
public class VehicleEnquiryPage {

    @Autowired
    private BrowserEvent browserEvent;
    @Autowired
    private BrowserContext browserContext;

    private String  enquiryPageTitle = "Check if a vehicle is taxed and has an MOT";

    private By pageBody = By.cssSelector(".js-enabled");
    private By txtRegistrationNumber = By.cssSelector("#Vrm");
    private By btnContinue = By.cssSelector(".button");

    public void assertEnquiryPage() {
        Assert.assertEquals(browserContext.getBrowser().getTitle(), enquiryPageTitle);
        browserEvent.waitForElementToBePresent(txtRegistrationNumber, 10);
        browserEvent.waitForElementToBePresent(btnContinue, 10);

        Assert.assertTrue(checkPageBody().contains("Check if a vehicle is taxed and has an MOT"));
        Assert.assertTrue(checkPageBody().contains("Enter the registration number of the vehicle"));
    }

    private String checkPageBody(){
        return browserEvent.getText(pageBody);
    }

    public void doVehicleEnquiry(String carreg){
        browserEvent.setTextInTextbox(txtRegistrationNumber, carreg);
        browserEvent.clickOnElement(btnContinue);
    }
}
