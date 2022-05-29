import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestCases {

    WebDriver driver;
    Registration register;
    LoginPage login;
    HomePage home;
    CheckOut checkout;


    @BeforeTest
    public void setWebDriver()
    {
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);

        driver=new ChromeDriver();
        driver.manage().window().maximize();
        register = new Registration(driver);
        login = new LoginPage(driver);
        home = new HomePage(driver);
        checkout = new CheckOut(driver);
    }

    @BeforeMethod
    public void goToHome(){
        driver.navigate().to("http://automationpractice.com/index.php");
    }

    @Test
    public void registerValidAccount() throws InterruptedException {
        Thread.sleep(2000);
        home.loginPage.click();
        Thread.sleep(2000);
        login.StartNewRegistration("Teating145545979@teating.com");
        Thread.sleep(4000);
        register.registerNewAccount();
        Thread.sleep(4000);

        String expectedResult = "Welcome to your account.";
        String actualResult = driver.findElement(By.id("center_column")).getText();
        Assert.assertTrue(actualResult.contains(expectedResult));

        home.logout.click();
    }


    @Test
    public void loginValid(){
        home.loginPage.click();
        login.login("mhdbassiouny@gmail.com", "Test@123");

        String expectedResult = "Welcome to your account.";
        String actualResult = driver.findElement(By.id("center_column")).getText();
        Assert.assertTrue(actualResult.contains(expectedResult));

        home.logout.click();
    }

    @Test
    public void resetPassword() throws InterruptedException {
        home.loginPage.click();
        Thread.sleep(2000);
        login.passReset("mhdbassiouny@gmail.com");

        String expectedResult = "email has been sent";
        String actualResult = driver.findElement(By.id("center_column")).getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Test
    public void search() throws InterruptedException {
        home.loginPage.click();
        Thread.sleep(1000);
        login.login("mhdbassiouny@gmail.com", "Test@123");

        home.searchBox.sendKeys("printed dress");
        home.searchBox.sendKeys(Keys.ENTER);

        home.searchArea.click();

        home.logout.click();
    }

    @Test
    public void currencyChange(){
        // Currency change not available on the test website
    }

    @Test
    public void categoryChange(){
        home.loginPage.click();
        login.login("mhdbassiouny@gmail.com", "Test@123");

        home.category1.click();

        SoftAssert soft = new SoftAssert();

        String expectedCat1 = "WOMEN";
        String actualCat1 = driver.findElement(By.className("cat-name")).getText();
        soft.assertTrue(actualCat1.contains(expectedCat1));


        home.category2.click();

        Actions hover = new Actions(driver);
        hover.moveToElement(home.category2).perform();
        home.subCat.click();

        String expectedCat2 = "CASUAL DRESSES";
        String actualCat2 = driver.findElement(By.className("cat-name")).getText();
        soft.assertTrue(actualCat2.contains(expectedCat2));

        soft.assertAll();
        home.logout.click();
    }

    @Test
    public void filterByColor() throws InterruptedException {
        home.loginPage.click();
        login.login("mhdbassiouny@gmail.com", "Test@123");
        home.category1.click();
        Thread.sleep(3000);
        home.firstColor.click();

        home.logout.click();
    }

    @Test
    public void addProduct() throws InterruptedException {
        home.loginPage.click();
        login.login("mhdbassiouny@gmail.com", "Test@123");
        home.category1.click();

        Actions hover = new Actions(driver);
        hover.moveToElement(home.product1).perform();
        home.productAdd1.click();
        Thread.sleep(2000);
        home.close.click();
        Thread.sleep(1000);

        hover.moveToElement(home.product2).perform();
        home.productAdd2.click();
        Thread.sleep(3000);
        home.checkOut.click();
        Thread.sleep(8000);

        String expectedResult = "$";
        String actualResult = checkout.orderTotal.getText();
        Assert.assertTrue(actualResult.contains(expectedResult));

        home.logout.click();
    }

    @Test
    public void wishList() throws InterruptedException {
        home.loginPage.click();
        login.login("mhdbassiouny@gmail.com", "Test@123");
        home.category1.click();

        Actions hover = new Actions(driver);
        hover.moveToElement(home.product1).perform();
        home.moreButton1.click();
        Thread.sleep(3400);
        home.wishlist.click();
        Thread.sleep(8000);

        String expectedResult = "Added to your wishlist.";
        String actualResult = driver.findElement(By.className("fancybox-error")).getText();
        Assert.assertTrue(actualResult.contains(expectedResult));

        home.closeWishList.click();

        home.logout.click();
    }

    @Test
    public void completeOrder() throws InterruptedException {
        home.loginPage.click();
        login.login("mhdbassiouny@gmail.com", "Test@123");
        home.category1.click();

        Actions hover = new Actions(driver);
        hover.moveToElement(home.product1).perform();
        home.productAdd1.click();
        Thread.sleep(2000);
        home.close.click();
        Thread.sleep(1000);

        hover.moveToElement(home.product2).perform();
        home.productAdd2.click();
        Thread.sleep(8000);
        home.checkOut.click();
        Thread.sleep(4000);

        checkout.completeCheckout();

        String expectedResult = "Your order on My Store is complete.";
        String actualResult = driver.findElement(By.className("cheque-indent")).getText();
        Assert.assertTrue(actualResult.contains(expectedResult));

        home.logout.click();
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }

}
