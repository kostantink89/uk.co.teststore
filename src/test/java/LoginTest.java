import org.junit.Assert;
import org.junit.Test;
import data.TestData;
import utils.ExcelUtils;

public class LoginTest extends BaseTest {


    public void positiveLoginTest() throws InterruptedException {

        homePage.openHomePage();
        homePage.checkIsRedirectToHomePage();
        homePage.clickOnSignInButton();

        loginPage.fillingLoginPageWithValidCred();

        Assert.assertTrue("Sign out button is not displayed", myStorePage.isSignOutButtonDisplayed());
        Assert.assertTrue("Account name is not displayed", myStorePage.isAccountNameDisplayed());

    }


    @Test
    public void positiveLoginTestWithExcel() {

        homePage.openHomePage();
        homePage.checkIsRedirectToHomePage();
        homePage.clickOnSignInButton();

        loginPage.enterEmailToTheEmailField(ExcelUtils.setEmail());
        loginPage.enterPasswordToThePasswordField(ExcelUtils.setPassword());
        loginPage.clickOnSignInButton();

        Assert.assertTrue("Sign out button is not displayed", myStorePage.isSignOutButtonDisplayed());
        Assert.assertTrue("Account name is not displayed", myStorePage.isAccountNameDisplayed());



    }


    public void negativeLoginTest() {

        homePage.openHomePage();
        homePage.checkIsRedirectToHomePage();
        homePage.clickOnSignInButton();

        loginPage.enterEmailToTheEmailField(TestData.EMAIL);
        loginPage.enterPasswordToThePasswordField(TestData.INVALID_PASSWORD);
        loginPage.clickOnSignInButton();

        Assert.assertTrue("Sign In Button is not displayed", loginPage.isSignInButtonDisplayed());
        Assert.assertFalse("Sign Out Button is displayed", myStorePage.isSignOutButtonDisplayed());


    }
}


