import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RediffRegularExpression {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/olya/Downloads/JavaProjects/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.rediff.com/");

        //Css regular expression tagName[attribute*='value']
        driver.findElement(By.cssSelector("a[title*='Sign in']")).click();
        driver.findElement(By.xpath("//input[@id='login1']")).sendKeys("hello");
        driver.findElement(By.cssSelector("input#password")).sendKeys("goodbuy");
        //Xpath regular expression //tagName[contains(@attribute,'value')]
        driver.findElement(By.xpath("//input[contains(@name,'procee')]")).click();



    }
}
