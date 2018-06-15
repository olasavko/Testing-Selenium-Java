import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FormMethods {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/olya/Downloads/JavaProjects/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://qaclickacademy.com/practice.php");

        // 1) how to validate object which is in code base but in visible/hidden mode
        System.out.println("Before hide an element --> it's visible");
        System.out.println(driver.findElement(By.xpath("//input[@name='show-hide']")).isDisplayed());//will print true
        driver.findElement(By.xpath("//input[@id='hide-textbox']")).click();
        System.out.println("After hide an element --> it's not visible");
        System.out.println(driver.findElement(By.xpath("//input[@name='show-hide']")).isDisplayed());//will print false

        /*difference between isSelected() and isDisplayed()
        - isSelected() - used for checkboxes and radio buttons to check if current element is checked or not
        - isDisplayed() - used for checking if elements is visible ot not and it should be present on the code.
        We cannot use it in case when object absents in code -> it will throw an error
        */

        //how to validate what text is present
        Thread.sleep(3000L);
        //What is wrong with my Xpath? - System.out.println(driver.findElement(By.xpath("//body[@data-gr-c-s-loaded='true']/div[2]/div[3]/fieldset/legend")).getText());
        System.out.println(driver.findElement(By.xpath("/html/body/div[2]/div[3]/fieldset/legend")).getText());


        // 2) how to validate object if it is present in web page or code base
        int count = driver.findElements(By.xpath("//input[@name='show-he']")).size();

        if(count == 0){
            System.out.println("verified");
        }
/*
Ex: we navigate from Home page to Contact page by clicking on link on the Home page.
How to check if home page elements are not present on the contact page?
we need use scenario 2 -> on the contact page find home page elements size and it should be equal 0.
 */

/*
also there is method isEnabled() -> check if element is enabled or disabled and returns boolen: true/false
driver.findElement(By.xpath("//input[@name='show-hide']")).isEnabled();

 */



    }
}
