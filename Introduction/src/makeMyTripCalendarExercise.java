import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class makeMyTripCalendarExercise {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/olya/Downloads/JavaProjects/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.makemytrip.com/flights/");
        driver.manage().window().maximize();
        Thread.sleep(5000L);

        driver.findElement(By.xpath("//input[@class='checkSpecialCharacters']")).click();
        //select desiered month

        while(!driver.findElement(By.cssSelector("[class='ui-datepicker-title'] span[class='ui-datepicker-month']")).getText().contains("AUGUST")){
            driver.findElement(By.cssSelector("[class='ui-icon ui-icon-circle-triangle-e']")).click();

        }
        int dates = driver.findElements(By.className("ui-state-default")).size();
        for(int i=0;i<dates;i++){
            String s = driver.findElements(By.className("ui-state-default")).get(i).getText();

            if(s.equalsIgnoreCase("15")){
                driver.findElements(By.className("ui-state-default")).get(i).click();
                break;
            }

        }

        //return date

        driver.findElement(By.cssSelector("[class='inputM inputHlp disable inputDateFilter'] [class='checkSpecialCharacters']")).click();
        Thread.sleep(3000L);

        driver.findElement(By.xpath("//*[@id='js-filterOptins']/div/div[4]/div/div[2]/div/div/span[1]")).getText();

        while (!driver.findElement(By.xpath("//*[@id='js-filterOptins']/div/div[4]/div/div[2]/div/div/span[1]")).getText().contains("OCTOBER")){
            driver.findElement(By.xpath("//*[@id='js-filterOptins']/div/div[4]/div/div[2]/div/a/span")).click();
        }
        int returnDates = driver.findElements(By.xpath("//*[@id='js-filterOptins']/div/div[4]/div/div[2]/table/tbody/tr[2]/td/a[@class='ui-state-default']")).size();
        List<WebElement> elements = driver.findElements(By.xpath("//*[@id='js-filterOptins']/div/div[4]/div/div[2]/table/tbody/tr[2]/td/a[@class='ui-state-default']"));

        for(int i=0;i<returnDates;i++){
            String s1 = elements.get(i).getText();

            if(s1.equalsIgnoreCase("10")){
                driver.findElements(By.xpath("//*[@id='js-filterOptins']/div/div[4]/div/div[2]/table/tbody/tr[2]/td/a[@class='ui-state-default']")).get(i).click();
                break;
            }
        }






    }
}
