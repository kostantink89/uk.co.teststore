package pageObjects;

import base.ParentPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {

    @FindBy(xpath = ".//input[@class='form-control']")
    private WebElement emailField;

    @FindBy(xpath = ".//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath = ".//button[@id='submit-login']")
    private WebElement signInButton;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void enterEmailToTheEmailField(String email) {
        enterTextInToElement(emailField, email);
    }

    public void enterPasswordToThePasswordField(String password) {
        enterTextInToElement(passwordField, password);
    }

    public void clickOnSignInButton() {
        clickOnElement(signInButton);

    }

    public boolean isSignInButtonDisplayed() {
       return isElementPresented(signInButton);
    }
}
