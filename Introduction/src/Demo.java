import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/olya/Downloads/JavaProjects/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("http://google.com");
        System.out.println(driver.getTitle());

        System.out.println(driver.getCurrentUrl());
        //System.out.println(driver.getPageSource());

        driver.get("http://yahoo.com");
        driver.navigate().back(); //back from yahoo to google page
        driver.navigate().forward(); //again back to the yahoo
        driver.close(); // it closes current browser
        //driver.quit();//whenever you want to end the program. It will close all opened browser window and terminates the WebDriver session. If you do not use driver.quit at the end of program, WebDriver session will not close properly and files would not be cleared off memory. This may result in memory leak errors.


    }
}
