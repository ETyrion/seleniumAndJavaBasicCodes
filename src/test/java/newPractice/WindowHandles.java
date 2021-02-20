package newPractice;

import static java.lang.Thread.*;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WindowHandles {
  String url= "http://www.popuptest.com/goodpopups.html";
  String tqa="https://www.toolsqa.com/";
  WebDriver driver;

  @BeforeTest
  public void launchBrowser()
  {
    System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver_win32\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.get(url);
    //driver.get(tqa);
    driver.manage().timeouts().implicitlyWait(300, TimeUnit.MILLISECONDS);
  }

  @Test
  public void windowTest() throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver_win32\\chromedriver.exe");
    //WebDriver driver = new ChromeDriver();
    //driver.get("http://www.popuptest.com/goodpopups.html");
    driver.findElement(By.xpath("//*[contains(text(),'Good PopUp #1')]")).click();
    Set<String> handler = driver.getWindowHandles();
    Iterator<String> it = handler.iterator();
    String parentId = it.next();
    String childId = it.next();
    driver.switchTo().window(childId);
    System.out.println(driver.getTitle());
    driver.close();
    driver.switchTo().window(parentId);
    System.out.println(driver.getTitle());
    sleep(200);

    driver.findElement(By.xpath("//*[contains(text(),'Good PopUp #2')]")).click();
    Set<String> str2= driver.getWindowHandles();
    Iterator<String> itr3= str2.iterator();
    itr3.next();

    String ch2= itr3.next();
    driver.switchTo().window(ch2);
    System.out.println(driver.getTitle());
    driver.switchTo().window(parentId);
    Thread.sleep(300);
    System.out.println(driver.getTitle());

  }

  @Test
  public void windowHandles() throws InterruptedException {
      driver.findElement(By.xpath("//*[contains(text(),'Good PopUp #1')]")).click();
      Set<String> handles= driver.getWindowHandles();
      Iterator<String> itr = handles.iterator();
      String pId= itr.next();
      String childId= itr.next();
      driver.switchTo().window(childId);
      sleep(5000);
      System.out.println(driver.getTitle());
      driver.close();
      driver.switchTo().window(pId);
      System.out.println(driver.getTitle());
      sleep(3000);

      driver.findElement(By.xpath("//*[contains(text(),'Good PopUp #2')]")).click();
      Set<String> wh= driver.getWindowHandles();
      Iterator<String> itr2 = wh.iterator();
      //String pid2 = itr2.next();
      String childid2 = itr2.next();
      driver.switchTo().window(childid2);
      sleep(3000);
      System.out.println(driver.getTitle());
      driver.close();
      driver.switchTo().window(pId);
      System.out.println(driver.getTitle());
  }

  @Test
  public void testQAWindow() throws InterruptedException {
    Thread.sleep(3000);
    WebDriverWait w1= new WebDriverWait(driver, 6);
    driver.manage().window().maximize();
    WebElement fb= driver.findElement(By.xpath("//div[@role='banner']//div[1]//div[3]//div[1]//*[@class='facebook']"));
    w1.until(ExpectedConditions.elementToBeClickable(fb));
    fb.click();
    Thread.sleep(3000);
    Set<String> wHandles = driver.getWindowHandles();
    Iterator<String> itr= wHandles.iterator();
    String pid= itr.next();
    String cid= itr.next();
    driver.switchTo().window(cid);
    System.out.println(driver.getTitle());
    driver.close();
    driver.switchTo().window(pid);
    System.out.println(driver.getTitle());
    System.out.println("Parent Id 1 is :-> " +pid);

    WebElement twitter= driver.findElement(By.xpath("//div[@role='banner']//div[1]//div[3]//div[1]//*[@class='twitter']"));
    w1.until(ExpectedConditions.elementToBeClickable(twitter));
    twitter.click();
    Set<String> set2= driver.getWindowHandles();
    Iterator<String> itr2= set2.iterator();
    String twitterPid= itr2.next();
    String twitterCid = itr2.next();
    driver.switchTo().window(twitterCid);
    Thread.sleep(3000);
    System.out.println(driver.getTitle());
    driver.close();
    driver.switchTo().window(pid);
    System.out.println("Parent Id 1 is :-> " +twitterPid);
    driver.close();

  }
}
