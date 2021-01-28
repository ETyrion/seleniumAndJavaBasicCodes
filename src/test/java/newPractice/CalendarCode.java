package newPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CalendarCode {
  WebDriver driver;
  String dateTobeSelected = "15-August";
  String[] pickDate = dateTobeSelected.split("-");
  //String vidUrl = "https://www.primevideo.com/region/eu/ref=atv_nb_sf_tv/259-3743311-9272620";
  String mmt = "https://makemytrip.com/";

  @BeforeTest
  public void launchBrowser() {
    System.setProperty("webdriver.chrome.driver", "E:\\AutomationPractice\\SeleniumPractice\\chromedriver_win32\\chromedriver.exe");
    driver = new ChromeDriver();
    //driver.get("https://www.path2usa.com/travel-companions");
    //driver.get(vidUrl);
    driver.get(mmt);
    driver.manage().window().maximize();
  }

  @Test(description = "Test to select the desired date from UI")
  public void selectDate() throws InterruptedException {
    System.out.println(pickDate[0]);
    System.out.println(pickDate[1]);
    WebElement calendar = driver.findElement(By.id("travel_date"));
    Thread.sleep(2000);
    calendar.click();
    Thread.sleep(2000);
    WebElement arrow = driver.findElement(By.xpath("(//*[@class='next'])[1]"));
    String month;
    arrow.click();
    for (int i = 0; i < 12; i++) {
      month = driver.findElement(By.xpath("(//*[@class='datepicker-switch'])[1]")).getText();
      if (month.contains(pickDate[1])) {
        List<WebElement> dates = driver.findElements(By.xpath("//*[@class='day']"));
        for (int j = 0; j < dates.size(); j++) {
          Thread.sleep(1000);
          if (dates.get(j).getText().equalsIgnoreCase(pickDate[0])) {
            dates.get(j).click();
            break;
          }
        }
        break;
      } else {
        arrow.click();
      }
    }
  }

  @Test(description = "choosing dates from mmt ddl")
  public void mmtDatePicker() throws InterruptedException {
    Thread.sleep(1000);
    driver.navigate().refresh();
    Thread.sleep(2000);
    String inputDate = "28-July";
    String[] dateSelect = inputDate.split("-");
    String month = dateSelect[1];
    String dt= dateSelect[0];
    System.out.println(month);
    System.out.println(dt);

    WebElement roundTrip = driver.findElement(By.xpath("//*[@class='fswTabs latoBlack greyText']/li[@data-cy='roundTrip']"));
    Actions axn = new Actions(driver);
    axn.moveToElement(roundTrip).click().build().perform();
    Thread.sleep(2000);
    WebElement calLocator = driver.findElement(By.xpath("(//*[@class='lbl_input latoBold appendBottom10'])[1]"));
    calLocator.click();

    WebElement nextBtn = driver.findElement(By.xpath("//*[@class='DayPicker-NavButton DayPicker-NavButton--next']"));
    Thread.sleep(2000);

    List<WebElement> months = driver.findElements(By.xpath("//*[@class='DayPicker-Months']//div[@class='DayPicker-Month']"));

    String[] monthName;
    String monthHeader;

    List<WebElement> days = driver.findElements(By.xpath("//*[@class='DayPicker-Day']//*[@class='dateInnerCell']"));

    String day;
    int flag = 0;

    int z = 0;
    for (int i = 0; i < 6; i++) {
      Thread.sleep(2000);

      for (int j = 0; j < months.size(); j++) {
        z = j + 1;
        monthHeader = driver.findElement(By.xpath("//*[@class='DayPicker-Months']//*[@class='DayPicker-Month'][" + z + "]")).getText();
        monthName = monthHeader.split("2");

        System.out.println(monthName[0]);

        if (monthName[0].contains(month)) {
          System.out.println("Month is found");
          flag = 1;
          break;
        }
      }

      if (flag == 0) {
        nextBtn.click();
      }
    }

    if (flag == 0) {
      System.out.println("Month is not found");
    }

    else {
      System.out.println("Month is selected, Now choose date");
      List<WebElement> daysOfMonth = driver.findElements(By.xpath("//*[@class='DayPicker-Months']//*[@class='DayPicker-Month'][" + z + "]//*[@class='DayPicker-Body']//div[@class='dateInnerCell']"));
      String dayTobeSelected;

      for (int u = 0; u < daysOfMonth.size(); u++) {
        dayTobeSelected = daysOfMonth.get(u).getText();

        if (dayTobeSelected.equalsIgnoreCase(dt)) {
          daysOfMonth.get(u).click();
          break;
        }
      }
    }
  }
}
