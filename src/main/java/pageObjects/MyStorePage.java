package pageObjects;

import base.ParentPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyStorePage extends ParentPage {


    @FindBy(xpath = ".//li[@class='category'][@id='category-3']")
    private WebElement clothes;

    @FindBy(xpath = ".//li[@class='category'][@id='category-6']")
    private WebElement accessories;

    @FindBy(xpath = ".//li[@class='category'][@id='category-9']")
    private WebElement art;

    @FindBy(xpath = ".//a[@class='logout hidden-sm-down']")
    private WebElement signOutButton;

    @FindBy(xpath = ".//a[@title='View my customer account']")
    private WebElement accountName;


    public MyStorePage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isSignOutButtonDisplayed() {
        return isElementPresented(signOutButton);
    }

    public boolean isAccountNameDisplayed() {
        return isElementPresented(accountName);
    }


}
