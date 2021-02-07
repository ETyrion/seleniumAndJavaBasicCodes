package newPractice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SortingWebTable {

  @Test
  public void sortTable() throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "E:\\AutomationPractice\\SeleniumPractice\\chromedriver_win32\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.get("https://www.w3schools.com/howto/howto_js_sort_table.asp");
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    WebElement sortBtn = driver.findElement(By.xpath("//*[@class='w3-btn w3-dark-grey']"));
    //sortBtn.click();
    Thread.sleep(3000);
    List<WebElement> countryName = driver.findElements(By.xpath("//*[@id='myTable']/tbody/tr/td[1]"));
    ArrayList<String> sortedCountryList = new ArrayList<>();
    for(int i=0; i<countryName.size(); i++)
    {
      System.out.println(countryName.get(i).getText());
    }

    ArrayList<String> obtainedCountryList = new ArrayList<>();

    for(int i=0; i<countryName.size(); i++)
    {
      obtainedCountryList.add(countryName.get(i).getText());
    }

    for(int j=0; j<countryName.size(); j++)
    {
      sortedCountryList.add(countryName.get(j).getText());
    }
    Collections.sort(sortedCountryList);

    Assert.assertEquals(sortedCountryList, obtainedCountryList);
  }
}
