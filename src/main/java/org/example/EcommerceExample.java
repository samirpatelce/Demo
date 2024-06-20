package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class EcommerceExample {
    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        int j = 0;
        String[] itemVeg = {"Cucumber", "Brocolli", "Tomato", "Pumpkin"};
        driver.get("https://rahulshettyacademy.com/seleniumPractise");
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
    driver.quit();
    }
}
