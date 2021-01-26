package newPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropdownLooping {
  @Test(description = "Verify that >9 passengers are not allowed")
  public void ddLoop() {
    System.setProperty("webdriver.chrome.driver", "E:\\AutomationPractice\\SeleniumPractice\\chromedriver_win32\\chromedriver.exe");

    WebDriver driver = new ChromeDriver();
    driver.get("https://www.spicejet.com/");
    driver.findElement(By.id("divpaxinfo")).click();
    WebDriverWait wait = new WebDriverWait(driver, 5);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_mainContent_ddl_Adult")));
    WebElement noOfPass = driver.findElement(By.id("ctl00_mainContent_ddl_Adult"));
    noOfPass.click();
    Select sel = new Select(noOfPass);
    sel.selectByValue("6");

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_mainContent_ddl_Child")));
    WebElement noOfChild = driver.findElement(By.id("ctl00_mainContent_ddl_Child"));
    noOfChild.click();
    Select sel1 = new Select(noOfChild);
    sel1.selectByIndex(4);

    /*wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_mainContent_ddl_Infant")));
    WebElement noOfInfants = driver.findElement(By.id("ctl00_mainContent_ddl_Infant"));
    noOfInfants.click();
    Select sel2 = new Select(noOfInfants);
    sel2.selectByIndex(3);*/

    wait.until(ExpectedConditions.alertIsPresent());
    String errMsg = driver.switchTo().alert().getText();
    String expectedMessage = "You are allowed a maximum of 9 passengers per booking online. If your party is larger than this, please call our reservation center.";
    Assert.assertEquals(expectedMessage, errMsg);
    driver.switchTo().alert().accept();
  }

}
