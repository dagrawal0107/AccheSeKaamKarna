package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.provar.core.model.ui.api.UiFacet;
import com.provar.core.testapi.annotations.*;

@Page( title="Table Page Object"                                
     , summary=""
     , relativeUrl=""
     , connection="TableConnection"
     )             
public class TablePageObject {

	WebDriver driver;
	public TablePageObject(WebDriver driver){
			this.driver = driver;
}
	 @PageRow()
    public static class Example {
    
		 @TextType()
        @FindBy(xpath = "./td[1]") //table column
        public WebElement Company;
        @TextType()
        @FindBy(xpath = "./td[2]") //table column
        public WebElement Contact;
    }
    
     @FindBy(xpath = "(//table[@id='customers']//tr)") //table Xpath
    @PageTable(firstRowContainsHeaders = false, row = Example.class)
    public List<Example> example;
			
}
    

        
	 
   

   

