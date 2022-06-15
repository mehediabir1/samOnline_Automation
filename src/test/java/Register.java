import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;

import java.io.IOException;

public class Register extends Base_Util{
    static String ExcelPath = "C:\\Users\\User\\Desktop\\Data.xlsx";
    static String Username;
    static String email;
    static int Pass;
    static String Name;
    static String Phone;
    static int age;
    static String Ins;



    //MainMethod
    public static void main(String[] args) throws InterruptedException, IOException {

        ChromeOpen();
        //GetUrl("https://sam.rultest2.com/account/");
        DataCollector();
        //Register_001();
        Login(Username);
    }

    public static void DataCollector() throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook(ExcelPath);
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        try
        {
            Username = sheet.getRow(0).getCell(0).getStringCellValue();
            email = sheet.getRow(0).getCell(1).getStringCellValue();
            Pass = (int) sheet.getRow(0).getCell(2).getNumericCellValue();
            Name = sheet.getRow(0).getCell(3).getStringCellValue();
            Phone = sheet.getRow(0).getCell(4).getStringCellValue();
            age = (int) sheet.getRow(0).getCell(5).getNumericCellValue();
            Ins = sheet.getRow(0).getCell(6).getStringCellValue();

        }
        catch (Exception ex){
            System.out.println("Data Collection : FAILED!");
        }
        workbook.close();

        String Pass2 = String.valueOf(Pass);
        String Age2 = String.valueOf(age);
        Login(Pass2);
    }



    //Register
    public static void Register_001(String Pass2) throws IOException, InterruptedException {

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

            //Assertion
            Thread.sleep(5000);
            String Actual = driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/a[2]")).getText();

            if (Actual.equals("Log out"))
            {
                System.out.println("Registered Passed");

                //Logout
                driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/a[2]")).click();
            }
            else
            {
                System.out.println("Registration Failed");
            }

    }

    public static void Login(String Username){
            GetUrl("https://sam.rultest2.com/account/");

            driver.findElement(By.xpath("//*[@id=\"stm-lms-login\"]/span/form/div/span[1]/div/input")).sendKeys(Username);
            //driver.findElement(By.xpath("(//input[contains(@placeholder,'Enter password')])[1]")).sendKeys(Pass2);

    }
}
