import org.junit.Assert;
import org.junit.Test;
import data.TestData;

public class LoginTest extends BaseTest {

    @Test
    public void positiveLoginTest() {

        homePage.openHomePage();
        homePage.checkIsRedirectToHomePage();
        homePage.clickOnSignInButton();

        loginPage.enterEmailToTheEmailField(TestData.VALID_EMAIL);
        loginPage.enterPasswordToThePasswordField(TestData.PASSWORD);
        loginPage.clickOnSignInButton();

        Assert.assertTrue("Sign out button is not displayed", myStorePage.isSignOutButtonDisplayed());
        Assert.assertTrue("Account name is not displayed", myStorePage.isAccountNameDisplayed());


    }

    @Test
    public void negativeLoginTest() {

        homePage.openHomePage();
        homePage.checkIsRedirectToHomePage();
        homePage.clickOnSignInButton();

        loginPage.enterPasswordToThePasswordField(TestData.INVALID_EMAIL);
        loginPage.enterPasswordToThePasswordField(TestData.PASSWORD);
        loginPage.clickOnSignInButton();

        Assert.assertTrue("Sign In Button is not displayed", loginPage.isSignInButtonDisplayed());
        Assert.assertFalse("Sign Out Button is displayed", myStorePage.isSignOutButtonDisplayed());


    }
}
