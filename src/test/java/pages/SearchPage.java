package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchPage {

    @FindBy(id = "search")
    WebElement searchInputField;

    @FindBy(className = "search-button")
    WebElement searchButton;

    @FindBy(className = "movie-icon-item")
    List<WebElement> moviesDisplayed;


    WebDriver driver;
    WebDriverWait wait;

    public SearchPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement enterMovieName(){
        return searchInputField;
    }

    public WebElement clickSearchButton(){
        return searchButton;
    }

    public List<WebElement> moviesListDisplayed(){
        return moviesDisplayed;
    }

}
