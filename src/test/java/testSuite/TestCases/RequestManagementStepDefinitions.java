package testSuite.TestCases;

import GenericFunctions.WaitGeneric;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testSuite.AccountPage.EnterAccountPageDetails;
import testSuite.AccountPage.clickAccountPageButton;
import testSuite.Navigation.NavigateTo;
import testSuite.RequestPage.RequestPageDetails;
import testSuite.RequestPage.clickRequestPageButton;

import java.util.Random;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import net.serenitybdd.screenplay.ensure.Ensure;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;


public class RequestManagementStepDefinitions extends InitializeValues {
    WaitGeneric wait;

    public RequestManagementStepDefinitions() {
        String user = System.getProperty("userEmail");
        System.out.println("------------ " + user);
        _initValues(user);
    }

    @Then("User should be able to see Benefits dashboard under the Account details page")
    public void verifyAccountIsDisplayed() {
        wait = testSessionInitiator(theActorInTheSpotlight());
        theActorInTheSpotlight().should(seeThat(the(RequestPageDetails.benefitDashboardDisplayed()), isVisible()));
    }

    @And("Submit Request button should be available")
    public void verifySubmitRequestIsDisplayed() {
        theActorInTheSpotlight().should(seeThat(the(clickRequestPageButton.Request_Button_Displayed("Tier Experience")), isVisible()));
    }

    @And("Contact Admin button should be available")
    public void verifyContactAdminIsDisplayed() {
        theActorInTheSpotlight().should(seeThat(the(clickRequestPageButton.Contact_Admin_Button_Displayed("Tier Experience")), isVisible()));
    }

    @When("User Selects on Submit Request for {string}")
    public void clickSubmitRequest(String title) {
        theActorInTheSpotlight().attemptsTo(clickRequestPageButton.clickRequestButton(title));
    }

    @When("User Selects on Contact Admin for {string}")
    public void clickContactAdmin(String title) {
        theActorInTheSpotlight().attemptsTo(clickRequestPageButton.clickContactAdminButton(title));
    }

    @Then("Application should navigate to the Request Management page")
    public void validateRequestManagementPage() {
        theActorInTheSpotlight().should(seeThat(the(RequestPageDetails.requestPageTitleDisplayed()), isVisible()));
    }

    @And("Request Category dropdown should be auto populated with value {string}")
    public void requestCategoryDropdownShouldBeAutoPopulatedWithValue(String value) {
        theActorInTheSpotlight().should(seeThat(the(RequestPageDetails.requestDropDown("Request Category")), containsText(value)));
    }

    @And("Request Type dropdown  should be auto populated with value {string}")
    public void requestTypeDropdownShouldBeAutoPopulatedWithValue(String value) {
        theActorInTheSpotlight().should(seeThat(the(RequestPageDetails.requestDropDown("Request Type")), containsText(value)));
    }


    @When("User Validates {string} Current date falls under the start date & end date of Value")
    public void validateDateForRequestSection(String requestTitle) {
        theActorInTheSpotlight().attemptsTo(clickAccountPageButton.clickSortForTitle("Submitted on"));
        theActorInTheSpotlight().attemptsTo(clickAccountPageButton.clickSortForTitle("Submitted on"));
        String requestDate = RequestPageDetails.getRequestOverviewDate(theActorInTheSpotlight(), requestTitle);
        RequestPageDetails.validateCurrectDateIsBetweenRange(requestDate);
    }

    @Then("Additional Inventory Request Is Displayed")
    public void additionalInventoryRequestIsDisplayed() {
        theActorInTheSpotlight().should(seeThat(the(RequestPageDetails.inventoryRequestModal()), isVisible()));
    }

    @Then("User should be able to see Start a new request")
    public void userShouldBeAbleToSeeStartANewRequest() {
        theActorInTheSpotlight().should(seeThat(the(RequestPageDetails.createANewRequest()), isVisible()));
    }

    @When("User selects Start a new request")
    public void userSelectsStartANewRequest() {
        theActorInTheSpotlight().attemptsTo(clickRequestPageButton.clickCreateANewRequest());
    }

    @And("User selects Request Category as {string}")
    public void userSelectsRequestCategoryAs(String value) {
        theActorInTheSpotlight().attemptsTo(clickRequestPageButton.clickRequestDropdown("Request Category"));
        theActorInTheSpotlight().attemptsTo(clickRequestPageButton.selectRequestDropdownValue(value));
    }

    @And("User selects Request Type as {string}")
    public void userSelectsRequestTypeAs(String value) {
        theActorInTheSpotlight().attemptsTo(clickRequestPageButton.clickRequestDropdown("Request Type"));
        theActorInTheSpotlight().attemptsTo(clickRequestPageButton.selectRequestDropdownValue(value));

    }

    @Then("User should be able to select Start Request")
    public void userShouldBeAbleToSelectStartRequest() {
        theActorInTheSpotlight().attemptsTo(clickRequestPageButton.clickStartRequest());
    }

