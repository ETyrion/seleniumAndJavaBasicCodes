package newPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class datePicker {
  WebDriver driver;
@Test
  public void calendarDate() throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "E:\\AutomationPractice\\SeleniumPractice\\chromedriver_win32\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.get("https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html");
    driver.findElement(By.xpath("(//*[@class='input-group-addon'])[1]")).click();
    Thread.sleep(1000);
   // driver.findElement(By.xpath("(//*[@class='today'])[1]")).click();
    driver.findElement(By.xpath("(//*[@class='prev'])[1]")).click();
    Thread.sleep(1000);
    String month;
    String[] mth;
    //System.out.println(mth[0]);
    for(int i=0;i <12; i++)
    {
      driver.findElement(By.xpath("(//*[@class='prev'])[1]")).click();
      Thread.sleep(1000);
      month=driver.findElement(By.xpath("(//*[@class='datepicker-switch'])[1]")).getText();
      mth= month.split(" ");
        System.out.println(mth[0]);
        if(mth[0].equalsIgnoreCase("March"))
        {
          for(int j=1; j<32; j++) {
            System.out.println(driver.findElement(By.xpath("(//*[@class='day'])["+j+"]")).getText());
            Thread.sleep(1000);
          }
        }

    }

  
  }
}
