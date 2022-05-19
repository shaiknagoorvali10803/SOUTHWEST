package testSuite.LoginPage;

import GenericFunctions.WaitGeneric;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class LoginPageButtons {
    public static Performable continueClick() {
        Target submit_button = Target.the("Submit Button").located(LoginPageLocator.SEARCH_CONTINUE_BUTTON);
        return Click.on(submit_button);
    }

    public static Performable loginClickOnHome() {
        Target submit_button = Target.the("Login Button Home").located(LoginPageLocator.LOGIN_BUTTON_HOME);
        return Click.on(submit_button);
    }

    public static Target loginButtonOnHome(WaitGeneric wait) {
        wait.waitforElementToBeVisible(LoginPageLocator.LOGIN_BUTTON_HOME);
        Target submit_button = Target.the("Login Button Home").located(LoginPageLocator.LOGIN_BUTTON_HOME);
        return  submit_button;
    }

    public static Performable loginClick() {
        Target submit_button = Target.the("Login Button").located(LoginPageLocator.LOGIN_BUTTON);
        return Click.on(submit_button);
    }



    //Swabiz Salesforce
    public static Target salesforceloginButton() {
        Target submit_button = Target.the("Login Button Salesforce").located(LoginPageLocator.SALESFORCE_LOGIN_BUTTON);
        return  submit_button;
    }

    public static Performable salesforceLoginClick() {
        Target submit_button = Target.the("Login Button Salesforce").located(LoginPageLocator.SALESFORCE_LOGIN_BUTTON);
        return Click.on(submit_button);
    }

    public static Performable salesforcVerifyClick() {
        Target submit_button = Target.the("Verify Button Salesforce").located(LoginPageLocator.SALESFORCE_VERIFY_BUTTON);
        return Click.on(submit_button);
    }

}
