package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class AssignmnetWait {
    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("password")).sendKeys("learning");
        driver.findElement(By.xpath("//span[contains(text(),'User')]")).click();
        WebElement okayButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("okayBtn")));
        okayButton.click();
        WebElement StaticDropdown = driver.findElement(By.xpath("//select[@class='form-control']"));
        Select dropdown = new Select(StaticDropdown);
        dropdown.selectByVisibleText("Consultant");
        driver.findElement(By.id("terms")).click();
        driver.findElement(By.id("signInBtn")).click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("h4.card-title")));
        List<WebElement> product = driver.findElements(By.cssSelector("h4.card-title"));
        for (int i=0; i<product.size(); i++)
        {

            driver.findElements(By.cssSelector("button.btn.btn-info")).get(i).click();;

        }
        driver.findElement(By.cssSelector("a.nav-link.btn.btn-primary")).click();
        driver.close();
    }
}
