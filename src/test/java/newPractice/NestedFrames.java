package newPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NestedFrames {
  WebDriver driver;

  @BeforeTest
  public void launchURL() {
    System.setProperty("webdriver.chrome.driver", "E:\\AutomationPractice\\SeleniumPractice\\chromedriver_win32\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.get("https://the-internet.herokuapp.com/nested_frames");
  }

  @Test
  public void printMiddle() throws InterruptedException {
    driver.switchTo().frame(0);
    Thread.sleep(2000);
    driver.switchTo().frame(1);
    String txt = driver.findElement(By.id("content")).getText();
    System.out.println(txt);

  }
}
