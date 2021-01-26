package newPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class handlingAlerts {

  @Test
  public void alertTest() throws InterruptedException {
    System.setProperty("webdriver.chrome.driver","E:\\AutomationPractice\\SeleniumPractice\\chromedriver_win32\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.get("https://demoqa.com/alerts");
    /*driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.findElement(By.xpath("//*[@id='alertButton']")).click();
    Thread.sleep(3000);
    Alert al= driver.switchTo().alert();
    String alertMsg= al.getText();
    System.out.println(alertMsg);
    al.accept();
    driver.switchTo().defaultContent();
    driver.findElement(By.xpath("//*[@id='timerAlertButton']")).click();
    WebDriverWait wait= new WebDriverWait(driver, 6);
    wait.until(ExpectedConditions.alertIsPresent());
    Alert alert2= driver.switchTo().alert();
    String msg2= alert2.getText();
    System.out.println(msg2);
    alert2.accept();
    driver.switchTo().defaultContent();

    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    driver.findElement(By.xpath("//*[@id='confirmButton']")).click();
    Alert alt3= driver.switchTo().alert();
    alt3.dismiss();

    driver.switchTo().defaultContent();*/

    Thread.sleep(4000);
    driver.manage().window().maximize();
    WebElement alt4= driver.findElement(By.xpath("//*[@id='promtButton']"));
    alt4.click();
    Thread.sleep(4000);
    Alert alert4 = driver.switchTo().alert();

    alert4.sendKeys("Alert box is here");
    Thread.sleep(3000);

    alert4.accept();

  }
}
