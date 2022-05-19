package testSuite.TestCases;

import GenericFunctions.KeyPressGeneric;
import GenericFunctions.ScrollGeneric;
import GenericFunctions.WaitGeneric;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.ScrollTo;
import net.serenitybdd.screenplay.actions.ScrollToBy;
import net.serenitybdd.screenplay.actions.ScrollToWebElement;
import testSuite.LoginPage.EnterLoginPageDetails;
import testSuite.LoginPage.LoginPageButtons;
import testSuite.Navigation.NavigateTo;
import testSuite.SalesforcePage.EnterSalesforcePageDetails;
import testSuite.SalesforcePage.SalesforcePageDetails;
import testSuite.SalesforcePage.clickSalesforcePageButtons;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;


public class swabizSalesForceCaseStepDefinitions extends InitializeValues {
    String caseNumber;
    WaitGeneric wait;
    public swabizSalesForceCaseStepDefinitions() {
        try {
            String user = System.getProperty("userEmail");
            System.out.println("------------ "+user);
            _initValues(user);
        }
        catch(Exception e)
        {

        }
    }

    @Given("Salesforce is accessible")
    public void navigate_to_salesforce()
    {
        setSystemValues();
        theActorCalled("User").attemptsTo(NavigateTo.theSwabizSalesforceLoginPage());
        wait = testSessionInitiator(theActorInTheSpotlight());
        theActorInTheSpotlight().should(seeThat(the(LoginPageButtons.salesforceloginButton()), isVisible()));
        theActorInTheSpotlight().attemptsTo(EnterLoginPageDetails.salesforceEnterUsername(username));
        theActorInTheSpotlight().attemptsTo(EnterLoginPageDetails.salesforceEnterPassword(password));
        theActorInTheSpotlight().attemptsTo(LoginPageButtons.salesforceLoginClick());

        //Added due to verification Code
       try {
           Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
       }
    }

