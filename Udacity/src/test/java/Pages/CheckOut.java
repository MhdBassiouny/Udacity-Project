package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOut {

    WebDriver driver;

    public CheckOut(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="total_price")
    WebElement orderTotal;

    @FindBy(xpath = "//*[@id=\"center_column\"]/p[2]/a[1]")
    WebElement proceedCheckout;

    @FindBy(xpath = "//*[@id=\"center_column\"]/form/p/button")
    WebElement proceedCheckout2;


    @FindBy(id="cgv")
    WebElement terms;

    @FindBy(xpath = "//*[@id=\"form\"]/p/button")
    WebElement proceedCheckout3;

    @FindBy(xpath = "//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a")
    WebElement payBank;

    @FindBy(xpath = "//*[@id=\"cart_navigation\"]/button")
    WebElement completeOrder;

    public void completeCheckout() throws InterruptedException {
        proceedCheckout.click();
        Thread.sleep(2000);

        proceedCheckout2.click();
        Thread.sleep(2000);

        terms.click();
        proceedCheckout3.click();
        Thread.sleep(2000);

        payBank.click();
        Thread.sleep(2000);

        completeOrder.click();
        Thread.sleep(2000);
    }

}
