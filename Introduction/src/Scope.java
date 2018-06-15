import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;


public class Scope {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/olya/Downloads/JavaProjects/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://qaclickacademy.com/practice.php");

        //1. give me the count of the link on the page
                //all links have tag a
        System.out.println(driver.findElements(By.tagName("a")).size());

        //2. give me the count of the link on the footer section
        //limit global driver scope for footer section -> create driver subset
        WebElement footerDriver = driver.findElement(By.id("gf-BIG")); // create WebElement for footer and it will play role of driver for footer -> limiting of webdriver scope
        System.out.println(footerDriver.findElements(By.tagName("a")).size());

        //3. count link only in the first column of the footer
        WebElement columnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul")); //webdriver scope limited for first column in the footer
        System.out.println(columnDriver.findElements(By.tagName("a")).size());

//Example of interview q: what did you do unique in your automation?

        //4. click on each link in the column and check if the pages are opened
        for(int i=1; i<columnDriver.findElements(By.tagName("a")).size(); i++) {
            //will open each link in a new tab -> like we press CTRL+Enter on keyboard.
            // //Otherwise we need to use for each link: findElement by Xpath -> Click Back button -> bad approach

            String clickOnLinkToOpenNewTab = Keys.chord(Keys.COMMAND, Keys.ENTER);// what is keys.chord - Alternative to Action class methods. It will simulate pressing of multiple keys.

            columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkToOpenNewTab);//whenever it is a keyboard event we have to use sendKeys()
            Thread.sleep(3000L);
        }
            //5. to get title of each tab
            Set<String> abc = driver.getWindowHandles();//all opened window ids will be stored in a set (parent-child) as a variable
            Iterator<String> it = abc.iterator();//iterate through all windows(move from one tab to another) - parent window is first by default

            while (it.hasNext()){ //if next index(window in this case) is present - move to it
                driver.switchTo().window(it.next()); //move to the next specific window
                System.out.println(driver.getTitle());

            }

        }


    }


