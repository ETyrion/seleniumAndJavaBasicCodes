package newPractice;


import javax.swing.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DoubleClickTest {

  @Test
  public void doubleTest()
  {
    System.setProperty("webdriver.chrome.driver", "E:\\AutomationPractice\\SeleniumPractice\\chromedriver_win32\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.get("http://demo.guru99.com/test/simple_context_menu.html");

    WebElement dc= driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
    Actions axn= new Actions(driver);
    axn.doubleClick(dc).build().perform();
  }

}
