package Project;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



public class FindBikes {
	public static WebDriver driver;
	 static Logger logger;
	SoftAssert asrt = new SoftAssert(); 
	WebDriverWait wait;
	
	
	@BeforeClass
	@Parameters({ "browser" })
	public void DriverSetup(String browser) throws IOException {
		logger = LogManager.getLogger(FindBikes.class);
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		else {
			System.setProperty("webdriver.edge.driver",
					"C:\\Users\\2419228\\Downloads\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
	}
	

	@Test(priority = 1)
	@Parameters({ "browser" })
	public void Maximize(String browser) throws Exception {
		logger.info("Navigating to the Website");
		driver.get("https://www.zigwheels.com/");
		driver.manage().window().maximize();
		if (driver.getTitle().equals("New Cars & Bikes, Prices, News, Reviews, Buy & Sell Used Cars - ZigWheels.com")) {
			asrt.assertTrue(true);
		} else {
			asrt.fail();
		}
		asrt.assertAll();
	}
	
	
	@Test(priority=2)
	@Parameters({ "browser" })
	public void searchBikes(String browser) {
		logger.info("Searching bikes");
		SearchBikes sb = new SearchBikes(driver);
		sb.search();
		asrt.assertTrue(true);
	}
	
	@Test(priority=3)
	@Parameters({ "browser" })
	public void upcoming(String browser) {
		upComing up = new upComing(driver);
		up.upcoming();
		up.selectBrand();
		asrt.assertTrue(true);
	}
	
	@Test(priority=4)
	@Parameters({ "browser" })
	public void selectbrand(String browser) {
		selectBrand sb = new selectBrand(driver);
		sb.select();
		asrt.assertTrue(true);
	}
	
	
	@Test(priority=5)
	@Parameters({ "browser" })
	public void getBikes(String browser) throws IOException {
		logger.info("Printing bike names");
		Bikes b= new Bikes(driver);
		System.out.println("Available Bikes:");
		System.out.println();
		for(WebElement bike:b.bike()) {
			System.out.println(bike.getText());
		}
		System.out.println();
		ApacheCode ac=new ApacheCode();
		ac.writeResult(browser);
		
		if(b.bike().size()>0) {
			asrt.assertTrue(true);
		}
		else {
			asrt.assertTrue(false);
		}
	}
	
	@Test(priority=6)
	@Parameters({ "browser" })
	public void getPrices(String browser) {
		logger.info("Printing prices");
		Bikes b= new Bikes(driver);
		System.out.println("Prices:");
		System.out.println();
		for(WebElement price:b.price()) {
			System.out.println(price.getText());
		}
		System.out.println();
		if(b.price().size()>0) {
			asrt.assertTrue(true);
		}
		else {
			asrt.assertTrue(false);
		}
		
	}
	
	@Test(priority=7)
	@Parameters({ "browser" })
	public void getdates(String browser) {
		Bikes b= new Bikes(driver);
		logger.info("Printing dates");
		System.out.println("Expected dates:");
		System.out.println();
		for(WebElement dat:b.date()) {
			System.out.println(dat.getText());
		}
		System.out.println();
		if(b.date().size()>0) {
			asrt.assertTrue(true);
		}
		else {
			asrt.assertTrue(false);
		}
	}
	
	@Test(priority=8)
	@Parameters({ "browser" })
	public void more(String browser) {
		Bikes b= new Bikes(driver);
		b.moreInfo();
		b.selectOption();
		asrt.assertTrue(true);
	}
	
	@Test(priority=9)
	@Parameters({ "browser" })
	public void selectCity(String browser) {
		selectCity sc= new selectCity(driver);
		sc.selectcity();
		asrt.assertTrue(true);
	}
	
	@Test(priority=10)
	@Parameters({ "browser" })
	public void getbrands(String browser) throws IOException {
		logger.info("Printing cars");
		getBrands gb= new getBrands(driver);
		System.out.println("Available car brands");
		System.out.println();
		for(WebElement dat:gb.getbrands()) {
			System.out.println(dat.getText());
		}
		System.out.println();
		ApacheCode ac=new ApacheCode();
		ac.writeCars();
		if(gb.getbrands().size()>0) {
			asrt.assertTrue(true);
		}
		else {
			asrt.assertTrue(false);
		}
	}
	
	@Test(priority=11)
	@Parameters({ "browser" })
	public void gmailLogin(String browser) {
		driver.navigate().to("https://www.zigwheels.com/");
		SearchBikes sb = new SearchBikes(driver);
		String Parent=driver.getWindowHandle();
		sb.clickLogin();
		sb.clickSign();

		Set<String> hansle=driver.getWindowHandles();
		for(String id:hansle) {
			if(!(id.equals(Parent))) {
				driver.switchTo().window(id);
			}
			
		}
		sb.sendUsername("saipraneeth@@gmail.com");
		sb.clickNext();
		asrt.assertTrue(true);
	}
	
	@Test(priority=12)
	@Parameters({ "browser" })
	public void screenShot(String browser) {
		File target = new File(System.getProperty("user.dir") + "\\Screenshot\\error.png");
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		src.renameTo(target);
		asrt.assertTrue(true);
		
	}
	
	@AfterClass
	public void close() {
		driver.quit();
	}

}
