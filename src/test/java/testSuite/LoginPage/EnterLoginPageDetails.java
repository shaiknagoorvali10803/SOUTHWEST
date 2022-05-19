package testSuite.LoginPage;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;

public class EnterLoginPageDetails {
    //Travel Portal
    public static Performable enterUsername(String username) {
        return Task.where("{0} attempts to enter username #username",
                Clear.field(LoginPageLocator.USERNAME_FIELD),
                Enter.theValue(username).into(LoginPageLocator.USERNAME_FIELD)
        ).with("username").of(username);
    }

    public static Performable enterPassword(String password) {
        return Task.where("{0} attempts to enter password",
                Clear.field(LoginPageLocator.PASSWORD_FIELD),
                Enter.theValue(password).into(LoginPageLocator.PASSWORD_FIELD)
        );
    }






    //Swabiz Salesforce
    public static Performable salesforceEnterUsername(String username) {
        return Task.where("{0} attempts to enter username #username",
                Clear.field(LoginPageLocator.SALESFORCE_USERNAME_FIELD),
                Enter.theValue(username).into(LoginPageLocator.SALESFORCE_USERNAME_FIELD)
        ).with("username").of(username);
    }

    public static Performable salesforceEnterPassword(String password) {
        return Task.where("{0} attempts to enter password",
                Clear.field(LoginPageLocator.SALESFORCE_PASSWORD_FIELD),
                Enter.theValue(password).into(LoginPageLocator.SALESFORCE_PASSWORD_FIELD)
        );
    }
}
