package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day09_AssertionT {
    private static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.manage().window().maximize();
    }
    @Test
    public void test1(){
        driver.get("https://google.com");
        //Test Case : Google.com'un başlığı "Google Arama Sayfası" olsun.
        //Google'ın title'ı "Google Arama sayfası"na eşitmi,değil mi?
        String title = driver.getTitle();

        Assert.assertEquals("Google Arama Sayfası",title);
        //Assert.assertEquals(5,5);
        //Assert.assertEquals(true,false);
        //Assert.assertEquals("Yazı","Google");

    }
    @Test
    public void test2(){
        driver.get("https://amazon.com");
        //Amazon.com'un başlığı Amazon kelimesini içeriyor olsun.
        String title = driver.getTitle();

        boolean içeriyoMu = title.contains("Amazon");//"true" yada  "false"
        //boolean veri tipinde bir değer giriyoruz.
        Assert.assertTrue(içeriyoMu);
    }
    @Test
    public void test3(){
        driver.get("https://amazon.com");
        //Amazon.com'un başlığı Amazon kelimesini içeriyor olsun.
        String title = driver.getTitle();


        Assert.assertTrue(title.contains("Amazon")?true:false);// parantezin içerisi true ise test bazarılı.
    }
    @Test
    public void test4(){
        driver.get("https://facebook.com");

        String title = driver.getTitle();
        // Facebook.com'un title'ı Youtube kelimesini içermesin.
        boolean içeriyoMu = title.contains("Youtube");//"true" yada  "false"
        //boolean veri tipinde bir değer giriyoruz.
        Assert.assertFalse(içeriyoMu);//parantezin içerisi false ise test başarılı.
    }
    @Test
    public void test5(){
        driver.get("https://google.com");
        String title = driver.getTitle();

        System.out.println("MERHABALAR...");

        Assert.assertEquals("Google Arama Sayfası",title);

        // Eğer test başarısızsa içerisinde bulunan testin kalan kısmı çalıştırmıyor.
        System.out.println("TEST DOĞGULAMA İŞLEMİ BİTTİ..");

    }
    @Test
    public void test6(){
        driver.get("https://facebook.com");

        String title = driver.getTitle();

        boolean içeriyoMu = title.contains("Google");//"true" yada  "false"

        Assert.assertFalse(içeriyoMu);//parantezin içerisi false ise test başarılı.

        System.out.println("TEST DOĞRULAMA İŞLEMİ BİTTİ..");
    }
    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
}
