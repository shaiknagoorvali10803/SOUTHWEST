package testSuite.TestCases;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testSuite.AccountPage.AccountPageDetails;
import testSuite.AccountPage.EnterAccountPageDetails;
import testSuite.AccountPage.clickAccountPageButton;
import testSuite.LoginPage.EnterLoginPageDetails;
import testSuite.LoginPage.LoginPageButtons;
import testSuite.LoginPage.LoginPageDetails;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;


public class InvalidInputStepDefinitions extends InitializeValues {
    String caseNumber;

    public InvalidInputStepDefinitions() {
        String user = System.getProperty("userEmail");
        System.out.println("------------ "+user);
        _initValues(user);
    }

    @When("Login Using Invalid Username and Password")
    public void invalid_username_and_password_is_entered() {
        testSessionInitiator(theActorInTheSpotlight());
        theActorInTheSpotlight().attemptsTo(EnterLoginPageDetails.enterUsername("123456789"));
        theActorInTheSpotlight().attemptsTo(EnterLoginPageDetails.enterPassword("123456789"));
        theActorInTheSpotlight().attemptsTo(LoginPageButtons.loginClick());
    }

    @Then("Login Error Message Is Displayed")
    public void invalid_Error_is_Displayed() {
        theActorInTheSpotlight().should(seeThat(the(LoginPageDetails.validateLoginErrorMessage()), isVisible()));
    }

    @And("User Searches with Invalid ARC Number")
    public void enterInvalidARCNumber() {
        theActorInTheSpotlight().attemptsTo(EnterAccountPageDetails.enterArcNumber("9541687624"));
        theActorInTheSpotlight().attemptsTo(clickAccountPageButton.clickNext());
    }

    @Then("No Account Found For ARC Is Displayed")
    public void validateNoAccountMessage() {
        theActorInTheSpotlight().should(seeThat(the(AccountPageDetails.validateNoAccountErrorMessage()), isVisible()));
    }

    @When("User Clicks Next Without Entering Value")
    public void clickNextWithoutEnteringData()
    {
        theActorInTheSpotlight().attemptsTo(clickAccountPageButton.clickNext());
        theActorInTheSpotlight().attemptsTo(clickAccountPageButton.clickNext());
    }

    @Then("Error Message For ARC Is Displayed on Mandatory Field")
    public void validateErrorMessageForARC()
    {
        String errorMessage = "Please enter some valid input. Input is not optional.";
        theActorInTheSpotlight().should(seeThat(the(AccountPageDetails.validateNoAccountErrorMessage("TMC Company Name")), containsText(errorMessage)));
        theActorInTheSpotlight().should(seeThat(the(AccountPageDetails.validateNoAccountErrorMessage("First Name")), containsText(errorMessage)));
        theActorInTheSpotlight().should(seeThat(the(AccountPageDetails.validateNoAccountErrorMessage("Last Name")), containsText(errorMessage)));
        theActorInTheSpotlight().should(seeThat(the(AccountPageDetails.validateNoAccountErrorMessage("Access Type")), containsText("Please select a choice.")));
        //To give demo
       /* try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }

    @When("User Enters Information With Company Name To Add To Your Account")
    public void enterInformationWithCompanyName() {

        theActorInTheSpotlight().attemptsTo(EnterAccountPageDetails.enterInformationForAccount("Travel_Agency_Name", travelAgency));
        theActorInTheSpotlight().attemptsTo(EnterAccountPageDetails.enterInformationForAccount("FirstName", "FirstTest"));
        theActorInTheSpotlight().attemptsTo(EnterAccountPageDetails.enterInformationForAccount("LastName", "LastTest"));
        theActorInTheSpotlight().attemptsTo(EnterAccountPageDetails.enterEmailInformationForAccount("firstLast@Testing.com"));
        theActorInTheSpotlight().attemptsTo(AccountPageDetails.selectAccessTypeInformationForAccount("TMC Fully Delegated"));
        theActorInTheSpotlight().attemptsTo(EnterAccountPageDetails.enterInformationForAccount("StartDate", "Apr 1, 2022"));
        theActorInTheSpotlight().attemptsTo(EnterAccountPageDetails.enterInformationForAccount("EndDate", "Jul 1, 2022"));
        theActorInTheSpotlight().attemptsTo(clickAccountPageButton.clickNext());
    }

    @Then("User validate the error message for mandatory fields in request page {string}, {string}")
    public void userValidateTheErrorMessageForMandatoryFieldsInRequestPage(String fName, String lName) {
        String errorMessage = "Please enter some valid input. Input is not optional.";
        if(fName.contains(""))
        {

        }
        else {
            theActorInTheSpotlight().should(seeThat(the(AccountPageDetails.validateNoAccountErrorMessage("First Name")), containsText(errorMessage)));
        }
        if(lName.contains(""))
        {

        }
        else{
            theActorInTheSpotlight().should(seeThat(the(AccountPageDetails.validateNoAccountErrorMessage("Last Name")), containsText(errorMessage)));
        }
    }

}
