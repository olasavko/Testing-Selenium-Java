import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


//Enter the letters BENG
//Verify if Airport option is displayed in the suggested box
public class autosuggestiveDropdown {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/olya/Downloads/JavaProjects/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://ksrtc.in/oprs-web/");

        //1. Find element
        driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys("BENG");
        Thread.sleep(2000);


//2. understand that it is hidden
        driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.DOWN);
        driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.DOWN);
        System.out.println(driver.findElement(By.xpath("//input[@id='fromPlaceName']")).getText());//hidden text and Selenium is not able to identify it.

        //3.
        //to extract hidden value we will use JavaScript DOM API
        //because Selenium cannot identify hidden el-ts - (Ajax inplementation)
        //investigate the properties of object if it has any hidden text

        JavascriptExecutor js=(JavascriptExecutor)driver;//identify JS driver

        String script = "return document.getElementById(\"fromPlaceName\").value;";//we can check this command directly in browser
        String text = (String) js.executeScript(script);
        System.out.println(text);

        int i=0;

        //4. nedd to varify if BENGALURU INTERNATION AIPORT element is present - put it into while loop

        while(!text.equalsIgnoreCase("BENGALURU INTERNATION AIPORT")){//until it founds this text -> keep looping
        //while(!text.equalsIgnoreCase("BENGALURU ITION AIPORT")){//negative TC -> wrong title
            i++;
            driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.DOWN);

            text = (String) js.executeScript(script);
            System.out.println(text);

            //5. if it is not present to avoid infinity looop we need to break the test

            if(i>10){//in case with a wrong title
                break;
            }

        }
        //we brake down from while loop and now need to check other condition
        if(i>10){
            System.out.println("Element is not found");
        }
        else {
            System.out.println("Element is found");

        }


    }

}
