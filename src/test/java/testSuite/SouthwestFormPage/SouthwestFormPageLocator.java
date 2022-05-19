package testSuite.SouthwestFormPage;

import org.openqa.selenium.By;

public class SouthwestFormPageLocator {
    static By SUBMIT_BUTTON = By.xpath("//input[@value=\"Submit\"]");
    //static By SEARCH_CONTINUE_BUTTON = By.id("//input[contains(@name,\"firstName\")]");

    static By FORM_FIELDS(String field)
    {
        String locator = "//input[contains(@name,\""+field+"\")]";
        return By.xpath(locator);
    }

}
