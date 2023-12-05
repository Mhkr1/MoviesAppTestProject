package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.*;

import java.time.Duration;

public class MoviesDetailsPageTest {

    WebDriver driver;
    LoginPage loginPage;
    MovieDetailsPage movieDetailsPage;
    HeaderSection headerSection;
    PopularPage popularPage;
    WebDriverWait wait;



    @Before
    public void setup(){
        System.setProperty("webdriver.edge.driver","C:\\Users\\mhkum\\Downloads\\edgedriver_win64\\msedgedriver.exe");
        driver=new EdgeDriver();
        loginPage=new LoginPage(driver);
        movieDetailsPage=new MovieDetailsPage(driver);
        headerSection=new HeaderSection(driver);
        popularPage=new PopularPage(driver);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://qamoviesapp.ccbp.tech/login");
        loginPage.loginToApplication("rahul","rahul@2021");
        String expectedUrl="https://qamoviesapp.ccbp.tech/";
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        headerSection.popularLinkText().click();
    }

    @After
    public void closeUp(){
        driver.quit();
    }

    @Given("I am on the popular page")
    public void iAmOnPopularPage(){
        System.out.println("I am On Popular Page");
    }

    @When("I click on one movie on popular page")
    public void clickOnOneMovieInPopularSection(){
        popularPage.moviesOnPopularPage().get(0).click();
    }

    @And("the movie title should be visible")
    public void allMovieAudio() {
        Assert.assertTrue(movieDetailsPage.movieTitleEl().isDisplayed(),"Title not visible");
    }

    @And("the movie watch time should be visible")
    public void movieWatchTimeElement(){
        Assert.assertTrue(movieDetailsPage.movieWatchTimeEl().isDisplayed(),"watch movie not visible");
    }

    @And("the movie sensor rating should be visible")
    public void sensorRating(){
        Assert.assertTrue(movieDetailsPage.sensroRatingEl().isDisplayed(),"sensor rating Not viible");
    }

    @And("the movie release year should be visble")
    public void releaseYear(){
        Assert.assertTrue(movieDetailsPage.movieReleaseYearEl().isDisplayed(),"release year not visible");
    }

    @And("the movie overview should be visible")
    public void overView(){
        Assert.assertTrue(movieDetailsPage.movieOverviewEl().isDisplayed(),"overview not visible");
    }

    @And("the movie play button should be visible")
    public void playButton(){
        Assert.assertTrue(movieDetailsPage.getplayButton().isDisplayed(),"play button not visible");
    }

    @And("the movie genres should be visible")
    public void genreVisibility(){
        Assert.assertTrue(movieDetailsPage.genreListEl().get(0).isDisplayed(),"genres not visible");
    }

    @And("the movie available audios should be visible")
    public void movieAudio(){
        Assert.assertTrue(movieDetailsPage.audioEl().get(0).isDisplayed(), "audio not visible");
    }

    @And("the movie rating count should be visible")
    public void ratingCount(){
        Assert.assertTrue(movieDetailsPage.getRatingCount().isDisplayed(),"rating count not visible");
    }

    @And("the movie average rating should be visible")
    public void movieAvgRating(){
        Assert.assertTrue(movieDetailsPage.getRatingAvg().isDisplayed(),"rating not visible");
    }

    @And("the movie budget should be visible")
    public void movieBudgetVisibility(){
        Assert.assertTrue(movieDetailsPage.getBudgetEl().isDisplayed(),"bugdet not visible");
    }

    @And("the movie release date should be visible")
    public void movieReleaseDate(){
        Assert.assertTrue(movieDetailsPage.getReleaseDate().isDisplayed(),"release date not visible");
    }

    @And("the more like movies section should be visible")
    public void moeLikeMovieSectionVisibility(){
        Assert.assertTrue(movieDetailsPage.moreLikeMovieSection().get(0).isDisplayed(),"more like section not visible");
    }




















}
