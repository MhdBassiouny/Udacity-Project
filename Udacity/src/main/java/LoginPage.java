import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;

public class LoginPage {

WebDriver driver;

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="email")
    WebElement emailLogin;

    @FindBy(id="passwd")
    WebElement password;

    @FindBy(id="SubmitLogin")
    WebElement loginButton;

    @FindBy(id="email_create")
    WebElement createAccountEntry;

    @FindBy(id="SubmitCreate")
    WebElement createAccountButton;

    @FindBy(xpath = "//*[@id=\"login_form\"]/div/p[1]/a")
    WebElement resetPass;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/div/form/fieldset/p/button")
    WebElement resetPassButton;

    public void StartNewRegistration(String email){
        createAccountEntry.sendKeys(email);
        createAccountButton.click();
    }

    public void login(String email, String pass){
        emailLogin.sendKeys(email);
        password.sendKeys(pass);
        loginButton.click();
    }

    public void passReset(String email) throws InterruptedException {
        resetPass.click();
        Thread.sleep(2000);
        emailLogin.sendKeys(email);
        resetPassButton.click();
    }

}
