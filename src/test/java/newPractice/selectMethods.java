package newPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class selectMethods {
  public static String url="https://demoqa.com/select-menu";
  WebDriver driver;
  //WebDriverWait wait= new WebDriverWait(driver, 3);

  @BeforeTest
  public void launchBrowser()
  {
    System.setProperty("webdriver.chrome.driver","E:\\AutomationPractice\\SeleniumPractice\\chromedriver_win32\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.get(url);
    driver.manage().timeouts().implicitlyWait(5000,TimeUnit.MILLISECONDS);
  }

  @Test
  public void singleSelect()
  {
    driver.manage().timeouts().implicitlyWait(300, TimeUnit.MILLISECONDS);
    WebElement singleSelect = driver.findElement(By.xpath("//*[@id='oldSelectMenu']"));
    //singleSelect.click();
    Select sel= new Select(singleSelect);
    sel.selectByValue("red");
    String singleselVal = singleSelect.getText();
    System.out.println(singleselVal);
    driver.manage().timeouts().implicitlyWait(300, TimeUnit.MILLISECONDS);
    sel.selectByIndex(3);
    driver.manage().timeouts().implicitlyWait(300, TimeUnit.MILLISECONDS);
    sel.selectByVisibleText("Aqua");
  }

  @Test
  public void multiSelect() throws InterruptedException {
    WebElement multi = driver.findElement(By.id("cars"));
    driver.manage().timeouts().implicitlyWait(400,TimeUnit.MILLISECONDS);

    Select sel = new Select(multi);
    List<WebElement> options = sel.getOptions();
    for(int i=0; i< options.size(); i++)
    {
      System.out.println(options.get(i).getText());
    }
    if(sel.isMultiple())
    {
      sel.selectByVisibleText("Saab");
      Thread.sleep(200);
      sel.selectByIndex(1);
    }
  }

  @Test
  public void multipleSelect(){
    WebElement mselect = driver.findElement(By.xpath("(//*[@class=' css-1hwfws3'])[3]"));
    //mselect.click();
    Select sel = new Select(mselect);
    List<WebElement> options = sel.getOptions();
    for(int i=0;i<options.size();i++)
    {
      System.out.println(options.get(i).getText());
    }
  }

  @Test
  public void selectTitle() throws InterruptedException {
    WebElement menu = driver.findElement(By.xpath("(//div[@id='selectMenuContainer']//*[@class=' css-2b097c-container'])[1]"));
    Thread.sleep(200);
    menu.click();
    //List<WebElement> options = driver.findElements(menu)
  }

}
