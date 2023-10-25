package tests;
import Pages.LoginPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import Retry.RetryAnalyzer;

public class ProfileTest extends BasicTest{
    @Test (priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void visitTheProfilePage(){
        String email = "admin@admin.com";
        String password = "12345";

        LoginPage.autoLogin(email,password);

        wait.until(ExpectedConditions.urlToBe(baseUrl + "/home"));

        driver.get(baseUrl + "/profile");

        profilePage.waitForProfilePage();

        Assert.assertTrue(driver.getCurrentUrl().contains("/profile"), "Urls should be " + baseUrl+ "/profile");

        navPage.clickOnLogoutButton();
    }
}
