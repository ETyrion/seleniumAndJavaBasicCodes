package newPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class HeadlessTesting {
  @Test
  public void headLesstest() {
    System.setProperty("webdriver.chrome.driver", "E:\\AutomationPractice\\SeleniumPractice\\chromedriver_win32\\chromedriver.exe");
    //WebDriver driver = new HtmlUnitDriver();
    ChromeOptions option = new ChromeOptions();
    option.addArguments("headless");
    WebDriver driver = new ChromeDriver(option);
    driver.get("https://demoqa.com/automation-practice-form");
    driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
    driver.manage().window().maximize();
    //driver.findElement(By.xpath("//*[@class='row']//*[@id='firstName']")).sendKeys("ABC");
    System.out.print(driver.getTitle());
    //driver.findElement(By.xpath("//*[@id='hobbies-checkbox-1']")).click();
  }

  @Test
  public void htmlUnit() {
    System.setProperty("webdriver.chrome.driver", "E:\\AutomationPractice\\SeleniumPractice\\chromedriver_win32\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.get("https://demoqa.com/automation-practice-form");
    driver.manage().deleteAllCookies();
    System.out.print(driver.getTitle());
  }
}