    @And("System should ask Submit the request by")
    public void systemShouldAskSubmitTheRequestBy() {
        theActorInTheSpotlight().should(seeThat(the(RequestPageDetails.submitTheRequestBy()), isVisible()));
    }

    @When("User selects {string}")
    public void userSelectsSubmitTheRequestBy(String value) {
        theActorInTheSpotlight().attemptsTo(clickRequestPageButton.clickRadioButtonForRequestBy(value));
        theActorInTheSpotlight().attemptsTo(clickAccountPageButton.clickNext());
    }

    @Then("User required to fill the information to create a case")
    public void userRequiredToFillTheInformationToCreateACase() {
        Random random = new Random();
        String randomNo = String.valueOf(random.nextInt(1000));
        System.setProperty("firstName", "FirstTest " + randomNo);
        theActorInTheSpotlight().attemptsTo(EnterAccountPageDetails.enterInformationForAccount("SBTP_StatusMatchFlow_First_Name", "FirstTest " + randomNo)); //
        theActorInTheSpotlight().attemptsTo(EnterAccountPageDetails.enterInformationForAccount("SBTP_StatusMatchFlow_Last_Name", "LastTest"));
        theActorInTheSpotlight().attemptsTo(EnterAccountPageDetails.enterEmailInformationForAccount("firstLast@Testing.com"));
        theActorInTheSpotlight().attemptsTo(EnterAccountPageDetails.enterInformationForAccount("SBTP_StatusMatchFlow_Rapid_RewardsNumber", "123456"));
        EnterAccountPageDetails.uplodadFileForRequest(theActorInTheSpotlight());
        //To upload the file
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        theActorInTheSpotlight().attemptsTo(clickAccountPageButton.clickNext());
    }

    @Then("Review the information is correct")
    public void reviewTheInformationIsCorrect() {
        theActorInTheSpotlight().should(seeThat(the(RequestPageDetails.validateRequestDetails("Traveler's Name")), containsText(System.getProperty("firstName") + " LastTest")));
        theActorInTheSpotlight().should(seeThat(the(RequestPageDetails.validateRequestDetails("Traveler's Corporate Email Address")), containsText("firstLast@Testing.com")));
        theActorInTheSpotlight().attemptsTo(clickAccountPageButton.clickSubmit());
    }

    @And("User selects finish")
    public void userSelectsFinish() {
        theActorInTheSpotlight().attemptsTo(clickAccountPageButton.clickFinish(wait));


//To be removed
        try {
            Thread.sleep(50000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        theActorCalled("User").attemptsTo(NavigateTo.theTravelPortalHomePage());
    }

    @When("User fills the information First Name as {string} LastName as {string} email as {string}")
    public void userFillsTheInformationFirstNameAsLastNameAsEmailAs(String testFirstName, String testLastName, String testEmail) {
        theActorInTheSpotlight().attemptsTo(EnterAccountPageDetails.enterInformationForAccount("SBTP_StatusMatchFlow_First_Name_Traveler", testFirstName)); //
        theActorInTheSpotlight().attemptsTo(EnterAccountPageDetails.enterInformationForAccount("SBTP_StatusMatchFlow_Last_Name_Traveler", testLastName));
        theActorInTheSpotlight().attemptsTo(EnterAccountPageDetails.enterEmailInformationForAccount(testEmail));

        theActorInTheSpotlight().attemptsTo(clickAccountPageButton.clickNext());

    }


    @When("User fills the information First Name as {string} LastName as {string} email as {string} companyName as {string} rapidRewardNumber as {string}")
    public void userRequiredToFillTheInformationOnBehalfOfTraveller(String testFName, String testLName, String testEmail, String testCompanyName, String testRewardName) {
        theActorInTheSpotlight().attemptsTo(EnterAccountPageDetails.enterInformationForAccount("SBTP_StatusMatchFlow_First_Name", testFName)); //
        theActorInTheSpotlight().attemptsTo(EnterAccountPageDetails.enterInformationForAccount("SBTP_StatusMatchFlow_Last_Name", testLName));
        theActorInTheSpotlight().attemptsTo(EnterAccountPageDetails.enterEmailInformationForAccount(testEmail));
        theActorInTheSpotlight().attemptsTo(EnterAccountPageDetails.enterInformationForAccount("SBTP_StatusMatchFlow_Rapid_RewardsNumber", testRewardName));

        EnterAccountPageDetails.uplodadFileForRequest(theActorInTheSpotlight());
        theActorInTheSpotlight().attemptsTo(clickAccountPageButton.clickNext());
    }

    @Then("Review the information is correct {string} and {string} and {string}")
    public void reviewTheInformationIsCorrectAnd(String fname, String lname, String testEmail) {
        theActorInTheSpotlight().should(seeThat(the(RequestPageDetails.validateRequestDetails("Traveler's Name")), containsText(fname + " " + lname)));
        theActorInTheSpotlight().should(seeThat(the(RequestPageDetails.validateRequestDetails("Traveler's Corporate Email Address")), containsText(testEmail)));
        theActorInTheSpotlight().attemptsTo(clickAccountPageButton.clickSubmit());

    }
}