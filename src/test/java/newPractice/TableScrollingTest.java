package newPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TableScrollingTest {
  WebDriver driver;

  @BeforeTest
  public void lanchBrowser() {
    System.setProperty("webdriver.chrome.driver", "E:\\AutomationPractice\\SeleniumPractice\\chromedriver_win32\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.get("https://rahulshettyacademy.com/AutomationPractice/");
  }

  @Test(description = "verify Total Amount in the Table")
  public void verifySum() throws InterruptedException {

    /*JavascriptExecutor js = (JavascriptExecutor) driver ;
    String s= "window.scrollBy(0,500)";
    js.executeAsyncScript(s);
    Thread.sleep(2000);

    //String tableScroll = "document.querySelector('.tableFixHead').scrollTo(0,200)";
    //js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
    //Thread.sleep(2000);*/

    WebElement table = driver.findElement(By.xpath("//*[@class='tableFixHead']"));
    List<WebElement> amount = driver.findElements(By.xpath("//*[@class='tableFixHead']/table/tbody/tr/td[4]"));
    int amountFetched = 0;
    int total = 0;
    Thread.sleep(1000);
    String totalString;

    for (int i = 0; i < amount.size(); i++) {
      Thread.sleep(1000);
      amountFetched = Integer.parseInt(amount.get(i).getText());
      total = total + amountFetched;
      System.out.println(" " + amountFetched);
    }
    totalString = String.valueOf(total);
    System.out.println(totalString);
    WebElement totalAmountCollected = driver.findElement(By.xpath("//*[@class='totalAmount']"));
    String[] totalAmountDisplayed = totalAmountCollected.getText().split(":");
    String fetchedAmountTotal = totalAmountDisplayed[1].trim();
    int totalAmount = Integer.parseInt(fetchedAmountTotal);
    Assert.assertEquals(totalAmount, total);
  }

}
