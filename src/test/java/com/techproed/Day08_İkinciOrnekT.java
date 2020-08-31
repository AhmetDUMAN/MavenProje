package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day08_İkinciOrnekT {
    //neden butda tanımladık?
    //çünkü , diger methodlardan da, yani tüm methodlardan bu nesneye erişmek istiyoruz.
    //çünkü, findElement gibi methodları ister istemez test'lerin içerisinde kullanağız.
    static WebDriver driver;
    @BeforeClass // Class çalışmadan çalışacak ve 1 kere çalışır.
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterClass //Class çalışmayı bitirdikden sonra çalışır ve sadece 1 kere çalışır.
    public static void tearDown(){
        driver.quit();
    }
    @Before//her test methodundan önce çalışacak
    public void testtenOnce(){
        driver.get("http://google.com");
    }
    @After//her test methodundan sonra çalışacak
    public void testtenSonra(){
        WebElement sonucSayısı = driver.findElement(By.id("result-stats"));
        System.out.println(sonucSayısı.getText());
    }
    @Test
    public void test1(){
        WebElement aramaKutusu = driver.findElement(By.name("q"));
        aramaKutusu.sendKeys("çalısma sandalyesi"+ Keys.ENTER);
    }
    @Test
    public void test2(){
        WebElement aramaKutusu = driver.findElement(By.name("q"));
        aramaKutusu.sendKeys("elma");
        aramaKutusu.submit();

    }
    @Test
    public void test3(){
        WebElement aramaKutusu = driver.findElement(By.name("q"));
        aramaKutusu.sendKeys("samsung kulanlık");
        aramaKutusu.submit();
    }
}
