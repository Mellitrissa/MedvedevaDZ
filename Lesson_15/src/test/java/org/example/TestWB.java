package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestWB {

    private WebDriver driver;
    HomePage homePage;
    BasketPage basketPage;
    List<String> homeItems;
    List<String> basketItems;
    List<String> priceHome;
    List<String> priceBasket;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.get("https://www.wildberries.ru");
    }

    @Test
    public void addProduct() {
        homePage = new HomePage(driver);
        homePage.addItemsOnBasket();
    }

    @Test
    public void rememberInfo() {
        homePage = new HomePage(driver);
        homePage.addListItem();
        homeItems = homePage.getItemsNames();
        homePage.addListPrice();
        priceHome = homePage.getPrice();
    }

    @Test(dependsOnMethods = {"addProduct"})
    public void goToBasket() {
        homePage = new HomePage(driver);
        homePage.clickOnGetBasket();

    }

    @Test(dependsOnMethods = {"addProduct", "goToBasket"})
    public void cheakNameProduct() {
        basketPage = new BasketPage(driver);
        basketPage.addListProduct();
        basketItems = basketPage.getBasketProductNames();
        for (int i = 0; i < homeItems.size(); i++) {
            Assert.assertTrue(homeItems.get(i).contains(basketItems.get(i)));
        }
    }

    @Test(dependsOnMethods = {"addProduct", "goToBasket"})
    public void cheakCountProduct() {
        basketPage = new BasketPage(driver);
        basketPage.addListNumber();
        List<WebElement> numb = basketPage.getNumberGoods();
        System.out.println(numb);
        for (WebElement s : numb) {
            Assert.assertEquals(s.getAttribute("value"), "1");
        }

    }

   @Test(dependsOnMethods = {"addProduct", "goToBasket","rememberInfo"})
    public void cheakPrice() throws InterruptedException {
        basketPage = new BasketPage(driver);
        basketPage.addListProductPrice();
        priceBasket = basketPage.getBasketProductPrice();
        for (int i = 0; i < priceHome.size(); i++) {
            Assert.assertTrue(priceHome.get(i).contains(priceBasket.get(i)));
        }
    }

    @Test(dependsOnMethods = {"addProduct", "goToBasket"})
    public void cheakSum() throws InterruptedException {
        basketPage = new BasketPage(driver);
        int sum = basketPage.getSum();
        int actualSum = basketPage.getActualSum();
        Assert.assertEquals(sum,actualSum);
    }

    @AfterClass
    public void quitDriver() {
        driver.quit();
   }
}

