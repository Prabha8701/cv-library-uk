package uk.co.library.testsuite;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import uk.co.library.pages.HomePage;
import uk.co.library.pages.ResultPage;
import uk.co.library.testbase.BaseTest;
import uk.co.library.testdata.TestData;

public class JobSearchTest extends BaseTest {
    HomePage homePage;
    ResultPage resultPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        resultPage = new ResultPage();
    }

    @Test (dataProvider = "JobSearch", dataProviderClass = TestData.class)
    public void verifyJobSearchResultUsingDifferentDataSet(
            String jobTitle, String location, String distance, String salaryMin, String salaryMax, String salaryType, String jobType, String expectedText) throws InterruptedException {

        homePage.acceptCookies();

        homePage.enterJobTitle(jobTitle);

        homePage.enterLocation(location);

        homePage.selectDistance(distance);

        homePage.clickOnMoreSearchOption();

        homePage.enterMinSalary(salaryMin);

        homePage.enterMaxSalary(salaryMax);

        homePage.selectSalaryType(salaryType);

        homePage.selectJobType(jobType);

        homePage.clickOnFindJobsButton();

        String actual =resultPage.getText();
        String expected = expectedText;
        Assert.assertEquals(actual,expected);


    }
}