    @Given("Salesforce is accessible with username {string}")
    public void navigate_to_salesforce(String username)
    {
        _initValues(username);
        theActorCalled("User").attemptsTo(NavigateTo.theSwabizSalesforceLoginPage());
        theActorInTheSpotlight().should(seeThat(the(LoginPageButtons.salesforceloginButton()), isVisible()));
        theActorInTheSpotlight().attemptsTo(EnterLoginPageDetails.salesforceEnterUsername(userUsername));
        theActorInTheSpotlight().attemptsTo(EnterLoginPageDetails.salesforceEnterPassword(userPassword));
        theActorInTheSpotlight().attemptsTo(LoginPageButtons.salesforceLoginClick());
        //
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Given("Salesforce is accessible with main username {string}")
    public void navigate_to_salesforce_with_main(String userUsername)
    {
        _initValues(userUsername);
        theActorCalled("User").attemptsTo(NavigateTo.theSwabizSalesforceLoginPage());
        theActorInTheSpotlight().should(seeThat(the(LoginPageButtons.salesforceloginButton()), isVisible()));
        theActorInTheSpotlight().attemptsTo(EnterLoginPageDetails.salesforceEnterUsername(username));
        theActorInTheSpotlight().attemptsTo(EnterLoginPageDetails.salesforceEnterPassword(password));
        theActorInTheSpotlight().attemptsTo(LoginPageButtons.salesforceLoginClick());
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    @Given("Salesforce is accessible and Setdata {string}")
    public void navigate_to_salesforce_with_testdata(String index)
    {
        System.setProperty("index",index);
        System.setProperty("caseId","00005041");
        _initValues(index);
        theActorCalled("User").attemptsTo(NavigateTo.theSwabizSalesforceLoginPage());
        theActorInTheSpotlight().should(seeThat(the(LoginPageButtons.salesforceloginButton()), isVisible()));
        theActorInTheSpotlight().attemptsTo(EnterLoginPageDetails.salesforceEnterUsername(username));
        theActorInTheSpotlight().attemptsTo(EnterLoginPageDetails.salesforceEnterPassword(password));
        theActorInTheSpotlight().attemptsTo(LoginPageButtons.salesforceLoginClick());
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("User logs in as System Admin Role into SWA Business Salesforce")
    public void validateUserIsOnSalesforceHomePAge() {
        clickSalesforcePageButtons.clickCloseCaseOpened(theActorInTheSpotlight());
        theActorCalled("User").attemptsTo(NavigateTo.theSwabizSalesforceLoginPage());
        theActorInTheSpotlight().attemptsTo(clickSalesforcePageButtons.clickSearchFieldButton());
        theActorInTheSpotlight().should(seeThat(the(clickSalesforcePageButtons.searchFieldButton()), isVisible()));

    }

    @And("search for Cases")
    public void validateUserIsAbleToSearchCase() {
        caseNumber = System.getProperty("caseId");
        theActorInTheSpotlight().attemptsTo(EnterSalesforcePageDetails.enterCaseInSearchField(System.getProperty("caseId")));
    }

    @And("search for Cases {string}")
    public void validateUserIsAbleToSearchCase(String caseId) {
        caseNumber = caseId;
        System.setProperty("caseId",caseId);
        theActorInTheSpotlight().attemptsTo(EnterSalesforcePageDetails.enterCaseInSearchField(System.getProperty("caseId")));
    }

    @Then("User should be able to see Cases as part of search results")
    public void validateSearchResult()
    {
        theActorInTheSpotlight().should(seeThat(the(clickSalesforcePageButtons.search_result_Displayed(caseNumber)), isVisible()));
    }

    @When("User selects Cases")
    public void openSearchResultCase()
    {
        theActorInTheSpotlight().attemptsTo(clickSalesforcePageButtons.clickSearchResult(caseNumber));
    }

    @Then("User should be able to see the Case home page")
    public void validateCaseIsOpened() {
        theActorInTheSpotlight().should(seeThat(the(SalesforcePageDetails.casePageTitle(wait)), containsText(caseNumber)));

    }

    @And("Origin as Travel Portal")
    public void validateCaseDetailOriginAsTravelPortal() {
        theActorInTheSpotlight().should(seeThat(the(SalesforcePageDetails.casePageDetails("Case Origin")), containsText("Travel Portal")));
    }

    @And("Type as TMC Designation")
    public void validateCaseDetailTypeAsTMC() {
        theActorInTheSpotlight().should(seeThat(the(SalesforcePageDetails.casePageDetails("Type")), containsText("TMC Designation")));
    }

    @And("Description information should be same as the Travel Portal {string}")
    public void descriptionInformationShouldBeSameAsTheTravelPortal(String testCaseType) {
        theActorInTheSpotlight().should(seeThat(the(SalesforcePageDetails.casePageDescription()), containsText("Travel Agency Name: "+travelAgency)));
        if(testCaseType.contains("nonvalid"))
        {
            theActorInTheSpotlight().should(seeThat(the(SalesforcePageDetails.casePageDescription()), containsText("ARC Number: 9541687624")));
        }
        else
        {
            theActorInTheSpotlight().should(seeThat(the(SalesforcePageDetails.casePageDescription()), containsText("ARC Number: "+ArcNumber)));
        }
        theActorInTheSpotlight().should(seeThat(the(SalesforcePageDetails.casePageDescription()), containsText("Selected Role: TMC Fully Delegated")));
        theActorInTheSpotlight().should(seeThat(the(SalesforcePageDetails.casePageDescription()), containsText("Contact Name: FirstTest LastTest")));
        theActorInTheSpotlight().should(seeThat(the(SalesforcePageDetails.casePageDescription()), containsText("firstLast@Testing.com")));
        theActorInTheSpotlight().should(seeThat(the(SalesforcePageDetails.casePageDescription()), containsText("Start Date: 4/1/2022")));
        theActorInTheSpotlight().should(seeThat(the(SalesforcePageDetails.casePageDescription()), containsText("End Date: 7/1/2022")));
    }

    @When("User should be able to see Close Opened Case")
    public void closeOpenedCase()
    {
        theActorInTheSpotlight().attemptsTo(clickSalesforcePageButtons.clickCloseCaseOpened(caseNumber));
    }

    @And("Contact as CTM filling the request")
    public void contactAsCTMFillingTheRequest() {
        theActorInTheSpotlight().should(seeThat(the(SalesforcePageDetails.casePageLink("Account Name")), containsText(companyName)));
    }

    @And("Account as Corporate Account selected on Portal")
    public void accountAsCorporateAccountSelectedOnPortal() {
        theActorInTheSpotlight().should(seeThat(the(SalesforcePageDetails.casePageLink("Contact Name")), containsText("")));
    }

    @And("Select compose on the Email component")
    public void selectComposeOnTheEmailComponent() {
        theActorInTheSpotlight().attemptsTo(clickSalesforcePageButtons.clickComposeEmail());
    }

    @Then("Fields to compose email should be appeared")
    public void fieldsToComposeEmailShouldBeAppeared() {
        theActorInTheSpotlight().should(seeThat(the(SalesforcePageDetails.emailFieldFrom(wait)), containsText(username.toLowerCase())));
        theActorInTheSpotlight().should(seeThat(the(SalesforcePageDetails.emailFieldBcc()), containsText(username.toLowerCase())));
    }

    @And("Select App Launcher and search for {string}")
    public void selectAppLauncherAndSearch(String item) {
        clickSalesforcePageButtons.clickCloseCaseOpened(theActorInTheSpotlight());
        theActorCalled("User").attemptsTo(NavigateTo.theSwabizSalesforceLoginPage());
        theActorInTheSpotlight().attemptsTo(clickSalesforcePageButtons.clickApplauncher());
        theActorInTheSpotlight().attemptsTo(EnterSalesforcePageDetails.enterValueInSearchFieldForAppLauncher(item));
    }

    @Then("User should be able to see {string} Home Page")
    public void userShouldBeAbleToSeeHomePage(String item) {
        theActorInTheSpotlight().should(seeThat(the(SalesforcePageDetails.appLauncherSearchResult(item)), isVisible()));
    }

    @When("User selects {string} from App Launcher Search")
    public void userSelectsResultFromAppLauncherSearch(String result) {
        theActorInTheSpotlight().attemptsTo(clickSalesforcePageButtons.clickApplauncherSearchResult(result));
    }

    @Then("User should see the all {string} on left side")
    public void userShouldSeeTheAllClausesOnLeftSide(String clauseType) {
        theActorInTheSpotlight().should(seeThat(the(SalesforcePageDetails.libraryLeftNavbar(clauseType)), isVisible()));
    }

    @When("User selects {string} Tab from Library Page")
    public void userSelectsTabFromLibraryPage(String tabName) {
        theActorInTheSpotlight().attemptsTo(clickSalesforcePageButtons.clickLibraryPageTab(tabName));
    }

    @Then("User verify options {string}, {string}, {string}, {string} and {string} are displayed in Library Page")
    public void userVerifyOptionsAndAreDisplayedInLibraryPage(String tab1, String tab2, String tab3, String tab4, String tab5) {
        theActorInTheSpotlight().should(seeThat(the(SalesforcePageDetails.libraryNavigationTab(tab1)), isVisible()));
        theActorInTheSpotlight().should(seeThat(the(SalesforcePageDetails.libraryNavigationTab(tab2)), isVisible()));
        theActorInTheSpotlight().should(seeThat(the(SalesforcePageDetails.libraryNavigationTab(tab3)), isVisible()));
        theActorInTheSpotlight().should(seeThat(the(SalesforcePageDetails.libraryNavigationTab(tab4)), isVisible()));
        theActorInTheSpotlight().should(seeThat(the(SalesforcePageDetails.libraryNavigationTab(tab5)), isVisible()));
    }

    @And("Select Navigation Menu and select {string}")
    public void selectNavigationMenuAndSelect(String option) {
        theActorInTheSpotlight().attemptsTo(clickSalesforcePageButtons.clickShowNavigationMenu());
        theActorInTheSpotlight().attemptsTo(clickSalesforcePageButtons.selectOptionFromNavigationMenu(option));
    }

    @And("Select Different Category from Left Nav {string}")
    public void theUserGoesToNav(String option) {
        theActorInTheSpotlight().attemptsTo(clickSalesforcePageButtons.selectOptionFromLeftNavigation(option));
    }

    @And("The user goes to {string} folder in {string} Page")
    public void theUserGoesToReportFolder(String option, String page) {
        theActorInTheSpotlight().attemptsTo(EnterSalesforcePageDetails.enterFolderInSearchField(option,page));
        theActorInTheSpotlight().attemptsTo(clickSalesforcePageButtons.openSearchedReport());
    }

    @And("The user goes to {string} folder")
    public void theUserGoesToFolder(String option) {
        theActorInTheSpotlight().attemptsTo(clickSalesforcePageButtons.openSearchedReport(option));
    }



    @And("The user goes to {string} report")
    public void theUserGoesToReport(String option) {
        theActorInTheSpotlight().attemptsTo(clickSalesforcePageButtons.selectOptionFromLeftNavigation("All Reports"));
        theActorInTheSpotlight().attemptsTo(EnterSalesforcePageDetails.enterReportInSearchField(option));
        theActorInTheSpotlight().attemptsTo(clickSalesforcePageButtons.openSearchedReport());
    }

    @And("The user search for {string} report")
    public void searchForReportAndOpen(String option) {
        theActorInTheSpotlight().attemptsTo(EnterSalesforcePageDetails.enterReportInSearchField(option));
        theActorInTheSpotlight().attemptsTo(clickSalesforcePageButtons.openSearchedReport());
    }

    @Then("The User should be able to see the all cases with a type value of {string}")
    public void theUserShouldBeAbleToSeeTheAllCasesWithATypeValueOf(String header) {

        SalesforcePageDetails.switchToReportFrame(theActorInTheSpotlight());
        theActorInTheSpotlight().should(seeThat(the(SalesforcePageDetails.reportPageHeader()), containsText(header)));
    }

    @Then("User should see Status Match report grouped by Case Outcome and sub-grouped by Outcome Reason")
    public void userFilteredWithGroupedByCaseOutcomeAndSubGroupedByOutcomeReason() {
        theActorInTheSpotlight().should(seeThat(the(SalesforcePageDetails.reportPageHeader("Traveler's Name",wait)), isVisible()));
    }

    @And("User should see Report with columns {string}, {string}, {string},{string}")
    public void userShouldSeeReportWithColumns(String arg0, String arg1, String arg2, String arg3) {
        SalesforcePageDetails.switchToReportFrame(theActorInTheSpotlight());

        theActorInTheSpotlight().should(seeThat(the(SalesforcePageDetails.reportPageColumn(arg0)), isVisible()));
        theActorInTheSpotlight().should(seeThat(the(SalesforcePageDetails.reportPageColumn(arg1)), isVisible()));
        theActorInTheSpotlight().should(seeThat(the(SalesforcePageDetails.reportPageColumn(arg2)), isVisible()));
        theActorInTheSpotlight().should(seeThat(the(SalesforcePageDetails.reportPageColumn(arg3)), isVisible()));
     }

    @When("User Selects the Time filter")
    public void userSelectsTheTimeFilter() {
        theActorInTheSpotlight().attemptsTo(clickSalesforcePageButtons.openFilterOnReportPage());
        theActorInTheSpotlight().attemptsTo(clickSalesforcePageButtons.clickDateClosedOpenedFilter());
        theActorInTheSpotlight().attemptsTo(clickSalesforcePageButtons.clickFilterDateRangeDropdown());
        theActorInTheSpotlight().attemptsTo(clickSalesforcePageButtons.selectDropdownRangeForFilter());
    }

    @And("User Generates the Report")
    public void userGeneratesTheReport() {
        theActorInTheSpotlight().attemptsTo(clickSalesforcePageButtons.clickApplyButton());
    }

    @Then("And User should be able to see the list of cases Approved and Denied")
    public void userFilteredWithGroupedByCaseOutcomeAndSubGroupedByOutcomeReasonAfterFilter() {
        theActorInTheSpotlight().should(seeThat(the(SalesforcePageDetails.reportPageHeader("Traveler's Name",wait)), isVisible()));
    }

    @When("User to edit {string} field")
    public void userToEditCaseOutcomeField(String field) {
        theActorInTheSpotlight().attemptsTo(clickSalesforcePageButtons.clickEditCaseField(field));
    }


    @Then("Verify {string} field should be editable")
    public void verifyCaseOutcomeFieldShouldBeEditable(String field) {
        theActorInTheSpotlight().should(seeThat(the(SalesforcePageDetails.casePageEditField(field)), isVisible()));
    }

    @And("User selects {string} as {string}")
    public void userSelectsAs(String field, String value) {
        clickSalesforcePageButtons.scrollToField(theActorInTheSpotlight(),userUsername);
        theActorInTheSpotlight().attemptsTo(clickSalesforcePageButtons.openDropdownForField(field));
        theActorInTheSpotlight().attemptsTo(clickSalesforcePageButtons.clickDropDownItemForField(value));
    }

    @And("Save the Case")
    public void saveTheCase() {
        theActorInTheSpotlight().attemptsTo(clickSalesforcePageButtons.clickSaveButtonForCase());
    }

    @Then("User should receive an error On Saving Case Page")
    public void userShouldReceiveAnErrorOnSavingCasePage() {
        theActorInTheSpotlight().should(seeThat(the(SalesforcePageDetails.casePageErrorMessageOnSaving()), isVisible()));
    }

    @Then("The user search for {string} contact")
    public void theUserSearchForContact(String contactName) {
        theActorInTheSpotlight().attemptsTo(EnterSalesforcePageDetails.enterContactInSearchField(contactName));
        KeyPressGeneric.pressEnterKey(theActorInTheSpotlight());
        theActorInTheSpotlight().attemptsTo(clickSalesforcePageButtons.openSearchedContacts());
    }

    @And("User navigate Edit Permission for contact")
    public void userNavigateEditPermissionForContact() {
        ScrollGeneric.scrollDownToEnd(theActorInTheSpotlight());
        theActorInTheSpotlight().attemptsTo(clickSalesforcePageButtons.openAllRelatedAccountsForContact());
        theActorInTheSpotlight().attemptsTo(clickSalesforcePageButtons.openEditPermissionDropdownForContact(secondaryAccount));
        theActorInTheSpotlight().attemptsTo(clickSalesforcePageButtons.clickEditPermissionForContact());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("User {string} permission for {string} for Contact")
    public void userPermissionForForContact(String actionTo, String item) {
        theActorInTheSpotlight().attemptsTo(clickSalesforcePageButtons.clickPermissionThatNeedsToBeClicked(item));
        if(actionTo.contains("disable"))
        {
            theActorInTheSpotlight().attemptsTo(clickSalesforcePageButtons.clickPermissionAddOrRemove("Move selection to Available"));
        }
        else
        {
            theActorInTheSpotlight().attemptsTo(clickSalesforcePageButtons.clickPermissionAddOrRemove("Move selection to Chosen"));
        }
    }

    @And("User saves the permission setting")
    public void userSavesThePermissionSetting() {
        theActorInTheSpotlight().attemptsTo(clickSalesforcePageButtons.clickPermissionSaveButton());
    }

    @And("The User Clicks on All Time")
    public void theUserClicksOnAllTime() {
        theActorInTheSpotlight().attemptsTo(clickSalesforcePageButtons.clickAllTimeButton());
    }
}

