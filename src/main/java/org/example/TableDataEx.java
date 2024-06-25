package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class TableDataEx {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        WebElement table = driver.findElement(By.xpath("(//table[@name='courses'])"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        int rowCount = rows.size();
        System.out.println("Number of rows: " + rowCount);


        List<WebElement> columns = rows.get(1).findElements(By.tagName("td"));
        int columnCount = columns.size();
        System.out.println("Number of columns: " + columnCount);

        if (rowCount > 1) {
            List<WebElement> secondRowColumns = rows.get(2).findElements(By.tagName("td"));
            System.out.println("Data in the second row:");
            for (WebElement cell : secondRowColumns) {
                System.out.print(cell.getText() + " ");
            }
        } else {
            System.out.println("There is no second row in the table.");
        }
        driver.close();
    }
}


