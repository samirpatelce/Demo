package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ConfigureBrowser {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/");

        String myProduct = "2017 Dell 15.6 Inch";
        boolean productFound = false;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        while (!productFound) {
            List<WebElement> products = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='card-block']/h4/a")));
            for (WebElement product : products) {
                if (product.getText().equalsIgnoreCase(myProduct)) {
                    wait.until(ExpectedConditions.elementToBeClickable(product)).click();
                    productFound = true;
                    break;
                }
            }
            if (!productFound) {
                try {
                    WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("next2")));
                    nextButton.click();
                    wait.until(ExpectedConditions.stalenessOf(products.get(0)));
                } catch (Exception e) {
                    System.out.println("Product not found.");
                    break;
                }
            }
        }
        driver.quit();
    }


}




