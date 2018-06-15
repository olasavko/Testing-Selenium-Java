import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class xPathSiblingParenth {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/Users/olya/Downloads/JavaProjects/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.qaclickacademy.com/interview.php");

        driver.findElement(By.xpath("//li[@id='tablist1-tab1']")).click();
        //travers between siblings (if you want to traver from parent to child, use absolute xpath)
        driver.findElement(By.xpath("//li[@id='tablist1-tab1']/following-sibling::li[1]")).click();
        driver.findElement(By.xpath("//li[@id='tablist1-tab1']/following-sibling::li[2]")).click();
        driver.findElement(By.xpath("//li[@id='tablist1-tab1']/following-sibling::li[3]")).click();
        //travers back from child to parent (in case if my parent is dynamic and child is static)
        driver.findElement(By.xpath("//li[@id='tablist1-tab1']/parent::ul"));

        //find element by text (even if you do not know tag name -> use *)
        // driver.findElement(By.xpath("//*[text()=' Selenium ']")).click();

        //about parent child travers relationship -> section 7, lecture 32

    }
}
