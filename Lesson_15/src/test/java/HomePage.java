
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;


public class HomePage {
    WebDriver driver;


    @FindBy(xpath = "//*[@id='app']/div[2]/div/div[2]/div/article[1]/div/div[2]/h2/span[2]")
    WebElement itemName;
    @FindBy(xpath = "//*[@id='app']/div[2]/div/div[2]/div/article[2]/div/div[2]/h2/span[2]")
    WebElement itemName1;
    @FindBy(xpath = "//ins[contains(@class, 'price__lower-price wallet-price') and contains(text(), '₽')]")
    WebElement itemPrice;
    @FindBy(xpath = "//*[@id='app']/div[2]/div/div[2]/div/article[2]/div/div[2]/p/span/ins")
    WebElement itemPrice1;
    @FindBy(xpath = "//*[@id='basketContent']/div[3]")
    WebElement getBasket;
    @FindBy(xpath = "//*[@id='app']/div[2]/div/div[2]/div/article[1]/div/div[3]/p[3]")
    WebElement BasketButton1;
    @FindBy(xpath = "//*[@id='app']/div[2]/div/div[2]/div/article[2]/div/div[3]/p[3]/a")
    WebElement BasketButton2;
    private final List<String> ItemsNames;
    private final List<String> Price;

    public HomePage(WebDriver driver){
        this.driver = driver;
        ItemsNames = new ArrayList<>();
        Price = new ArrayList<>();
        PageFactory.initElements(driver, this);
    }

    public List<String> getItemsNames() {
        return ItemsNames;
    }
    public List<String> getPrice() {
        return Price;
    }
    public void addListItem() {
        ItemsNames.add(itemName.getText());
        ItemsNames.add(itemName1.getText());
    }

    public void addItemsOnBasket(){
        BasketButton1.click();
        BasketButton2.click();
    }
    public void addListPrice(){
        Price.add(itemPrice.getText());
        Price.add(itemPrice1.getText());
    }
    public void clickOnGetBasket(){
        getBasket.click();

    }

}
