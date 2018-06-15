import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Miscelleanous {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/olya/Downloads/JavaProjects/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://socialblade.com/register");

        int number=findFrameNumber(driver,By.xpath("//*[@id='recaptcha-anchor']/div[5]"));//count frames on the page
        driver.switchTo().frame(number);
        driver.findElement(By.xpath("//*[@id='recaptcha-anchor']/div[5]")).click();

        //we have already handled 1st frame with checkbox and need to click on Verify button
        //driver.switchTo().defaultContent();
        int number1=findFrameNumber(driver,By.xpath("//div[@id='rc-imageselect']/div[3]/div[2]/div/div[2]/button"));
        driver.switchTo().frame(number1);//switch to this frame
        driver.findElement(By.xpath("//div[@id='rc-imageselect']/div[3]/div[2]/div/div[2]/button")).click();

        }

       //write my own utility to handle frame - trying to make reusable utility
        public static int findFrameNumber(WebDriver driver, By by) {

        int i;
        int frameCount = driver.findElements(By.tagName("iframe")).size();
        for(i=0;i<frameCount;i++){
            driver.switchTo().frame(i);

            //find if el-t(checkbox) is present on the page -> use findElements().size().
            //If it presents, it will return 1 and click on checkbox. If not, returns 0 and continues looping.
            int count = driver.findElements(by).size();
            //if this object is present -> click on it
            if(count>0){
                driver.findElement(by).click();
                break;
            }
            else {
                System.out.println("continue looping");
            }


        }

        driver.switchTo().defaultContent();//to switch to another frame we need to come back to the parent page and then switch
        return i;


    }
}

// section 12, lecture 85 - my question