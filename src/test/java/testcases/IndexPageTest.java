package testcases;

import com.crm.qa.actiondriver.Action;
import com.crm.qa.base.BaseClass;
import com.crm.qa.pages.IndexPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.SearchResultPage;
import com.crm.qa.utility.Log;
import org.testng.Assert;
import org.testng.annotations.*;




public class IndexPageTest extends BaseClass {

    private IndexPage indexPage;
    private LoginPage loginPage;
    private SearchResultPage searchResultPage;
    @BeforeMethod
    public void setup() {

        launchApp();
    }
    @AfterMethod
    public void tearDown(){
        getDriver().quit();
    }

    @Test
    public void verifyLogoTest(){
        Log.startTestCase("verifyLogo");
        indexPage = new IndexPage();
        Log.info("validate the log");

        boolean result = indexPage.validateLogo();
        Assert.assertTrue(result);
        Log.endTestCase("verifyLogo");


    }
    @Test
    public void verifyTitleTest(){
        Log.debug("Hai dfkdjj==================");
        String actTitle = indexPage.getAmazonTitle();
        Assert.assertEquals(actTitle,"Amazon.com. Spend less. Smile more.");
        Log.error("test fials display this");
    }
    @Test
    public void signInTest() throws Throwable {
        indexPage = new IndexPage();
        loginPage = new LoginPage();
        indexPage.moveToAccountList();
        loginPage = indexPage.clickOnSignIn();
        boolean result=loginPage.validateSignin();
        Assert.assertTrue(result);

    }




}
