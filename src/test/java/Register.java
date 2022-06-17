import org.apache.poi.ss.formula.functions.Log;
import org.openqa.selenium.By;
import java.io.IOException;

public class Register extends Base_Util {
    public static void main(String[] args) throws InterruptedException, IOException {
        ChromeOpen();
        GetUrl("https://sam.rultest2.com/account/");
        Base_Util.DataCollector();
        Register_001();
    }

    //Register
    public static void Register_001() throws IOException, InterruptedException {

        //Data Sending
        driver.findElement(By.xpath("(//input[contains(@type,'text')])[3]")).sendKeys(Username);
        driver.findElement(By.xpath("//input[contains(@type,'email')]")).sendKeys(email);
        driver.findElement(By.xpath("(//input[contains(@type,'password')])[2]")).sendKeys(Pass2);
        driver.findElement(By.xpath("//input[contains(@name,'password_re')]")).sendKeys(Pass2);
        driver.findElement(By.xpath("//input[contains(@name,'first_name')]")).sendKeys(Name);
        driver.findElement(By.xpath("//input[@placeholder='Enter your phone number']")).sendKeys(Phone);

        //SelectGender
        Sleep(1000);
        driver.findElement(By.xpath("(//span[contains(@class,'select2-selection__placeholder')])[1]")).click();
        driver.findElement(By.xpath("//li[@class='select2-results__option select2-results__option--highlighted']")).click();

        //Age
        Sleep(1000);
        driver.findElement(By.xpath("//input[contains(@type,'number')]")).sendKeys(Age2);

        //SelectDesignation
        Sleep(1000);
        driver.findElement(By.xpath("//span[@class='select2-selection__placeholder'][contains(.,'Select Designation')]")).click();
        driver.findElement(By.xpath("(//li[contains(@role,'option')])[4]")).click();

        //Institution
        Sleep(1000);
        driver.findElement(By.xpath("//input[contains(@name,'institution_name')]")).sendKeys(Ins);

        //RegisterButton
        Sleep(1000);
        driver.findElement(By.xpath("(//span[contains(.,'Register')])[2]")).click();

        //Assertion
        Sleep(1000);
        String Actual = driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/a[2]")).getText();

        if (Actual.equals("Log out")) {

            System.out.println("Registration: PASSED");

            //Logout
            Sleep(5000);
            driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/a[2]")).click();

        }
        else {
            System.out.println("Registration: FAILED");
            //Login.Login_001(Username, Pass2);
        }

    }
}

