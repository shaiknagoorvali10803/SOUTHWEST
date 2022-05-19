package testSuite.TestCases;

import GenericFunctions.WaitGeneric;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.interactions.Ensure;
import testSuite.AccountPage.AccountPageDetails;
import testSuite.HomePage.EnterHomePageDetails;
import testSuite.HomePage.clickHomePageButtons;
import testSuite.LoginPage.EnterLoginPageDetails;
import testSuite.LoginPage.LoginPageButtons;
import testSuite.Navigation.NavigateTo;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
public class loginTravellerPortalStepDefinitions extends InitializeValues {

    WaitGeneric wait;
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    public void SetValues(String userEmail)
    {
        String email = System.setProperty("userEmail", userEmail);
        _initValues(System.getProperty("userEmail"));
    }
    @Given("Travel portal is accessible and SetData for User {string}")
    public void on_the_TravelPortal_home_page(String index) {
        SetValues(index);
        theActorCalled("User").attemptsTo(NavigateTo.theTravelPortalHomePage());
        wait = testSessionInitiator(theActorInTheSpotlight());
        theActorInTheSpotlight().should(seeThat(the(LoginPageButtons.loginButtonOnHome(wait)), isVisible()));
        theActorInTheSpotlight().attemptsTo(LoginPageButtons.loginClickOnHome());
    }
    @When("User logs in as CTM Full Access role into the Travel Portal")
    public void loginToTravelPortal() {
        theActorInTheSpotlight().attemptsTo(EnterLoginPageDetails.enterUsername(userUsername));
        theActorInTheSpotlight().attemptsTo(EnterLoginPageDetails.enterPassword(userPassword));
        theActorInTheSpotlight().attemptsTo(LoginPageButtons.loginClick());
    }

    @When("User taps on accountSearch Dropdown and selects an account")
    public void selectAccountSearchDropdown()
    {
        WaitGeneric wait = testSessionInitiator(theActorInTheSpotlight());
        theActorInTheSpotlight().should(seeThat(the(EnterHomePageDetails.companyNameField(wait)), isVisible()));
        theActorInTheSpotlight().attemptsTo(EnterHomePageDetails.enterCompanyName(accountSearch));
        theActorInTheSpotlight().attemptsTo(clickHomePageButtons.selectDropdownforAccountSearch(companyName));
    }

    @And("The user is redirected to the Account page")
    public void accountPageisOpened()
    {
        theActorInTheSpotlight().should(seeThat(the(AccountPageDetails.accountNameTitle(wait)), containsText(companyName)));

    }

    @Then("Account home page should be displayed with CONTRACTS,REQUESTS,FUNDS,ACCOUNT PERFORMANCE and SETTINGS tabs")
    public void headerIsVisible()
    {
        theActorInTheSpotlight().should(seeThat(the(AccountPageDetails.headerTabs("CONTRACTS"))));
        theActorInTheSpotlight().should(seeThat(the(AccountPageDetails.headerTabs("REQUESTS"))));
        theActorInTheSpotlight().should(seeThat(the(AccountPageDetails.headerTabs("FUNDS"))));
        theActorInTheSpotlight().should(seeThat(the(AccountPageDetails.headerTabs("ACCOUNT PERFORMANCE"))));
        theActorInTheSpotlight().should(seeThat(the(AccountPageDetails.headerTabs("SETTINGS"))));

    }


}
