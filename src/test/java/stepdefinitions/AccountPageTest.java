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
import pages.AccountPage;
import pages.HeaderSection;
import pages.LoginPage;

import java.time.Duration;

public class AccountPageTest {

    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage;

    HeaderSection headerSection;
    AccountPage accountPage;
    String expectedUrl;
    String actualText;

    @Before
    public void setup(){
        System.setProperty("webdriver.edge.driver","C:\\Users\\mhkum\\Downloads\\edgedriver_win64\\msedgedriver.exe");
        driver=new EdgeDriver();
        loginPage=new LoginPage(driver);
        headerSection=new HeaderSection(driver);
        accountPage=new AccountPage(driver);

        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://qamoviesapp.ccbp.tech/login");
        loginPage.loginToApplication("rahul","rahul@2021");
        String expectedUrl="https://qamoviesapp.ccbp.tech/";
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        headerSection.getProfileButton().click();
    }

    @After
    public void closeUp(){
        driver.quit();
    }

    @Given("I am on the account page")
    public void iAmOnAccountPage(){
        System.out.println("I am on profile section");
    }

    @When("all profile page opened perfectly")
    public void profileSectionOpenedPerfectly(){
        expectedUrl="https://qamoviesapp.ccbp.tech/account";
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
    }

    @Then("all ui elements should be visible on profile page")
    public void allUIElementsVisibled(){

        Assert.assertEquals(accountPage.accountHeadEl().getText(),"Account","head mismatch");

        Assert.assertTrue(accountPage.accountLogoutButtonEl().isDisplayed(),"logout button not visible");

        Assert.assertEquals(accountPage.accountUserNameEl().getText(),"User name : rahul","user name not visible");

        Assert.assertEquals(accountPage.accountPasswordEl().getText(),"Password : **********","password mismatch");

        Assert.assertEquals(accountPage.accountPlanQuality().getText(),"Ultra HD","plan quality mismatch");

        Assert.assertEquals(accountPage.accountPlanType().getText(),"Premium","plan type mismatch");
    }

    @When("I click on logout button")
    public void clickOnLogoutButton(){
        accountPage.accountLogoutButtonEl().click();
    }

    @Then("I should be redirected to the login page")
    public void navigateToLoginPage(){
        expectedUrl="https://qamoviesapp.ccbp.tech/login";
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        Assert.assertEquals(driver.getCurrentUrl(),"https://qamoviesapp.ccbp.tech/login","URL Mismatch");
    }
}
