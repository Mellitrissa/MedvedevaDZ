package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestMTS {
    public static void main(String[] args) {
       System.setProperty("webdriver.chrome.driver", "/Users/uliamedvedeva/Desktop/GitHub/MedvedevaDZ/Lesson_13/src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.mts.by");
        WebElement cookiesButton = driver.findElement(By.xpath("//button[contains(text(), 'Принять')]"));
        cookiesButton.click();
        WebElement title = driver.findElement(By.xpath("//h2[contains(text(),'Онлайн пополнение')]"));
        if (title.isDisplayed()) {
            System.out.println("Название блока найдено: " + title.getText());
        } else {
            System.out.println("Название блока не найдено");
        }
        WebElement logo = driver.findElement(By.xpath("//div[@class='pay__partners']"));
        if (logo.isDisplayed()) {
            System.out.println("Логотипы платежных систем найдены");
        } else {
            System.out.println("Логотипы платежных систем не найдены");
        }
        WebElement moreInfoLink = driver.findElement(By.linkText("Подробнее о сервисе"));
        moreInfoLink.click();
        String newPageTitle = driver.getTitle();
        if ((newPageTitle.equals("Порядок оплаты и безопасность интернет платежей"))) {
            System.out.println("Ссылка работает.");
        } else {
           System.out.println("Ссылка не работает.");
       }
        driver.navigate().back();
        WebElement serviceInput = driver.findElement(By.id("pay"));
        WebElement connection = serviceInput.findElement(By.xpath("//select[@id='pay']/option[text()='Услуги связи']"));
        connection.click();
        WebElement numberInput = driver.findElement(By.id("connection-phone"));
        numberInput.click();
        numberInput.sendKeys("297777777");
        WebElement sumInput = driver.findElement(By.id("connection-sum"));
        sumInput.click();
        sumInput.sendKeys("100");
        WebElement emailInput = driver.findElement(By.id("connection-email"));
        emailInput.click();
        emailInput.sendKeys("juliet810@mail.ru");
        WebElement continueButton = driver.findElement(By.xpath("//button[contains(text(), 'Продолжить')]"));
        continueButton.click();
        driver.navigate().back();
        driver.quit();
    }
}