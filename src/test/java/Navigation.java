import org.openqa.selenium.By;
import java.io.IOException;

public class Navigation extends Base_Util{

    public static void main(String[] args) {
        GetUrl("https://sam.rultest2.com/account/");
        Login();
    }
    public static void Login(){

        driver.findElement(By.xpath("//*[@id=\"stm-lms-login\"]/span/form/div/span[1]/div/input")).sendKeys(Username);
        driver.findElement(By.xpath("(//input[contains(@name,'password')])[1]")).sendKeys(Pass2);

    }

}
