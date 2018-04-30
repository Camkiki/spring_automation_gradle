package com.pages;

import com.utility.BrowserContext;
import com.utility.BrowserEvent;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by tolaf on 29/04/2018.
 */

@Component
public class ConfirmVehiclePage {

    @Autowired
    private BrowserEvent browserEvent;
    @Autowired
    private BrowserContext browserContext;

    private String confirmPageTitle = "Check if a vehicle is taxed and has an MOT";

    private By pageBody = By.cssSelector(".js-enabled");
    private By registrationNumber = By.cssSelector(".reg-mark");
    private By vehicleMake = By.xpath(".//*[@id='pr3']/div/ul/li[2]/span[2]/strong");
    private By vehicleColour = By.xpath(".//*[@id='pr3']/div/ul/li[3]/span[2]/strong");

    public void assertConfirmPage(){
        Assert.assertEquals(browserContext.getBrowser().getTitle(), confirmPageTitle);
        browserEvent.waitForElementToBePresent(registrationNumber, 10);
        browserEvent.waitForElementToBePresent(vehicleMake, 10);
        browserEvent.waitForElementToBePresent(vehicleColour, 10);

        Assert.assertTrue(checkPageBody().contains("Check if a vehicle is taxed and has an MOT"));
        Assert.assertTrue(checkPageBody().contains("Is this the vehicle you are looking for?"));
    }

    private String checkPageBody(){
        return browserEvent.getText(pageBody);
    }

    public String getRegistrationNumber(){
        return browserEvent.getText(registrationNumber);
    }

    public String getVehicleMake(){
        return browserEvent.getText(vehicleMake);
    }

    public String getVehicleColour(){
        return browserEvent.getText(vehicleColour);
    }

    public void confirmVehicleDetails(String regnum, String make, String colour){
        Assert.assertEquals(getRegistrationNumber(),(regnum));
        Assert.assertEquals(getVehicleMake(),(make));
        Assert.assertEquals(getVehicleColour(),(colour));
    }


}
