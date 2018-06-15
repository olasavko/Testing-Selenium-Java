import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;

public class FramesTest {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","/Users/olya/Downloads/JavaProjects/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://jqueryui.com/droppable/");

        //to count how many iframes do we have
        System.out.println(driver.findElements(By.tagName("iframe")).size());
        //to know number of frames we can use index but it is not good approach
        //driver.switchTo().frame(1);

        //to find element
        //1) driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));//or other css option: iframe[class='demo-frame']

        //2) we know that in current page there is only one frame -> we can find it by index now
        driver.switchTo().frame(0);

        //drag and drop element -> need to use Actions class
        Actions a = new Actions(driver);
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        a.dragAndDrop(source, target).build().perform();

        //to come back fron frame to the page
        driver.switchTo().defaultContent();


    }

}
