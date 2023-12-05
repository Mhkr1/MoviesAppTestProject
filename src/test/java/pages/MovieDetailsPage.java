package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MovieDetailsPage {

    @FindBy(className = "movie-title")
    WebElement moviesTitle;

    @FindBy(className = "watch-time")
    WebElement watchTime;

    @FindBy(className = "sensor-rating")
    WebElement sensorRating;

    @FindBy(className = "release-year")
    WebElement releaseYear;

    @FindBy(className = "movie-overview")
    WebElement movieOverview;

    @FindBy(xpath = "//div[@class='similar-movies-container']/child::ul//li")
    List<WebElement> moreLikeMovies;

    @FindBy(xpath = "//div[@class='genres-category']/child::div//p")
    List<WebElement> genreList;

    @FindBy(xpath = "//h1[@class='audio-heading']/following::li[@class='audio-list-item']")
    List<WebElement> audioHeadingList;

    @FindBy(css = "h1.rating-heading + p.category-paragraph")
    WebElement ratingCount;

    @FindBy(css = "h1.rating-average-heading + p.category-paragraph")
    WebElement ratingAvg;

    @FindBy(css = "h1.budget-heading + p.category-paragraph")
    WebElement budgetEl;

    @FindBy(css = "h1.release-date-heading + p.category-paragraph")
    WebElement releaseDate;

    @FindBy(css = "button.play-button")
    WebElement playBtn;


    WebDriver driver;
    WebDriverWait wait;


    public MovieDetailsPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement movieTitleEl(){
        waitForVisibility(moviesTitle);
        return moviesTitle;
    }

    public WebElement movieWatchTimeEl(){
        waitForVisibility(watchTime);
        return watchTime;
    }

    public WebElement sensroRatingEl(){
        waitForVisibility(sensorRating);
        return sensorRating;
    }

    public WebElement movieReleaseYearEl(){
        waitForVisibility(releaseYear);
        return releaseYear;
    }

    public WebElement movieOverviewEl(){
        waitForVisibility(movieOverview);
        return movieOverview;
    }


    public List<WebElement> moreLikeMovieSection(){
        return moreLikeMovies;
    }

    public List<WebElement> genreListEl(){
        return genreList;
    }

    public List<WebElement> audioEl(){
        return audioHeadingList;
    }

    public WebElement getRatingCount(){
        waitForVisibility(ratingCount);
        return ratingCount;
    }

    public WebElement getRatingAvg(){
        waitForVisibility(ratingAvg);
        return ratingAvg;
    }

    public WebElement getBudgetEl() {
        waitForVisibility(budgetEl);
        return budgetEl;
    }

    public WebElement getReleaseDate(){
        waitForVisibility(releaseDate);
        return releaseDate;
    }

    public WebElement getplayButton(){
        waitForVisibility(playBtn);
        return playBtn;
    }

    private void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
