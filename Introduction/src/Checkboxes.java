import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkboxes {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/olya/Downloads/JavaProjects/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://spicejet.com/");

        //validate is checkbox is selected by default
        System.out.println(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());
        driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
        //check if checkbox has been selected -> isSelected()
        System.out.println(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());


    }
}
