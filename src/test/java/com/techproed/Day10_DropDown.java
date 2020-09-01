package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day10_DropDown {
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
        driver.get("http://amazon.com");
        WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));
        //Select class'ından nesne üretmeden dropdon üzerinde işlem yapayız.
        //Eğer mülakatta dropdown ile ilgili bir soru gelirse, kesinlikle
        // select class'ından bahsetmeniz gerekiyor.
        Select select = new Select(dropDown);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Seçeneğin bulundugu sıraya göre seçim yapabiliriz.
        select.selectByIndex(1);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // seçeneğin, value attribute kullanıllarak seçim yapılır.
        select.selectByValue("search-alias=computers-intl-ship");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Seçeneğin yazısına göre, seçim yapabiliriz.
        select.selectByVisibleText("Baby");
        //getFirstSelectedOption - dropdown üzerinde şuanda seçili olan webelementi size return eder.
        WebElement seçım = select.getFirstSelectedOption();
        System.out.println(seçım.getText());
        // getOptions() tüm seçenekleri List<WebElement> şeklinde size return eder.
        List<WebElement> liste = select.getOptions();
        for (WebElement webElement:liste) {
            System.out.println(webElement.getText());
        }
        // liste.size() tüm seçeneklerin toplam sayısını size return eder.
        int toplamSecenekSayısı = liste.size();
        System.out.println("Toplam şeçim sayısı :"+toplamSecenekSayısı);
    }
}
