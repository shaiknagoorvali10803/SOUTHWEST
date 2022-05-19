package GenericFunctions;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class KeyPressGeneric {
    public static void pressEnterKey(Actor actor) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        WebElement html = driver.findElement(By.tagName("html"));
        html.sendKeys(Keys.ENTER);
    }
}
