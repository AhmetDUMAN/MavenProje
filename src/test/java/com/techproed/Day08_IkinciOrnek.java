package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day08_IkinciOrnek {
    //neden butda tanımladık?
    //çünkü , diger methodlardan da, yani tüm methodlardan bu nesneye erişmek istiyoruz.
    //çünkü, findElement gibi methodları ister istemez test'lerin içerisinde kullanağız.
    static WebDriver driver;
    @BeforeClass  // class'tan önce çalışır
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterClass   // class çalışması bittikten sonra  çalışır
    public static void tearDown(){
        driver.quit();
    }
    @Before  // Her test methodundan önce çalışır
    public void testtenOnce(){
        driver.get("https://google.com");
    }
    @After   // Her test methodu bittikten sonra çalışır.
    public void testtenSonra(){
       WebElement sonucSayısı = driver.findElement(By.id("result-stats"));
        System.out.println(sonucSayısı.getText());
    }
    @Test
    public void test1(){
        WebElement aramaKutusu = driver.findElement(By.name("q"));
        aramaKutusu.sendKeys("elma");
        aramaKutusu.submit();
    }
    @Test
    public void test2(){ WebElement aramaKutusu = driver.findElement(By.name("q"));
        aramaKutusu.sendKeys("samsug kullaklık");
        aramaKutusu.submit();
    }
    @Test
    public void test3(){ WebElement aramaKutusu = driver.findElement(By.name("q"));
        aramaKutusu.sendKeys("çalışma sandalyesi");
        aramaKutusu.submit();
    }

}
