package testSuite.RequestPage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.junit.Assert;
import testSuite.AccountPage.AccountPageLocator;
import utils.DateRelatedActions;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class RequestPageDetails {
    public static Target benefitDashboardDisplayed()
    {
        return Target.the("Benefit Dashboard").located(RequestPageLocator.BENEFIT_DASHBOARD);
    }

    public static Target requestPageTitleDisplayed()
    {
        return Target.the("Request Page Title").located(RequestPageLocator.REQUEST_PAGE_TITLE);
    }

    public static Target requestDropDown(String dropdownTitle)
    {
        return Target.the("Request Dropdown").located(RequestPageLocator.REQUEST_DROPDOWN(dropdownTitle));
    }

    public static String getRequestOverviewDate(Actor actor,String title) {
        actor.attemptsTo(WaitUntil.the(Target.the("").located(By.xpath("//p[contains(text(),\""+title+"\")]/parent::div/following-sibling::div/p[@class=\"waivers-card-date-range\"]")), isVisible()));
        String dateRange = BrowseTheWeb.as(actor).findBy("//p[contains(text(),\""+title+"\")]/parent::div/following-sibling::div/p[@class=\"waivers-card-date-range\"]").getText();
        return dateRange;
    }

    public static void validateCurrectDateIsBetweenRange(String requestDate) {
        DateRelatedActions dt = new DateRelatedActions();
        String date = dt.getCurrentDate();
        String[] actualDate = requestDate.split("-");
        Boolean flag;

       if(dt.getTotalOfDate(actualDate[0])< dt.getTotalOfDate(date) && dt.getTotalOfDate(date)<dt.getTotalOfDate(actualDate[1]))
        {
            flag = true;
        }
        else
        {
            flag = false;
        }

        Assert.assertTrue("Date was not inside Range",flag);
        //System.out.println("Date was inside Range");
    }

    public static Target inventoryRequestModal() {
        return Target.the("Inventory Request Modal").located(RequestPageLocator.ADDITIONAL_REQUEST_MODAL);
    }

    public static Target createANewRequest() {
        return Target.the("Create Request").located(RequestPageLocator.CREATE_A_NEW_REQUEST);
    }

    public static Target submitTheRequestBy() {
        return Target.the("Create Request").located(RequestPageLocator.SUBMIT_THE_REQUEST_BY);
    }

    public static Target validateRequestDetails(String name) {
        return Target.the("Request Details").located(RequestPageLocator.INFORMATION_DETAILS(name));
    }
}
