package newPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class hoverElementandSlider {
  WebDriver driver;
  public static String url = "https://demoqa.com/menu/";
  public static String slider = "https://demoqa.com/slider/";
  public static String spiceJet="https://www.spicejet.com/";

  @BeforeTest
  public void openSite() {
    System.setProperty("webdriver.chrome.driver", "E:\\AutomationPractice\\SeleniumPractice\\chromedriver_win32\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.get(spiceJet);
  }

  @Test
  @Ignore
  public void moveToElement() {
    WebElement mn2 = driver.findElement(new By.ByLinkText("Main Item 2"));
    Actions axn = new Actions(driver);
    axn.moveToElement(mn2).build().perform();
    WebDriverWait wait = new WebDriverWait(driver, 2);
    WebElement sublist = wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByLinkText("SUB SUB LIST »")));

    axn.moveToElement(sublist).perform();
    WebElement subSubList = wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByLinkText("Sub Sub Item 2")));
    axn.moveToElement(subSubList);
    String expectedTest = driver.findElement(new By.ByLinkText("Sub Sub Item 2")).getText();
    Assert.assertEquals(expectedTest, "Sub Sub Item 2");
  }

  @Test
  @Ignore
  public void sliderTest() {
    WebDriverWait wait = new WebDriverWait(driver, 3);
    WebElement slider = driver.findElement(By.xpath("//*[@class='range-slider range-slider--primary']"));
    Actions axn = new Actions(driver);
    axn.dragAndDropBy(slider, -10, 0).build().perform();
    //slider.click();
  }

  @Test
  public void spiceJetTest() throws InterruptedException {
    WebDriverWait wait= new WebDriverWait(driver,5);
    WebElement adons = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Add-Ons')]")));
    WebElement addons= driver.findElement(By.xpath("//*[contains(text(),'Add-Ons')]"));
    Actions axn= new Actions(driver);
    axn.moveToElement(adons).perform();
    Thread.sleep(300);
    WebElement clickLink = driver.findElement(By.xpath("//*[contains(text(),'You 1st')]"));
    axn.moveToElement(clickLink).click().build().perform();
  }

}
