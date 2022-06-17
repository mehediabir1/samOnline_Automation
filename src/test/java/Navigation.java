import org.openqa.selenium.*;

import javax.xml.crypto.Data;
import java.io.IOException;

public class Navigation extends Base_Util{

    public static void main(String[] args) throws IOException, InterruptedException {
        ChromeOpen();
        GetUrl("https://sam.rultest2.com/account/");
        Login();
        Course();
        Setting();
        ChangeSetting();
    }
    public static void Login() throws IOException, InterruptedException {
        DataCollector();
        driver.findElement(By.xpath("//*[@id=\"stm-lms-login\"]/span/form/div/span[1]/div/input")).sendKeys(Username);
        driver.findElement(By.xpath("(//input[contains(@name,'password')])[1]")).sendKeys(Pass);
        Sleep(3000);
        driver.findElement(By.xpath("//a[@href='#'][contains(.,'Login')]")).click();
        System.out.println("-> Logged in.");
    }

    public static void Course() throws InterruptedException {
        Sleep(3000);
        driver.findElement(By.xpath("(//a[@href='https://sam.rultest2.com/courses'][contains(.,'Course')])[2]")).click();
        System.out.println("-> Course Page.");

        Sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)", "");

        Sleep(2500);
        driver.findElement(By.xpath("//a[@href='https://sam.rultest2.com/courses/mycourse/0'][contains(.,'Start course')]")).click();

        Sleep(1000);
        js.executeScript("window.scrollBy(0,200)", "");

        Sleep(1000);
        js.executeScript("window.scrollBy(0,200)", "");

        Sleep(3000);
        js.executeScript("window.scrollBy(0,-400)", "");
    }

    public static void Setting() throws InterruptedException {
        Sleep(2000);
        driver.findElement(By.xpath("//i[contains(@class,'lnr lnr-cog')]")).click();
        driver.findElement(By.xpath("//a[@href='https://sam.rultest2.com/account/settings'][contains(.,'Settings')]")).click();

        System.out.println("-> Setting Page.");
    }

    public static void ChangeSetting() throws InterruptedException {

        WebElement Name = driver.findElement(By.xpath("//input[@placeholder='Enter your full name']"));
        Name.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        driver.findElement(By.xpath("//input[@placeholder='Enter your full name']")).sendKeys("Edited Name");

        //Save Button
        Sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        driver.findElement(By.xpath("//*[@id=\"stm_lms_edit_account\"]/span/form/div[3]/div/div/div[1]/button")).click();

        System.out.println("-> Name Updated!");
    }
}
