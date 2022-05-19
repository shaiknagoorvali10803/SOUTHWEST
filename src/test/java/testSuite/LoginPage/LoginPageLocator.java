package testSuite.LoginPage;

import org.openqa.selenium.By;

public class LoginPageLocator {
    static By SEARCH_CONTINUE_BUTTON = By.id("TravelerLoginForm_submitButton");
    static By LOGIN_BUTTON_HOME = By.xpath("//button[text()=\"Log in\"]");
    static By LOGIN_BUTTON = By.xpath("//span[text()=\"Log in\"]");
    static By USERNAME_FIELD = By.xpath("//input[@placeholder=\"Username\"]");
    static By PASSWORD_FIELD = By.xpath("//input[@placeholder=\"Password\"]");
    static By LOGIN_ERROR_MESSAGE = By.xpath("//div[text()=\"Your login attempt has failed. Make sure the username and password are correct.\"]");

    //Swabiz Salesforce
    static By SALESFORCE_LOGIN_BUTTON = By.xpath("//input[@value=\"Log In to Sandbox\"]");
    static By SALESFORCE_USERNAME_FIELD = By.xpath("//input[@id=\"username\"]");
    static By SALESFORCE_PASSWORD_FIELD = By.xpath("//input[@id=\"password\"]");
    static By SALESFORCE_VERIFY_BUTTON = By.xpath("//input[@id=\"save\"]");
}
