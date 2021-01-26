package newPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class iframeTest {
  WebDriver driver;
  @Test
  public static void iframeTestMethod(){
    System.setProperty("webdriver.chrome.driver", "E:\\AutomationPractice\\SeleniumPractice\\chromedriver_win32\\chromedriver.exe");
   // WebDriver driver = new ChromeDriver();
    String url="https://demoqa.com/nestedframes";
    WebDriver driver = new ChromeDriver();
    driver.get(url);
    List<WebElement> frames= driver.findElements(By.tagName("iframe"));
    int total = frames.size();
    System.out.println(total);
    driver.switchTo().frame("frame1");
    driver.switchTo().frame(0);
  }

  @Test
  public void getTextFrames() throws InterruptedException
  {System.setProperty("webdriver.chrome.driver", "E:\\AutomationPractice\\SeleniumPractice\\chromedriver_win32\\chromedriver.exe");
   driver = new ChromeDriver();
    driver.get("https://demoqa.com/frames");
    Thread.sleep(3000);
    driver.switchTo().frame("frame1");
    Thread.sleep(3000);
    String txt= driver.findElement(By.xpath("//*[@id='sampleHeading']")).getText();
    System.out.println(txt);

  }

  @Test
  public void getElementsTest()
  {
    System.setProperty("webdriver.chrome.driver", "E:\\AutomationPractice\\SeleniumPractice\\chromedriver_win32\\chromedriver.exe");
    // WebDriver driver = new ChromeDriver();
    String url="http://demo.guru99.com/test/guru99home/";
    driver = new ChromeDriver();
    driver.get(url);
    driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
    List<WebElement> frames= driver.findElements(By.tagName("iframe"));
    System.out.println(frames.size());
    driver.manage().window().maximize();
    System.out.println(driver.findElement(By.xpath("//*[@id='flow_close_btn_iframe']")).getText());
    driver.switchTo().frame(1);
    

  }
}
