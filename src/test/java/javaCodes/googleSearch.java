package javaCodes;

import java.util.List;
import java.util.concurrent.TimeUnit;

import com.sun.org.apache.bcel.internal.generic.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

public class googleSearch {
  @Test
  public void search() throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "E:\\AutomationPractice\\SeleniumPractice\\chromedriver_win32\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.get("http://demo.guru99.com/test/guru99home/");
    Thread.sleep(2000);
    List<WebElement> iframeele= driver.findElements(By.tagName("iframe"));
    System.out.println(iframeele.size());
    driver.manage().timeouts().implicitlyWait(300, TimeUnit.MILLISECONDS);
    driver.switchTo().frame("a077aa5e");
    //driver.findElement(By.xpath("//*[@src='Jmeter720.png']")).click();
    driver.switchTo().defaultContent();
    driver.manage().timeouts().implicitlyWait(300, TimeUnit.MILLISECONDS);
    driver.switchTo().frame("flow_close_btn_iframe");
    WebElement close = driver.findElement(By.xpath("//*[@id='closeBtn']"));
    close.click();
    driver.switchTo().defaultContent();
    WebElement ele= driver.findElement(By.xpath("//*[@id='awf_field-91977689']"));

    /*Select sel = new Select(driver.findElement(By.xpath("//*[@id='awf_field-91977689']")));
    List<WebElement> options = sel.getOptions();
    String selectedOption="";
    for(int i=0; i<options.size(); i++)
    {
      sel.selectByIndex(i);
      driver.manage().timeouts().implicitlyWait(200, TimeUnit.MILLISECONDS);
      selectedOption= ele.getText();
    }*/

  }
}
