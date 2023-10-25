package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage extends BasicPage {
    protected NavPage navPage;
    public SignUpPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        navPage = new NavPage(driver,wait);
    }
    public WebElement getNameInput(){
        return  driver.findElement(By.id("name"));
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
    public WebElement getSingMeUpButton(){
        return driver.findElement(By.cssSelector("button[type=\"submit\"]"));
    }


    public void clickOnSingMeUpButton(){
        getSingMeUpButton().click();
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
    public void autoSingup(String name, String email, String password, String confirmPassword){
        getNameInput().sendKeys(name);
        getEmailInput().sendKeys(email);
        getPasswordInput().sendKeys(password);
        getConfimPasswordInput().sendKeys(confirmPassword);
        clickOnSingMeUpButton();
    }


}
