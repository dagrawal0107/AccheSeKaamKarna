package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.provar.core.testapi.annotations.*;

@Page( title="New Page"                                
     , summary=""
     , relativeUrl=""
     , connection="DevOrg"
     )             
public class NewPage {

	WebDriver driver ;
	public NewPage(WebDriver driver){
		this.driver=driver;
	}
	public String getCurrentUrl(){
	
	return driver.getCurrentUrl();
	}
	@TextType()
	@FindBy(xpath = "//th[normalize-space(.)='Company']")
	public WebElement Name; 
	
			
}
