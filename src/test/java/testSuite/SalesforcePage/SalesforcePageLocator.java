package testSuite.SalesforcePage;

import org.openqa.selenium.By;

public class SalesforcePageLocator {
    static By ALL_TIME_BUTTON = By.xpath("//a[text()=\"All Time\"]");
    static By CONTACT_EDIT_PERMISSSION = By.xpath("//div[text()=\"Edit Relationship\"]/parent::a");;
    static By CONTACT_RELATED_ACCOUNTS = By.xpath("//span[@title=\"Related Accounts\"]/parent::a");
    static By CONTACT_SAVE_BUTTON = By.xpath("//div[@class=\"inlineFooter\"]//button/span[text()=\"Save\"]");

    static By CASE_SAVE_ERROR_MSG = By.xpath("//h2[text()=\"We hit a snag.\"]");
    static By CASE_SAVE_BUTTON = By.xpath("//button[text()=\"Save\"]");

    static By REPORT_PAGE_APPLY = By.xpath("//button[text()=\"Apply\"]");
    static By REPORT_PAGE_DROPDOWNVALUE = By.xpath("//ul[contains(@class,\"dropdown__list\")]/li/a//span[text()=\"All Time\"]");
    static By REPORT_PAGE_RANGE = By.xpath("//label[text()=\"Range\"]/following-sibling::div/button");
    static By REPORT_PAGE_FILTER_DATE = By.xpath("//span[text()=\"Date/Time Closed\"]/following-sibling::span/span");
    static By REPORT_PAGE_FILTER = By.xpath("//span[text()=\"Filters\"]/parent::button[contains(@class,\"toggleFilter\")]");
    static By REPORT_PAGE_TITLE = By.xpath("//h1/span[contains(@class,\"header\")]");
    static By REPORTS_IN_PAGE = By.xpath("//div[@class=\"listViewContainer\"]//tr/th//lightning-formatted-url/a[1]");
    static By REPORT_SEARCH_FIELD = By.xpath("//input[@placeholder=\"Search all reports...\"]");
    static By CONTACT_SEARCH_FIELD = By.xpath("//input[@placeholder=\"Search this list...\"]");
    static By CONTACTS_IN_PAGE = By.xpath("//div[contains(@class,\"listViewContent\")]//tbody/tr[1]/th[1]//a");
    static By SHOW_NAVIGATION_MENU = By.xpath("//span[text()=\"Show Navigation Menu\"]/parent::button");
    static By APPLAUNCHER_SEARCH_FIELD = By.xpath("//input[@placeholder=\"Search apps and items...\"]");
    static By APP_LAUNCHER = By.xpath("//button[contains(@class,\"AppLauncher\")]");
    static By EMAIL_FIELD_BCC = By.xpath("//span[contains(text(),\"Bcc\")]/parent::label/following-sibling::div//a/span");
    static By COMPOSE_EMAIL =  By.xpath("//span[text()=\"Compose\"]/parent::button");
    static By EMAIL_FIELD_FROM = By.xpath("//span[contains(text(),\"From\")]/parent::span/following-sibling::div//a");
    //static By SEARCH_FIELD = By.xpath("//input[@placeholder=\"Search...\"]");
    static By SEARCH_FIELD = By.xpath("//input[@placeholder=\"Search Cases and more...\"] | //input[@placeholder=\"Search...\"]");
    static By SEARCH_FIELD_BUTTON = By.xpath("//button[@aria-label=\"Search\"]");
    static By CASE_PAGE_HEADING = By.xpath("//h1//lightning-formatted-text");
    static By CASE_PAGE_DESCRIPTION = By.xpath("//span[text()=\"Description\"]/parent::div/following-sibling::div//lightning-formatted-text[@data-output-element-id=\"output-field\"]");

    public static By GENERIC_LINK(String link)
    {
        String locator = "//a[text()=\""+link+"\"]";
        return By.xpath(locator);
    }

