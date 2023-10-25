package tests;
import Pages.LoginPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import Retry.RetryAnalyzer;

public class ProfileTest extends BasicTest{
    @Test (priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void visitTheProfilePage() throws InterruptedException {
        String email = "admin@admin.com";
        String password = "12345";

        LoginPage.autoLogin(email,password);

        wait.until(ExpectedConditions.urlToBe(baseUrl + "/home"));

        navPage.clickOnMyProfileButton();
        profilePage.waitForProfilePage();


        Assert.assertEquals(navPage.getCurrentUrl(), baseUrl + "/profile", "Current url should be " + baseUrl + "/profile");

        Assert.assertEquals(profilePage.getEmailInputFieldValue(), "admin@admin.com",
                "Email input field should have value 'admin@admin.com'.");

        navPage.clickOnLogoutButton();
    }
    @Test (priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void checksInputTypes() throws InterruptedException{
        String email = "admin@admin.com";
        String password = "12345";

        LoginPage.autoLogin(email,password);

        wait.until(ExpectedConditions.urlToBe(baseUrl + "/home"));

        navPage.clickOnMyProfileButton();

        profilePage.waitForProfilePage();

        Assert.assertEquals(profilePage.checkEmailFieldByTypeAttribute(), "email", "Email input field type should have value 'email'");
        Assert.assertEquals(profilePage.chechkEmailInputFieldByAttributeDisabled(), "disabled", "Email input field should have value 'disabled' for attribute 'disabled'");
        Assert.assertEquals(profilePage.checkNameFieldByTypeAttribute(), "text", "Name input field type should have value 'text'");
        Assert.assertEquals(profilePage.checkCityFieldByTypeAttribute(), "text", "City input field type should have value 'text'");
        Assert.assertEquals(profilePage.checkCountryFieldByTypeAttribute(), "text", "Country input field type should have value 'text'");
        Assert.assertEquals(profilePage.checkTwitterFieldByTypeAttribute(), "url", "Twitter url input field type should have value 'url'");
        Assert.assertEquals(profilePage.checkGitHubFieldByTypeAttribute(), "url", "Email input field type should have value 'url'");
        Assert.assertEquals(profilePage.checkPhoneFieldByTypeAttribute(), "tel", "Phone input field type should have value 'tel'");

        navPage.clickOnLogoutButton();
    }
}
