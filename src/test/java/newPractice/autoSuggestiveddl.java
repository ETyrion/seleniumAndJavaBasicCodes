package newPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class autoSuggestiveddl {
  @Test

  public void autoSugest() throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "E:\\AutomationPractice\\SeleniumPractice\\chromedriver_win32\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.get("https://rahulshettyacademy.com/AutomationPractice/");
    driver.findElement(By.xpath("//input[@id='autocomplete']"));
    Thread.sleep(4000);
    driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys("Ind");
    Thread.sleep(5000);
    driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys(Keys.ARROW_DOWN);
    JavascriptExecutor js = (JavascriptExecutor) driver;
    String ddcntry = "return document.getElementById(\"autocomplete\").value;";
    String countryVal = (String) js.executeScript(ddcntry);
    System.out.println(countryVal);

    //get the message of Alert box
    WebElement alertbox = driver.findElement(By.xpath("//input[@id='name']"));
    alertbox.sendKeys("Shubhman Gill");
    driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
    Thread.sleep(1000);
    System.out.println(driver.switchTo().alert().getText());
    driver.switchTo().alert().accept();
  }

  @Test
  public void autoSuggestive() throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "E:\\AutomationPractice\\SeleniumPractice\\chromedriver_win32\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.get("https://rahulshettyacademy.com/AutomationPractice/");
    driver.findElement(By.xpath("//input[@id='autocomplete']"));
    Thread.sleep(4000);
    driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys("Ind");
    Thread.sleep(5000);
    List<WebElement> search = driver.findElements(By.xpath("//input[@id='autocomplete']"));
    JavascriptExecutor js = (JavascriptExecutor) driver;
    String val =  "return document.getElementById(\"autocomplete\").value;";
    String cntry = (String) js.executeScript(val);
    for(int i=0; i<search.size(); i++)
    {
      System.out.println(search.get(i).getText());
      if(search.get(i).getText().equalsIgnoreCase("Indonesia"))
      {
        search.get(i).click();
        break;
      }
      else
      {
        continue;
      }
    }

  }



}
