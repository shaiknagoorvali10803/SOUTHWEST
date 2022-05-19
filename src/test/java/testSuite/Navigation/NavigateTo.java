package testSuite.Navigation;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo  {

    public static Performable theSwaBizHomePage() {
        return Task.where("{0} opens the SwaBiz home page",
                Open.browserOn().the(SwaBizHomePage.class)
        );
    }

    public static Performable theTravelPortalHomePage() {
        System.out.println("Url----------------------"+ TravelPortalHomePage.class);
        return Task.where("{0} opens the Travel Portal home page",
                Open.browserOn().the(TravelPortalHomePage.class)
        );
    }

    public static Performable theSwabizSalesforceLoginPage() {
        System.out.println("Url----------------------"+ SwaBizSalesforcePage.class);
        return Task.where("{0} opens the Salesforce login page",
                Open.browserOn().the(SwaBizSalesforcePage.class)
        );
    }


    public static Performable theSouthwestFormPage() {
        System.out.println("Url----------------------"+ SouthwestFormPage.class);
        return Task.where("{0} opens the Southform Page",
                Open.browserOn().the(SouthwestFormPage.class)
        );
    }

    public static Performable aMissingPage() {
        return Task.where("{0} opens the DuckDuckGo home page",
                Open.browserOn().the(WrongPage.class)
        );
    }

}