package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day07_IlkDers {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement sonucsayısı = driver.findElement(By.id("twotabsearchtextbox"));
        sonucsayısı.sendKeys("samsung headphones"+ Keys.ENTER);
        //sonucsayısı.sendKeys();

        WebElement yazi = driver.findElement(By.xpath("//span[@dir='auto']"));
        System.out.println(yazi.getText());

        List<WebElement> listem = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));

        System.out.println(listem.get(0).getText());
        for (WebElement w : listem){
            System.out.println(w.getText());
        }
    }
}
