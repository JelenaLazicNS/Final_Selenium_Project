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
        navPage.getLoginButton();
        navPage.clickOnLoginButton();
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "/login");
    }
    @Test (priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void checksInputTypes(){
        navPage.clickOnLoginButton();
        String attributeEmail = LoginPage.getEmailInput().getAttribute("type");
        String attributePassword =LoginPage.getPasswordInput().getAttribute("type");
        Assert.assertEquals(attributeEmail, "email", "The email field should have the value \"email\" in the \"type\" attribute." );
        Assert.assertEquals(attributePassword, "password", "The password field should have the value \"password\" in the \"type\" attribute.");
    }
}
