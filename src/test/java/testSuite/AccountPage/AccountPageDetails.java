package testSuite.AccountPage;

import GenericFunctions.WaitGeneric;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AccountPageDetails {
    public static Target accountNameTitle(WaitGeneric wait) {
        wait.waitforElementToBeVisible(AccountPageLocator.ACCOUNTNAME_TITLE);
        return Target.the("Account Name Title").located(AccountPageLocator.ACCOUNTNAME_TITLE);
    }

    public static Target accountCid() {
        return Target.the("Account CID").located(AccountPageLocator.ACCOUNTCID("Primary CID"));
    }

    public static Target headerTabs(String tabName) {
        return Target.the("HeaderTabs").located(AccountPageLocator.HEADERTAB(tabName));
    }

    public static Target designateTMC(WaitGeneric wait) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.waitforElementToBeVisible(AccountPageLocator.DESIGNATE_TMC);
        return Target.the("designateTMC").located(AccountPageLocator.DESIGNATE_TMC);
    }

    public static Performable selectAccessTypeInformationForAccount(String dropDownValue) {
        Target dropDownElement = Target.the("Access Type").located(AccountPageLocator.INFORMATION_ACCESS_TYPE);
        return SelectFromOptions.byVisibleText(dropDownValue).from(dropDownElement);
    }

    public static Target validateRequestDetails(String detail) {
        return Target.the("Request Details").located(AccountPageLocator.INFORMATION_DETAILS(detail));
    }

    public static Target validateRequestOnRequestPage(String fieldName) {
        String index = getIndexOfField(fieldName);
        return Target.the("Get Request Details").located(AccountPageLocator.REQUEST_DETAILS(index));
    }

    public static String getIndexOfField(String fieldName){
        String index = "1";
        if(fieldName.contains("Case Number")){
            index = "1";
        }
        else if(fieldName.contains("Request Type")){
            index = "2";
        }
        else if(fieldName.contains("Subject")){
            index = "3";
        }
        return index;
    }

    public static String getCaseNumberFromInformationPage(Actor actor, WaitGeneric wait) {
        wait.waitforElementToBeVisible(By.xpath("//lightning-formatted-rich-text//p/a"));
        actor.attemptsTo(WaitUntil.the(Target.the("").located(By.xpath("//lightning-formatted-rich-text//p/a")), isVisible()));
        String caseNumber = BrowseTheWeb.as(actor).findBy("//lightning-formatted-rich-text//p/a").getText();
        return caseNumber;
    }

    public static Target validateCaseDetails(String fieldName) {
        return Target.the("Get Case Details").located(AccountPageLocator.CASEDETAIL_DATA(fieldName));
    }

    public static Target validateNoAccountErrorMessage() {
        return Target.the("No Account Message").located(AccountPageLocator.NO_ACCOUNT_MESSAGE);
    }

    public static Target validateNoAccountErrorMessage(String fieldName) {
        return Target.the("Mandatory Error Message").located(AccountPageLocator.ERRORMESSAGE_FORM(fieldName));
    }

    public static Target validateFormPageDetails(String dataName) {
        return Target.the("Form Page Detail").located(AccountPageLocator.FORMPAGE_DATA(dataName));
    }

    public static Target userContact(String userName) {
        return Target.the("Form Page Detail").located(AccountPageLocator.USER_CONTACT_TABLE(userName));
    }

    public static Target userContract(String userName) {
        return Target.the("Contract Page Detail").located(AccountPageLocator.USER_CONTACT_TABLE(userName));
    }

    public static Target userAccessSection() {
        return Target.the("Form Page Detail").located(AccountPageLocator.USER_ACCESS_SECTION);
    }

    public static Target validateContactDropdownOptions(String option) {
        return Target.the("Contact Option Dropdown").located(AccountPageLocator.CONTACT_OPENED_DROPDOWN(option));
    }


    public static Target validatePermissionPageTitle() {
        return Target.the("Permission Page Title").located(AccountPageLocator.PERMISSION_PAGE_TITLE);
    }

    public static Target permissionButton(String field) {
        return Target.the("Permission Page Edit").located(AccountPageLocator.EDIT_PERMISSION(field));
    }

    public static Target validateContactsDetails(String contact, String field) {
        return Target.the("Contact user field").located(AccountPageLocator.CONTACT_DETAIL(contact,field));
    }
}
