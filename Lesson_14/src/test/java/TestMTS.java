import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TestMTS {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void getPage(){
        System.setProperty("webdriver.chrome.driver", "/Users/uliamedvedeva/Desktop/GitHub/MedvedevaDZ/Lesson_14/src/main/resources/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.get("https://www.mts.by");
        driver.findElement(By.xpath("//*[@id=\"cookie-agree\"]")).click();
    }
    @Test
    public void checkConnection(){
        WebElement serviceInput = driver.findElement(By.id("pay"));
        WebElement connection = serviceInput.findElement(By.xpath("//select[@id='pay']/option[text()='Услуги связи']"));
        connection.click();

        WebElement numberInput = driver.findElement(By.id("connection-phone"));
        String numberLabel = numberInput.getAttribute("placeholder");
        Assert.assertEquals(numberLabel,"Номер телефона");

        WebElement sumInput = driver.findElement(By.id("connection-sum"));
        String sumLabel = sumInput.getAttribute("placeholder");
        Assert.assertEquals(sumLabel,"Сумма");

        WebElement emailInput = driver.findElement(By.id("connection-email"));
        String emailLabel = emailInput.getAttribute("placeholder");
        Assert.assertEquals(emailLabel,"E-mail для отправки чека");
    }
    @Test
    public void checkInternet(){
        WebElement serviceInput = driver.findElement(By.id("pay"));
        WebElement connection = serviceInput.findElement(By.xpath("//select[@id='pay']/option[text()='Домашний интернет']"));
        connection.click();

        WebElement numberInput = driver.findElement(By.id("internet-phone"));
        String numberLabel = numberInput.getAttribute("placeholder");
        Assert.assertEquals(numberLabel,"Номер абонента");

        WebElement sumInput = driver.findElement(By.id("internet-sum"));
        String sumLabel = sumInput.getAttribute("placeholder");
        Assert.assertEquals(sumLabel,"Сумма");

        WebElement emailInput = driver.findElement(By.id("internet-email"));
        String emailLabel = emailInput.getAttribute("placeholder");
        Assert.assertEquals(emailLabel,"E-mail для отправки чека");
    }
    @Test
    public void checkInstalment(){
        WebElement serviceInput = driver.findElement(By.id("pay"));
        WebElement connection = serviceInput.findElement(By.xpath("//select[@id='pay']/option[text()='Рассрочка']"));
        connection.click();

        WebElement scoreInput = driver.findElement(By.id("score-instalment"));
        String scoreLabel = scoreInput.getAttribute("placeholder");
        Assert.assertEquals(scoreLabel,"Номер счета на 44");

        WebElement sumInput = driver.findElement(By.id("instalment-sum"));
        String sumLabel = sumInput.getAttribute("placeholder");
        Assert.assertEquals(sumLabel,"Сумма");

        WebElement emailInput = driver.findElement(By.id("instalment-email"));
        String emailLabel = emailInput.getAttribute("placeholder");
        Assert.assertEquals(emailLabel,"E-mail для отправки чека");
    }
    @Test
    public void checkArrears(){
        WebElement serviceInput = driver.findElement(By.id("pay"));
        WebElement connection = serviceInput.findElement(By.xpath("//select[@id='pay']/option[text()='Задолженность']"));
        connection.click();

        WebElement scoreInput = driver.findElement(By.id("score-arrears"));
        String scoreLabel = scoreInput.getAttribute("placeholder");
        Assert.assertEquals(scoreLabel,"Номер счета на 2073");

        WebElement sumInput = driver.findElement(By.id("arrears-sum"));
        String sumLabel = sumInput.getAttribute("placeholder");
        Assert.assertEquals(sumLabel,"Сумма");

        WebElement emailInput = driver.findElement(By.id("arrears-email"));
        String emailLabel = emailInput.getAttribute("placeholder");
        Assert.assertEquals(emailLabel,"E-mail для отправки чека");
    }
    @Test (dependsOnMethods = {"checkConnection","checkInternet","checkInstalment","checkArrears"})
    public void checkConnectionFrame(){
        WebElement serviceInput = driver.findElement(By.id("pay"));
        serviceInput.findElement(By.xpath("//select[@id='pay']/option[text()='Услуги связи']")).click();
        driver.findElement(By.id("connection-phone")).sendKeys("297777777");
        driver.findElement(By.id("connection-sum")).sendKeys("100");
        driver.findElement(By.id("connection-email")).sendKeys("juliet810@mail.ru");
        driver.findElement(By.xpath("//button[contains(text(), 'Продолжить')]")).click();

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/div/app-payment-container/app-header/header/div/div/div")));

        WebElement payment = driver.findElement(By.xpath("/html/body/app-root/div/div/app-payment-container/app-header/header/div/div/div"));
        Assert.assertTrue(payment.getText().contains("100"));
        WebElement telephoneNumber = driver.findElement(By.xpath("/html/body/app-root/div/div/app-payment-container/app-header/header/div/div/p"));
        Assert.assertTrue(telephoneNumber.getText().contains("297777777"));
        WebElement cardNumber = driver.findElement(By.xpath( "/html/body/app-root/div/div/app-payment-container/section/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[1]/label"));
        Assert.assertTrue(cardNumber.getText().contains("Номер карты"));
        WebElement cardImg = driver.findElement(By.xpath("/html/body/app-root/div/div/app-payment-container/section/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div"));
        Assert.assertTrue(cardImg.isDisplayed());
        WebElement cardValidity = driver.findElement(By.xpath("/html/body/app-root/div/div/app-payment-container/section/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[1]/app-input/div/div/div[1]/label"));
        Assert.assertTrue(cardValidity.getText().contains("Срок действия"));
        WebElement cardCVC = driver.findElement(By.xpath("/html/body/app-root/div/div/app-payment-container/section/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[3]/app-input/div/div/div[1]/label"));
        Assert.assertTrue(cardCVC.getText().contains("CVC"));
        WebElement cardHolder = driver.findElement(By.xpath("/html/body/app-root/div/div/app-payment-container/section/app-card-page/div/div[1]/app-card-input/form/div[1]/div[3]/app-input/div/div/div[1]/label"));
        Assert.assertTrue(cardHolder.getText().contains("Имя держателя (как на карте)"));
        WebElement buttonPay = driver.findElement(By.xpath("/html/body/app-root/div/div/app-payment-container/section/app-card-page/div/div[1]/button"));
        Assert.assertTrue(buttonPay.getText().contains("100.00"));
    }
    @AfterClass
    public void quitDriver() {
        driver.quit();
    }



}
