package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import com.provar.core.testapi.annotations.*;

@Page( title="Allow Third Party Cookies"                                
     , summary=""
     , relativeUrl=""
     , connection="DevOrg"
     )             
public class AllowThirdPartyCookies {

public void Hello() {
        // Path to your chromedriver executable
        String chromedriverPath = "D:/Deepak/Download/Slack/chromedriver.exe";
        
        // Initialize Chrome WebDriver with existing Chrome session
        System.setProperty("webdriver.chrome.driver", chromedriverPath);
        WebDriver driver = new ChromeDriver();
        
        // Navigate to a different website
        driver.get("chrome://settings/");

        // Wait for the settings menu to be clickable
        WebElement settingsMenu = driver.findElement(By.cssSelector("button[aria-label='Settings']"));
        settingsMenu.click();

        // Find and click on the "Site settings" option
        WebElement siteSettingsOption = driver.findElement(By.xpath("//span[text()='Site settings']"));
        siteSettingsOption.click();

        // Find and click on the "Cookies" option
        WebElement cookiesOption = driver.findElement(By.xpath("//span[text()='Cookies']"));
        cookiesOption.click();

        // Wait for the "Block third-party cookies" toggle to be clickable
        WebElement toggle = driver.findElement(By.xpath("//span[contains(text(), 'Block third-party cookies')]/parent::div/following-sibling::div//div[@role='switch']"));
        toggle.click();

        // Close the WebDriver session
        //driver.quit();
        
    }

			
}
