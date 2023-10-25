package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasicPage {
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public static WebElement getEmailInput() {
        return driver.findElement(By.cssSelector("input[type='email']"));
    }

    public static WebElement getPasswordInput() {
        return driver.findElement(By.cssSelector("input[type='password']"));
    }

    public static WebElement getLoginButton(){
        return driver.findElement(By.cssSelector("div.flex.text-xs-center.mt-5.mb-3 > button"));
    }
    public static void clickOnLoginButton() {
        getLoginButton().click();
    }

    public static void waitForErrorPopupToBeVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.v-snack__content")));
    }

    public static String getErrorLoginPopupMessage() {
        WebElement errorElement = driver.findElement(By.cssSelector("div > div.v-snack__content > ul > li"));
        return errorElement.getText();

    }
}

