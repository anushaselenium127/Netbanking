package pom.InetBanking_pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class addNewCustomer {
	
	
	WebDriver Idriver;
	
	public addNewCustomer(WebDriver rdriver) {
		
		this.Idriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(how = How.XPATH, using="/html/body/div[3]/div/ul/li[2]/a")
	WebElement linkaddNewCustomer;
	
	@FindBy(how = How.NAME, using="name")
	WebElement name;
	
	@FindBy(how = How.NAME, using="rad1")
	WebElement radGender;
	
	@FindBy(how = How.NAME, using="dob")
	WebElement txtdob;
	
	@FindBy(how = How.NAME, using="addr")
	WebElement txtAddress;
	
	@FindBy(how = How.NAME, using="city")
	WebElement cityname;
	
	@FindBy(how = How.NAME, using="state")
	WebElement statename;
	
	@FindBy(how = How.NAME, using="pinno")
	WebElement pinNo;

	
	@FindBy(how = How.NAME, using="telephoneno")
	WebElement telNo;
	
	@FindBy(how = How.NAME, using="emailid")
	WebElement EmailId;

	@FindBy(how = How.NAME, using="sub")
	WebElement btnSubmit;
	
	@FindBy(how = How.NAME, using="res")
	WebElement btnReset;

	
    public void addNewCustomer() {
		Actions actions=new Actions(Idriver);
		actions.moveToElement(linkaddNewCustomer).click().build().perform();
	//linkaddNewCustomer.click();	
	
	}
	
	public void setName(String cname) {
		
		name.sendKeys(cname);
		
	}
	
    public void custgender() {
		
    	radGender.click();		
	}
    
    public void custDob(String mm,String dd,String yy) {
		
	 txtdob.sendKeys(mm);
	 txtdob.sendKeys(dd);
	 txtdob.sendKeys(yy);
 
	}
 
    public void custAddress(String address) {
		
	 txtAddress.sendKeys(address);		
	}
 
    public void custCity(String cityName) {
		
	 cityname.sendKeys(cityName);;		
	}
 
    public void custState(String stateName) {
		
	 statename.sendKeys(stateName);;		
	}
 
    public void custpinNo(String pinno) {
		
	 pinNo.sendKeys(pinno);;		
	}
 
    public void custtelNo(String telephoneno) {
		
	 telNo.sendKeys(telephoneno);;		
	}
    public void custemailId(String emailId) {
		
	 EmailId.sendKeys(emailId);;		
	}
 
    public void submitClick() {
	 
	 btnSubmit.click();
	 
   }
 
   public void ResetClick() {
	 
	 btnReset.click(); 
   }


}

































