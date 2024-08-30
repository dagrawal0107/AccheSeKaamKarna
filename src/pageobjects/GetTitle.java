package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.provar.core.testapi.annotations.*;

@Page( title="Get Title"                                
     , summary=""
     , relativeUrl=""
     , connection="DevOrg"
     )             
public class GetTitle {

WebDriver driver;
public  GetTitle(WebDriver driver){
this.driver =driver;
}

public String getURL(){
return driver.getCurrentUrl();
}
			
}
