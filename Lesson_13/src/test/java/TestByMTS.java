import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class TestByMTS {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void getPage(){
        System.setProperty("webdriver.chrome.driver", "/Users/uliamedvedeva/Desktop/GitHub/MedvedevaDZ/Lesson_13/src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
        driver.get("https://www.mts.by");
        driver.findElement(By.xpath("//*[@id=\"cookie-agree\"]")).click();
    }
    @Test
    public void testTitle(){
        WebElement title = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/h2"));
        Assert.assertTrue(title.getText().contains("Онлайн пополнение\n" + "без комиссии"));
    }
    @Test
    public void testLogo(){
        WebElement logo = driver.findElement(By.xpath("//div[@class='pay__partners']"));
        Assert.assertTrue(logo.isDisplayed());
    }
    @Test
    public void testLink(){
        WebElement moreInfoLink = driver.findElement(By.linkText("Подробнее о сервисе"));
        moreInfoLink.click();
        Assert.assertEquals(driver.getTitle(), "Порядок оплаты и безопасность интернет платежей");
        driver.navigate().back();
    }
    @Test (dependsOnMethods = {"testTitle","testLogo","testLink"})
    public void testPayForm(){
        WebElement serviceInput = driver.findElement(By.id("pay"));
        serviceInput.findElement(By.xpath("//select[@id='pay']/option[text()='Услуги связи']")).click();
         WebElement phone = driver.findElement(By.id("connection-phone"));
         phone.click();
         phone.sendKeys("297777777");
         WebElement sum = driver.findElement(By.id("connection-sum"));
         sum.click();
         sum.sendKeys("100");
         WebElement email = driver.findElement(By.id("connection-email"));
         email.click();
         email.sendKeys("juliet810@mail.ru");
        WebElement continueButton = driver.findElement(By.xpath("//button[contains(text(), 'Продолжить')]"));
        continueButton.click();
        driver.navigate().back();
    }
    @AfterClass
    public void quitDriver() {
        driver.quit();
    }




}
