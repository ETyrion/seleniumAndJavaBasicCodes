package mvnPracticeTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class amazonMvnTest {
    @Test
    public void addToCart() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "E:\\AutomationPractice\\SeleniumPractice\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        String[] vegeName = {"Cucumber", "Potato", "Onion", "Raspberry"};
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        AddVegeTables(vegeName, driver);
        //driver.findElement(By.xpath("//img[@alt='Cart']")).click();
    }

    public static void AddVegeTables(String[] vegeName, WebDriver driver) {
        int j = 0;
        List veggieList = Arrays.asList(vegeName);
        List<WebElement> dispVeggies = driver.findElements(By.xpath("//*[@class='product-name']"));
        for (int i = 0; i < dispVeggies.size(); i++) {
            String[] displayedName = dispVeggies.get(i).getText().split("-");
            String formattedVeggieName = displayedName[0].trim();
            if (veggieList.contains(formattedVeggieName)) {
                j++;
                System.out.println("Vegetable to be added to cart is " + formattedVeggieName);
                System.out.println("Adding it to cart");
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                if (j == veggieList.size()) {
                    System.out.println("All the veggies in the list have been added to the cart");
                    break;
                } else {
                    System.out.println(j + " vegetables have been added");
                }
            } else {
                System.out.println(formattedVeggieName + " is not in the list");
            }


        }
        WebElement addCartBtn = driver.findElement(By.xpath("//img[@alt='Cart']"));
        addCartBtn.click();
        System.out.println("Number of items in cart are " + addCartBtn.getText());
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
       /* WebDriverWait w = new WebDriverWait(driver, 5);
        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Place Order')]")));*/
        WebElement promoCodeField = driver.findElement(By.xpath("//input[@placeholder='Enter promo code']"));
        promoCodeField.sendKeys("ABC");
        driver.findElement(By.xpath("//*[@class='promoBtn']")).click();
        driver.close();
    }
}

