package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class BasketPage {
    WebDriver driver;
    @FindBy(xpath = "//*[@id='app']/div[4]/div/div[1]/form/div[1]/div[1]/div[2]/div/div/div/div/div/div/div[1]/div/a/span[1]")
    WebElement NameProductBasket2;
    @FindBy(xpath = "//*[@id='app']/div[4]/div/div[1]/form/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[1]/div/a/span[1]")
    WebElement NameProductBasket1;
    WebElement ProductPriceBasket;//второй товар в корзине с wb кошелек
    WebElement ProductPriceBasket1;//первый товар в корзине с wb кошелек
    @FindBy(xpath = "//*[@id='app']/div[4]/div/div[1]/form/div[1]/div[1]/div[2]/div/div/div/div/div/div/div[2]/div/div/input")
    WebElement number1;
    @FindBy(xpath = "//*[@id='app']/div[4]/div/div[1]/form/div[1]/div[1]/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div/div/input")
    WebElement number2;
    @FindBy(xpath = "//*[@id='app']/div[4]/div/div[1]/form/div[2]/div/div/div/div[2]/p/span[2]/span")
    WebElement sum;

    private final List<WebElement> numberGoods;
    private final List<String> BasketProductNames;
    private final List<String> BasketPrice;

    public BasketPage(WebDriver driver) {
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

    public List<WebElement> getNumberGoods() {
        return numberGoods;
    }

    public void addListNumber() {
        numberGoods.add(number1);
        numberGoods.add(number2);
    }

    public void addListProduct()  {
        BasketProductNames.add(NameProductBasket1.getText());
        BasketProductNames.add(NameProductBasket2.getText());
    }

    public void addListProductPrice() throws InterruptedException {
        Thread.sleep(3000);
        WebElement prod1 = driver.findElement(By.xpath("//*[@id='app']/div[4]/div/div[1]/form/div[1]/div[1]/div[2]/div/div[2]/div/div/div[1]"));
        ProductPriceBasket = prod1.findElement(By.className("list-item__price-wallet"));
        WebElement prod2 = driver.findElement(By.xpath("//*[@id='app']/div[4]/div/div[1]/form/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]"));
        ProductPriceBasket1 = prod2.findElement(By.className("list-item__price-wallet"));
        BasketPrice.add(ProductPriceBasket1.getText());
        BasketPrice.add(ProductPriceBasket.getText());
    }

    public int getSum() throws InterruptedException {
        Thread.sleep(3000);
        return Integer.parseInt (sum.getText().replaceAll("₽", "").replaceAll(" ", ""));
    }
    public int getActualSum() throws InterruptedException {
        Thread.sleep(3000);
        WebElement pr1 = driver.findElement(By.xpath("//*[@id='app']/div[4]/div/div[1]/form/div[1]/div[1]/div[2]/div/div[2]/div/div/div[1]"));
        WebElement ProductPriceSum = pr1.findElement(By.cssSelector("div.list-item__price-new.wallet"));
        WebElement pr2 = driver.findElement(By.xpath("//*[@id='app']/div[4]/div/div[1]/form/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]"));
        WebElement ProductPriceSum1 = pr2.findElement(By.cssSelector("div.list-item__price-new.wallet"));
        int i = Integer.parseInt (ProductPriceSum.getText().replaceAll("₽", "").replaceAll(" ", ""));
        int a = Integer.parseInt (ProductPriceSum1.getText().replaceAll("₽", "").replaceAll(" ", ""));
        return  i+a;
    }
}
