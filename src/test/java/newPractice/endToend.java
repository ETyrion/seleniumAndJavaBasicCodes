package newPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class endToend {

  @Test
  public void openBrowser() throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "E:\\AutomationPractice\\SeleniumPractice\\chromedriver_win32\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

    WebElement searchbox = driver.findElement(By.xpath("//input[@type='search']"));
    searchbox.sendKeys("Cucumber");
    driver.manage().window().maximize();
    WebDriverWait w1 = new WebDriverWait(driver, 5);
    WebElement adbtn = driver.findElement(By.xpath("//a[@class='increment']"));
    w1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='increment']")));
    for (int i = 0; i < 3; i++) {
      adbtn.click();
      Thread.sleep(1000);
    }

    driver.findElement(By.xpath("//div[@class='product-action']")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//*[@alt='Cart']")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//*[contains(text(),'PROCEED TO CHECKOUT')]")).click();
    Thread.sleep(1000);
    int quantity = Integer.parseInt(driver.findElement(By.xpath("//*[@class='quantity']")).getText());
    int price = Integer.parseInt(driver.findElement(By.xpath("//*[@class='amount']")).getText());
    int finalPrice = Integer.parseInt(driver.findElement(By.xpath("(//*[@class='amount'])[2]")).getText());

    System.out.println(quantity);
    System.out.println(price);
    System.out.println(finalPrice);
    int expectedPrice = quantity * price;
    Assert.assertEquals(expectedPrice, finalPrice);

  }
}
