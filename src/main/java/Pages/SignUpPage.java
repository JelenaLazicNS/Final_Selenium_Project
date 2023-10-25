package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage extends BasicPage {
    public SignUpPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement getEmailInput(){
        return driver.findElement(By.id("email"));
    }
    public WebElement getPasswordInput(){
        return driver.findElement(By.id("password"));
    }
    public WebElement getConfimPasswordInput(){
        return driver.findElement(By.id("confirmPassword"));
    }
    public String checkEmailType(){
        return getEmailInput().getAttribute("type");
    }
    public String checkPasswordType(){
        return  getPasswordInput().getAttribute("type");
    }
    public String checkConfirmPasswordType(){
        return getConfimPasswordInput().getAttribute("type");
    }

}
