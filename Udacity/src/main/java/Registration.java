import io.cucumber.java.eo.Se;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Registration {

WebDriver driver;

    public Registration(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="id_gender1")
    WebElement genderMale;

    @FindBy(id="customer_firstname")
    WebElement firstName;

    @FindBy(id="customer_lastname")
    WebElement lastName;

    @FindBy(id="passwd")
    WebElement passwordRegistration;

    @FindBy(id="days")
    WebElement dayBirth;

    @FindBy(id="months")
    WebElement monthBirth;

    @FindBy(id="years")
    WebElement yearBirth;

    @FindBy(id="address1")
    WebElement address;

    @FindBy(id="city")
    WebElement city;

    @FindBy(id="id_state")
    WebElement selectState;

    @FindBy(id="postcode")
    WebElement postCode;

    @FindBy(id="phone_mobile")
    WebElement phoneNumber;

    @FindBy(id="submitAccount")
    WebElement createAccount;


    public void registerNewAccount(){
        genderMale.click();
        firstName.sendKeys("Test");
        lastName.sendKeys("test");
        passwordRegistration.sendKeys("Teat@123");
        Select day= new Select(dayBirth);
        day.selectByValue("2");
        Select month= new Select(monthBirth);
        month.selectByValue("2");
        Select year= new Select(yearBirth);
        year.selectByValue("2000");
        address.sendKeys("Test");
        city.sendKeys("Test");
        Select state= new Select(selectState);
        state.selectByValue("2");
        postCode.sendKeys("12345");
        phoneNumber.sendKeys("123456789");
        createAccount.click();
    }

}
