package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.provar.core.testapi.annotations.*;

@Page( title="PO Title"                                
     , summary=""
     , relativeUrl=""
     , connection="DifferrentURL"
     )             
public class POTitle {

WebDriver driver;
public POTitle(WebDriver driver)
{
this.driver =driver;

}	

public String FetchTitle(){
return driver.getTitle();
}

@LinkType()
@FindBy(xpath = "//div[@class='column slds-size_1-of-1 slds-medium-size_4-of-12 slds-large-size_4-of-12 region-sidebar-right']//li[@class='slds-tabs_default__item slds-is-active']//a[@class='slds-tabs_default__link']")
public WebElement chatter;		
}
