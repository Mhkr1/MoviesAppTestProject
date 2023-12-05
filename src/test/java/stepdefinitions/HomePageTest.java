package stepdefinitions;



import io.cucumber.java.After;

import io.cucumber.java.Before;

import io.cucumber.java.en.And;

import io.cucumber.java.en.Given;

import io.cucumber.java.en.Then;

import io.cucumber.java.en.When;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.edge.EdgeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;

import pages.LoginPage;



import java.time.Duration;



public class HomePageTest {

    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage;
    HomePage homePage;
    String expectedUrl;
    String actualText;

    @Before
    public void setup(){
        System.setProperty("webdriver.edge.driver","C:\\Users\\mhkum\\Downloads\\edgedriver_win64\\msedgedriver.exe");
        driver=new EdgeDriver();
        loginPage=new LoginPage(driver);
        homePage=new HomePage(driver);
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


    @Given("I am on the home page")
    public void iAmOnHomePage(){
        System.out.println("I am on home page");
    }

    @When("I am on home page first heading should be 'Trending Now'")
    public void firstHead(){
        Assert.assertEquals(homePage.firstMovieHeading().getText(),"Trending Now","first head Mismatch");
    }

    @Then("the second heading should be 'Originals'")
    public void secondHead(){
        Assert.assertEquals(homePage.secondMovieHeading().getText(),"Originals","2nd Head Mismatch");
    }

    @Then("play button should be visible on the home page")
    public void playButtonVisible(){
        boolean isEnabled=homePage.playBtnEle().isDisplayed();
        Assert.assertTrue(isEnabled,"play button mismatch");
    }

    @Then("movies should be visible in their corresponding sections")
    public void movieListOfElements() {
        int numberOfMovies = homePage.movieListElement().size();
        if (numberOfMovies >= 1)
            System.out.println("movies visible");
        else
            System.out.println("movies not visible");
    }

    @Then("contact us Section should be visible")
    public void contactUsSection() {
        Assert.assertTrue(homePage.contactButtonEle().isDisplayed(), "contact us section not visible");
    }

}