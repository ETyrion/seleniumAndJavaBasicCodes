package newPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GoogleSearch {
  WebDriver driver;
  String url = "https://www.techlistic.com/p/demo-selenium-practice.html";

  @Test
  public void search() throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "E:\\AutomationPractice\\SeleniumPractice\\chromedriver_win32\\chromedriver.exe");
    driver = new ChromeDriver();
    int flag = 1;
    driver.get("https://www.google.com/");
    driver.findElement(By.xpath("//*[@class='gLFyf gsfi']")).sendKeys("iphone");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
    String val;
    //List<WebElement> items = driver.findElements(By.xpath("//*[@class='UUbT9']//ul/descendant::div[@class='sbtc']"));

    List<WebElement> items = driver.findElements(By.xpath("//*[@class='sbtc']"));
    for (int i = 0; i < items.size(); i++) {
      System.out.println(items.get(i).getText());
      Thread.sleep(2000);
      val = items.get(i).getText();
      if (val.equalsIgnoreCase("iphone 12 price in India")) {
        items.get(i).click();
        flag = 0;
        break;
      }
    }

    if (flag == 0) {
      System.out.println("Found");
    } else {
      System.out.println("Not found");
    }
  }

  @Test
  public void searchFruits() throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "E:\\AutomationPractice\\SeleniumPractice\\chromedriver_win32\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.get("https://www.google.com/");
    Thread.sleep(3000);
    driver.findElement(By.xpath("//*[@name='q']")).sendKeys("Mango");
    Thread.sleep(3000);
    List<WebElement> results = driver.findElements(By.xpath("//*[@class='UUbT9']//ul//li/descendant::div[@class='sbtc']"));
    System.out.print(results.size());
    String suggestedResults;
    for (int i = 0; i < results.size(); i++) {
      suggestedResults = results.get(i).getText();
      if (suggestedResults.equalsIgnoreCase("mango people")) {
        results.get(i).click();
        break;
      } else {
        continue;
      }
    }
  }

}
