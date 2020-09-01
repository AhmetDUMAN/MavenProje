package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Day10_DropDownOrnek {
    // 1. Amazon.com'a gidelim.
    // 2. DropDown üzerinde Software seçelim.
    // 3. Arama kutusuna JAVA yazalım ve arama yapalım.
    // 4. Sonuç sayısını ekrana yazdıralım
    private static WebDriver driver;
    @BeforeClass
    public static void  setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://amazon.com");
    }
    @Test
    public void test1 (){
        WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Software");
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("JAVA");
        aramaKutusu.submit();
        //<span dir="auto">8 results for</span>
        WebElement aramaMiktarı = driver.findElement(By.xpath("//span[@dir='auto']"));
        System.out.println(aramaMiktarı.getText());

        Assert.assertTrue(aramaMiktarı.getText().contains("for"));

        // CŞASS DEĞERİ : a-section a-spacin-small a-spacina a-spacing-top-small

        WebElement sonuçSayısıCss = driver.findElement(By.cssSelector(".a-section.a-spacing-small.a-spacing-top-small"));
        System.out.println(sonuçSayısıCss.getText());
    }

}
