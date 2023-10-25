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
    @Test (priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void editProfile(){
        String email = "admin@admin.com";
        String password = "12345";
        String name = "Jelena Lazic";
        String phone = "+38133555";
        String city = "Paris";
        String country = "France";
        String twitter = "https://twitter.com/profile/2";
        String github = "https://github.com/JelenaLazicNS";

        LoginPage.autoLogin(email, password);
        wait.until(ExpectedConditions.urlToBe(baseUrl + "/home"));
        navPage.clickOnMyProfileButton();
        profilePage.replaceName(name);
        profilePage.replacePhone(phone);
        profilePage.replaceCity(city);
        profilePage.replaceCountry(country);
        profilePage.replaceTwitter(twitter);
        profilePage.replaceGitHub(github);
        profilePage.clickOnSaveButton();
        messagePopUpPage.waitUntilPopUpMessageForSuccessfulProfileUpdateIsVisible();
        Assert.assertTrue(messagePopUpPage.getTextFromPopUpMessageForSuccessfulProfileUpdate(), "Pop up message should be 'Profile saved successfuly'.");


        Assert.assertEquals(profilePage.getNameFieldValue(), name,
                "Name input field should have name value.");
        Assert.assertEquals(profilePage.getPhoneFieldValue(), phone,
                "Phone input field should have phone value.");
        Assert.assertEquals(profilePage.getCityFieldValue(), city,
                "City input field should have city value.");
        Assert.assertEquals(profilePage.getCountryFieldValue(), country,
                "Country input field should have country value.");
        Assert.assertTrue(profilePage.getTwitterFieldValue().equals(twitter), "Twitter url input field should have twitter value.");
        Assert.assertTrue(profilePage.getGitHubFieldValue().equals(github), "GitHub url input field should have github value.");

        navPage.clickOnLogoutButton();
    }
}
