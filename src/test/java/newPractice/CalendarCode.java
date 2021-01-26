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

  @BeforeTest
  public void launchBrowser() {
    System.setProperty("webdriver.chrome.driver", "E:\\AutomationPractice\\SeleniumPractice\\chromedriver_win32\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.get("https://www.path2usa.com/travel-companions");
  }

  @Test(description = "Test to select the desired date from UI")
  public void selectDate() throws InterruptedException {
    WebElement calendar = driver.findElement(By.id("travel_date"));
    calendar.click();
    Thread.sleep(2000);
    List<WebElement> dates = driver.findElements(By.xpath("//*[@class='day']"));
    for (int i = 0; i < dates.size(); i++) {
      Thread.sleep(1000);
      if (dates.get(i).getText().equalsIgnoreCase("30")) {
        dates.get(i).click();
        break;
      }
    }
  }
}
