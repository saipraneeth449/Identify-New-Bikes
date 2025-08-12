package Project;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class getBrands {

	WebDriver driver;
	public getBrands(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='gsc_thin_scroll']/ul/li")
	List<WebElement> brands;
	
	
	public List<WebElement> getbrands(){
		return brands;
	}
}
