package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LoginPage {

    @FindBy(className = "login-website-logo")
    WebElement websiteLogo;

    @FindBy(className = "sign-in-heading")
    WebElement websiteHead;

    @FindBy(className = "input-label")
    List<WebElement> labelElements;

    @FindBy(className = "login-button")
    WebElement loginButtonEl;


    @FindBy(id="usernameInput")
    WebElement userInputField;

    @FindBy(id="passwordInput")
    WebElement passwordInputField;

    @FindBy(className = "error-message")
    WebElement errorMsgElement;

    @FindBy(linkText = "Popular")
    WebElement popularText;

    WebDriver driver;
    WebDriverWait wait;


    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement linkPopular() {
        wait.until(ExpectedConditions.visibilityOf(popularText));
        return popularText;
    }

    public String getLabelTextAtIndex(int index){
        return labelElements.get(index).getText();
    }

    public WebElement getWebsiteLogo(){
        return websiteLogo;
    }

    public String getWebsiteHead(){
        return websiteHead.getText();
    }

    public WebElement loginButtonElement(){
        return loginButtonEl;
    }

    public void enterUserField(String username){
        userInputField.sendKeys(username);
    }

    public void enterPasswordField(String password){
        passwordInputField.sendKeys(password);
    }

    public void clickLoginButton(){
        loginButtonEl.click();
    }

    public void loginToApplication(String username,String password){
        enterUserField(username);
        enterPasswordField(password);
        clickLoginButton();
    }

    public String getErrorMessage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message")));
        return errorMsgElement.getText();
    }
}
