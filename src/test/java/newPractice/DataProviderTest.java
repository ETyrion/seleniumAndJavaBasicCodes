package newPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
  public WebDriver driver;

  @Test(dataProvider = "getData")
  public void launch(String veg) throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "E:\\AutomationPractice\\SeleniumPractice\\chromedriver_win32\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
    Thread.sleep(4000);
    WebElement searchbox = driver.findElement(By.xpath("//input[@type='search']"));
    searchbox.sendKeys(veg);
    Thread.sleep(3000);
    searchbox.clear();
    Thread.sleep(2000);
     driver.close();
  }

  /*@Test(dataProvider = "getData")
  public void searchVeg(String veg) throws InterruptedException {
    WebElement searchbox = driver.findElement(By.xpath("//input[@type='search']"));
    searchbox.sendKeys(veg);
    Thread.sleep(3000);
    searchbox.clear();
    Thread.sleep(2000);
    driver.close();
  }*/

  @DataProvider
  public Object[] getData() {
    Object[] data = new Object[5];
    data[0] = "Cauliflower";
    data[1] = "Cucumber";
    data[2] = "Beans";
    data[3] = "Brinjal";
    data[4] = "Carrot";
    return data;
  }
}
