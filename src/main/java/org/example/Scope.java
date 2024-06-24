package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class Scope {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        System.out.println(driver.findElements(By.tagName("a")).size());

        WebElement footer = driver.findElement(By.id("gf-BIG"));
        System.out.println(footer.findElements(By.tagName("a")).size());
//        System.out.println(driver.findElements(By.xpath("//div[@id='gf-BIG']//a")).size());
        WebElement columnLinks = footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        System.out.println(columnLinks.findElements(By.tagName("a")).size());

        for (int i = 1; i < columnLinks.findElements(By.tagName("a")).size(); i++)
        {
            String clickOnEachLinks = Keys.chord(Keys.CONTROL, Keys.ENTER);
            columnLinks.findElements(By.tagName("a")).get(i).sendKeys(clickOnEachLinks);
            Thread.sleep(3000);
        }
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.stream().iterator();
        while (it.hasNext()) {
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());
        }
    }
}
