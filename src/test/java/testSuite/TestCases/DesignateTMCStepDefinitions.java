package testSuite.TestCases;

import GenericFunctions.ScrollGeneric;
import GenericFunctions.WaitGeneric;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.Ensure;
import net.serenitybdd.screenplay.actions.Switch;
//import cucumber.api.DataTable;
import testSuite.AccountPage.*;
import testSuite.HomePage.EnterHomePageDetails;
import testSuite.HomePage.HomePageDetails;
import testSuite.HomePage.HomePageLocator;
import testSuite.HomePage.clickHomePageButtons;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;


public class DesignateTMCStepDefinitions extends InitializeValues {
    public String caseNumber,randomNo;
    WaitGeneric wait;

    public DesignateTMCStepDefinitions() {

        String user = System.getProperty("userEmail");
        System.out.println("------------ "+user);
        _initValues(user);
    }

    @When("The Travel Portal landing page is displayed")
    public void verifyAccountIsDisplayed() {
        wait = testSessionInitiator(theActorInTheSpotlight());

        System.out.println("Account Type is "+accountType);
        if (accountType.contains("TMC")) {
            theActorInTheSpotlight().should(seeThat(the(EnterHomePageDetails.companyNameField(wait)), isVisible()));
        } else
        {
            theActorInTheSpotlight().should(seeThat(the(HomePageDetails.givenAccount(companyName, wait)), isVisible()));
        }
    }

    @When("Account is selected from homepage")
    public void clickOnAccount()
    {
        if (accountType.contains("TMC")) {
            theActorInTheSpotlight().attemptsTo(EnterHomePageDetails.enterCompanyName(accountSearch));
            theActorInTheSpotlight().attemptsTo(clickHomePageButtons.selectDropdownforAccountSearch(companyName));
        }
        else
        {
            theActorInTheSpotlight().attemptsTo(clickHomePageButtons.openAccountDisplayed(companyName));
        }
    }

    @When("User Navigate to Account Settings")
    public void selectSettingTab() {
        theActorInTheSpotlight().attemptsTo(clickAccountPageButton.clickHeaderTabs("SETTINGS"));
    }

    @When("User navigates to Requests tab")
    public void selectRequestTab() {
        theActorInTheSpotlight().attemptsTo(clickAccountPageButton.clickHeaderTabs("REQUESTS"));
    }

    @Then("User should see the Designate TMC")
    public void designateTMCButtonIsVisible() {
        theActorInTheSpotlight().should(seeThat(the(AccountPageDetails.designateTMC(wait)), isVisible()));
    }

    @Then("User navigates to Contacts")
    public void userAccessSectionIsVisible() {
        theActorInTheSpotlight().should(seeThat(the(AccountPageDetails.userAccessSection()), isVisible()));
    }

    @Then("User should be able to see all his contacts")
    public void userContactIsVisible() {
        theActorInTheSpotlight().should(seeThat(the(AccountPageDetails.userContact(contact[0])), isVisible()));
        theActorInTheSpotlight().should(seeThat(the(AccountPageDetails.userContact(contact[1])), isVisible()));
        theActorInTheSpotlight().should(seeThat(the(AccountPageDetails.userContact(contact[2])), isVisible()));
    }

    @When("User clicks on Designate TMC")
    public void clickDesignateTMC()
    {
        theActorInTheSpotlight().attemptsTo(clickAccountPageButton.clickDesignateTMC());
    }


    @And("User Searches with ARC Number")
    public void enterARCNumber() {
        theActorInTheSpotlight().attemptsTo(EnterAccountPageDetails.enterArcNumber(ArcNumber));
        theActorInTheSpotlight().attemptsTo(clickAccountPageButton.clickNext());
    }

    @When("The details of Travel Agency should be Read only")
    public void validate_populated_data_on_form_page() {
        theActorInTheSpotlight().should(seeThat(the(AccountPageDetails.validateFormPageDetails("ARC Number")), containsText(ArcNumber)));
        theActorInTheSpotlight().should(seeThat(the(AccountPageDetails.validateFormPageDetails("Travel Agency")), containsText(travelAgency)));
    }

