import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base_Util {
    static WebDriver driver;
    public static void main(String[] args) {

    }
    public static void ChromeOpen(){
        System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void GetUrl(String URL){
        driver.get(URL);
    }
}
