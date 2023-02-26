package com.crm.qa.pages;

import com.crm.qa.actiondriver.Action;
import com.crm.qa.base.BaseClass;
import com.crm.qa.utility.Log;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {


    Action action= new Action();
    @FindBy(xpath="//h1[normalize-space()='Sign in']")
    private WebElement signInTxt;
    @FindBy(id="ap_email")
    private WebElement email;

    @FindBy(id="continue")
    private WebElement continueBtn;
    @FindBy(id="ap_password")
    private WebElement password;

    @FindBy(id="signInSubmit")
    private WebElement signInSubmit;



    public LoginPage(){

        PageFactory.initElements(getDriver(),this);
    }

    public boolean validateSignin() throws Throwable {
        action.fluentWait(getDriver(), signInTxt, 20);
        return action.isDisplayed(getDriver(), signInTxt);
    }
    public void enterEmail(){
              Log.info("SIGNIN_PAGE: Entering username: " + email);
        action.explicitWait(getDriver(),email,30);
        action.type(email,"sharanya.kadarla79@gmail.com");
            }
    public void clickContinueButton(){
        Log.info("SIGNIN_PAGE: Clicking the Continue button.\n");
        action.explicitWait(getDriver(),continueBtn,30);
        action.click(getDriver(),continueBtn);

    }

    public void enterPassword(){
            Log.info("SIGNIN_PAGE: Entering password.");
        action.explicitWait(getDriver(),password,30);
        action.type(password,"technology$123");
            }
    public YourAccountPage clickSignInButton(){
        Log.info("SIGNIN_PAGE: Clicking the [SIGN_IN] button.\n");
              action.click(getDriver(),signInSubmit);
              return new YourAccountPage();
          }
    public String getAccountPageTitle(){
        String accountPageTitle = getDriver().getTitle();
        return accountPageTitle;
    }

}
