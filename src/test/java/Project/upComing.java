package Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class upComing {
	WebDriver driver;
	
	public upComing(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//li[text()='Upcoming']")
	WebElement search;
	
	@FindBy(xpath="//a[@title='All Upcoming Bikes']")
	WebElement Brand;
	
	public void upcoming() {
		search.click();
	}
	
	public void selectBrand() {
		Actions act = new Actions(driver);
		act.moveToElement(Brand).click().perform();
	}

}
