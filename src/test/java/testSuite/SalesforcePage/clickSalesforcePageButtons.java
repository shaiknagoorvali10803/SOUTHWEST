package testSuite.SalesforcePage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.ScrollTo;
import net.serenitybdd.screenplay.actions.ScrollToWebElement;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.*;
import testSuite.HomePage.HomePageLocator;

import javax.xml.crypto.dsig.spec.ExcC14NParameterSpec;
import java.util.List;

public class clickSalesforcePageButtons {
    public static Target searchFieldButton() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Target.the("Search Field Button").located(SalesforcePageLocator.SEARCH_FIELD_BUTTON);
    }

    public static Performable clickSearchFieldButton()
    {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Target submit_button = Target.the("Search Field Button").located(SalesforcePageLocator.SEARCH_FIELD_BUTTON);
        return JavaScriptClick.on(submit_button);
    }


    public static Target search_result_Displayed(String caseNumber) {
        Target case_number_button = Target.the("Search Result Case").located(SalesforcePageLocator.SEARCH_RESULT(caseNumber));
        return case_number_button;
    }

    public static Performable clickSearchResult(String caseNumber) {
        Target case_number_button = Target.the("Search Result Case").located(SalesforcePageLocator.SEARCH_RESULT(caseNumber));
        return Click.on(case_number_button);
    }

    public static Performable clickCloseCaseOpened(String caseNumber) {
        Target case_close_button = Target.the("Close Opened case").located(SalesforcePageLocator.CLOSE_OPENED_CASE("Close "+caseNumber));
        return Click.on(case_close_button);
    }

    public static void clickCloseCaseOpened(Actor actor) {

        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        List<WebElement> closeButtons = null;
        int flag=0;
        try {
            closeButtons = driver.findElements(By.xpath("//span[contains(text(),\"Close\")]/parent::button[contains(@title,\"Close\")]"));

            flag=1;
        }
        catch(ElementNotInteractableException e)
        {
            System.out.println("No Cases were already opened");
        }

        if(flag==1)
        {
            System.out.print("Values of size "+closeButtons.size());
            for(int i = 0; i < closeButtons.size(); i++) {
                closeButtons.get(i).click();
            }
        }
    }
