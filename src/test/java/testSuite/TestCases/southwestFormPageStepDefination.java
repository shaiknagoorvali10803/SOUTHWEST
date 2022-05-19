package testSuite.TestCases;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import testSuite.AccountPage.AccountPageDetails;
import testSuite.HomePage.EnterHomePageDetails;
import testSuite.HomePage.clickHomePageButtons;
import testSuite.LoginPage.EnterLoginPageDetails;
import testSuite.LoginPage.LoginPageButtons;
import testSuite.Navigation.NavigateTo;
import testSuite.Navigation.TravelPortalHomePage;
import testSuite.SouthwestFormPage.EnterSouthwestFormPageDetails;
import testSuite.SouthwestFormPage.SouthwestPageButtons;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;


public class southwestFormPageStepDefination extends InitializeValues {
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    public void SetValues(String userEmail)
    {
        String email = System.setProperty("userEmail", userEmail);
        _initValues(System.getProperty("userEmail"));
    }


    @Given("User navigates to Status Match form by launching SouthwestForm Page")
    public void on_the_TravelPortal_home_page() {
        theActorCalled("User").attemptsTo(NavigateTo.theSouthwestFormPage());
        testSessionInitiator(theActorInTheSpotlight());
    }


    @Then("{string} form should be displayed")
    public void formShouldBeDisplayed(String field) {
        theActorInTheSpotlight().should(seeThat(the(EnterSouthwestFormPageDetails.formFields(field)), isVisible()));
    }

    @When("User provides alphanumeric value in Rapid Rewards Number {string} field")
    public void userProvidesAlphanumericValueInRapidRewardsNumberField(String field) {
        theActorInTheSpotlight().attemptsTo(EnterSouthwestFormPageDetails.enterFormFields(field,"abc"));
    }

    @When("User provides numeric value in Rapid Rewards Number {string} field")
    public void userProvidesNumericValueInRapidRewardsNumberField(String field) {
        theActorInTheSpotlight().attemptsTo(EnterSouthwestFormPageDetails.enterFormFields(field,"123"));
    }

    @When("User provides {string} in {string} field")
    public void userProvidesValueInField(String value,String field) {
        theActorInTheSpotlight().attemptsTo(EnterSouthwestFormPageDetails.enterFormFields(field,value));
    }

    @And("User submits the form For Southwest")
    public void userSubmitsTheFormForSouthwest() {
        theActorInTheSpotlight().attemptsTo(SouthwestPageButtons.submitForm());
    }

}
