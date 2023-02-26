package com.crm.qa.pages;

import com.crm.qa.actiondriver.Action;
import com.crm.qa.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SearchResultPage extends BaseClass {

Action action = new Action();

    @FindBy(xpath = "//span[text()='RESULTS']")
    WebElement productResult;


    public SearchResultPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public boolean isProductAvailable() throws Throwable {
        action.fluentWait(getDriver(),productResult,20);
        return action.isDisplayed(getDriver(), productResult);
    }
}