package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import Retry.RetryAnalyzer;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignupTest extends BasicTest{
    @Test (priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void visitsTheSignupPage(){
        navPage.clickOnSingupButton();
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/signup", "Urls should be similar.");
    }
    @Test (priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void checksInputTypes(){
        navPage.clickOnSingupButton();
        Assert.assertEquals(singupPage.checkEmailType(), "email", "The email field should have the value \"email\" in the \"type\" attribute.");
        Assert.assertEquals(singupPage.checkPasswordType(), "password", "The password field should have the value \"password\" in the \"type\" attribute.");
        Assert.assertEquals(singupPage.checkConfirmPasswordType(), "password", "The confirm password field should have the value \"password\" in the \"type\" attribute.");
    }
    @Test (priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void displaysErrorsWhenUserAlreadyExists(){
        String name = "Another User";
        String email = "admin@admin.com";
        String password = "12345";
        String confirmPassword = "12345";

        navPage.clickOnSingupButton();
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/signup", "Urls should be similar.");

        singupPage.autoSingup(name, email, password, confirmPassword);

        messagePopUpPage.waitForErrorPopupToBeVisible();

        String errorMessage = messagePopUpPage.getErrorPopupMessage();
        Assert.assertEquals(errorMessage, "E-mail already exists", "Message from popup should be like expected message");

        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/signup", "Urls should be similar.");
    }
    @Test (priority = 4, retryAnalyzer = RetryAnalyzer.class)
    public void signup(){
        String name = "Jelena Lazic";
        String email = "jelena.lazic@lalala.com";
        String password = "12345";
        String confirmPassword = "12345";
        navPage.clickOnSingupButton();

        singupPage.autoSingup(name, email, password, confirmPassword);

        wait
                .withMessage("Url should be for home page.")
                .until(ExpectedConditions.urlToBe(baseUrl+ "/home"));

        messagePopUpPage.waitForVerifyPopUpMessage();
        Assert.assertEquals(messagePopUpPage.getVerifPopupMessage(), "IMPORTANT: Verify your account");
        messagePopUpPage.clickOnVerifyPopupCloseButton();
        navPage.clickOnLogoutButton();

    }

}
