import org.apache.commons.collections4.Get;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.IOException;

public class Login extends Register{


    public static void main(String[] args) throws IOException {
        DataCollector();
    }

    public static void Try(String Username){
        driver.findElement(By.xpath("//*[@id=\"stm-lms-login\"]/span/form/div/span[1]/div/input")).sendKeys(Username);

    }
}
