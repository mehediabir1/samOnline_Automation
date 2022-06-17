import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class Base_Util {
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException, IOException {

    }
    public static void ChromeOpen(){
        System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }

    public static void Sleep(int Time) throws InterruptedException {
        Thread.sleep(Time);
    }

    public static void GetUrl(String URL){ driver.get(URL); }
    public static WebElement FindByXpath(String xpath){ driver.findElement(By.xpath(xpath));
        return null;
    }
    public static void FindById(String id){ driver.findElement(By.xpath(id)); }
    public static void FindByClass(String className){ driver.findElement(By.xpath(className)); }
    public static void FindByCss(String cssSelector){ driver.findElement(By.xpath(cssSelector)); }
    public static void FindByLinkText(String linkText){ driver.findElement(By.xpath(linkText)); }
    public static void ChromeClose (){ driver.quit(); }

}
