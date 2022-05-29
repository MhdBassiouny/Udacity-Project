package StepDefinition;

import Pages.CheckOut;
import Pages.HomePage;
import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class CompleteOrder {
    WebDriver driver;
    LoginPage login;
    HomePage home;
    CheckOut checkout;

    @Given("user navigate to homepage")
    public void openBrowser(){
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);

        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://automationpractice.com/index.php");
        login = new LoginPage(driver);
        home = new HomePage(driver);
        checkout = new CheckOut(driver);
    }

    @And("User Login")
    public void login(){
        home.loginPage.click();
        login.login("mhdbassiouny@gmail.com", "Test@123");
    }

    @Then("User add products")
    public void addProducts() throws InterruptedException {
        home.category1.click();

        Actions hover = new Actions(driver);
        hover.moveToElement(home.product1).perform();
        home.productAdd1.click();
        Thread.sleep(8000);
        home.close.click();
        Thread.sleep(2000);

        hover.moveToElement(home.product2).perform();
        home.productAdd2.click();
        Thread.sleep(8000);
        home.checkOut.click();
        Thread.sleep(5000);
    }

    @And("User complete Order")
    public void completeOrder() throws InterruptedException {
        checkout.completeCheckout();

        String expectedResult = "Your order on My Store is complete.";
        String actualResult = driver.findElement(By.className("cheque-indent")).getText();
        Assert.assertTrue(actualResult.contains(expectedResult));

        home.logout.click();
    }
}
