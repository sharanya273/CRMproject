package com.crm.qa.pages;

import com.crm.qa.actiondriver.Action;
import com.crm.qa.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class IndexPage extends BaseClass {
Action action = new Action();
    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    private WebElement searchBox;
    @FindBy(xpath = "//a[@id='nav-logo-sprites']")
    private WebElement logoTxt;
    @FindBy(xpath = "//input[@id='nav-search-submit-button']")
    private WebElement searchSubmitBtn;
    @FindBy(id="nav-link-accountList")
    private WebElement accountnLists;

    @FindBy(id="nav-link-accountList")
    private WebElement signInBtn;


    public IndexPage(){

        PageFactory.initElements(getDriver(),this);
    }


    public boolean validateLogo(){

        return action.isDisplayed(getDriver(),logoTxt);
    }

    public String getAmazonTitle(){
        String amazonTitle = getDriver().getTitle();
        return amazonTitle;
    }
    public void moveToAccountList(){

       action.mouseOverElement(getDriver(),accountnLists);
    }
    public LoginPage clickOnSignIn() throws Throwable {

        action.click(getDriver(),accountnLists);
        return new LoginPage();
    }


    public SearchResultPage searchProduct(String productName) throws Throwable {
       action.fluentWait(getDriver(),searchBox,20);
        action.type(searchBox, productName);
        action.scrollByVisibilityOfElement(getDriver(), searchSubmitBtn);
        action.click(getDriver(), searchSubmitBtn);
        return new SearchResultPage();
    }

}
