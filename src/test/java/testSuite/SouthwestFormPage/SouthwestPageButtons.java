package testSuite.SouthwestFormPage;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import testSuite.LoginPage.LoginPageLocator;

public class SouthwestPageButtons {


    public static Performable submitForm() {
        Target submit_button = Target.the("Submit Button").located(SouthwestFormPageLocator.SUBMIT_BUTTON);
        return Click.on(submit_button);
    }


}
