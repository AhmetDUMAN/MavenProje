package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day10_isDisplayed {
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        // driver'i kullnabilir hala geririyoruz
        WebDriverManager.chromedriver().setup();
        //driver nesnesini olluşturalım.
        driver = new ChromeDriver();

        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void test1(){
        // Google.com'A gidiyoruz.
        driver.get("https://google.com");
        WebElement logo = driver.findElement(By.id("hplogo"));
        // eğer webelement kullanıcıya gösteriliyorsa, TRUE
        // eğer webelement kulLanıcıya gösterilmiyorsa, FALSE
        boolean görünüyorMu = logo.isDisplayed();
        //testimizin sonucunu bildiriyoruz.
        //eğer "görünüyorMu" TRUE ise testimiZ PASSED(BAŞARILI)
        //eğer "görünüyorMu" FALSE ise testimiz FAILED(BAŞARISIZ)
        Assert.assertTrue(görünüyorMu);
    }
    @AfterClass
    public static void tearDown(){
        //driver.quit();
    }
}