    public static By GENERIC_SPAN(String text)
    {
        String locator = "//span[text()=\""+text+"\"]";
        return By.xpath(locator);
    }

    public static By EDIT_CASE_FIELD_BUTTON(String field)
    {
        String locator = "//button[@title=\"Edit "+field+"\"]";
        return By.xpath(locator);
    }

    public static By CASE_EDIT_FIELD(String fieldName)
    {
        String locator = "//span/parent::button[contains(@aria-label,\""+fieldName+"\")]";
        return By.xpath(locator);
    }

    public static By CASE_FIELD_DROPDOWN_OPTION(String dropdownOption)
    {
        String locator = "//lightning-base-combobox-item[@data-value=\""+dropdownOption+"\"]";
        return By.xpath(locator);
    }

    public static By FOLDER_SEARCH_FIELD(String page)
    {
        String locator = "//span[text()=\""+page+"\"]/ancestor::div[@role=\"banner\"]/parent::div//input[@placeholder=\"Search all folders...\"]";
        return By.xpath(locator);
    }
    public static By REPORT_PAGE_HEADER(String option)
    {
        String locator = "//div[contains(@style,\"fixed\")]/table//th//span/span[text()=\""+option+"\"]";
        return By.xpath(locator);
    }

    public static By SELECT_NAV_OPTION_CATEGORY(String option)
    {
        String locator = "//div[@id=\"navSection\"]//li/a[text()=\""+option+"\"]";
        return By.xpath(locator);
    }

    public static By SELECT_NAV_MENU_ITEM(String item)
    {
        String locator = "//li[@role=\"presentation\"]//span[text()=\""+item+"\"]/parent::span/parent::a";
        return By.xpath(locator);
    }

    public static By SEARCH_RESULT(String option) {
        String locator="//search_dialog-instant-result-item//span[@title=\""+option+"\"]";
        return By.xpath(locator);
    }

    public static By CLOSE_OPENED_CASE(String caseNo)
    {
        String locator = "//button[contains(@title,\""+caseNo+"\")]";
        return By.xpath(locator);
    }

    public static By CASE_PAGE_DETAIL(String detailName) {
        String locator = "//span[contains(text(),\""+detailName+"\")]/parent::div/following-sibling::div/span//lightning-formatted-text";
        return By.xpath(locator);
    }

    public static By CASE_PAGE_LINK(String detailName) {
        String locator = "//span[contains(text(),\""+detailName+"\")]/parent::div/following-sibling::div/span//a//span";
        return By.xpath(locator);
    }

    public static By APP_LAUNCHER_SEARCH_RESULT(String item) {
        String locator = "//one-app-launcher-menu-item/a//b[contains(text(),\""+item+"\")]";
        return By.xpath(locator);
    }

    public static By LIBRARY_PAGE_TAB(String tabName) {
        String locator = "//a[@data-tab=\""+tabName+"\"]";
        return By.xpath(locator);
    }

    public static By LIBRARY_LEFT_NAVBAR(String header) {
        String locator = "//h4[text()=\""+header+"\"]/parent::div/parent::div[contains(@class,\"clause-library-sidebar\")]";
        return By.xpath(locator);
    }


    public static By CONTACT_PERMISSION_DROPDOWN(String secondaryAccount) {
        String locator = "//th//a[contains(text(),\""+secondaryAccount+"\")]/ancestor::th/following-sibling::td//span[text()=\"Show more actions\"]";
        return By.xpath(locator);
    }

    public static By CONTACT_PERMISSSION_ITEM(String item) {
        String locator = "//div[text()=\"Account Permissions\"]/parent::div//li//span[contains(text(),\""+item+"\")]";
        return By.xpath(locator);
    }

    public static By CONTACT_PERMISSSION_ADD_REMOVE(String item) {
        String locator = "//div[text()=\"Account Permissions\"]/parent::div//span[text()=\""+item+"\"]/parent::button";
        return By.xpath(locator);
    }
}
