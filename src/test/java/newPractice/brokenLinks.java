package newPractice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class brokenLinks {

  @Test
  public void brokenLinksCode() throws IOException {
    System.setProperty("webdriver.chrome.driver","E:\\AutomationPractice\\SeleniumPractice\\chromedriver_win32\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    String url= "";
    HttpURLConnection huc = null;
    int respCode = 200;
    String homePage = "http://www.zlti.com";
    int brokenCount=0;
    int correctCount=0;
    int anotherdomain=0;
    driver.get("https://www.zlti.com/");
    List<WebElement> links_list = driver.findElements(By.tagName("a"));
    int totaLinks= links_list.size();
    System.out.println("Total links on the page are " +totaLinks);
    Iterator<WebElement> itr = links_list.iterator();
    while(itr.hasNext())
    {
      url = itr.next().getAttribute("href");
      System.out.println(url);
      if(url == null || url.isEmpty())
      {
       System.out.println("URL is empty");
      }
      if(!url.startsWith(homePage)){
        anotherdomain++;
        continue;
      }

      try{
        huc =(HttpURLConnection)(new URL(url).openConnection());
        huc.setRequestMethod("HEAD");
        huc.connect();
        respCode = huc.getResponseCode();
        if(respCode>=400)
        {
          //System.out.println("link is broken: "+url);
          brokenCount++;

        }
        else{
          System.out.println("Valid link");
          correctCount++;
        }
      } catch (MalformedURLException e) {
        e.printStackTrace();
      }
    }

    driver.quit();
    System.out.println("ANother domain url are " +anotherdomain);
    System.out.println("broken urls are "+brokenCount);
    System.out.println("correct urls are "+correctCount);
  }
  WebElement driver;
  @BeforeTest
  public void openURL() throws InterruptedException {
    System.setProperty("webdriver.chrome.driver","E:\\AutomationPractice\\SeleniumPractice\\chromedriver_win32\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.get("https://www.softwaretestingmaterial.com");
    Thread.sleep(4000);
  }


  @Test
  public void brokenLinksCodeTwo() throws IOException {
    System.setProperty("webdriver.chrome.driver","E:\\AutomationPractice\\SeleniumPractice\\chromedriver_win32\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.get("https://www.softwaretestingmaterial.com");
    int brokenLinksCount=0;
    int statuscode=0;
    int activeLinks=0;
    List<WebElement> totalLinksonPage = driver.findElements(By.tagName("a"));
    int totalLinks = totalLinksonPage.size();
     for(int i=0;i<50;i++)
     {
       WebElement ele = totalLinksonPage.get(i);
       String url = ele.getAttribute("href");
       URL link = new URL(url);
       HttpURLConnection huc = (HttpURLConnection) link.openConnection();
       huc.connect();
       statuscode = huc.getResponseCode();
       if(statuscode == 200)
       {
         //System.out.println("Link is not broken "+url);
         activeLinks++;
       }
       else
       {
         //System.out.println("Link is broken "+url);
         brokenLinksCount++;
       }
     }
     driver.quit();
     System.out.println("Total active links are "+activeLinks);
     System.out.println("Total unused links are "+brokenLinksCount);
  }

  @Test
  public void brokenLinksTest() throws IOException {
    List<WebElement> links= driver.findElements(By.tagName("a"));
    int totalLinks = links.size();
    int statusCode=0;
    int brokenLinks=0;
    int activeLinks=0;
    for(int i=0; i<totalLinks; i++)
    {
      WebElement ele=links.get(i);
      String url= ele.getAttribute("href");
      URL newUrl = new URL(url);
      HttpURLConnection huc = (HttpURLConnection) newUrl.openConnection();
      huc.connect();
      statusCode= huc.getResponseCode();
      if(statusCode==200)
      {
        activeLinks++;
      }
      System.out.print(totalLinks);
    }
  }

}
