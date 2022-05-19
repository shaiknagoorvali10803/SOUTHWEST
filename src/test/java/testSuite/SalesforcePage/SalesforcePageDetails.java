package testSuite.SalesforcePage;

import GenericFunctions.WaitGeneric;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class SalesforcePageDetails {
    public static Target casePageTitle(WaitGeneric wait) {
        wait.waitforElementToBeVisible(SalesforcePageLocator.CASE_PAGE_HEADING);
        return Target.the("Case Page Title").located(SalesforcePageLocator.CASE_PAGE_HEADING);
    }

    public static Target casePageDescription() {
        return Target.the("Details of Case").located(SalesforcePageLocator.CASE_PAGE_DESCRIPTION);
    }

    public static Target casePageDetails(String detailName) {
        return Target.the("Details of Case").located(SalesforcePageLocator.CASE_PAGE_DETAIL(detailName));
    }

    public static Target casePageLink(String detailName) {
        return Target.the("Details of Case Links").located(SalesforcePageLocator.CASE_PAGE_LINK(detailName));
    }

    public static Target emailFieldFrom(WaitGeneric wait) {
        wait.waitforElementToBeVisible(SalesforcePageLocator.EMAIL_FIELD_FROM);
        return Target.the("Email Field From").located(SalesforcePageLocator.EMAIL_FIELD_FROM);
    }

    public static Target emailFieldBcc() {
        return Target.the("Email Field Bcc").located(SalesforcePageLocator.EMAIL_FIELD_BCC);
    }

    public static Target appLauncherSearchResult(String item) {
        return Target.the("Search Result").located(SalesforcePageLocator.APP_LAUNCHER_SEARCH_RESULT(item));
    }

    public static Target libraryLeftNavbar(String header) {
        return Target.the("Left Nav Bar").located(SalesforcePageLocator.LIBRARY_LEFT_NAVBAR(header));
    }

    public static Target libraryNavigationTab(String tabName) {
        return Target.the("Nav Bar").located(SalesforcePageLocator.LIBRARY_PAGE_TAB(tabName));
    }

    public static Target reportPageHeader() {
        return Target.the("Report Header").located(SalesforcePageLocator.REPORT_PAGE_TITLE);
    }

    public static void switchToReportFrame(Actor actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement frameEle = driver.findElement(By.xpath("//iframe[@title=\"Report Viewer\"]"));
        driver.switchTo().frame(frameEle);
    }

    public static void scrollToBottom(Actor actor) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        List<WebElement> rowElements = driver.findElements(By.xpath("//tr/td[3]"));

        Actions action = new Actions(driver);
        action.moveToElement(rowElements.get(rowElements.size()-1));
        action.perform();


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static Target reportPageHeader(String header, WaitGeneric wait) {
        wait.waitforElementToBeVisible(SalesforcePageLocator.REPORT_PAGE_HEADER(header));
        return Target.the("Page header").located(SalesforcePageLocator.REPORT_PAGE_HEADER(header));
    }

    public static Target reportPageColumn(String column) {
        return Target.the("Column").located(SalesforcePageLocator.GENERIC_SPAN(column));
    }

    public static Target casePageEditField(String field) {
        return Target.the("Case Field").located(SalesforcePageLocator.CASE_EDIT_FIELD(field));
    }

    public static Target casePageErrorMessageOnSaving() {
        return Target.the("Error Message").located(SalesforcePageLocator.CASE_SAVE_ERROR_MSG);
    }
}
