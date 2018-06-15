import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class ActionsDemo {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/Users/olya/Downloads/JavaProjects/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
//Scenario: hover over the button (move our mouse to specific element) - verify if dropdown appears;
        Actions a = new Actions(driver);
        //build() - code is ready to execute; perform() - we can execute it
        //a.moveToElement(driver.findElement(By.cssSelector("a[id='nav-link-accountList']"))).build().perform();

//to make code readable and clear better to do like this:
        WebElement move = driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));
        a.moveToElement(move).build().perform();

        //enter text in upper case and then select this text (manual way - double click on that text)
        a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();

        //how to perform  right mouse click and invoke context menu
        a.moveToElement(move).contextClick().build().perform();




    }
}
