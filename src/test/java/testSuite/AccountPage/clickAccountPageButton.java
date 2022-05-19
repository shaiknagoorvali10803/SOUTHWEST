package testSuite.AccountPage;

import GenericFunctions.WaitGeneric;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.targets.Target;
import testSuite.HomePage.HomePageLocator;

public class clickAccountPageButton {

    public static Performable clickHeaderTabs(String tabName) {
        Target headerTab = Target.the(tabName+" HeaderTabs").located(AccountPageLocator.HEADERTAB(tabName));
        return Click.on(headerTab);
    }

    public static Performable clickDesignateTMC() {
        Target desgnateTMC = Target.the("Designate TMC").located(AccountPageLocator.DESIGNATE_TMC);
        return Click.on(desgnateTMC);
    }

    public static Performable clickNext() {
        Target next = Target.the("Next").located(AccountPageLocator.NEXT_BUTTON);
        return Click.on(next);
    }

    public static Performable clickSubmit() {
        Target submit = Target.the("Submit").located(AccountPageLocator.SUBMIT_FORM);
        return Click.on(submit);
    }

    public static Performable clickFinish(WaitGeneric wait) {
        wait.waitforElementToBeVisible(AccountPageLocator.FINISH_BUTTON);
        Target next = Target.the("Finish").located(AccountPageLocator.FINISH_BUTTON);
        return Click.on(next);
    }

    public static Performable clickAccountDashboard() {
        Target accDashboard = Target.the("Account Dashboard").located(AccountPageLocator.ACCOUNT_DASHBOARD_BUTTON);
        return Click.on(accDashboard);
    }

    public static Performable clickCaseOnTop() {
        Target caseNumberLink = Target.the("Case").located(AccountPageLocator.CASE_ON_TOP);
        return JavaScriptClick.on(caseNumberLink);
    }

    public static Performable clickCaseNumber(String casenumber, WaitGeneric wait) {
        wait.waitforElementToBeVisible(AccountPageLocator.REQUEST_CASENUMBER(casenumber));
        Target caseNumberLink = Target.the("Case Number").located(AccountPageLocator.REQUEST_CASENUMBER(casenumber));
        return JavaScriptClick.on(caseNumberLink);
    }

    public static Performable clickContactDropdown(String contact) {
        Target contactDropdown = Target.the("Contact Dropdown").located(AccountPageLocator.CONTACT_ACTIONS_DROPDOWN(contact));
        return Click.on(contactDropdown);
    }

    public static Performable scrollToContactButton(String contact) {
        Target contactDropdown = Target.the("Contact Dropdown").located(AccountPageLocator.CONTACT_ACTIONS_DROPDOWN(contact));
        return Scroll.to(contactDropdown);
    }

    public static Performable clickContactDropdownOption(String option) {
        Target contactDropdown = Target.the("Contact Dropdown Option").located(AccountPageLocator.CONTACT_OPENED_DROPDOWN(option));
        return Click.on(contactDropdown);
    }

    public static Performable clickSortForTitle(String title) {
        Target sortButton = Target.the("Sort Request").located(AccountPageLocator.SORT_REQUEST_TITLE(title));
        return Click.on(sortButton);
    }

    public static Performable clickCheckBoxForTitle(String title) {
        Target sortButton = Target.the("Checkbox").located(AccountPageLocator.TITLE_CHECKBOX(title));
        return Click.on(sortButton);
    }

    public static Performable clickSaveButton() {
        Target save = Target.the("Save").located(AccountPageLocator.SAVE_BUTTON);
        return Click.on(save);
    }

    public static Performable clickModalSaveButton() {
        Target save = Target.the("Modal Save").located(AccountPageLocator.MODAL_SAVE_BUTTON);
        return Click.on(save);
    }
}
