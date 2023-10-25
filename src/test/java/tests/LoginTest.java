package tests;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import Retry.RetryAnalyzer;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Pages.LoginPage.*;

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
        String attributeEmail = getEmailInput().getAttribute("type");
        String attributePassword = getPasswordInput().getAttribute("type");
        Assert.assertEquals(attributeEmail, "email", "The email field should have the value \"email\" in the \"type\" attribute." );
        Assert.assertEquals(attributePassword, "password", "The password field should have the value \"password\" in the \"type\" attribute.");
    }
    @Test (priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void displaysErrorsWhenUserDoesNotExist(){
        String email = "non-existing-user@gmal.com";
        String password = "password123";
        navPage.clickOnLoginNavButton();

        getEmailInput().sendKeys(email);
        getPasswordInput().sendKeys(password);
        clickOnLoginButton();
        LoginPage.autoLogin(email,password);
        waitForErrorPopupToBeVisible();

        String errorMessage = getErrorLoginPopupMessage();
        Assert.assertEquals(errorMessage, "User does not exists", "Message from popup should be like expected message");

        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login", "Urls should be similar.");
    }
    @Test (priority = 4, retryAnalyzer = RetryAnalyzer.class)
    public void displaysErrorsWhenPasswordIsWrong(){
        String email = "admin@admin.com";
        String password = "password123";
        navPage.clickOnLoginNavButton();

        getEmailInput().sendKeys(email);
        getPasswordInput().sendKeys(password);
        clickOnLoginButton();
        LoginPage.autoLogin(email,password);
        waitForErrorPopupToBeVisible();

        String errorMessage = getErrorLoginPopupMessage();
        Assert.assertEquals(errorMessage, "Wrong password", "Message from popup should be contains \"Wrong password\"" );

        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login", "Urls should be similar.");
    }
    @Test (priority = 5, retryAnalyzer = RetryAnalyzer.class)
    public void correctLogin(){
        String email = "admin@admin.com";
        String password = "12345";

        navPage.clickOnLoginNavButton();

        getEmailInput().sendKeys(email);
        getPasswordInput().sendKeys(password);
        clickOnLoginButton();
        LoginPage.autoLogin(email,password);
        wait
                .withMessage("Url should be for home page.")
                .until(ExpectedConditions.urlToBe(baseUrl + "/home"));
    }
    @Test(priority = 6, retryAnalyzer = RetryAnalyzer.class)
    public void logout(){
        navPage.waitUntilLogoutButtonIsVisible();
        navPage.clickOnLogoutButton();
    }


}
