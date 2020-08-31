package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day08_JUnitT {


    @Test
    public void test1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://google.com");
        driver.close();
        System.out.println("Elveda main..");
    }
    @Test
    @Ignore
    public void test2(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://amazon.com");
        driver.quit();
        System.out.println("Merhaba test..");
    }
    @Test
    public void test3(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://facebook.com");
        driver.quit();

    }
}
