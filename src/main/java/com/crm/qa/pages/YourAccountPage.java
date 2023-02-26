package com.crm.qa.pages;

import com.crm.qa.actiondriver.Action;
import com.crm.qa.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YourAccountPage extends BaseClass {

    Action action= new Action();
    @FindBy(xpath="//a[normalize-space()='Click here to go to amazon.in']")
    private WebElement yourAccountTxt;





    public YourAccountPage(){

        PageFactory.initElements(getDriver(),this);
    }

    public void waitForAccountpage(){
        action.explicitWait(getDriver(),yourAccountTxt,30);
    }
}
