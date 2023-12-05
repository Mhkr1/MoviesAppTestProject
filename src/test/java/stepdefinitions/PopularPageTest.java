package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.HeaderSection;
import pages.HomePage;
import pages.LoginPage;
import pages.PopularPage;

import java.time.Duration;

public class PopularPageTest {

    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage;
    PopularPage popularPage;
    HeaderSection headerSection;
    String expectedUrl;
    String actualText;

    @Before
    public void setup(){
        System.setProperty("webdriver.edge.driver","C:\\Users\\mhkum\\Downloads\\edgedriver_win64\\msedgedriver.exe");
        driver=new EdgeDriver();
        loginPage=new LoginPage(driver);
        popularPage=new PopularPage(driver);
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

    @When("I click on the popular route option")
    public void iClickPopularRouteOption(){
        headerSection.popularLinkText().click();
    }

    @Then("the popular movies should be visible on popular page")
    public void popularMovieList(){
        if(popularPage.moviesOnPopularPage().size()>0) {
            System.out.println("Popular Page movies displayed");
        }else {
            System.out.println("Popular Page movies not displayed");
        }
    }
}
