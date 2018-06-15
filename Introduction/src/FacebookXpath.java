import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookXpath {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/olya/Downloads/JavaProjects/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://facebook.com");

         /* different selectors
         //driver.findElement(By.id("email")).sendKeys("qqq");
       // driver.findElement(By.name("pass")).sendKeys("123");
        //driver.findElement(By.linkText("Forgot account?")).click();

        driver.findElement(By.cssSelector("#email")).sendKeys("emiladdress");
        driver.findElement(By.xpath("//*[@id=\'pass\']")).sendKeys("12345");
        driver.findElement(By.xpath("//*[@id=\'u_0_2\']")).click();

        //driver.close();*/

         //Xpath

       /* Pattern -> //tagName[@attribute='value'] or //*[@attribute='value'] -> xpath
        driver.findElement(By.xpath("//*[@type='email']")).sendKeys("my own xpath");
        driver.findElement(By.xpath("//*[@id=\'pass\']")).sendKeys("hello");
        driver.findElement(By.xpath("//*[@value='Log In']")).click();*/

       // Pattern -> tagName[attribute='value'] or [attribute='value'] or tagName#id or #id -> css
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys("my own css");
        driver.findElement(By.cssSelector("input[id='pass']")).sendKeys("hello");
        driver.findElement(By.cssSelector("input[value='Log In']")).click();


    }
}
