package testSuite.HomePage;

import GenericFunctions.WaitGeneric;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;

public class EnterHomePageDetails {
    public static Target companyNameField(WaitGeneric wait) {
        wait.waitforElementToBeVisible(HomePageLocator.COMPANYNAME_FIELD);
        return Target.the("Login Button Home").located(HomePageLocator.COMPANYNAME_FIELD);
    }
    public static Performable enterCompanyName(String company) {
        return Task.where("{0} attempts to enter company #company",
                Clear.field(HomePageLocator.COMPANYNAME_FIELD),
                Enter.theValue(company).into(HomePageLocator.COMPANYNAME_FIELD)
        ).with("company").of(company);
    }

}
