import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/olya/Downloads/JavaProjects/chromedriver");
        WebDriver driver = new ChromeDriver();
        //driver.get("https://www.cheapoair.com/");

        /*
        //static dropdown - using Select class when web element has <select> tag and all options have <option> tag . It allows to manipulate dropdowns on web sites
        //https://www.guru99.com/select-option-dropdown-selenium-webdriver.html

        //www.cheapoair.com
        // 1. Import the package org.openqa.selenium.support.ui.Select
        // 2. Declare the drop-down element as an instance of the Select class
        // 3. Control "s" by using any of the available Select methods
        Select s = new Select(driver.findElement(By.id("ember786")));
        // 4. Select Items in a Multiple SELECT elements using different methods
        s.selectByValue("2");
        s.selectByIndex(5);
        s.selectByVisibleText("9");*/

        //dynamic dropdown
        //spicejet.com
        driver.get("http://spicejet.com/");
        driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
        driver.findElement(By.xpath("//a[@value='GOI']")).click();
        Thread.sleep(2000);
        //chapter 8 lecture 41
        driver.findElement(By.xpath("(//a[@value='DEL'])[2]")).click();




    }
}

