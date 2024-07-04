package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Amazon {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Mobile");

//        String name = "Storite Dust & Rain Cover for Backpack with Pouch, Waterproof Dustproof Rain Cover Bag Elastic Adjustable for School, College,Office, Trekking Bags (30L-35L,Black)";
//        driver.findElement(By.xpath("//div[@id='nav-xshop']//a[contains(.,'Best Sellers')]")).click();
//        List<WebElement> productName = driver.findElements(By.xpath("//div[@class='p13n-sc-truncate-desktop-type2  p13n-sc-truncated']"));
//
//        for (WebElement webElement : productName) {
//            String name12 = webElement.getAttribute("title");
//            if (name12.contains(name)) {
//                driver.findElement(By.xpath("//div[@title='" + name + "']")).click();
//                driver.findElement(By.xpath("//span[@class='a-button-inner']//input[@id='add-to-cart-button']")).click();
//            }
//        }
    }
}
