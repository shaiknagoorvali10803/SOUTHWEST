package testSuite.RequestPage;

import org.openqa.selenium.By;

public class RequestPageLocator {

    static By START_REQUEST = By.xpath("//button[text()=\"Start Request\"]");
    static By CREATE_A_NEW_REQUEST = By.xpath("//button[contains(text(),\"Start a New Request\")]");
    static By ADDITIONAL_REQUEST_MODAL = By.xpath("//h2[text()=\"Additional inventory request\"]/parent::header/parent::div");
    static By BENEFIT_DASHBOARD = By.xpath("//h1[text()=\"Your contractual benefits\"]/parent::div/parent::div[contains(@class,\"benefits-container\")]");
    static By REQUEST_PAGE_TITLE = By.xpath("//h1/b[text()=\"New Request\"]");
    static By SUBMIT_THE_REQUEST_BY = By.xpath("//div[contains(@class,\"flowruntimeBody\")]");

    public static By REQUEST_BUTTON(String title) {
        String locator="//p[contains(text(),\""+title+"\")]/parent::div/following-sibling::div/button[text()=\"Submit request\"]";
        return By.xpath(locator);
    }

    public static By REQUEST_DROPDOWN(String title) {
        String locator="//p[text()=\""+title+"\"]/following-sibling::lightning-combobox//button/span";
        return By.xpath(locator);
    }

    public static By CONTACT_ADMIN_BUTTON(String title) {
        String locator="//p[contains(text(),\""+title+"\")]/parent::div/following-sibling::div/button[text()=\"Contact your Account Manager\"]";
        return By.xpath(locator);
    }

    public static By REQUEST_DROPDOWN_VALUE(String value) {
        String locator ="//span[text()=\""+value+"\"]/parent::span/parent::lightning-base-combobox-item";
        return By.xpath(locator);
    }

    public static By RADIO_REQUEST_BY(String value) {
        String locator = "//span[text()=\""+value+"\"]/ancestor::label";
        return By.xpath(locator);
    }

    public static By INFORMATION_DETAILS(String fieldName) {
        String locator = "//p[contains(text(),\""+fieldName+"\")]/following-sibling::p[1]";
        return By.xpath(locator);
    }
}
