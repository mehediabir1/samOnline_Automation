import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Register {
    static String ExcelPath = "C:\\Users\\User\\Desktop\\Data.xlsx";
    static String Username;
    static String email;
    static int Pass;
    static String Name;
    static String Phone;
    static int age;
    static String Ins;
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        ChromeSetup();
        Register_001();
    }
    public static void ChromeSetup(){
        System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://sam.rultest2.com/account/");
    }

    public static void Register_001() throws InterruptedException {

        XSSFWorkbook workbook = new XSSFWorkbook(ExcelPath);
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        try
        {
            Username = sheet.getRow(0).getCell(0).getStringCellValue();
            Thread.sleep(2000);
            email = sheet.getRow(0).getCell(1).getStringCellValue();
            Thread.sleep(2000);
            Pass = (int) sheet.getRow(0).getCell(2).getNumericCellValue();
            Thread.sleep(2000);
            Name = sheet.getRow(0).getCell(3).getStringCellValue();
            Thread.sleep(2000);
            Phone = sheet.getRow(0).getCell(4).getStringCellValue();
            Thread.sleep(2000);
            age = (int) sheet.getRow(0).getCell(5).getNumericCellValue();
            Thread.sleep(2000);
            Ins = sheet.getRow(0).getCell(6).getStringCellValue();
            Thread.sleep(2000);
        }
        catch (Exception ex){
            System.out.println("not working");
        }
            String Pass2 = String.valueOf(Pass);
            String Age2 = String.valueOf(age);

            driver.findElement(By.xpath("(//input[contains(@type,'text')])[3]")).sendKeys(Username);
            driver.findElement(By.xpath("//input[contains(@type,'email')]")).sendKeys(email);
            driver.findElement(By.xpath("(//input[contains(@type,'password')])[2]")).sendKeys(Pass2);
            driver.findElement(By.xpath("//input[contains(@name,'password_re')]")).sendKeys(Pass2);
            driver.findElement(By.xpath("//input[contains(@name,'first_name')]")).sendKeys(Name);
            driver.findElement(By.xpath("//input[@placeholder='Enter your phone number']")).sendKeys(Phone);

            //SelectGender
            driver.findElement(By.xpath("(//span[contains(@class,'select2-selection__placeholder')])[1]")).click();
            driver.findElement(By.xpath("//li[@class='select2-results__option select2-results__option--highlighted']")).click();

            //Age
            driver.findElement(By.xpath("//input[contains(@type,'number')]")).sendKeys(Age2);

            //SelectDesignation
            driver.findElement(By.xpath("//span[@class='select2-selection__placeholder'][contains(.,'Select Designation')]")).click();
            driver.findElement(By.xpath("(//li[contains(@role,'option')])[4]")).click();

            driver.findElement(By.xpath("//input[contains(@name,'institution_name')]")).sendKeys(Ins);

            //RegisterButton
            driver.findElement(By.xpath("(//span[contains(.,'Register')])[2]")).click();

    //        Thread.sleep(3000);
    //        boolean b = driver.findElements(By.xpath("//a[@href='https://sam.rultest2.com/wp-login.php?action=logout&redirect_to=https%3A%2F%2Fsam.rultest2.com&_wpnonce=5d6ea4068e']")).isEmpty();
    //        System.out.println(b);
    }
}
