import org.apache.commons.collections4.Get;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.io.IOException;

public class Login extends Base_Util{
    public static void main(String[] args) throws IOException {
        DataCollector();
        Login_001();
    }

    public static void Login_001() {
        driver.get("https://sam.rultest2.com/account/");
        driver.findElement(By.xpath("//*[@id=\"stm-lms-login\"]/span/form/div/span[1]/div/input")).sendKeys(Username);
        driver.findElement(By.xpath("(//input[contains(@name,'password')])[1]")).sendKeys(Pass);
    }
}
