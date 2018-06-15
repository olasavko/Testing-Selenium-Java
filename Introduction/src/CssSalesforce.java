import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssSalesforce {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/olya/Downloads/JavaProjects/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://login.salesforce.com/");

        // 1. Pattern -> tagName[attribute='value'] or [attribute='value']
        driver.findElement(By.cssSelector("input[class='input r4 wide mb16 mt8 username'")).sendKeys("login");
        driver.findElement(By.cssSelector("input[class='input r4 wide mb16 mt8 password'")).sendKeys("password");
        //driver.findElement(By.cssSelector("input[id='Login']")).click();
        // 2. If we sure there is only one Login button on the page -> #Login
        //driver.findElement(By.cssSelector("#Login")).click();
        // 3. If we want to use class -> .classNameNoSpaces <- does not work with spaces -> replace spaces with dots
        driver.findElement(By.cssSelector(".button.r4.wide.primary")).click();




    }
}
