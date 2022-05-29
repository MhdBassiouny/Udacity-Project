import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "login")
    WebElement loginPage;

    @FindBy(className = "logout")
    WebElement logout;

    @FindBy(id="search_query_top")
    WebElement searchBox;

    @FindBy(className = "product_list")
    WebElement searchArea;

    @FindBy(xpath="/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[1]/a")
    WebElement category1;

    @FindBy(xpath="/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[2]/a")
    WebElement category2;

    @FindBy(xpath = "/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[2]/ul/li[1]/a")
    WebElement subCat;

    @FindBy(id="layered_id_attribute_group_7")
    WebElement firstColor;

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img")
    WebElement product1;

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[2]/a[1]")
    WebElement productAdd1;

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[2]/div/div[1]/div/a[1]/img")
    WebElement product2;

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[2]/div/div[2]/div[2]/a[1]")
    WebElement productAdd2;

    @FindBy(className = "cross")
    WebElement close;

    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")
    WebElement checkOut;

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[2]/a[2]")
    WebElement moreButton1;

    @FindBy(id="wishlist_button")
    WebElement wishlist;

    @FindBy(className = "fancybox-item")
    WebElement closeWishList;
}
