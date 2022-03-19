package Amazon.Mavenjava;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

//import flipkart.Loginpage;

import org.apache.logging.log4j.*;

public class seleniumTest {
	private static Logger log= LogManager.getLogger(seleniumTest.class.getName());
	
	ExtentReports extent;
	@BeforeTest
	public void config()
	{
		log.info("Designing the test page using ExtentReports");
		//ExtendReports ,ExtendSparkReporter
		String path =System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Amazon Automation Result");
		reporter.config().setDocumentTitle("Test Results");
		
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Karthiga");
	}

	@Test
	public void browserAutomation()
	{
		
		ExtentTest test=extent.createTest("browserAutomation");
		System.setProperty("webdriver.chrome.driver", "C://Users//karth//chromedriver//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		log.info("page loaded");
		
		System.out.println(driver.getTitle());
		System.out.println("BrowserAuto");
		Loginpage lp=new Loginpage(driver);
		lp.Emailid().sendKeys("8217649451");
		lp.Password().sendKeys("12345678");
		//test.addScreenCaptureFromBase64String(null);
		extent.flush();
	}
	@Test
	public void elementsUi()
	{
		System.out.println("elementsUi");
	}
	public ArrayList<String> getData(String testcasename) throws IOException
	{
		ArrayList a=new ArrayList();
		FileInputStream fis=new FileInputStream("C:\\Users\\karth\\Documents\\customer.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		int sheets=workbook.getNumberOfSheets();
		for(int i=0;i<sheets;i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase("Testdata"))
			{
			XSSFSheet sheet=workbook.getSheetAt(i);
			Iterator<Row> rows=sheet.rowIterator();
			Row firstrow=rows.next();
			Iterator<Cell> ce=firstrow.cellIterator();
			int k=0;
			int column = 0;
			while(ce.hasNext())
			{
				Cell value=ce.next();
				if(value.getStringCellValue().equalsIgnoreCase(testcasename))
				{
					column=k;
					
				}
				k++;
			}
			System.out.println(column);

			while(rows.hasNext())
			{
				Row r=rows.next();
				if(r.getCell(column).getStringCellValue().equalsIgnoreCase("karthik"))
				{
					Iterator<Cell> cv=r.cellIterator();
					while(cv.hasNext())
					{
						//System.out.println(cv.next().getStringCellValue());
						Cell c=cv.next();
						if(c.getCellType()==CellType.STRING)
						{
						a.add(c.getStringCellValue());
						}
						else
						{
							a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							
						}
					}
				}
			}
			}
			
			
		}
		return a;
	}
	public static void main(String[] args) throws IOException {
		
	}
}
