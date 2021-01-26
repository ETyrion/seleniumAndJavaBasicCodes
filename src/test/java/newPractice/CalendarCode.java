package newPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CalendarCode {
  WebDriver driver;
  String dateTobeSelected = "15-June";
  String[] pickDate = dateTobeSelected.split("-");


  @BeforeTest
  public void launchBrowser() {
    System.setProperty("webdriver.chrome.driver", "E:\\AutomationPractice\\SeleniumPractice\\chromedriver_win32\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.get("https://www.path2usa.com/travel-companions");
    driver.manage().window().maximize();
  }

  @Test(description = "Test to select the desired date from UI")
  public void selectDate() throws InterruptedException {
    System.out.println(pickDate[0]);
    System.out.println(pickDate[1]);
    WebElement calendar = driver.findElement(By.id("travel_date"));
    Thread.sleep(3000);
    calendar.click();
    Thread.sleep(2000);
    WebElement arrow = driver.findElement(By.xpath("(//*[@class='next'])[1]"));
    String month;
    arrow.click();
    for(int i=0; i<12; i++)
    {
       month= driver.findElement(By.xpath("(//*[@class='datepicker-switch'])[1]")).getText();
       if(month.contains(pickDate[1]))
       {
         List<WebElement> dates = driver.findElements(By.xpath("//*[@class='day']"));
         for (int j = 0; j < dates.size(); j++) {
           Thread.sleep(1000);
           if (dates.get(j).getText().equalsIgnoreCase(pickDate[0])) {
             dates.get(j).click();
             break;
           }
         }
         break;
       }
       else
       {
         arrow.click();
       }
    }


  }
}
