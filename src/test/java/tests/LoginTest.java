package tests;
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
}
