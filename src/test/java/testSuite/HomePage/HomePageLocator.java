package testSuite.HomePage;

import org.openqa.selenium.By;

public class HomePageLocator {
    static By COMPANYNAME_FIELD = By.xpath("//input[@name=\"enter-search\"]");

    public static By ACCOUNT_DROPDOWN_OPTION(String option) {
        String locator="//div[@class=\"search-results-container\"]/div/div/p[contains(text(),\""+option+"\")]";
        return By.xpath(locator);
    }

    public static By HOMEPAGE_ACCOUNT(String accountName) {
        String locator="//p[@class=\"account-name\" and  contains(text(),\""+accountName+"\")]";
        return By.xpath(locator);
    }

}
