package TestNG;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DemoBlazeTest {
    private static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testProductSearch() throws InterruptedException {
        driver.get("https://www.demoblaze.com/");

        String myProduct = "MacBook Pro";
        boolean productFound = searchForProduct(myProduct);

        if (productFound) {
            System.out.println("Product " + myProduct + " Found");
        } else {
            System.out.println("Product " + myProduct + " Not Found");
        }
    }

    public boolean searchForProduct(String myProduct) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean productFound = false;

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
        return productFound;
    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
        if (driver != null) {
            Thread.sleep(4000);
            driver.quit();
        }
    }
}
