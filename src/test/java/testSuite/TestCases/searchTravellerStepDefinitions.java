package testSuite.TestCases;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import testSuite.LoginPage.LoginPageButtons;
import testSuite.Navigation.NavigateTo;
import testSuite.search.SearchFor;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class searchTravellerStepDefinitions {
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^(.*) is on the SwaBiz home page")
    public void on_the_SwaBiz_home_page(String actor) {
        theActorCalled(actor).attemptsTo(NavigateTo.theSwaBizHomePage());
    }

    @When("^s?he searches for companyId \"(.*)\"")
    public void search_for(String companyId) {
        theActorInTheSpotlight().attemptsTo(SearchFor.traveller(companyId));
    }

    @When("User Click on Continue")
    public void click_continue()
    {
        theActorInTheSpotlight().attemptsTo(LoginPageButtons.continueClick());
    }

    @Then("^error message should contain the word \"(.*)\"")
    public void error_message_should_contain_the_word(String errorMsg) {
//        theActorInTheSpotlight().should(
//                seeThat("error message",
//                        SearchResult.errorMsg(), containsStringIgnoringCase(errorMsg))
//        );
    }



}
