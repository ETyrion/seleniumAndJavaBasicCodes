package newPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class dynamicTables {
  String tbl = "https://www.seleniumeasy.com/test/table-search-filter-demo.html";
  WebDriver driver;

  @BeforeTest
  public void openURL() throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "E:\\AutomationPractice\\SeleniumPractice\\chromedriver_win32\\chromedriver.exe");
    driver = new ChromeDriver();
    //driver.get("https://www.w3schools.com/html/html_tables.asp");
    driver.get(tbl);
    Thread.sleep(3000);
  }

  @Test
  public void table()
  {
    List<WebElement> rows = driver.findElements(By.xpath("//div[@class='row']//*[@id='task-table']//tr"));
    List<WebElement> col = driver.findElements(By.xpath("//div[@class='row']//*[@id='task-table']//tr[1]//td"));
    String data;
    for(int i=1;i<rows.size();i++)
    {
     for(int j=1; j<col.size();j++)
     {
       data=driver.findElement(By.xpath("//div[@class='row']//*[@id='task-table']//tr["+i+"]//td["+j+"]")).getText();
       System.out.print(" "+data+" ");
     }
     System.out.println(" ");
    }
  }

  @Test
  public void dynamicTableHandle() throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "E:\\AutomationPractice\\SeleniumPractice\\chromedriver_win32\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.get("https://www.w3schools.com/html/html_tables.asp");
    Thread.sleep(3000);
    driver.findElement(By.xpath("//*[@id='customers']/tbody/tr[2]"));
    //List<WebElement> rows= driver.findElements(By.xpath("//*[@id='customers']/tbody/tr"));
    List<WebElement> cell = driver.findElements(By.xpath("//*[@id='customers']/tbody/tr/td"));
    String cellVal;

    for (int i = 0; i < cell.size(); i++) {
      cellVal = cell.get(i).getText();
      System.out.println(cellVal);
    }

  }

  @Test
  public void tableTest() throws InterruptedException {
    WebElement taskTbl = driver.findElement(By.xpath("//*[@id='task-table']//tbody/tr"));
    List<WebElement> ele = driver.findElements(By.xpath("//*[@id='task-table']//tbody/tr"));
    List<WebElement> col = driver.findElements(By.xpath("//*[@id='task-table']//tbody/tr[1]/td"));
    String colval;
    //WebElement col=driver.findElements(By.xpath(""))
    for (int i = 1; i <= ele.size(); i++) {
      for (int j = 1; j <= col.size(); j++) {
        //Thread.sleep(3000);
        colval = driver.findElement(By.xpath("//*[@id='task-table']//tbody/tr[" + i + "]/td[" + j + "]")).getText();
        System.out.println(colval);
      }

    }

  }
}
