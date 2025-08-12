package Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class selectBrand {
	
WebDriver driver;
	
	public selectBrand(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Honda']")
	WebElement brand;
	
	
	public void select() {
		Actions act = new Actions(driver);
		act.moveToElement(brand).click().perform();
	}

}