//    public static Performable scrollToComposeEmail() {
//        Target case_close_button = Target.the("Compose Button").located(SalesforcePageLocator.COMPOSE_EMAIL);
//        return Click.on(case_close_button);
//    }

    public static Performable clickComposeEmail() {
        Target case_close_button = Target.the("Compose Button").located(SalesforcePageLocator.COMPOSE_EMAIL);
        return JavaScriptClick.on(case_close_button);
    }

    public static Performable closeAlreadyOpenedCases() {
        try {
            Target case_close_button = Target.the("Close Opened case").located(SalesforcePageLocator.CLOSE_OPENED_CASE("Close "));
            return Click.on(case_close_button);
        }
        catch(Exception e)
        {

        }
        return null;
    }

    public static Performable clickApplauncher() {
        Target appLauncher = Target.the("App Launcher").located(SalesforcePageLocator.APP_LAUNCHER);
        return Click.on(appLauncher);
    }

    public static Performable clickApplauncherSearchResult(String result) {
        Target resultElement = Target.the("App Launcher Result").located(SalesforcePageLocator.APP_LAUNCHER_SEARCH_RESULT(result));
        return Click.on(resultElement);
    }

    public static Performable clickLibraryPageTab(String tabName) {
        Target resultElement = Target.the("Library Tab").located(SalesforcePageLocator.LIBRARY_PAGE_TAB(tabName));
        return Click.on(resultElement);
    }

    public static Performable clickShowNavigationMenu() {
        Target resultElement = Target.the("Navigation Dropdown").located(SalesforcePageLocator.SHOW_NAVIGATION_MENU);
        return Click.on(resultElement);
    }

    public static Performable selectOptionFromNavigationMenu(String option) {
        Target resultElement = Target.the("Navigation Option").located(SalesforcePageLocator.SELECT_NAV_MENU_ITEM(option));
        return Click.on(resultElement);
    }


    public static Performable selectOptionFromLeftNavigation(String option) {
        Target resultElement = Target.the("Left Navigation Option").located(SalesforcePageLocator.SELECT_NAV_OPTION_CATEGORY(option));
        return Click.on(resultElement);
    }

    public static Performable openSearchedReport() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Target resultElement = Target.the("Searched Report").located(SalesforcePageLocator.REPORTS_IN_PAGE);
        return JavaScriptClick.on(resultElement);
    }

    public static Performable openSearchedContacts() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Target resultElement = Target.the("Searched Contact").located(SalesforcePageLocator.CONTACTS_IN_PAGE);
        return JavaScriptClick.on(resultElement);
    }

    public static Performable openSearchedReport(String folder) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Target resultElement = Target.the("Open Folder").located(SalesforcePageLocator.GENERIC_LINK(folder));
        return JavaScriptClick.on(resultElement);
    }

    public static Performable openFilterOnReportPage() {
        Target resultElement = Target.the("Open Filter").located(SalesforcePageLocator.REPORT_PAGE_FILTER);
        return Click.on(resultElement);
    }

    public static Performable clickDateClosedOpenedFilter() {
        Target resultElement = Target.the("Filter Date").located(SalesforcePageLocator.REPORT_PAGE_FILTER_DATE);
        return Click.on(resultElement);
    }

    public static Performable clickFilterDateRangeDropdown() {
        Target resultElement = Target.the("Filter Range").located(SalesforcePageLocator.REPORT_PAGE_RANGE);
        return Click.on(resultElement);
    }

    public static Performable selectDropdownRangeForFilter() {
        Target resultElement = Target.the("Filter Range").located(SalesforcePageLocator.REPORT_PAGE_DROPDOWNVALUE);
        return Click.on(resultElement);
    }

    public static Performable clickApplyButton() {
        Target resultElement = Target.the("Apply").located(SalesforcePageLocator.REPORT_PAGE_APPLY);
        return Click.on(resultElement);
    }

    public static Performable clickEditCaseField(String field) {
        Target ele = Target.the("Edit").located(SalesforcePageLocator.EDIT_CASE_FIELD_BUTTON(field));
        return Click.on(ele);
    }

    public static Performable openDropdownForField(String fieldName) {
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Target ele = Target.the("Edit").located(SalesforcePageLocator.CASE_EDIT_FIELD(fieldName));
        return Click.on(ele);
    }

    public static Performable clickDropDownItemForField(String dropDownOption) {
        try {
            System.out.print("--------");
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Target ele = Target.the("Dropdown Field").located(SalesforcePageLocator.CASE_FIELD_DROPDOWN_OPTION(dropDownOption));
        return Click.on(ele);
    }

    public static Performable clickSaveButtonForCase() {
        Target ele = Target.the("Save").located(SalesforcePageLocator.CASE_SAVE_BUTTON);
        return Click.on(ele);
    }

    public static void scrollToField(Actor actor, String username) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        //WebElement element = driver.findElement(SalesforcePageLocator.CASE_EDIT_FIELD(field));
        if(username.contains("sysadm"))
        {
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,450);");
        }
        else {
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,100);");
        }
    }

    public static Performable openAllRelatedAccountsForContact() {
        Target ele = Target.the("Related Accounts").located(SalesforcePageLocator.CONTACT_RELATED_ACCOUNTS);
        return Click.on(ele);
    }

    public static Performable openEditPermissionDropdownForContact(String secondaryAccount) {
        Target ele = Target.the("Open Account Permission Dropdown").located(SalesforcePageLocator.CONTACT_PERMISSION_DROPDOWN(secondaryAccount));
        return Click.on(ele);
    }

    public static Performable clickEditPermissionForContact() {
        Target ele = Target.the("Edit Permission").located(SalesforcePageLocator.CONTACT_EDIT_PERMISSSION);
        return Click.on(ele);
    }

    public static Performable clickPermissionThatNeedsToBeClicked(String item) {
        Target ele = Target.the("Permission Item").located(SalesforcePageLocator.CONTACT_PERMISSSION_ITEM(item));
        return Click.on(ele);
    }

    public static Performable clickPermissionAddOrRemove(String add_remove) {
        Target ele = Target.the("Permission Item").located(SalesforcePageLocator.CONTACT_PERMISSSION_ADD_REMOVE(add_remove));
        return Click.on(ele);
    }

    public static Performable clickPermissionSaveButton() {
        Target ele = Target.the("Save").located(SalesforcePageLocator.CONTACT_SAVE_BUTTON);
        return Click.on(ele);
    }

    public static Performable clickAllTimeButton() {
        Target ele = Target.the("All Time").located(SalesforcePageLocator.ALL_TIME_BUTTON);
        return Click.on(ele);
    }
}
