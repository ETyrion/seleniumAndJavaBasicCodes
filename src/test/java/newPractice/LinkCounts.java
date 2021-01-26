package newPractice;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LinkCounts {
  WebDriver driver;

  @BeforeTest
  public void launchURL() {
    System.setProperty("webdriver.chrome.driver", "E:\\AutomationPractice\\SeleniumPractice\\chromedriver_win32\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.get("https://rahulshettyacademy.com/AutomationPractice/");
  }

  @Test
  public void countLinks() throws InterruptedException {
    List<WebElement> links = driver.findElements(By.tagName("a"));
    int totalLinks = links.size();
    System.out.println(totalLinks);
    WebElement footer = driver.findElement(By.xpath("//*[@id='gf-BIG']"));
    System.out.println(footer.findElements(By.tagName("a")).size());

    WebElement col1 = driver.findElement(By.xpath("(//*[@id='gf-BIG']/table/tbody/tr/td)[1]"));
    List<WebElement> column1Links = col1.findElements(By.tagName("a"));
    int column1LinksSize = column1Links.size();
    System.out.println(column1LinksSize);

    WebElement col2 = driver.findElement(By.xpath("(//*[@id='gf-BIG']/table/tbody/tr/td)[2]"));
    List<WebElement> column2Links = col2.findElements(By.tagName("a"));
    int column2LinksSize = column2Links.size();
    System.out.println(column2LinksSize);
    Actions axn = new Actions(driver);

    for(int i=0; i<column2LinksSize; i++)
    {
      axn.moveToElement(column2Links.get(i)).keyDown(Keys.CONTROL).click().build().perform();
      Thread.sleep(2000);
    }

    Set<String> title = driver.getWindowHandles();
    Iterator<String> itr = title.iterator();

    while(itr.hasNext())
    {
      driver.switchTo().window(itr.next());
      System.out.println(driver.getTitle());
    }
  }
}
