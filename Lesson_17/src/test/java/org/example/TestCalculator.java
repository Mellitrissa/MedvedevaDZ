package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestCalculator {
    AndroidDriver<AndroidElement> driver = null;

    @BeforeTest
    public void setUp()throws MalformedURLException {

    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 3a API 31");
    capabilities.setCapability("platformName","Android");
    capabilities.setCapability("appium:automationName", "UiAutomator2");
    capabilities.setCapability(MobileCapabilityType.APP,"/Users/uliamedvedeva/Downloads/com.google.android.calculator_78000303_apps.evozi.com.apk");
    capabilities.setCapability("appium:ensureWebviewsHavePages", true);
    capabilities.setCapability("appium:nativeWebScreenshot", true);
    capabilities.setCapability("appium:newCommandTimeout", 3600);
    capabilities.setCapability("appium:connectHardwareKeyboard", true);
    driver=new AndroidDriver<>(new URL("http://127.0.0.1:4723"),capabilities);
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void plusTest() {
        driver.findElementById("com.google.android.calculator:id/arrow").click();
        driver.findElementById("com.google.android.calculator:id/digit_2").click();
        driver.findElementById("com.google.android.calculator:id/op_add").click();
        driver.findElementById("com.google.android.calculator:id/digit_5").click();
        driver.findElementById("com.google.android.calculator:id/eq").click();
        AndroidElement result = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.google.android.calculator:id/result_final']"));
        Assert.assertEquals("7",result.getText());

    }
    @Test(dependsOnMethods = {"plusTest"})
    public void minusTest(){
        driver.findElementById("com.google.android.calculator:id/clr").click();
        driver.findElementById("com.google.android.calculator:id/digit_5").click();
        driver.findElementById("com.google.android.calculator:id/op_sub").click();
        driver.findElementById("com.google.android.calculator:id/digit_2").click();
        driver.findElementById("com.google.android.calculator:id/eq").click();
        AndroidElement result = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.google.android.calculator:id/result_final']"));
        Assert.assertEquals("3",result.getText());
    }
    @Test (dependsOnMethods = {"plusTest","minusTest"})
    public void multiplicationTest(){
        driver.findElementById("com.google.android.calculator:id/clr").click();
        driver.findElementById("com.google.android.calculator:id/digit_5").click();
        driver.findElementById("com.google.android.calculator:id/op_mul").click();
        driver.findElementById("com.google.android.calculator:id/digit_2").click();
        driver.findElementById("com.google.android.calculator:id/eq").click();
        AndroidElement result = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.google.android.calculator:id/result_final']"));
        Assert.assertEquals("10",result.getText());
    }
    @Test(dependsOnMethods = {"plusTest","minusTest","multiplicationTest"})
    public void divisionTest(){
        driver.findElementById("com.google.android.calculator:id/clr").click();
        driver.findElementById("com.google.android.calculator:id/digit_6").click();
        driver.findElementById("com.google.android.calculator:id/op_div").click();
        driver.findElementById("com.google.android.calculator:id/digit_2").click();
        driver.findElementById("com.google.android.calculator:id/eq").click();
        AndroidElement result = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.google.android.calculator:id/result_final']"));
        Assert.assertEquals("3",result.getText());
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
