package newPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DynamicDDL {

  @Test
  public void ddl() throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "E:\\AutomationPractice\\SeleniumPractice\\chromedriver_win32\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.get("https://www.spicejet.com/");
    driver.manage().window().maximize();
    WebElement arrow = driver.findElement(By.xpath("//*[@id='ctl00_mainContent_ddl_originStation1_CTXTaction']"));
    arrow.click();
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    WebElement ddsrc = driver.findElement(By.xpath("(//a[@value='KNU'])[1]"));
    //Select sel = new Select(arrow);
    //sel.selectByValue("BUP");

    ddsrc.click();

    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    WebElement dest = driver.findElement(By.xpath("(//a[@value='TRV'])[2]"));
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    dest.click();
    Thread.sleep(3000);

    WebElement nextMonth = driver.findElement(By.xpath("//*[@class='ui-datepicker-next ui-corner-all']"));
    List<WebElement> month = driver.findElements(By.xpath("//*[@id='ui-datepicker-div']//*[@class='ui-datepicker-month']"));
    for (int i = 0; i < month.size(); i++) {
      System.out.println(month.get(i).getText());
      Thread.sleep(3000);
      if (month.get(i).getText().equalsIgnoreCase("June")) {
        System.out.println("June is found");
      }
    }
  }

  @Test
  public void flightCode() throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "E:\\AutomationPractice\\SeleniumPractice\\chromedriver_win32\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    //driver.get("https://www.cleartrip.com/");
    //driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    driver.get("https://rahulshettyacademy.com/AutomationPractice/");
    driver.findElement(By.xpath("//*[@id='autocomplete']")).sendKeys("pa");
    Thread.sleep(3000);
    int flag = 0;
    List<WebElement> options = driver.findElements(By.xpath("//*[@class='ui-menu-item']"));
    for (int i = 0; i < options.size(); i++) {
      if (options.get(i).getText().equalsIgnoreCase("Paraguay")) {
        options.get(i).click();
        flag = 1;
      }
    }
    if (flag == 0) {
      System.out.println("Not found");
    } else
      System.out.println("found");
  }

  @Test
  public void googleSearch() throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "E:\\AutomationPractice\\SeleniumPractice\\chromedriver_win32\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.get("https://www.google.com/");
    driver.findElement(By.xpath("//*[@name='q']")).sendKeys("ip");
    Thread.sleep(3000);
    List<WebElement> options = driver.findElements(By.xpath("//*[@class='sbct']"));
    for (int i = 0; i < options.size(); i++) {
      if (options.get(i).getText().equalsIgnoreCase("iphone 12")) {
        options.get(i).click();
        System.out.println("element found");
        break;
      }
    }
  }

  @Test
  public void gmailLink() {
    System.setProperty("webdriver.chrome.driver", "E:\\AutomationPractice\\SeleniumPractice\\chromedriver_win32\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.get("https://www.google.com/");
    WebElement gmail = driver.findElement(By.xpath("(//*[@class='gb_h gb_i'])[1]"));
    gmail.click();
  }

  @Test
  public void autoSuggest() throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "E:\\AutomationPractice\\SeleniumPractice\\chromedriver_win32\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    int flag = 0;
    WebElement search = driver.findElement(By.id("autosuggest"));
    search.sendKeys("pa");
    Thread.sleep(3000);
    List<WebElement> options = driver.findElements(By.xpath("//*[@class='ui-menu-item']"));
    for (WebElement option : options) {
      Thread.sleep(3000);
      String country = option.getText();
      System.out.println(country);
      if (country.equalsIgnoreCase("Nepal")) {
        option.click();
        flag = 1;
        break;
      }
    }

    if (flag == 0) {
      System.out.println("Not found");
    } else {
      System.out.println("found");
    }
  }

}
