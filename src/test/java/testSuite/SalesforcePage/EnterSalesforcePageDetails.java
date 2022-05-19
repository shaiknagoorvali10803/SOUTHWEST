package testSuite.SalesforcePage;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import testSuite.HomePage.HomePageLocator;

public class EnterSalesforcePageDetails {


    public static Performable enterCaseInSearchField(String caseID) {

        return Task.where("{0} attempts to enter company #caseID",
                Clear.field(SalesforcePageLocator.SEARCH_FIELD),
                Enter.theValue(caseID).into(SalesforcePageLocator.SEARCH_FIELD)
        ).with("caseID").of(caseID);
    }

    public static Performable enterValueInSearchFieldForAppLauncher(String item) {
        return Task.where("{0} attempts to enter value #value",
                Clear.field(SalesforcePageLocator.APPLAUNCHER_SEARCH_FIELD),
                Enter.theValue(item).into(SalesforcePageLocator.APPLAUNCHER_SEARCH_FIELD)
        ).with("value").of(item);
    }

    public static Performable enterReportInSearchField(String report) {
        return Task.where("{0} attempts to enter Report #report",
                Clear.field(SalesforcePageLocator.REPORT_SEARCH_FIELD),
                Enter.theValue(report).into(SalesforcePageLocator.REPORT_SEARCH_FIELD)
        ).with("report").of(report);
    }


    public static Performable enterContactInSearchField(String contact) {
        return Task.where("{0} attempts to enter Contact #contact",
                Clear.field(SalesforcePageLocator.CONTACT_SEARCH_FIELD),
                Enter.theValue(contact).into(SalesforcePageLocator.CONTACT_SEARCH_FIELD)
        ).with("contact").of(contact);
    }


    public static Performable enterFolderInSearchField(String folder, String page) {
        return Task.where("{0} attempts to enter Folder #folder",
                Clear.field(SalesforcePageLocator.FOLDER_SEARCH_FIELD(page)),
                Enter.theValue(folder).into(SalesforcePageLocator.FOLDER_SEARCH_FIELD(page))
        ).with("folder").of(folder);
    }
}
