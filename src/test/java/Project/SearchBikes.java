package Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class SearchBikes {
	
	 WebDriver driver;

	public SearchBikes(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@title='New Bikes']")
	WebElement search;
	
	@FindBy(xpath="//div[@id='forum_login_title_lg']")
	WebElement Login;
	
	@FindBy(xpath="//div[@class='lgn-sc c-p txt-l pl-30 pr-30 googleSignIn']")
	WebElement signin;
	
	@FindBy(xpath="//input[@type='email']")
	WebElement user;
	
	@FindBy(xpath="//span[@class='VfPpkd-vQzf8d' and text()='Next']")
	WebElement next;
	
	
	
	
	public void search() {
		search.click();
	}
	
	public void clickLogin() {
		Login.click();
	}
	
	public void clickSign() {
		signin.click();
	}
	
	public void sendUsername(String username) {
		user.sendKeys(username);
	}
	
	public void clickNext() {
		next.click();
	}
	
	
	
	
	
	
}
