package testSuite.AccountPage;

import org.openqa.selenium.By;

public class AccountPageLocator {
    static By SAVE_BUTTON = By.xpath("//button[text()=\"Save\"]");
    static By MODAL_SAVE_BUTTON = By.xpath("//div[contains(@class,\"modal\")]/button[text()=\"Save\"]");
    static By CASE_ON_TOP = By.xpath("//section[contains(@class,\"active\")]//table/tbody/tr[1]/td[1]//lightning-formatted-url");
    static By FILE_UPLOAD_DONE =By.xpath("//span[text()=\"Done\"]") ;
    static By ACCOUNTNAME_TITLE = By.xpath("//c-sbtp_account-header//h1");
    static By DESIGNATE_TMC = By.xpath("//lightning-icon[@title=\"Designate TMC User\"]/parent::button");
    static By ARC_NUMBER_FIELD = By.xpath("//input[@name=\"ARC\"]");
    static By NEXT_BUTTON = By.xpath("//button[text()=\"Next\"]");
    static By SUBMIT_FORM = By.xpath("//button[contains(text(),\"Submit Request\")]");
    static By FINISH_BUTTON = By.xpath("//button[text()=\"Finish\"]");
    static By INFORMATION_EMAIL_FIELD = By.xpath("//input[contains(@placeholder,\"@example.com\")]");
    static By INFORMATION_ACCESS_TYPE = By.xpath("//select[contains(@name,\"Contact_Role\")]");
    static By ACCOUNT_DASHBOARD_BUTTON = By.xpath("//button[text()=\"Account Request Dashboard\"]");
    static By NO_ACCOUNT_MESSAGE = By.xpath("//span[text()=\"A TMC wasn't found in our system. You can go back to search with another ARC number or proceed with giving more information about the company.\"]");
//Setting Tab
    static By USER_ACCESS_SECTION = By.xpath("//h1[text()=\"CTM & TMC User Access\"]");
    //PermissionTab
    static By PERMISSION_PAGE_TITLE = By.xpath("//h3[text()=\"Account & Contract Permissions\"]");


    public static By ACCOUNTCID(String title) {
        String locator="//span[@title=\""+title+"\"]/following-sibling::div//span";
        return By.xpath(locator);
    }

    public static By HEADERTAB(String tabName) {
        String locator="//ul[@role=\"presentation\"]/li/a/span[text()=\""+tabName+"\"]";
        return By.xpath(locator);
    }

    public static By INFORMATION_FIELD(String fieldName)
    {
        String locator = "//input[contains(@name,\""+fieldName+"\")]";
        return  By.xpath(locator);
    }

    public static By INFORMATION_DETAILS(String detail)
    {
        String locator = "//flowruntime-display-text-lwc//p/span[contains(text(),\""+detail+"\")]";
        return  By.xpath(locator);
    }

    public static By REQUEST_DETAILS(String index) {
       String locator = "//section[contains(@class,\"active\")]//table/tbody/tr[1]/td["+index+"]";
        return By.xpath(locator);
    }

    public static By REQUEST_CASENUMBER(String casenumber) {
        String locator = "//section[contains(@class,\"active\")]//table/tbody/tr/td[1]//a[text()=\""+casenumber+"\"]";
        return By.xpath(locator);
    }

    public static By CASEDETAIL_DATA(String fieldName) {
        String locator = "//span[text()=\""+fieldName+"\"]/parent::div/following-sibling::div/span/*";
        return By.xpath(locator);
    }

    public static By ERRORMESSAGE_FORM(String fieldName) {
        String locator = "//span[contains(text(),\""+fieldName+"\")]/ancestor::div[contains(@class,\"flowruntime-input\")]/following-sibling::div[contains(@class,\"flowruntime-input-error\")]//span";
        return By.xpath(locator);
    }

    public static By FORMPAGE_DATA(String dataName)
    {
        String locator = "//b[contains(text(),\""+dataName+"\")]/following-sibling::span";
        return By.xpath(locator);
    }

    public static By USER_CONTACT_TABLE(String userName) {
        String locator = "//*[contains(text(),\""+userName+"\")]/ancestor::tr";
        return By.xpath(locator);
    }

    public static By CONTACT_ACTIONS_DROPDOWN(String userName) {
        String locator = "//*[text()=\""+userName+"\"]/ancestor::tr//lightning-button-menu/button";
        return By.xpath(locator);
    }

    public static By CONTACT_OPENED_DROPDOWN(String option) {
        String locator = "//a[@role=\"menuitem\"]/span[contains(text(),\""+option+"\")]";
        return By.xpath(locator);
    }

    public static By SORT_REQUEST_TITLE(String title) {
        String locator = "//thead//a/span[contains(text(),\""+title+"\")]";
        return By.xpath(locator);
    }


    public static By EDIT_PERMISSION(String option) {
        String locator = "//td[text()=\""+option+"\"]/following-sibling::td/input";
        return By.xpath(locator);
    }

    public static By CONTACT_DETAIL(String contact, String field) {
        String locator = "//*[text()=\""+contact+"\"]/ancestor::tr/td[@data-label=\""+field+"\"]//lightning-base-formatted-text";
        return By.xpath(locator);
    }

    public static By TITLE_CHECKBOX(String title) {
        String locator = "//td[text()=\""+title+"\"]/following-sibling::td/input";
        return By.xpath(locator);
    }
}
