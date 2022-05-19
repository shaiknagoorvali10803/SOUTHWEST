package testSuite.TestCases;

import dto.LoadCsvDataToDB;
import dto.LoadDataFromDB;
import entity.TpTable;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

import java.util.List;


public class GenericActions {
    public void refreshPage(Actor actor)
    {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        driver.navigate().refresh();
    }

}
