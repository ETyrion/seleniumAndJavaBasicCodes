package newPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ModalDialogues {
  @Test
  public static void modal() throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "E:\\AutomationPractice\\SeleniumPractice\\chromedriver_win32\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.get("https://demoqa.com/modal-dialogs");
    WebDriverWait wait = new WebDriverWait(driver, 5);
    WebElement smallModal = driver.findElement(By.xpath("//*[@id='showSmallModal']"));
    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='showSmallModal']")));
    smallModal.click();
    Thread.sleep(3000);
    driver.switchTo().activeElement();
    Thread.sleep(4000);
    System.out.print(driver.findElement(By.xpath("//*[@class='modal-body']")).getText());
    driver.findElement(By.xpath("//*[@id='closeSmallModal']")).click();

    WebElement largeModal = driver.findElement(By.xpath("//*[@id='showLargeModal']"));
    driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
    largeModal.click();
    driver.switchTo().activeElement();
    Thread.sleep(3000);
    System.out.println(driver.findElement(By.xpath("//div[@class='modal-content']//div[2]//*[@class]")).getText());
    driver.navigate().forward();

  }
}
