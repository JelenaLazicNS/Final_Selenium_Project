package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ProfilePage extends BasicPage{
    public ProfilePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public void waitForProfilePage(){
        wait
                .withMessage("Url should contains /profile.")
                .until(ExpectedConditions.urlContains("/profile"));
    }
    public WebElement getEmailInput(){
        return driver.findElement(By.id("email"));
    }
    public String getEmailInputText(){
        return getEmailInput().getText();
    }
}
