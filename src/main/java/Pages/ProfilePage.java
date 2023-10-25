package Pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProfilePage extends BasicPage{
    public ProfilePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public void waitForProfilePage(){
        wait
                .withMessage("Url should contains /profile.")
                .until(ExpectedConditions.urlContains("/profile"));
    }
    public WebElement getEmailField(){
        return driver.findElement(By.id("email"));
    }
    public String getEmailInputText(){
        return getEmailField().getText();
    }
    public WebElement getNameField(){
        return driver.findElement(By.id("name"));
    }
    public WebElement getCityField(){
        return driver.findElement(By.id("city"));
    }
    public WebElement getCountryField(){
        return driver.findElement(By.id("country"));
    }
    public WebElement getTwitterField(){
        return driver.findElement(By.id("urlTwitter"));
    }
    public WebElement getGitHubField(){
        return driver.findElement(By.id("urlGitHub"));
    }
    public WebElement getPhoneField(){
        return driver.findElement(By.id("phone"));
    }

    public String getEmailInputFieldValue () {
        return getEmailField().getAttribute("value");
    }
    public String chechkEmailInputFieldByAttributeDisabled() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript("return arguments[0].getAttribute('disabled');", getEmailField()).toString();
    }
    public String checkEmailFieldByTypeAttribute(){
        return getEmailField().getAttribute("type");
    }
    public String checkNameFieldByTypeAttribute(){
        return getNameField().getAttribute("type");
    }
    public String checkCityFieldByTypeAttribute(){
        return getCityField().getAttribute("type");
    }
    public String checkCountryFieldByTypeAttribute(){
        return getCountryField().getAttribute("type");
    }
    public String checkTwitterFieldByTypeAttribute(){
        return getTwitterField().getAttribute("type");
    }
    public String checkGitHubFieldByTypeAttribute(){
        return getGitHubField().getAttribute("type");
    }
    public String checkPhoneFieldByTypeAttribute(){
        return getPhoneField().getAttribute("type");
    }
    public void replaceName(String name){
        getNameField().click();
        getNameField().sendKeys(Keys.chord(Keys.CONTROL, "a"), name);
    }
    public void replacePhone(String phone){
        getPhoneField().click();
        getPhoneField().sendKeys(Keys.chord(Keys.CONTROL, "a"), phone);
    }
    public void replaceCity(String city){

        getCityField().sendKeys(Keys.CONTROL + "a");
        getCityField().click();
        getCityField().sendKeys(Keys.chord(Keys.CONTROL, "a"), city);
    }
    public void replaceCountry(String country){
        getCountryField().click();
        getCountryField().sendKeys(Keys.chord(Keys.CONTROL, "a"), country);
    }
    public void replaceTwitter(String twitter){
        getTwitterField().click();
        getTwitterField().sendKeys(Keys.chord(Keys.CONTROL, "a"), twitter);
    }
    public void replaceGitHub(String github){

        getGitHubField().click();
        getGitHubField().sendKeys(Keys.chord(Keys.CONTROL, "a"), github);
    }
    public WebElement getSaveButton () {
        return driver.findElement(By.className("btnSave"));
    }
    public void clickOnSaveButton () {
        getSaveButton().click();
    }
    public String getNameFieldValue() {
        return getNameField().getAttribute("value");
    }
    public String getPhoneFieldValue() {
        return getPhoneField().getAttribute("value");
    }
    public String getCityFieldValue() {
        return getCityField().getAttribute("value");
    }
    public String getCountryFieldValue() {
        return getCountryField().getAttribute("value");
    }
    public String getTwitterFieldValue() {
        return getTwitterField().getAttribute("value");
    }
    public String getGitHubFieldValue() {
        return getGitHubField().getAttribute("value");
    }
}
