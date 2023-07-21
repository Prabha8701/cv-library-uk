package uk.co.library.pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import uk.co.library.customlisteners.CustomListeners;
import uk.co.library.utility.Utility;

public class HomePage extends Utility {

    //Locators - jobTitle, location, distanceDropDown, moreSearchOptionsLink, salaryMin, salaryMax, salaryTypeDropDown, jobTypeDropDown, findJobsBtn
    //  Methods - enterJobTitle(String jobTitle), enterLocation(String location), selectDistance(String distance), clickOnMoreSearchOptionLink(),
    //  enterMinSalary(String minSalary),  enterMaxSalary(String maxSalary), selectSalaryType(String sType), selectJobType(String jobType),
    //  clickOnFindJobsButton().

    public HomePage() {
        PageFactory.initElements(driver, this);

    }
    @CacheLookup
    @FindBy(id = "keywords")
    WebElement jobTitleField;

    @CacheLookup
    @FindBy(id = "location")
    WebElement locationField;

    @CacheLookup
    @FindBy(id = "distance")
    WebElement distanceDropDown;

    @CacheLookup
    @FindBy(id = "toggle-hp-search")
    WebElement moreSearchOptionsLink;

    @CacheLookup
    @FindBy(id = "salarymin")
    WebElement salaryMin;

    @CacheLookup
    @FindBy(id = "salarymax")
    WebElement salaryMax;

    @CacheLookup
    @FindBy(id = "salarytype")
    WebElement salaryTypeDropDown;

    @CacheLookup
    @FindBy(id = "tempperm")
    WebElement jobTypeDropDown;

    @CacheLookup
    @FindBy(id = "hp-search-btn")
    WebElement findJobsBtn;

    @CacheLookup
    @FindBy(xpath = "//iframe[@id='gdpr-consent-notice']")
    WebElement acceptIFrame;

    @CacheLookup
    @FindBy(xpath = "//button[@id='save']")
    WebElement acceptCookies;

    public void acceptCookies(){
        Reporter.log("Accept Cookies"+acceptCookies.toString());
        driver.switchTo().frame(acceptIFrame);
        clickOnElement(acceptCookies);
        CustomListeners.test.log(Status.PASS,"Accept Cookies");
    }

    public void enterJobTitle(String jobTitle) {
        Reporter.log("Enter Job Title"+jobTitleField.toString());
        sendTextToElement(jobTitleField, jobTitle);
        CustomListeners.test.log(Status.PASS,"Enter Job Title");
    }

    public void enterLocation(String location) {
        Reporter.log("Enter Location"+locationField.toString());
        sendTextToElement(locationField, location);
        selectByVisibleTextFromDropDown(locationField,"Harrow, Greater London");
        CustomListeners.test.log(Status.PASS,"Enter Location");
    }

    public void selectDistance(String distance) throws InterruptedException {
        Thread.sleep(1000);
        Reporter.log("Select Distance"+distanceDropDown.toString());
        selectByVisibleTextFromDropDown(distanceDropDown, distance);
        CustomListeners.test.log(Status.PASS,"Select Distance");
    }

    public void clickOnMoreSearchOption() {
        Reporter.log("click On More Search Option"+moreSearchOptionsLink.toString());
        clickOnElement(moreSearchOptionsLink);
        CustomListeners.test.log(Status.PASS,"click On More Search Option");
    }

    public void enterMinSalary(String minSalary) {
        Reporter.log("Enter Minimum Salary"+salaryMin.toString());
        sendTextToElement(salaryMin, minSalary);
        CustomListeners.test.log(Status.PASS,"Enter Minimum Salary");
    }

    public void enterMaxSalary(String maxSalary) {
        Reporter.log("Enter Maximum Salary"+salaryMax.toString());
        sendTextToElement(salaryMax, maxSalary);
        CustomListeners.test.log(Status.PASS,"Enter Maximum Salary");
    }

    public void selectSalaryType(String salaryType) {
        Reporter.log("Select Salary Type"+salaryTypeDropDown.toString());
        selectByVisibleTextFromDropDown(salaryTypeDropDown, salaryType);
        CustomListeners.test.log(Status.PASS,"Select Salary Type");
    }

    public void selectJobType(String jobType) {
        Reporter.log("Select Job Type"+jobTypeDropDown.toString());
        selectByVisibleTextFromDropDown(jobTypeDropDown, jobType);
        CustomListeners.test.log(Status.PASS,"Select Job Type");
    }

    public void clickOnFindJobsButton() {
        Reporter.log("click On find jobs button"+findJobsBtn.toString());
        clickOnElement(findJobsBtn);
        CustomListeners.test.log(Status.PASS,"click On find jobs button");
    }
}
