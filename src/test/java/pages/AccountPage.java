package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountPage {

    @FindBy(className = "account-heading")
    WebElement accountHead;

    @FindBy(className = "membership-username")
    WebElement accountUserName;

    @FindBy(className = "membership-password")
    WebElement accountPassword;

    @FindBy(className = "plan-paragraph")
    WebElement planType;

    @FindBy(className = "plan-details")
    WebElement planQuality;

    @FindBy(className = "logout-button")
    WebElement logoutBtn;

    WebDriver driver;
    WebDriverWait wait;

    public AccountPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement accountHeadEl(){
        waitForVisibility(accountHead);
        return accountHead;
    }

    public WebElement accountUserNameEl(){
        waitForVisibility(accountUserName);
        return accountUserName;
    }

    public WebElement accountPasswordEl(){
        waitForVisibility(accountPassword);
        return accountPassword;
    }

    public WebElement accountPlanType(){
        waitForVisibility(planType);
        return planType;
    }

    public WebElement accountPlanQuality(){
        waitForVisibility(planQuality);
        return planQuality;
    }

    public WebElement accountLogoutButtonEl(){
        waitForVisibility(logoutBtn);
        return logoutBtn;
    }

    private void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
