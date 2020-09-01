package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day10_isDisplayedOrnek {
    private static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();

    }
    @Before
    public void beforMethod (){
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10 , TimeUnit.SECONDS);
        driver.get("https://www.bestbuy.com");
    }
    @Test
    public void test1(){
        String başlık = driver.getTitle();
        boolean içeriyormu = başlık.contains("Best");
        Assert.assertTrue(içeriyormu);
    }
    @Test
    public void test2(){
        WebElement logo = driver.findElement(By.className("logo"));
        boolean görünüyormu = logo.isDisplayed();
        Assert.assertTrue(görünüyormu);
    }
    @Test
    public void test3(){
        WebElement logo1 = driver.findElement(By.xpath("//img[@src='https://www.bestbuy.com/~assets/bby/_intl/landing_page/images/maps/mexico.svg']"));
        boolean görünüyormu = logo1.isDisplayed();
        Assert.assertTrue(görünüyormu);
    }

    @After
    public void afterMethod(){
        driver.quit();
    }
}
