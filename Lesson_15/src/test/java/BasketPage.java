import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class BasketPage {
    WebDriver driver;
    @FindBy(xpath =  "//*[@id='app']/div[4]/div/div[1]/form/div[1]/div[1]/div[2]/div/div/div/div/div/div/div[1]/div/a/span[1]")
    WebElement NameProductBasket2;
    @FindBy(xpath = "//*[@id='app']/div[4]/div/div[1]/form/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[1]/div/a/span[1]")
    WebElement NameProductBasket1;
    @FindBy(xpath = "//*[@id='app']/div[4]/div/div[1]/form/div[1]/div[1]/div[2]/div/div/div/div/div/div/div[3]/div[2]")
    WebElement ProductPriceBasket;
    @FindBy(xpath = "//*[@id='app']/div[4]/div/div[1]/form/div[1]/div[1]/div[2]/div/div[2]/div/div/div[1]/div/div[3]/div[2]")
    WebElement ProductPriceBasket1;
    @FindBy(xpath = "//*[@id='app']/div[4]/div/div[1]/form/div[1]/div[1]/div[2]/div/div/div/div/div/div/div[2]/div/div/input")
    WebElement number1;
    @FindBy(xpath = "//*[@id='app']/div[4]/div/div[1]/form/div[1]/div[1]/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div/div/input")
    WebElement number2;
    @FindBy(xpath = "//*[@id='app']/div[4]/div/div[1]/form/div[2]/div/div/div/div[2]/p/span[2]/span")
    WebElement sum;

    private final List<WebElement> numberGoods;
    private final List<String> BasketProductNames;
    private final List<String> BasketPrice;

    public BasketPage(WebDriver driver){
        this.driver = driver;
        BasketProductNames = new ArrayList<>();
        BasketPrice = new ArrayList<>();
        numberGoods = new ArrayList<WebElement>();
        PageFactory.initElements(driver, this);
    }
    public List<String> getBasketProductNames() {
        return BasketProductNames;
    }
    public List<String> getBasketProductPrice() {
        return BasketPrice;
    }
    public List<WebElement> getNumberGoods(){
        return numberGoods;
    }
    public void addListNumber(){
        numberGoods.add(number1);
        numberGoods.add(number2);
    }
    public void addListProduct() {
        BasketProductNames.add(NameProductBasket1.getText());
        BasketProductNames.add(NameProductBasket2.getText());
    }
    public void addListProductPrice() {
        BasketPrice.add(ProductPriceBasket.getText());
        BasketPrice.add(ProductPriceBasket1.getText());
    }
    public String getSum(){
        return sum.getText();
    }
}
