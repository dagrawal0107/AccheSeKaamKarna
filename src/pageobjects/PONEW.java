package pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.provar.core.testapi.annotations.*;

@Page( title="PONEW"                                
     , summary=""
     , relativeUrl=""
     , connection="DevOrg"
     )             
public class PONEW {

	@LinkType()
	@FindBy(xpath = "//a[normalize-space(.)='Setup']")
	public WebElement setup;
	@LinkType()
	@FindBy(xpath = "//li[@id='related_setup_app_home']/a")
	public WebElement new_;
	@TextType()
	@FindBy(xpath = "//input[@placeholder='Quick Find']")
	public WebElement quickFind;
	@LinkType()
	@FindBy(xpath = "//mark")
	public WebElement customSettings;
	
    
	@PageFrame()
	public static class Frame {

		@PageRow()
    public static class Example {
    
		 @TextType()
        @FindBy(xpath = "./th/a") //table column
        public WebElement Company;
        @FindBy(xpath = "./td/a[text()='Manage']") 
        public WebElement Manage;
        
    }
    
     @FindBy(xpath = "(//table[@class='list']/tbody/tr[@class!='headerRow'])") //table Xpath
    @PageTable(firstRowContainsHeaders = false, row = Example.class)
    public List<Example> example;
	}
	@FindBy(xpath = "//iframe")
	public Frame frame;
	
	
			
}
