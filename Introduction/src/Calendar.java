import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Calendar {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/Users/olya/Downloads/JavaProjects/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.path2usa.com/travel-companions");

       //we want to select August 23
        driver.findElement(By.id("travel_date")).click();

        //find future month
        //Firstly it will find current month -> while month name not equil August -> click on the Next button.
        //We use ! because it will show true (current month is found) and end up a while loop. but we need future month
        //While loop will keep executing until it becomes false
        while (!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText().contains("May")){
            driver.findElement(By.cssSelector("[class='datepicker-days'] [class='next']")).click();
        }


        //grab common attribute->put into list->iterate
        List<WebElement> dates = driver.findElements(By.className("day"));//expected to be a list -> wrap it into the list
        //we need to compare each el-t with August 23 -> need to know how many el-s do we have
        int count = driver.findElements(By.className("day")).size();

        for (int i=0;i<count;i++) {
            String text = driver.findElements(By.className("day")).get(i).getText();

            if(text.equalsIgnoreCase("23")){
                driver.findElements(By.className("day")).get(i).click();
                break;
            }


        }

    }
}
