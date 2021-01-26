package mvnPracticeTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.List;

public class tableAssignment {
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("I am the before method");
    }

    @Test
    public void tblAssignment()
    {
        System.out.println("These changes are made by Jones on his local machine");
        System.out.println ("These changes are made by Jones @10:20 PM");
        System.setProperty("webdriver.chrome.driver", "E:\\AutomationPractice\\SeleniumPractice\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.qaclickacademy.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[@href='https://www.rahulshettyacademy.com/AutomationPractice']")).click();
        WebDriverWait w = new WebDriverWait(driver, 5);
        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='product']")));
        WebElement tbldriver = driver.findElement(By.xpath("//*[@id='product']"));
        List<WebElement> rows = tbldriver.findElements(By.xpath("//*[@id='product']/tbody/tr"));
        System.out.println("Number of rows in table are "+rows.size());
        System.out.println("Number of columns are "+tbldriver.findElements(By.xpath("//*[@id='product']/tbody/tr/th")).size());
        System.out.println(tbldriver.findElement(By.xpath("//*[@id='product']/tbody/tr[3]")).getText());
        driver.close();
    }

    @Ignore
    public void espnTest() throws InterruptedException
    {
        System.setProperty("webdriver.chrome.driver", "E:\\AutomationPractice\\SeleniumPractice\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("https://www.espncricinfo.com/series/8531/scorecard/65577/england-vs-sri-lanka-8th-match-carlton-&-united-series-1998-99");

        driver.manage().window().maximize();
        WebDriverWait w1 = new WebDriverWait(driver, 60);
        //w1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-reactid='139']")));
        WebElement tbldriver= driver.findElement(By.xpath("//div/article[@class='sub-module scorecard']"));
        System.out.println("Table driver identified");
        Thread.sleep(5000);
        WebElement rowdriver = tbldriver.findElement(By.xpath("//div/article[@class='sub-module scorecard'][1]//div[@class='wrap batsmen']"));
        int rowcount= tbldriver.findElements(By.xpath("//div/article[@class='sub-module scorecard'][1]//div[@class='wrap batsmen']")).size();
        System.out.println(rowcount);
        List<WebElement> runs = tbldriver.findElements(By.xpath("//div/article[@class='sub-module scorecard'][1]//div[@class='wrap batsmen']//div[3]"));
        String Engruns;
        int Engbatruns =0;
        int EngTotal=0;
        System.out.println("Runs scored by England batsmen are :");
        for(int i=0; i<rowcount; i++)
        {
            Engruns = runs.get(i).getText();
            System.out.println(Engruns);
            Engbatruns = Integer.parseInt(Engruns);
            EngTotal = Engbatruns+EngTotal;

        }
        Thread.sleep(6000);
        int extraruns=0;
        String[] extras= tbldriver.findElement(By.xpath("//div[@class='wrap extras']//div[2]")).getText().split( " ");
        System.out.println(extras[0]);
        extraruns = Integer.parseInt(extras[0]);
        EngTotal=EngTotal+extraruns;
        System.out.println("Total runs scored by Englad are " +EngTotal);

        System.out.println("Now getting score of Sri Lanka");
        Thread.sleep(2000);

        WebElement SlScoredriver = driver.findElement(By.xpath("//*[@id='gp-inning-01']//*[@class='scorecard-section batsmen']"));
        int SLrows = SlScoredriver.findElements(By.xpath("//*[@id='gp-inning-01']//*[@class='scorecard-section batsmen']//div[@class='wrap batsmen']")).size();
        System.out.println("Total SL batsmen "+SLrows);
        List<WebElement> Slruns=SlScoredriver.findElements(By.xpath("//*[@id='gp-inning-01']//*[@class='scorecard-section batsmen']//div[@class='wrap batsmen']//div[3]"));
        String slBatruns;
        int SlTotal=0;
        int SlExtra=0;
        Thread.sleep(4000);
        for(int j=0; j<SLrows; j++)
        {
            slBatruns=Slruns.get(j).getText();
            System.out.println(slBatruns);
            SlTotal = SlTotal+ Integer.parseInt(slBatruns);
        }
        Thread.sleep(1000);
        String[] SlextraRuns = SlScoredriver.findElement(By.xpath("//*[@id='gp-inning-01']//*[@class='wrap extras']//div[2]")).getText().split( " ");
        SlExtra = Integer.parseInt(SlextraRuns[0]);
        SlTotal = SlTotal+SlExtra;
        System.out.println("Total runs scored by Sri lanka are "+SlTotal);

        if(EngTotal>SlTotal)
        {
            System.out.println("England won ");
        }
        else
        {
            System.out.println("Sri Lanka won");
        }
        driver.close();
    }

    @AfterMethod
    public void after()
    {
        System.out.println("Hello from the other side");
    }
}


