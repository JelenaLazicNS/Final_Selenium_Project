package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage extends BasicPage{
    public NavPage (WebDriver driver, WebDriverWait wait) {

        super(driver, wait);
    }

    public WebElement getLanguageButton(){
        return driver.findElement(By.cssSelector(".v-btn__content >.mdi-earth"));
    }
    public void clickOnLanguageButton(){
        getLanguageButton().click();
    }
    public WebElement getEnglishLanguage(){
        return driver.findElement(By.cssSelector("span.f-gb"));
    }
    public void clickOnEnglishLanguage(){
        getEnglishLanguage().click();
    }
    public static WebElement getLoginNavButton() {
        return driver.findElement(By.cssSelector(" div.v-toolbar__items > a:nth-child(3) > span"));
    }
    public static void clickOnLoginNavButton() {
        getLoginNavButton().click();
    }
    public WebElement getLogoutButton () {
        return driver.findElement(By.className("btnLogout"));
    }
    public void clickOnLogoutButton () {
        getLogoutButton().click();
    }
    public void waitUntilLogoutButtonIsVisible () {
        wait
                .withMessage("Logout button should be visible.")
                .until(ExpectedConditions.visibilityOf(getLogoutButton()));
    }
    public WebElement getSingupButton(){
        return driver.findElement(By.cssSelector(".v-toolbar__items > a:nth-child(4)"));
    }
    public void clickOnSingupButton(){
        getSingupButton().click();
    }
    public WebElement getAdminButton(){
        return driver.findElement(By.className("btnAdmin"));
    }
    public void clickOnAdminButton(){
        getAdminButton().click();
    }
    public WebElement getCitiesButton(){
        return driver.findElement(By.cssSelector("a[href=\"/admin/cities\"]"));
    }
    public void waitUntilCitiesIsVisible(){
        wait
                .withMessage("Cities button from dropdown should be visible.")
                .until(ExpectedConditions.visibilityOf(getCitiesButton()));
    }
    public void clickOnCitiesButton(){
        getCitiesButton().click();
    }
    public void waitUntilLanguageListIsVisible() {
        //WebDriverWait wait = new WebDriverWait(driver, wait);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[2]/div")));
    }

    public WebElement getSpanishLanguage(){
        return driver.findElement(By.cssSelector("span.f-es"));
    }
    public void clickOnSpanishLanguage(){
        getSpanishLanguage().click();
    }
    public WebElement getHeader () {
        return driver.findElement(By.cssSelector("h1.display-2"));
    }
    public String getHeaderText () {
        return getHeader().getText();
    }
}
