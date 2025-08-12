package Project;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class FindBikes {
	public static WebDriver driver;
	SoftAssert asrt = new SoftAssert(); 
	WebDriverWait wait;
	
	
	@BeforeClass
	public void DriverSetup() throws IOException {
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	

	@Test(priority = 1)
	public void Maximize() throws Exception {
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
	public void searchBikes() {
		SearchBikes sb = new SearchBikes(driver);
		sb.search();
	}
	
	@Test(priority=3)
	public void upcoming() {
		upComing up = new upComing(driver);
		up.upcoming();
		up.selectBrand();
	}
	
	@Test(priority=4)
	public void selectbrand() {
		selectBrand sb = new selectBrand(driver);
		sb.select();
	}
	
	
	@Test(priority=5)
	public void getBikes() throws IOException {
		Bikes b= new Bikes(driver);
		System.out.println("Available Bikes:");
		for(WebElement bike:b.bike()) {
			System.out.println(bike.getText());
		}
		ApacheCode ac=new ApacheCode();
		ac.writeResult();
	}
	
	@Test(priority=6)
	public void getPrices() {
		Bikes b= new Bikes(driver);
		System.out.println("Prices:");
		for(WebElement price:b.price()) {
			System.out.println(price.getText());
		}
		
	}
	
	@Test(priority=7)
	public void getdates() {
		Bikes b= new Bikes(driver);
		System.out.println("Expected dates:");
		for(WebElement dat:b.date()) {
			System.out.println(dat.getText());
		}
	}
	
	@Test(priority=8)
	public void more() {
		Bikes b= new Bikes(driver);
		b.moreInfo();
		b.selectOption();
	}
	
	@Test(priority=9)
	public void selectCity() {
		selectCity sc= new selectCity(driver);
		sc.selectcity();
	}
	
	@Test(priority=10)
	public void getbrands() throws IOException {
		getBrands gb= new getBrands(driver);
		System.out.println("Available car brands");
		for(WebElement dat:gb.getbrands()) {
			System.out.println(dat.getText());
		}
		ApacheCode ac=new ApacheCode();
		ac.writeCars();
		
	}
	
	@Test(priority=11)
	public void gmailLogin() {
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
	}
	
	@Test(priority=12)
	public void screenShot() {
		File target = new File(System.getProperty("user.dir") + "\\Screenshot\\error.png");
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		src.renameTo(target);
		
	}
	
	@AfterClass
	public void close() {
		driver.quit();
	}

}
