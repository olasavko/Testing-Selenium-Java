import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Synchronize {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/olya/Downloads/JavaProjects/chromedriver");
        WebDriver driver = new ChromeDriver();
        /*Implicit wait
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.get("https://alaskatrips.poweredbygps.com/g/pt/hotels?MDPCID=ALASKA-US.TPS.BRAND.hotels.HOTEL");

        driver.findElement(By.id("H-destination")).sendKeys("nyc");
        //how to press Enter
        driver.findElement(By.id("H-destination")).sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("//a[contains(@href,'New-York-Hotels-Salisbury')]")).click();*/

        /////////the same scenario with explicit wait with conditions
        driver.get("https://alaskatrips.poweredbygps.com/g/pt/hotels?MDPCID=ALASKA-US.TPS.BRAND.hotels.HOTEL");
        driver.findElement(By.id("H-destination")).sendKeys("nyc");
        //how to press Enter
        driver.findElement(By.id("H-destination")).sendKeys(Keys.ENTER);

        WebDriverWait d = new WebDriverWait(driver,20);
        //when we want something to be visible (use Xpath of the first element)
        d.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"4164\"]/div[2]/div/a"))).click();
        //when we want something to be clickable
        //d.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href,'New-York-Hotels-Salisbury')]")));


    }
}
