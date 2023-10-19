package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasicPage{
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public static WebElement getEmailInput() {
        return driver.findElement(By.cssSelector("input[type='email']"));
    }
    public static WebElement getPasswordInput() {
        return driver.findElement(By.cssSelector("input[type='password']"));
    }


}
