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

import java.time.Duration;

public class HeaderSectionTest {

    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage;

    HeaderSection headerSection;
    String expectedUrl;
    String actualText;

    @Before
    public void setup(){
        System.setProperty("webdriver.edge.driver","C:\\Users\\mhkum\\Downloads\\edgedriver_win64\\msedgedriver.exe");
        driver=new EdgeDriver();
        loginPage=new LoginPage(driver);
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

    @Then("the website logo should be visible")
    public void websiteLogoVisibility(){
        Assert.assertTrue(headerSection.websiteLogoVisible().isDisplayed(),"website logo Mismatch");
    }

    @Then("the home route should be visible")
    public void homeRoute(){
        Assert.assertEquals(headerSection.homeLinkkText().getText(),"Home","home route Mismatch");
    }

    @Then("the popular route should be visible")
    public void popularRoute(){
        Assert.assertEquals(headerSection.popularLinkText().getText(),"Popular","popular route mismatch");
    }

    @Then("the search icon should be visible")
    public void searchLogo(){
        Assert.assertTrue(headerSection.searchIconVisibility().isDisplayed(),"search icon mismatch");
    }

    @Then("the profile image should be visible")
    public void profileRoute(){
        Assert.assertTrue(headerSection.getProfileButton().isDisplayed(),"profile mismatch");
    }

    @When("I click popular route option on header section")
    public void clickPopularRoute(){
        headerSection.popularLinkText().click();
    }

    @When("I click profile route option on header section")
    public void clickProfileRoute(){
        headerSection.getProfileButton().click();
    }

    @Then("I should be redirected to the profile route section")
    public void navigateToProfileRoute(){
        actualText=driver.getCurrentUrl();
        Assert.assertEquals(actualText,"https://qamoviesapp.ccbp.tech/account","profile Url mismatch");
    }

    @Then("I should be redirected to the popular route section")
    public void navigateToPopularSection(){
        actualText=driver.getCurrentUrl();
        Assert.assertEquals(actualText,"https://qamoviesapp.ccbp.tech/popular","popular Url mismatch");
    }

}
