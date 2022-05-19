package testSuite.SouthwestFormPage;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import testSuite.LoginPage.LoginPageLocator;

public class EnterSouthwestFormPageDetails {
    public static Performable enterFormFields(String field,String value) {
        return Task.where("{0} attempts to enter field #field",
                Clear.field(SouthwestFormPageLocator.FORM_FIELDS(field)),
                Enter.theValue(value).into(SouthwestFormPageLocator.FORM_FIELDS(field))
        ).with("field").of(field);
    }

    public static Target formFields(String field) {
        return Target.the("field").located(SouthwestFormPageLocator.FORM_FIELDS(field));
    }
}