    @And("User Enters Information To Add To Your Account")
    public void enterInformation() {
        //To give demo
       /* try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        theActorInTheSpotlight().attemptsTo(EnterAccountPageDetails.enterInformationForAccount("FirstName", "FirstTest")); //
        theActorInTheSpotlight().attemptsTo(EnterAccountPageDetails.enterInformationForAccount("LastName", "LastTest"));
        theActorInTheSpotlight().attemptsTo(EnterAccountPageDetails.enterEmailInformationForAccount("firstLast@Testing.com"));
        theActorInTheSpotlight().attemptsTo(AccountPageDetails.selectAccessTypeInformationForAccount("TMC Fully Delegated"));
        theActorInTheSpotlight().attemptsTo(EnterAccountPageDetails.enterInformationForAccount("StartDate", "Apr 1, 2022"));
        theActorInTheSpotlight().attemptsTo(EnterAccountPageDetails.enterInformationForAccount("EndDate", "Jul 1, 2022"));
        theActorInTheSpotlight().attemptsTo(clickAccountPageButton.clickNext());

    }


    @Then("Application should display Request Details")
    public void validateDetails() {
        theActorInTheSpotlight().should(seeThat(the(AccountPageDetails.validateRequestDetails("FirstTest")), isVisible()));
        theActorInTheSpotlight().should(seeThat(the(AccountPageDetails.validateRequestDetails("LastTest")), isVisible()));
        theActorInTheSpotlight().should(seeThat(the(AccountPageDetails.validateRequestDetails("firstLast@Testing.com")), isVisible()));
        //To give demo
        /*try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        theActorInTheSpotlight().attemptsTo(clickAccountPageButton.clickNext());
    }

    @And("User Goes To Request DashBoard")
    public void clickGoToDashboard(){
        caseNumber = AccountPageDetails.getCaseNumberFromInformationPage(theActorInTheSpotlight(),wait);
        theActorInTheSpotlight().attemptsTo(clickAccountPageButton.clickAccountDashboard());
        System.setProperty("caseId",caseNumber);
    }

    @Then("User Validate Request Is Available")
    public void validateRequest(){
        theActorInTheSpotlight().attemptsTo(clickAccountPageButton.clickSortForTitle("Submitted on"));
        theActorInTheSpotlight().attemptsTo(clickAccountPageButton.clickSortForTitle("Submitted on"));
        theActorInTheSpotlight().attemptsTo(clickAccountPageButton.clickSortForTitle("Submitted on"));
        theActorInTheSpotlight().should(seeThat(the(AccountPageDetails.validateRequestOnRequestPage("Case Number")), containsText(caseNumber)));
    }

    @Then("User Open Request on the Top")
    public void openRequestOnTheTop(){
        theActorInTheSpotlight().attemptsTo(clickAccountPageButton.clickSortForTitle("Submitted on"));
        theActorInTheSpotlight().attemptsTo(clickAccountPageButton.clickSortForTitle("Submitted on"));
        theActorInTheSpotlight().attemptsTo(clickAccountPageButton.clickSortForTitle("Submitted on"));
        theActorInTheSpotlight().attemptsTo(clickAccountPageButton.clickCaseOnTop());
        theActorInTheSpotlight().attemptsTo(Switch.toTheOtherWindow());
    }

    @When("User Clicks On New Request Created")
    public void openRequest(){
        theActorInTheSpotlight().attemptsTo(clickAccountPageButton.clickCaseNumber(caseNumber,wait));
        theActorInTheSpotlight().attemptsTo(Switch.toTheOtherWindow());
    }

    @Then("Validate Information on Case Detail Page")
    public void validateCaseDetail(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        theActorInTheSpotlight().should(seeThat(the(AccountPageDetails.validateCaseDetails("Case Number")), containsText(caseNumber)));
        theActorInTheSpotlight().should(seeThat(the(AccountPageDetails.validateCaseDetails("Account Name")), containsText(companyName)));
        //To give demo
      /*  try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }

    @Then("Validate Information on New Created Request")
    public void validateCaseDetailForNewRequest(){
        ScrollGeneric.scrollDownToEnd(theActorInTheSpotlight());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        theActorInTheSpotlight().should(seeThat(the(AccountPageDetails.validateCaseDetails("Account Name")), containsText(companyName)));
        theActorInTheSpotlight().should(seeThat(the(AccountPageDetails.validateCaseDetails("First Name")), containsText(System.getProperty("firstName"))));
        theActorInTheSpotlight().should(seeThat(the(AccountPageDetails.validateCaseDetails("Last Name")), containsText("LastTest")));
        //theActorInTheSpotlight().should(seeThat(the(AccountPageDetails.validateCaseDetails("Corporate Email")), containsText("firstLast@Testing.com")));
        theActorInTheSpotlight().should(seeThat(the(AccountPageDetails.validateCaseDetails("Rapid Rewards Number")), containsText("123456")));

    }

    @When("User clicks on Dropdown available at the end of each contact")
    public void userClicksOnDropdownAvailableAtTheEndOfContact() {
        theActorInTheSpotlight().attemptsTo(clickAccountPageButton.scrollToContactButton(contact[0]));
        theActorInTheSpotlight().attemptsTo(clickAccountPageButton.clickContactDropdown(contact[0]));
    }

    @Then("User should see the options Edit Permissions, Remove User")
    public void userShouldSeeTheOptionsEditPermissionsRemoveUser() {
        theActorInTheSpotlight().should(seeThat(the(AccountPageDetails.validateContactDropdownOptions("Edit Permission")), isVisible()));
        theActorInTheSpotlight().should(seeThat(the(AccountPageDetails.validateContactDropdownOptions("Remove User")), isVisible()));
    }

    @Then("User should see the option View Permission")
    public void userShouldSeeTheOptionViewPermission() {
        theActorInTheSpotlight().should(seeThat(the(AccountPageDetails.validateContactDropdownOptions("View Permissions")), isVisible()));
    }

    @When("User selects the View permission")
    public void userSelectOptionViewPermission() {
        theActorInTheSpotlight().attemptsTo(clickAccountPageButton.clickContactDropdownOption("View Permissions"));
    }

    @When("User selects the Edit permission")
    public void userSelectOptionEditPermission() {
        theActorInTheSpotlight().attemptsTo(clickAccountPageButton.clickContactDropdownOption("Edit Permissions"));
    }

    @Then("User should navigate to Permission access page")
    public void verifyUserNavigatesToPermissionPage() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        theActorInTheSpotlight().should(seeThat(the(AccountPageDetails.validatePermissionPageTitle()), isVisible()));
    }


    @And("Should not be able to edit the permissions")
    public void shouldNotBeAbleToEditThePermissions() {
        theActorInTheSpotlight().should(seeThat(the(AccountPageDetails.permissionButton("Delegate a Full Access Admin")), isNotEnabled()));
    }

    @And("check the columns Name, Email, Phone, Role, Dropdown for permissions")
    public void checkTheColumnsNameEmailPhoneRoleDropdownForPermissions() {
        theActorInTheSpotlight().should(seeThat(the(AccountPageDetails.validateContactsDetails(contact[1],"Email")), containsText(contactEmail)));
        theActorInTheSpotlight().should(seeThat(the(AccountPageDetails.validateContactsDetails(contact[1],"Phone")), containsText(contactPhone)));
        theActorInTheSpotlight().should(seeThat(the(AccountPageDetails.validateContactsDetails(contact[1],"Role")), containsText(contactRole)));
        userClicksOnDropdownAvailableAtTheEndOfContact();
        userShouldSeeTheOptionsEditPermissionsRemoveUser();

    }

    @Then("User should be able to view Active Contracts")
    public void userShouldBeAbleToViewActiveContracts() {
        theActorInTheSpotlight().should(seeThat(the(AccountPageDetails.userContact(companyName)), isVisible()));
    }

    @When("User check the {string}")
    public void userCheckTheFollowingTitle(String title) {
        theActorInTheSpotlight().attemptsTo(clickAccountPageButton.clickCheckBoxForTitle(title));
    }

    @And("Selects save")
    public void selectsSave() {
        theActorInTheSpotlight().attemptsTo(clickAccountPageButton.clickSaveButton());
        theActorInTheSpotlight().attemptsTo(clickAccountPageButton.clickModalSaveButton());
    }
}
