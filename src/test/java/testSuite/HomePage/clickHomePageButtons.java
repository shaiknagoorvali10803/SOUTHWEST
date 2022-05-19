package testSuite.HomePage;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class clickHomePageButtons {
    public static Performable selectDropdownforAccountSearch(String option)
    {
        Target submit_button = Target.the("Account Search Dropdown").located(HomePageLocator.ACCOUNT_DROPDOWN_OPTION(option));
        return Click.on(submit_button);
    }

    public static Performable openAccountDisplayed(String account)
    {
        Target submit_button = Target.the("Homepage Account").located(HomePageLocator.HOMEPAGE_ACCOUNT(account));
        return Click.on(submit_button);
    }

}
