package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagePopUpPage extends BasicPage {
    public MessagePopUpPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public String getErrorPopupMessage(){
        WebElement errorElement = driver.findElement(By.cssSelector("div > div.v-snack__content > ul > li"));
        return errorElement.getText();
    }
    public void waitForErrorPopupToBeVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.v-snack__content")));
    }
    public void waitForVerifyPopUpMessage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".black--text.dlgVerifyAccount > i")));
    }
    public String getVerifPopupMessage(){
        WebElement verifyPopupText = driver.findElement(By.cssSelector(".black--text.dlgVerifyAccount"));
        return verifyPopupText.getText();
    }
    public WebElement getVerifyPopupCloseButton(){
        return driver.findElement(By.cssSelector(".btnClose"));
    }
    public void clickOnVerifyPopupCloseButton(){
        getVerifyPopupCloseButton().click();
    }


}
