package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasicPage {
    protected NavPage navPage;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        navPage = new NavPage(driver, wait);
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


    public static void autoLogin(String email, String password){
        NavPage.clickOnLoginNavButton();
        getEmailInput().sendKeys(email);
        getPasswordInput().sendKeys(password);
        clickOnLoginButton();
    }
}

