package pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.provar.core.testapi.annotations.*;

@Page( title="TablePO"                                
     , summary=""
     , relativeUrl=""
     , connection="DevOrg"
     )             
public class TablePO {

	@LinkType()
	@FindBy(xpath = "//div[contains(@class,'active') and contains(@class,'oneContent')]//a[normalize-space(.)='DeepakX06']")
	public WebElement ACCOUNT_NAME;

	@PageFrame()
	public static class Frame {

		@TextType()
		@FindBy(xpath = "//input")
		public WebElement Hello;
	}

	@FindBy(xpath = "//iframe[contains(@id,'singleframe')]")
	public Frame frame;

	@PageFrame()
	public static class OuterFrame {

		@FindBy(xpath = "//iframe")
		public InnerFrame innerFrame;
	}

	@FindBy(xpath = "//div[contains(@class, \"tab-content\")]/div[2]//iframe")
	public OuterFrame outerFrame;

	@PageFrame()
	public static class InnerFrame {

		@TextType()
		@FindBy(xpath = "//input")
		public WebElement h;
	}
			
}
