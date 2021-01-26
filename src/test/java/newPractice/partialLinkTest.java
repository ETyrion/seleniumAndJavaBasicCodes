package newPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class partialLinkTest {
  public static String url="http://demo.guru99.com/test/link.html";
  @Test
  public void openLink()
  {
    System.setProperty("webdriver.chrome.driver", "E:\\AutomationPractice\\SeleniumPractice\\chromedriver_win32\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.get(url);
    driver.findElement(new By.ByLinkText("click")).click();
  }
}
