package GenericFunctions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WaitGeneric {
    static WebDriver driver;
    static int timeout = 10;
    WebDriverWait wait;

    public WaitGeneric(Actor actor)
    {
        driver = BrowseTheWeb.as(actor).getDriver();
        wait = new WebDriverWait(driver, timeout);
    }

    public static void waitforElementToBeVisible(By element) {
        int count;
        int i=0;
        resetImplicitTimeout(1);
        while (i <= timeout) {
            count = driver.findElements(element).size();
            if (count != 1) {
                i += 1;
            } else {
                break;
            }
        }
        resetImplicitTimeout(timeout);
    }

    public static void resetImplicitTimeout(int itimeout)
    {
        try{
            driver.manage().timeouts().implicitlyWait(itimeout, TimeUnit.SECONDS);
        }
        catch(Exception e)
        {

        }
    }
}
