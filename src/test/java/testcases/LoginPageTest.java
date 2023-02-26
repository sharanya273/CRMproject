package testcases;

import com.crm.qa.actiondriver.Action;
import com.crm.qa.base.BaseClass;
import com.crm.qa.pages.IndexPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.SearchResultPage;
import com.crm.qa.pages.YourAccountPage;
import com.crm.qa.utility.Log;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseClass {
    private IndexPage indexPage;
    private LoginPage loginPage;
    private SearchResultPage searchResultPage;
    private YourAccountPage yourAccountPage;
    @BeforeMethod
    public void setup() {

        launchApp();
    }
    @AfterMethod
    public void tearDown(){
        getDriver().quit();
    }
    @Test
    public void validateLoginTest() throws Throwable {
        Log.startTestCase("emailInputTest");
        indexPage = new IndexPage();
        loginPage = new LoginPage();
        yourAccountPage = new YourAccountPage();
        indexPage.moveToAccountList();
        loginPage = indexPage.clickOnSignIn();
        Log.info("validate the log");
        loginPage.enterEmail();
        loginPage.clickContinueButton();
        loginPage.enterPassword();

        yourAccountPage=loginPage.clickSignInButton();
        yourAccountPage.waitForAccountpage();

        String actTitle = loginPage.getAccountPageTitle();
        System.out.println(actTitle);
        Assert.assertEquals(actTitle,"Amazon.com. Spend less. Smile more.");
        Log.info("Your account page title is matched");
        Log.endTestCase("validateLoginTest");


    }

}
