package testSuite.AccountPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import testSuite.HomePage.HomePageLocator;
import utils.FileHandling;

public class EnterAccountPageDetails {
    public static Performable enterArcNumber(String arcNumber) {
        return Task.where("User attempts to enter ArcNumber #arcNumber",
                Clear.field(AccountPageLocator.ARC_NUMBER_FIELD),
                Enter.theValue(arcNumber).into(AccountPageLocator.ARC_NUMBER_FIELD)
        ).with("arcNumber").of(arcNumber);
    }


    public static Performable enterInformationForAccount(String fieldName, String value) {
        return Task.where("User attempts to enter #fieldName",
                Clear.field(AccountPageLocator.INFORMATION_FIELD(fieldName)),
                Enter.theValue(value).into(AccountPageLocator.INFORMATION_FIELD(fieldName))
        ).with("fieldName").of(fieldName);
    }

    public static Performable enterEmailInformationForAccount(String emailValue) {
        return Task.where("User attempts to enter Email",
                Clear.field(AccountPageLocator.INFORMATION_EMAIL_FIELD),
                Enter.theValue(emailValue).into(AccountPageLocator.INFORMATION_EMAIL_FIELD)
        );
    }

    public static void uplodadFileForRequest(Actor actor) {
        String file_path = "C:\\Users\\x283727\\Documents\\Code\\qmo-travel-portal\\src\\test\\resources\\TestData\\TestingDoc.pdf";
        FileHandling fh = new FileHandling(actor);
        fh.uploadFile(file_path,"//input[@name=\"uploadFile\"]");
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Target doneBtn = Target.the("Done Button").located(AccountPageLocator.FILE_UPLOAD_DONE);
        actor.attemptsTo(Click.on(doneBtn));
    }


}
