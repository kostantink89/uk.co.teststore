package pageObjects;

import base.ParentPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage {

    @FindBy(xpath = ".//span[@class='hidden-sm-down'][text()='Sign in']")
    private WebElement signInButton;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openHomePage() {
        try {
            webDriver.get(base_URL);
        } catch (Exception e) {
            logger.error("Cannot open Home Page");
            Assert.fail("Cannot open Home Page");
        }
    }

    public HomePage checkIsRedirectToHomePage() {
        Assert.assertTrue("Homepage is not loaded", isSignInButtonDisplayed());
        return this;
    }

    public boolean isSignInButtonDisplayed() {
        return isElementPresented(signInButton);

    }

    public void clickOnSignInButton() {
        clickOnElement(signInButton);
    }


}
