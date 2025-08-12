package Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class selectCity {

	
	WebDriver driver;
	public selectCity(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@title='Chennai']")
	WebElement city;
	
	public void selectcity() {
		Actions act = new Actions(driver);
		act.moveToElement(city).click().perform();
	}
	
}
