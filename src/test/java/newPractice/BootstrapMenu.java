package newPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BootstrapMenu {
  String url = "https://www.jquery-az.com/boots/demo.php?ex=63.0_2";
  WebDriver driver;

  @Test
  public void handleBootstrap() {
    System.setProperty("webdriver.chrome.driver", "E:\\AutomationPractice\\SeleniumPractice\\chromedriver_win32\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.get(url);
    driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
    driver.manage().window().maximize();
    driver.findElement(By.xpath("//button[@type='button']")).click();
    List<WebElement> ele= driver.findElements(By.xpath("//*[@class='multiselect-container dropdown-menu']//li//a//label"));
    String val="";
    for(int i=0;i<ele.size();i++)
    {
      val=ele.get(i).getText();
      ele.get(i).click();
    }
  }
}
