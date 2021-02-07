package newPractice;

import static java.lang.Thread.sleep;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class makeMyTripTest {
  WebDriver driver;
  String mmt = "https://makemytrip.com/";

  @BeforeTest
  public void launchBrowser() {
    System.setProperty("webdriver.chrome.driver", "E:\\AutomationPractice\\SeleniumPractice\\chromedriver_win32\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.get(mmt);
    driver.manage().window().maximize();
  }

  @Test
  public void selectDate() throws InterruptedException {
    sleep(1000);
    driver.navigate().refresh();
    sleep(1000);
    String inputDate = "25-December";
    String[] dateSelect = inputDate.split("-");
    String month = dateSelect[1];
    String dt = dateSelect[0];
    int monthSelect = 0;
    int daySelect = 0;

    System.out.println(dt);
    System.out.println(month);

    WebElement roundTrip = driver.findElement(By.xpath("//*[@class='fswTabs latoBlack greyText']/li[@data-cy='roundTrip']"));
    Actions axn = new Actions(driver);
    axn.moveToElement(roundTrip).click().build().perform();
    sleep(1000);
    WebElement calLocator = driver.findElement(By.xpath("(//*[@class='lbl_input latoBold appendBottom10'])[1]"));
    calLocator.click();

    WebElement nextBtn = driver.findElement(By.xpath("//*[@class='DayPicker-NavButton DayPicker-NavButton--next']"));
    sleep(1000);

    List<WebElement> monthHeader = driver.findElements(By.xpath("//*[@class='DayPicker-Month']//*[@class='DayPicker-Caption']/div"));
    String monthName;
    String[] monthVal;

    //List<WebElement> days = driver.findElements(By.xpath("//*[@class='DayPicker-Months']//*[@class='DayPicker-Day']"));
    String selectDays;
    String[] dayTobeSelected;
    int z = 0;

    /*for (int i = 0; i <5; i++) {
      Thread.sleep(1000);
      for (int u = 0; u < monthHeader.size(); u++) {
        z = u + 1;
        monthName = driver.findElement(By.xpath("//*[@class='DayPicker-Month'][" + z + "]//*[@class='DayPicker-Caption']/div")).getText();
        monthVal= monthName.split("2");
        System.out.println(monthVal[0]);

        if (monthVal[0].contains(month)) {
          monthSelect = 1;
          System.out.println("Month is found");
          break;
        }
      }

      if (monthSelect == 0) {
        nextBtn.click();
      }
    }*/

    do{
      sleep(1000);
      for (int u = 0; u < monthHeader.size(); u++) {
        z = u + 1;
        monthName = driver.findElement(By.xpath("//*[@class='DayPicker-Month']["+z+"]//*[@class='DayPicker-Caption']/div")).getText();
        monthVal = monthName.split("2");
        System.out.println(monthVal[0]);

        if (monthVal[0].contains(month)) {
          monthSelect = 1;
          System.out.println("Month is found");
          break;
        }
      }

      if (monthSelect == 0) {
        nextBtn.click();
      }

    }while(monthSelect==0);

    if (monthSelect == 1) {
      List<WebElement> days = driver.findElements(By.xpath("//*[@class='DayPicker-Months']//*[@class='DayPicker-Month'][" + z + "]//*[@class='DayPicker-Day']"));
      for (int j = 0; j < days.size(); j++) {
        selectDays = days.get(j).getAttribute("aria-label");
        dayTobeSelected = selectDays.split(" ");
        System.out.println(dayTobeSelected[2]);
        if(dayTobeSelected[2].equalsIgnoreCase(dt))
        {
          int w=j+1;
          Thread.sleep(1000);
          driver.findElement(By.xpath("(//*[@class='DayPicker-Months']//*[@class='DayPicker-Month']["+z+"]//*[@class='DayPicker-Day']//div)["+w+"]")).click();
          System.out.println("date selected");
          break;
        }
      }
    }

    else {
      System.out.println("Month not found");
    }
  }

  @AfterSuite
  public void teardown()
  {
    driver.quit();
  }
}
