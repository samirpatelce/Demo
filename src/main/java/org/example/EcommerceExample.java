package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class EcommerceExample {
    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriver driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
        String[] itemVeg = {"Cucumber", "Brocolli", "Tomato", "Pumpkin"};
        driver.get("https://rahulshettyacademy.com/seleniumPractise");
        addItemToCart(driver, itemVeg);
        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button.promoBtn")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());


    driver.quit();
    }

    public static void addItemToCart(WebDriver driver, String[] itemVeg)
    {
        int j = 0;
        List<WebElement> product = driver.findElements(By.cssSelector("h4.product-name"));

        for (int i=0; i<product.size(); i++)
        {
            String[] name = product.get(i).getText().split("-");
            String newName = name[0].trim();
            List fixedSizeList = Arrays.asList(itemVeg);

            if (fixedSizeList.contains(newName))
            {
                j++;
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                if(j==itemVeg.length)
                {
                    break;
                }
            }
        }
    }
}
