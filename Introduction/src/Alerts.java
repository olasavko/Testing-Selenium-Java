import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class Alerts {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "/Users/olya/Downloads/JavaProjects/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://toolsqa.com/handling-alerts-using-selenium-webdriver/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.xpath("//*[text()='Confirm Pop up']"));
        //also correct Xpath -> WebElement element = driver.findElement(By.xpath("//button[@onclick='pushConfirm()']"));

        //scroll down the web page by pixel -> https://www.guru99.com/scroll-up-down-selenium-webdriver.html
        js.executeScript("window.scrollBy(0,500)", element);
        element.click();

        //verify is text is present on popup
        System.out.println(driver.switchTo().alert().getText());

        driver.switchTo().alert().accept();//accept method for positive scenario: OK / Done / Yes
        //driver.switchTo().alert().dismiss();//dismiss method for negative scenario: Cancel / No / Dismiss

        /*scenario for entering text and ckick button
        WebElement element = driver.findElement(By.xpath("//*[text()='Prompt Pop up']"));
        js.executeScript("window.scrollBy(0,500)", element);
        element.click();

        driver.switchTo().alert().sendKeys("rrrr");
        driver.switchTo().alert().accept();*/


    }
}
