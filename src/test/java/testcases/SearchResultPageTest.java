package testcases;

import com.crm.qa.base.BaseClass;
import com.crm.qa.pages.IndexPage;
import com.crm.qa.pages.SearchResultPage;
import com.crm.qa.utility.Log;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchResultPageTest extends BaseClass {
    private IndexPage indexPage;
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
    public void productAvailabilityTest() throws Throwable {
            Log.startTestCase("productAvailabilityTest");
            indexPage= new IndexPage();
            searchResultPage=indexPage.searchProduct("flower");
            boolean result=searchResultPage.isProductAvailable();
            Assert.assertTrue(result);
            Log.endTestCase("productAvailabilityTest");
        }



}
