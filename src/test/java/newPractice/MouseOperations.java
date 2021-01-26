package newPractice;

import static java.lang.Thread.*;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MouseOperations {
  WebDriver driver;
  String webUrl = "https://demoqa.com/webtables";
  String drag = "https://demoqa.com/droppable";
  String mouseActions = "http://demo.guru99.com/test/simple_context_menu.html";
  String amazonURL = "https://www.amazon.in/";

  @BeforeTest
  public void launchBrowser() {
    System.setProperty("webdriver.chrome.driver", "E:\\AutomationPractice\\SeleniumPractice\\chromedriver_win32\\chromedriver.exe");
    driver = new ChromeDriver();
    //driver.navigate().to(webUrl);
    //driver.navigate().to(mouseActions);
    driver.get(amazonURL);
  }

  @Test
  public void launchbrowser() {
    WebElement src = driver.findElement(By.xpath("//*[@id='draggable']"));
    WebElement dest = driver.findElement(By.cssSelector("div[id=droppable]"));
    //driver.findElement(By.xpath(""));
    Actions axn = new Actions(driver);
    axn.dragAndDrop(src, dest).build().perform();
  }

  @Test
  public void tableHandle() {
    List<WebElement> firstrow = driver.findElements(By.xpath("//*[@class='ReactTable -striped -highlight']/div[1]/div//*[@class='rt-th rt-resizable-header -cursor-pointer']"));
    String rowHeaders = "";
    List<WebElement> rows = driver.findElements(By.xpath("//*[@class='rt-tbody']/div"));
    String celldata = "";
    List<WebElement> cdata = driver.findElements(By.xpath("//*[@class='rt-tbody']/div//div[@class='rt-td']"));

    for (int i = 0; i < firstrow.size(); i++) {
      rowHeaders = firstrow.get(i).getText();
      System.out.print(" " + rowHeaders + " ");
    }

    for (int j = 0; j < cdata.size(); j++) {
      celldata = cdata.get(j).getText();
      System.out.print(" " + celldata + " ");
    }
  }

  @Test
  public void mouseOperations() throws InterruptedException {
    WebDriverWait wait = new WebDriverWait(driver, 5);
    //WebElement rbtn= "//*[@class='context-menu-one btn btn-neutral']";
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='context-menu-one btn btn-neutral']")));
    Actions axn = new Actions(driver);
    axn.contextClick(driver.findElement(By.xpath("//*[@class='context-menu-one btn btn-neutral']"))).perform();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'Edit')])[2]")));
    driver.findElement(By.xpath("(//*[contains(text(),'Edit')])[2]")).click();
    sleep(5000);
    Alert box = driver.switchTo().alert();
    sleep(3000);
  }

  @Test
  public void guruTest() {
    //driver.get("http://demo.guru99.com/test/simple_context_menu.html");
    driver.manage().window().maximize();

// Right click the button to launch right click menu options
    Actions action = new Actions(driver);

    WebElement link = driver.findElement(By.cssSelector(".context-menu-one"));
    action.contextClick(link).perform();
// Click on Edit link on the displayed menu options
    WebElement element = driver.findElement(By.cssSelector(".context-menu-icon-copy"));
    element.click();
// Accept the alert displayed
//driver.switchTo().alert().accept();
// Closing the driver instance
//driver.quit();
  }

  @Test
  public void amazonTest() throws InterruptedException {
    WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));

    Actions axn = new Actions(driver);
    axn.moveToElement(searchbox).click().keyDown(Keys.SHIFT).sendKeys("iphone").build().perform();
    axn.keyDown(Keys.ARROW_DOWN).build().perform();
  }
}
