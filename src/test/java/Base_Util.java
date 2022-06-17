import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;

public class Base_Util {
    static String ExcelPath = "C:\\Users\\User\\Desktop\\Data.xlsx";
    public static String Username;
    static String email;
    public static int Pass;
    static String Name;
    static String Phone;
    static int age;
    static String Ins;
    static String Pass2;
    static String Age2;
    public static WebDriver driver;
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

    public static void DataCollector() throws IOException {

        //Opening Workbook - Excel
        XSSFWorkbook workbook = new XSSFWorkbook(ExcelPath);
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        //Catching Data
        try {
            Username = sheet.getRow(0).getCell(0).getStringCellValue();
            email = sheet.getRow(0).getCell(1).getStringCellValue();
            Pass = (int) sheet.getRow(0).getCell(2).getNumericCellValue();
            Name = sheet.getRow(0).getCell(3).getStringCellValue();
            Phone = sheet.getRow(0).getCell(4).getStringCellValue();
            age = (int) sheet.getRow(0).getCell(5).getNumericCellValue();
            Ins = sheet.getRow(0).getCell(6).getStringCellValue();

        } catch (Exception ex) {
            System.out.println("Data Collection : FAILED!");
        }
        workbook.close();
        Pass2 = String.valueOf(Pass);
        Age2 = String.valueOf(age);
    }

}
