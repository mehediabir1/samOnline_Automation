import org.openqa.selenium.By;

import javax.xml.crypto.Data;
import java.io.IOException;

public class Navigation extends Base_Util{

    public static void main(String[] args) throws IOException, InterruptedException {
        ChromeOpen();
        GetUrl("https://sam.rultest2.com/account/");
        Login();
    }
    public static void Login() throws IOException, InterruptedException {
        DataCollector();
        driver.findElement(By.xpath("//*[@id=\"stm-lms-login\"]/span/form/div/span[1]/div/input")).sendKeys(Username);
        driver.findElement(By.xpath("(//input[contains(@name,'password')])[1]")).sendKeys(Pass);
        Sleep(3000);
        driver.findElement(By.xpath("//a[@href='#'][contains(.,'Login')]")).click();
    }

}
