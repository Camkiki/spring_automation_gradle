package steps;

import com.pages.ConfirmVehiclePage;
import com.pages.VehicleEnquiryPage;
import com.pages.VehicleHomePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by tolaf on 29/04/2018.
 */

@ContextConfiguration("classpath:cucumber.xml")
public class VehicleSteps {

    @Autowired
    private VehicleHomePage vehicleHomePage;
    @Autowired
    private VehicleEnquiryPage vehicleEnquiryPage;
    @Autowired
    private ConfirmVehiclePage confirmVehiclePage;

    @Value("${base.url}")
    private String baseUrl;
    @Value("${registration.number}")
    private String regNumber;
    @Value("${vehicle.make}")
    private String vehMake;
    @Value("${vehicle.colour}")
    private String vehColour;

    @Given("^GOV DVLA Platform$")
    public void govDVLAPlatform() throws Throwable {
        vehicleHomePage.navigateToPage(baseUrl); //point of NullPointerException
        vehicleHomePage.clickOnStartNowButton();
    }

    @When("^User Trigger Vehicle Enquiry with Registration Number$")
    public void userTriggerVehicleEnquiryWithRegistrationNumber() throws Throwable {
        vehicleEnquiryPage.assertEnquiryPage();
        vehicleEnquiryPage.doVehicleEnquiry(regNumber);
    }

    @Then("^Vehicle Details is returned in Confirm Vehicle Page$")
    public void vehicleDetailsIsReturnedInConfirmVehiclePage() throws Throwable {
        confirmVehiclePage.assertConfirmPage();
    }

    @And("^Returned Vehicle Details match Expected Result for Vehicle$")
    public void returnedVehicleDetailsMatchExpectedResultForVehicle() throws Throwable {
        confirmVehiclePage.confirmVehicleDetails(regNumber, vehMake, vehColour);
    }
}
