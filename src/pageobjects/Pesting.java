package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.provar.core.testapi.annotations.*;

@Page( title="Pesting"                                
     , summary=""
     , relativeUrl=""
     , connection="DevOrg"
     )             
public class Pesting {
			
			WebDriver driver;
			public Pesting(WebDriver driver){
					this.driver=driver;
					}
		@TextType()
		@FindBy(xpath = "id=123")
		public WebElement Hello;
		
		public String title() {
		
		String a=driver.getTitle();
			return a;
		
		}
		
		
}
