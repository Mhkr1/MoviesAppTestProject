package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HeaderSection;
import pages.LoginPage;
import pages.PopularPage;
import pages.SearchPage;

import java.time.Duration;

public class SearchPageTest {

    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage;
    HeaderSection headerSection;
    SearchPage searchPage;
    int movieCount=0;

    @Before
    public void setup(){
        System.setProperty("webdriver.edge.driver","C:\\Users\\mhkum\\Downloads\\edgedriver_win64\\msedgedriver.exe");
        driver=new EdgeDriver();
        loginPage=new LoginPage(driver);
        searchPage=new SearchPage(driver);
        headerSection=new HeaderSection(driver);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://qamoviesapp.ccbp.tech/login");
        loginPage.loginToApplication("rahul","rahul@2021");
        String expectedUrl="https://qamoviesapp.ccbp.tech/";
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
    }

    @After
    public void closeUp(){
        driver.quit();
    }

    @When("I search for multiple movies on the movie page")
    public void searchWithMultipleMovies(){

        String[] movieNames = {"Titanic", "The Suicide Squad", "The Pursuit of Happyness", "Shang-Chi and the Legend of the Ten Rings", "No Time to Die"};

        headerSection.searchIconVisibility().click();

        for (String movie : movieNames) {

            searchPage.enterMovieName().sendKeys(movie);

            searchPage.clickSearchButton().click();

            movieCount += searchPage.moviesListDisplayed().size();

            searchPage.enterMovieName().clear();

            System.out.println("For Loop");
        }

    }

    @Then("the movies count should be visible")
    public void moviesCountVisible(){
        System.out.println(movieCount);
    }
}
