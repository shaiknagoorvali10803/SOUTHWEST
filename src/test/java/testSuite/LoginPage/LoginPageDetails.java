package testSuite.LoginPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.targets.Target;
import testSuite.AccountPage.AccountPageLocator;

public class LoginPageDetails {

    public static Target validateLoginErrorMessage() {
        return Target.the("loginError Message").located(LoginPageLocator.LOGIN_ERROR_MESSAGE);
    }

}
