package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

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
}
