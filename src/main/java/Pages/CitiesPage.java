package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import java.util.List;

import java.time.Duration;


public class CitiesPage extends BasicPage {
    public CitiesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickOnCitiesButton() {
        driver.findElement(By.cssSelector("a.btnAdminCities")).click();
    }

    public void clickOnNewItemButton() {
        driver.findElement(By.className("btnNewItem")).click();
    }

    public void waitForCreateEditCityDialogToAppear() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#app > div.v-dialog__content.v-dialog__content--active > div > div")));
    }

    public WebElement getCityInputField() {
        return driver.findElement(By.cssSelector("#name"));
    }

    public void enterCityName(String cityName) {
        WebElement cityNameInput = driver.findElement(By.cssSelector("#name"));
        cityNameInput.sendKeys(Keys.CONTROL + "a");
        cityNameInput.sendKeys(Keys.DELETE);
        cityNameInput.sendKeys(cityName);
    }

    public void clickOnSaveButton() {
        driver.findElement(By.cssSelector("div.v-card__actions > button.btnSave")).click();
    }

    public String getMessagePopupText() {
        WebElement messagePopup = driver.findElement(By.cssSelector(".success .v-snack__content"));
        return messagePopup.getText();
    }

    public WebElement getSearchField() {
        return driver.findElement(By.id("search"));
    }

    public void sendValueOnSearchField(String oldCityName) {
        getSearchField().sendKeys(oldCityName);
    }


    public void waitForNumberOfRowsInTableToBe(int expectedNumberOfRows) {
        List<WebElement> rows = driver.findElements(By.cssSelector(".v-data-table__wrapper tbody tr"));
        Assert.assertEquals(rows.size(), expectedNumberOfRows);
    }

    public void clickOnEditButtonForFirstRow() {
        driver.findElement(By.cssSelector("#edit")).click();
    }
}
