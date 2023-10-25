package tests;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import Retry.RetryAnalyzer;

public class LoginTest extends BasicTest {
    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void visitsTheHomePage(){
        navPage.getLanguageButton();
        navPage.clickOnLanguageButton();
        navPage.getEnglishLanguage();
        navPage.clickOnEnglishLanguage();
        navPage.getLoginNavButton();
        navPage.clickOnLoginNavButton();
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "/login");
    }
    @Test (priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void checksInputTypes(){
        navPage.clickOnLoginNavButton();
        String attributeEmail = LoginPage.getEmailInput().getAttribute("type");
        String attributePassword =LoginPage.getPasswordInput().getAttribute("type");
        Assert.assertEquals(attributeEmail, "email", "The email field should have the value \"email\" in the \"type\" attribute." );
        Assert.assertEquals(attributePassword, "password", "The password field should have the value \"password\" in the \"type\" attribute.");
    }
    @Test (priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void displaysErrorsWhenUserDoesNotExist(){
        String email = "non-existing-user@gmal.com";
        String password = "password123";
        navPage.clickOnLoginNavButton();

        LoginPage.getEmailInput().sendKeys(email);
        LoginPage.getPasswordInput().sendKeys(password);
        LoginPage.clickOnLoginButton();
        LoginPage.waitForErrorPopupToBeVisible();

        String errorMessage = LoginPage.getErrorLoginPopupMessage();
        Assert.assertEquals(errorMessage, "User does not exists", "Message from popup should be like expected message");

        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login", "Urls should be similar.");
    }

}
