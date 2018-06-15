import com.google.common.base.Strings;
import com.sun.tools.classfile.Opcode;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;
import java.util.Iterator;
import java.util.Set;

public class MultipleWindows {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/Users/olya/Downloads/JavaProjects/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.expedia.com/");
//Scroll down page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.xpath("//a[contains(@href,'business-travel-management')]"));
        js.executeScript("arguments[0].scrollIntoView();", element);
        element.click();

        System.out.println("Before switching");
        System.out.println(driver.getTitle()); // will print parent title
        //all opened window ids will be stored in a set (parent-child) as a variable
        Set<String> ids = driver.getWindowHandles();
        //iterate through all windows - parent window is first by default
        Iterator<String> it = ids.iterator();
        String parentId = it.next(); // grab the first window -> parent window
        String childId = it.next(); // grab the second window -> child window
        driver.switchTo().window(childId); //switch to child window
        System.out.println("After switching");
        System.out.println(driver.getTitle());// will print child title

        //to switch to parent window again
        driver.switchTo().window(parentId);
        System.out.println("Switching back to parent");
        System.out.println(driver.getTitle());// will print parent title


    }
}
