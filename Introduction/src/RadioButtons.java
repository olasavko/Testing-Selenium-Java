import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;
import java.util.concurrent.TimeUnit;

public class RadioButtons {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/olya/Downloads/JavaProjects/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.echoecho.com/htmlforms10.htm");

        //https://www.guru99.com/scroll-up-down-selenium-webdriver.html
        //To scroll down the web page by the visibility of the element
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Find element and store in variable "Element"
//        WebElement element = driver.findElement(By.xpath("//input[@value='Milk']"));

        //This will scroll the page till the element is found
//        js.executeScript("arguments[0].scrollIntoView();", element);
       // element.click();

        //if there are many elements with the same locator (i.e: 3 radio buttons in a group1) -> findElements
        //how many radio buttons are present in that section
        //driver.findElements(By.xpath("//input[@name='group1']")).size();

        //Scenario 2
        //if you need to handle all radio buttons (click on each): 1) find the size of group 2) keep it in a loop

        WebElement element = driver.findElements(By.xpath("//input[@name='group1']")).get(0);
        js.executeScript("arguments[0].scrollIntoView();", element);

        int count = driver.findElements(By.xpath("//input[@name='group1']")).size();

        for(int i = 0; i < count; i++){
            //driver.findElements(By.xpath("//input[@name='group1']")).get(i).click();

            //want to get attribute "value" of each radio button
            //driver.findElements(By.xpath("//input[@name='group1']")).get(i).getAttribute("value");

            //want to get specific value - Cheese
            String text = driver.findElements(By.xpath("//input[@name='group1']")).get(i).getAttribute("value");
            if(text.equals("Cheese")){
                driver.findElements(By.xpath("//input[@name='group1']")).get(i).click();
            }

            //TimeUnit.SECONDS.sleep(2);
        }


    }
}
