package utils;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.pages.components.FileToUpload;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileHandling {
    WebDriver driver;

    public FileHandling(Actor actor)
    {
        driver = BrowseTheWeb.as(actor).getDriver();
    }

    public void uploadFile(String filePath, String locator)
    {
        FileToUpload fileToUpload = new FileToUpload(driver, filePath);
        WebElement uploadFileElement = driver.findElement(By.xpath(locator));
        System.out.print("Up Element "+ uploadFileElement.getText());
        fileToUpload.fromLocalMachine().to(uploadFileElement);
    }

}
