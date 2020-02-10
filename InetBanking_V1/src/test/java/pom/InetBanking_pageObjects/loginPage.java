package pom.InetBanking_pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

   public class loginPage {

	WebDriver ldriver;
	
	public loginPage(WebDriver rdriver){
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(name="uid")
	WebElement txtUserName;
	
	@FindBy(name="password")
	WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	WebElement btnLogin;
	
	@FindBy(linkText="Log out")
	WebElement btnLogout;
  
   public void setUserName(String userName) {
	   
	   txtUserName.sendKeys(userName);
   }
   
   public void setpw(String pw) {
	   
	   txtPassword.sendKeys(pw);
   }

   public void clickSubmit() {
	   
	   btnLogin.click();
}
   public void clickLogout() {
	   
	   //btnLogout.click();
	   
	Actions action=new Actions(ldriver);
	action.moveToElement(btnLogout).build().perform();
}
   
   }
