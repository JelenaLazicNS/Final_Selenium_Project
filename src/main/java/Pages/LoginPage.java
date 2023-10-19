package Pages;

import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasicPage{
    public LoginPage(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
    }
    public WebElement getEmailField () {
        return driver.findElement(By.id("email"));
    }
    public WebElement getPasswordField () {
        return driver.findElement(By.id("password"));
    }
    public WebElement getLoginButton () {
        return driver.findElement(By.className("v-btn__content"));
    }
}
