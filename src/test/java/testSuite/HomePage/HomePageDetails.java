package testSuite.HomePage;

import GenericFunctions.WaitGeneric;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.targets.Target;
import testSuite.AccountPage.AccountPageLocator;

public class HomePageDetails {
    public static Target givenAccount(String account, WaitGeneric wait) {
        wait.waitforElementToBeVisible(HomePageLocator.HOMEPAGE_ACCOUNT(account));
        return Target.the("given Account").located(HomePageLocator.HOMEPAGE_ACCOUNT(account));
    }

}
