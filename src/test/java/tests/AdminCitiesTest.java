package tests;
import Pages.LoginPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import Retry.RetryAnalyzer;
import org.openqa.selenium.WebElement;

public class AdminCitiesTest extends BasicTest{
    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void visitsTheAdminCitiesPageAndListCities(){
        String username= "admin@admin.com";
        String password = "12345";

        LoginPage.autoLogin(username,password);
        navPage.clickOnAdminButton();
        navPage.waitUntilCitiesIsVisible();
        navPage.clickOnCitiesButton();
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl+ "/admin/cities", "Url should contains \"/admin/cities\" after base url.");
    }
    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void checksInputTypesForCreateEditNewCity() throws InterruptedException {
        String username= "admin@admin.com";
        String password = "12345";
        LoginPage.autoLogin(username, password);

        navPage.clickOnAdminButton();

        citiesPage.clickOnCitiesButton();

        citiesPage.clickOnNewItemButton();

        citiesPage.waitForCreateEditCityDialogToAppear();


        WebElement cityInputField = citiesPage.getCityInputField();
        Assert.assertEquals(cityInputField.getAttribute("type"), "text");
    }
    @Test (priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void createNewCity(){
        String city = "Novi Sad";

        navPage.clickOnAdminButton();
        citiesPage.clickOnCitiesButton();
        citiesPage.clickOnNewItemButton();
        citiesPage.waitForCreateEditCityDialogToAppear();
        citiesPage.enterCityName(city);
        citiesPage.clickOnSaveButton();
        messagePopUpPage.waitForSavedSuccefulyPopup();

        Assert.assertTrue(citiesPage.getMessagePopupText().contains("Saved successfully"));

    }
    @Test (priority = 4, retryAnalyzer = RetryAnalyzer.class)
    public void editCity(){
        String oldCityName = "Novi Sad";
        String editedCityName = "Subotica";

        navPage.clickOnAdminButton();
        citiesPage.clickOnCitiesButton();
        citiesPage.sendValueOnSearchField(oldCityName);
        citiesPage.waitForNumberOfRowsInTableToBe(1);
        citiesPage.clickOnEditButtonForFirstRow();
        citiesPage.enterCityName(editedCityName);
        citiesPage.clickOnSaveButton();
        messagePopUpPage.waitForSavedSuccefulyPopup();
        Assert.assertTrue(citiesPage.getMessagePopupText().contains("Saved successfully"));
    }
    @Test (priority = 5, retryAnalyzer = RetryAnalyzer.class)
    public void searchCity(){
        String editedCityName = "Subotica";
        navPage.clickOnAdminButton();

        citiesPage.clickOnCitiesButton();

        citiesPage.sendValueOnSearchField(editedCityName);

        citiesPage.waitForNumberOfRowsInTableToBe(1);

        String firstRowCityName = citiesPage.getFirstRowName();
        Assert.assertEquals(editedCityName, firstRowCityName);
    }
}
