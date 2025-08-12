package Project;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Bikes {

	
	WebDriver driver;
	public Bikes(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public Bikes() {
		
	}

	@FindBy(xpath="//div[@class='p-15 pt-10 mke-ryt rel']/a")
	List<WebElement> bikes;
	
	@FindBy(xpath="//div[@class='b fnt-15']")
	List<WebElement> prices;
	
	@FindBy(xpath="//div[@class='clr-try fnt-14']")
	List<WebElement> dates;
	
	@FindBy(xpath="//span[@class='c-p icon-down-arrow']")
	WebElement more;
	
	@FindBy(xpath="//a[@title='Used Cars']")
	WebElement option;
	
	
	public List<WebElement> bike(){
		return bikes;
	}
	
	public List<WebElement> price(){
		return prices;
	}
	
	public List<WebElement> date(){
		return dates;
	}
	
	public void moreInfo() {
		more.click();
	}
	
	public void selectOption() {
		option.click();
	}
}
