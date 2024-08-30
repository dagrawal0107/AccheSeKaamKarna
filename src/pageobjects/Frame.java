package pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.provar.core.testapi.annotations.*;

@Page( title="Frame"                                
     , summary=""
     , relativeUrl=""
     , connection="Frame"
     )             
public class Frame {

	@PageFrame()
	public static class Frame1 {
	
	@TextType()
	@FindBy(xpath = "//input")
	public WebElement Hello;
	}

	@FindBy(xpath = "//iframe[contains(@id,'singleframe')]")
	public Frame frame;
	
	
			
}
