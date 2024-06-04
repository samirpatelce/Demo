package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.lang.model.element.Element;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class ConfigureBrowser extends BaseClass{

    public static void main(String[] args) {
        String myProduct = "ASUS Full HD";
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.demoblaze.com/#");

        boolean productFound = false;
        while(true){
            List<WebElement> products = driver.findElements(By.xpath("//div[@class='card-block']/h4/a"));
            for (WebElement product : products) {
                System.out.println(product.getText());
                if (product.getText().equalsIgnoreCase(myProduct)) {
                    product.click();
                    productFound = true;
                    break;
                }
            }
            if(productFound){
                System.out.println("Product "+ myProduct + " Found");
                break;
            }else {
                WebElement nextButton = driver.findElement(By.id("next2"));
                nextButton.click();
                Thread.sleep(1000);
                products.clear();
            }

        }
        driver.quit();
    }
}

