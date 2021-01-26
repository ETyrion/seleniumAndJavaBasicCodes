package newPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RadioButtonClick {
  String url = "https://www.rahulshettyacademy.com/AutomationPractice/";
  ChromeDriver driver;

  @Test
  public void rdbtn() throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "E:\\AutomationPractice\\SeleniumPractice\\chromedriver_win32\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.get(url);
    List<WebElement> rdbtn= driver.findElements(By.xpath("//*[@class='radioButton']"));
    //WebElement radio = driver.findElement(By.xpath("//*[@id='radio-btn-example']/fieldset/label"));
    int size= rdbtn.size();
    System.out.println(size);

    for(int i=0; i< size; i++)
    {
      rdbtn.get(i).click();
      Thread.sleep(1000);
    }


  }
}
