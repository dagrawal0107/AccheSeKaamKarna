package pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.spire.xls.ExcelVersion;
import com.spire.xls.Workbook;
import com.spire.xls.Worksheet;

import com.provar.core.testapi.annotations.*;

@Page( title="URL"                                
     , summary=""
     , relativeUrl=""
     , connection="DevOrg"
     )             
public class URL {

	@TextType()
	@FindBy(xpath = "//td[normalize-space(.)='Alfreds Futterkiste']")
	public WebElement hello;
	@TextType()
	@FindBy(xpath = "//div[@class='___917j710 ftgm304 fly5x3f fwrgwhw f15tpi3i f10pi13n frecw6t f1mmgjok f1tto2h8 f1c2pb84 fyft3pb f1rof34y f1172n73 f4hylce f18s3fau f1ymw6u3 f1xqrj1d f160kle0 f6rydpu f1i9lmva fspveqh f2x7bcd f1imcvf3 f1bxicz3 f1kf6f3a fajq0z4 fyw0hav f1a7xkls fnpm3l fsc3mvo f1s66rt0 f73ugz1 f1iw8vv5 f5iv370 f1ytw2m8 feh5m5c f7upnml fexuuuk fklagwq fsjklvg f1uvsclk f123zcai']//input")
	public WebElement emailPhoneOrSkype;
	@ButtonType()
	@FindBy(xpath = "//div[@class='ext-button-item ___frx9oy0 f14t3ns0']//button")
	public WebElement next;
	@TextType()
	@FindBy(xpath = "//input[@name='passwd']")
	public WebElement emailPhoneOrSkype1;
	@ButtonType()
	@FindBy(xpath = "//div[@class='ext-button-item ___frx9oy0 f14t3ns0']//button")
	public WebElement next1;
	@ButtonType()
	@FindBy(xpath = "//span[text()='Testing']")
	public WebElement next2;
	@TextType()
	@FindBy(xpath = "//span/span[normalize-space(.)='Sales']")
	public WebElement f;
	@TextType()
	@FindBy(xpath = "//input[@id='username']")
	public WebElement username;
	@TextType()
	@FindBy(xpath = "//input[@id='password']")
	public WebElement password;
	@ButtonType()
	@FindBy(xpath = "//button[@id='submit']")
	public WebElement submit;
			
}
