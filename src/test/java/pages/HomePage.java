package pages;



import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;



import java.time.Duration;

import java.util.List;



public class HomePage {



    @FindBy(how= How.XPATH, using = "//h1[text()='Trending Now']")
    WebElement firstHeadingElement;

    @FindBy(how= How.XPATH, using = "//h1[text()='Originals']")
    WebElement secondHeadingElement;

    @FindBy(className = "home-movie-play-button")
    WebElement playButtonElement;

    @FindBy(className = "poster")
    List<WebElement> moviesList;

    @FindBy(className = "contact-us-paragraph")
    WebElement contactElement;

    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement firstMovieHeading() {
        waitForVisibility(firstHeadingElement);
        return firstHeadingElement;
    }

    public WebElement secondMovieHeading() {
        waitForVisibility(secondHeadingElement);
        return secondHeadingElement;
    }

    public WebElement playBtnEle() {
        waitForVisibility(playButtonElement);
        return playButtonElement;
    }

    public List<WebElement> movieListElement() {
        return moviesList;
    }

    public WebElement contactButtonEle() {
        waitForVisibility(contactElement);
        return contactElement;
    }

    private void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}