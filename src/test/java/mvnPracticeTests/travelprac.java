package mvnPracticeTests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import sun.font.Script;

import java.security.Key;
import java.util.List;

public class travelprac {
    @Test
    public void fromBox() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "E:\\AutomationPractice\\SeleniumPractice\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.path2usa.com/travel-companions");
        driver.findElement(By.id("travel_from")).sendKeys("new");
        Thread.sleep(2000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "return document.getElementById(\"ajax_listOfOptions\").value;";
        String sourceCity = (String) js.executeScript(script);
        System.out.println(sourceCity);

        //WebElement boxDriver = driver.findElement(By.xpath("//*[@id='ajax_listOfOptions']"));
        //int ele= boxDriver.findElements(By.tagName("div")).size();
        String source = "India";
        String reqsrc = "Newark Liberty International Airport (EWR) Newark";
        //System.out.println(ele);
        int i = 0;

        while (!source.equalsIgnoreCase(reqsrc)) {
            i++;
            Thread.sleep(2000);
//            sourceCity = (String) js.executeScript(script);
//            System.out.println(sourceCity);
            driver.findElement(By.xpath("//*[@id='travel_from']")).sendKeys(Keys.ARROW_DOWN);
            source = driver.findElements(By.xpath("//*[starts-with(@class,'optionDiv')]")).get(i).getText();
            if (source.equalsIgnoreCase(reqsrc)) {
                driver.findElements(By.xpath("//*[starts-with(@class,'optionDiv')]")).get(i).click();
                System.out.println(source);
                break;
            }
            System.out.println(source);
            if (i > 11) {
                System.out.println("City not found");
            }
        }

        String destination = "Aus";
        String reqdstn = "Augusta Regional Airport at Bush Field (AGS) Augusta";
        driver.findElement(By.xpath("//*[@id='travel_to']")).sendKeys("b");
        Thread.sleep(2000);
        JavascriptExecutor dest = (JavascriptExecutor) driver;
        String scriptDestn = "return document.getElementById(\"travel_to\").value;";
        String trvldestn = (String) dest.executeScript(scriptDestn);

        int j = 0;
        while (!destination.equalsIgnoreCase(reqdstn)) {
            j++;
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id='travel_to']")).sendKeys(Keys.ARROW_DOWN);
            destination = driver.findElements(By.xpath("//*[starts-with(@class,'optionDiv')]")).get(j).getText();
            Thread.sleep(1000);
            System.out.println(destination);
            if(destination.equalsIgnoreCase(reqdstn))
            {
                driver.findElements(By.xpath("//*[starts-with(@class,'optionDiv')]")).get(j).click();
                break;
            }
            if(j>10)
            {
                System.out.println("destination not found");
                break;
            }
        }

        driver.close();

    }

    @Test
    public void flightTest() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "E:\\AutomationPractice\\SeleniumPractice\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.path2usa.com/travel-companions");
        driver.findElement(By.xpath("//*[@id='travel_date']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class='datepicker-switch']")).click();
        Thread.sleep(3000);
        List<WebElement> months = driver.findElements(By.xpath("//*[@class='month']"));
        int total = months.size();
        for (int i = 0; i < total; i++) {
            String month = driver.findElements(By.xpath("//*[@class='month']")).get(i).getText();
            if (month.equals("May")) {
                driver.findElements(By.xpath("//*[@class='month']")).get(i).click();
                Thread.sleep(3000);
                List<WebElement> days = driver.findElements(By.xpath("//*[@class='day']"));
                int daysofMonth = days.size();
                for (int j = 0; j < daysofMonth; j++) {
                    String date = driver.findElements(By.xpath("//*[@class='day']")).get(j).getText();
                    if (date.equals("22")) {
                        driver.findElements(By.xpath("//*[@class='day']")).get(j).click();
                        break;
                    }
                }
                break;
            }
        }
        driver.close();


        Thread.sleep(2000);
//        JavascriptExecutor js = (JavascriptExecutor)driver;
//        String source = "return document.getElementById(\"suggestions1\").value;";
//        String srcVal = (String) js.executeScript(source);
//        System.out.println(srcVal);


    }

    @Test
    public static void chooseDestination() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "E:\\AutomationPractice\\SeleniumPractice\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        WebElement autoBox = driver.findElement(By.xpath("//*[@id='autocomplete']"));
        autoBox.sendKeys("Tan");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='autocomplete']")).sendKeys(Keys.ARROW_DOWN);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String cntry = "return document.getElementById(\"autocomplete\").value;";
        String countryVal = (String) js.executeScript(cntry);
        System.out.println(countryVal);
        Thread.sleep(2000);
        int i = 0;
        while (!countryVal.equalsIgnoreCase("Tajikistan")) {
            i++;
            autoBox.sendKeys(Keys.ARROW_DOWN);
            countryVal = (String) js.executeScript(cntry);
            System.out.println(countryVal);
            Thread.sleep(2000);
            System.out.println(countryVal);
            if (i > 10) {
                System.out.println("country is not in the list");
                break;
            }

        }
        driver.close();

    }
}

