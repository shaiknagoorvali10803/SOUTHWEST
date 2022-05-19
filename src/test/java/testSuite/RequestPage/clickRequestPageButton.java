package testSuite.RequestPage;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.targets.Target;
import testSuite.AccountPage.AccountPageLocator;

public class clickRequestPageButton {

    public static Target Request_Button_Displayed(String title) {
        Target request_button = Target.the(title+" Request Page").located(RequestPageLocator.REQUEST_BUTTON(title));
        return request_button;
    }

    public static Target Contact_Admin_Button_Displayed(String title) {
        Target contact_button = Target.the(title+" Contact Admin Page").located(RequestPageLocator.CONTACT_ADMIN_BUTTON(title));
        return contact_button;
    }


    public static Performable clickRequestButton(String title) {
        Target request_button = Target.the(title+" Request Page").located(RequestPageLocator.REQUEST_BUTTON(title));
        return Click.on(request_button);
    }

    public static Performable clickContactAdminButton(String title) {
        Target request_button = Target.the(title+" Contact Admin Page").located(RequestPageLocator.CONTACT_ADMIN_BUTTON(title));
        return Click.on(request_button);
    }

    public static Performable clickCreateANewRequest() {
        Target new_request_button = Target.the("New Request Button").located(RequestPageLocator.CREATE_A_NEW_REQUEST);
        return Click.on(new_request_button);
    }

    public static Performable clickRequestDropdown(String title) {
        Target dropdown_field = Target.the("Request Dropdown").located(RequestPageLocator.REQUEST_DROPDOWN(title));
        return Click.on(dropdown_field);
    }

    public static Performable selectRequestDropdownValue(String value) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Target dropdown_value = Target.the("Request Dropdown Value").located(RequestPageLocator.REQUEST_DROPDOWN_VALUE(value));
        return Click.on(dropdown_value);
    }

    public static Performable clickStartRequest() {
        Target dropdown_value = Target.the("Start Request").located(RequestPageLocator.START_REQUEST);
        return Click.on(dropdown_value);
    }

    public static Performable clickRadioButtonForRequestBy(String value) {
        Target dropdown_value = Target.the("Radio Button").located(RequestPageLocator.RADIO_REQUEST_BY(value));
        return Click.on(dropdown_value);
    }
}
