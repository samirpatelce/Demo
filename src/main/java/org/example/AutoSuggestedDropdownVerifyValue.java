package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AutoSuggestedDropdownVerifyValue {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.id("autocomplete")).sendKeys("ind");

        Thread.sleep(2000);

        driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);

        driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);

        System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));
        driver.close();
//        WebElement inputField = driver.findElement(By.id("autocomplete"));
//        inputField.sendKeys("Ind");
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        List<WebElement> suggestions = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".ui-autocomplete li")));
//
//        Actions actions = new Actions(driver);
//
//        for (WebElement suggestion : suggestions) {
//            if (suggestion.getText().equalsIgnoreCase("India")) {
//                actions.moveToElement(suggestion).perform();
//
//                suggestion.click();
//                break;
//            }
//        }
//        String selectedValue = inputField.getAttribute("value");
//        if ("India".equals(selectedValue)) {
//            System.out.println("Assertion passed: The value is correctly selected as 'India'.");
//        } else {
//            System.out.println("Assertion failed: The selected value is '" + selectedValue + "' instead of 'India'.");
//        }

    }
}
