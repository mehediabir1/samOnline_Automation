import org.apache.poi.ss.formula.functions.Log;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;

import java.io.IOException;

public class Register extends Base_Util {

    //Variables
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


    //MainMethod
    public static void main(String[] args) throws InterruptedException, IOException {

        ChromeOpen();
        GetUrl("https://sam.rultest2.com/account/");
        DataCollector();
        Register_001();
    }

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

        //Login.Try(Username);
    }


    //Register
    public static void Register_001() throws IOException, InterruptedException {

        //Data Sending..
        driver.findElement(By.xpath("(//input[contains(@type,'text')])[3]")).sendKeys(Username);
        driver.findElement(By.xpath("//input[contains(@type,'email')]")).sendKeys(email);
        driver.findElement(By.xpath("(//input[contains(@type,'password')])[2]")).sendKeys(Pass2);
        driver.findElement(By.xpath("//input[contains(@name,'password_re')]")).sendKeys(Pass2);
        driver.findElement(By.xpath("//input[contains(@name,'first_name')]")).sendKeys(Name);
        driver.findElement(By.xpath("//input[@placeholder='Enter your phone number']")).sendKeys(Phone);


        //SelectGender
        Sleep(2000);
        driver.findElement(By.xpath("(//span[contains(@class,'select2-selection__placeholder')])[1]")).click();
        driver.findElement(By.xpath("//li[@class='select2-results__option select2-results__option--highlighted']")).click();

        //Age
        Sleep(2000);
        driver.findElement(By.xpath("//input[contains(@type,'number')]")).sendKeys(Age2);

        //SelectDesignation
        Sleep(2000);
        driver.findElement(By.xpath("//span[@class='select2-selection__placeholder'][contains(.,'Select Designation')]")).click();
        driver.findElement(By.xpath("(//li[contains(@role,'option')])[4]")).click();
        driver.findElement(By.xpath("//input[contains(@name,'institution_name')]")).sendKeys(Ins);

        //RegisterButton
        Sleep(2000);
        driver.findElement(By.xpath("(//span[contains(.,'Register')])[2]")).click();

        //Assertion
        Sleep(2000);
        String Actual = driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/a[2]")).getText();

        if (Actual.equals("Log out")) {

            System.out.println("Registration: PASSED");

            //Logout
            Sleep(5000);
            driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/a[2]")).click();
        }
        else {
            System.out.println("Registration: FAILED");
        }

    }
}

