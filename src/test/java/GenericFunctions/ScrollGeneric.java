package GenericFunctions;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testSuite.AccountPage.AccountPageLocator;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ScrollGeneric {
    public static void scrollDownLittle(Actor actor) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        WebElement html = driver.findElement(By.tagName("html"));
        html.sendKeys(Keys.PAGE_DOWN);
        html.sendKeys(Keys.PAGE_DOWN);
    }

    public static void scrollDownToEnd(Actor actor) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        WebElement html = driver.findElement(By.tagName("html"));
        for(int i=0;i<10;i++) {
            html.sendKeys(Keys.PAGE_DOWN);
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
