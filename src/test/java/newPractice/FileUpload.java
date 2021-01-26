package newPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FileUpload {

  String path = "E:\\download.jpg";

  @Test
  public void upload() throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "E:\\AutomationPractice\\SeleniumPractice\\chromedriver_win32\\chromedriver.exe");

    //ChromeOptions option= new ChromeOptions();
    //option.setHeadless(true);
    //WebDriver driver = new ChromeDriver(option);
    //WebDriver driver = new HtmlUnitDriver();
    WebDriver driver = new ChromeDriver();
    driver.get("http://demo.guru99.com/test/upload/");
    Thread.sleep(400);
    driver.manage().window().maximize();
    driver.findElement(By.xpath("//*[@id='uploadfile_0']")).sendKeys(path);
    Thread.sleep(500);
    driver.findElement(By.xpath("//*[@id='submitbutton']")).click();
  }
}
