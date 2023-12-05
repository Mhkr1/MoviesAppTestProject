package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HeaderSection {

    @FindBy(className = "website-logo")
    WebElement websiteHomeLogo;

    @FindBy(linkText = "Home")
    WebElement homeLink;

    @FindBy(linkText = "Popular")
    WebElement popularLink;

    @FindBy(className = "search-empty-button")
    WebElement searchEmptyButton;

    @FindBy(className = "avatar-button")
    WebElement profileButton;

    WebDriver driver;
    WebDriverWait wait;

    public HeaderSection(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement websiteLogoVisible(){
        waitForVisibility(websiteHomeLogo);
        return websiteHomeLogo;
    }

    public WebElement homeLinkkText(){
        waitForVisibility(homeLink);
        return homeLink;
    }

    public WebElement popularLinkText(){
        waitForVisibility(popularLink);
        return popularLink;
    }

    public WebElement searchIconVisibility(){
        waitForVisibility(searchEmptyButton);
        return searchEmptyButton;
    }

    public WebElement getProfileButton(){
        waitForVisibility(profileButton);
        return profileButton;
    }

    private void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
