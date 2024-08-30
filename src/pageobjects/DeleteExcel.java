package pageobjects;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.provar.core.testapi.annotations.*;
import com.spire.xls.ExcelVersion;
import com.spire.xls.Workbook;
import com.spire.xls.Worksheet;



@Page( title="Delete Excel"                                
     , summary=""
     , relativeUrl=""
     , connection="DevOrg"
     )             
public class DeleteExcel {

WebDriver driver;
public DeleteExcel(WebDriver driver){
this.driver =driver;
}

public String ABC(){
        //Instantiate a Workbook object
        Workbook workbook = new Workbook();
        //Load the Excel file
        workbook.loadFromFile("C://Users//deepak.agrawal//Desktop//Testing.xlsx");
 
        //Get the first worksheet
        Worksheet sheet = workbook.getWorksheets().get(0);
 
        //Loop through all rows in the worksheet
        for (int i = sheet.getRows().length - 1; i >= 0; i--)
        {
            //Check if the current row is blank
            if (sheet.getRows()[i].isBlank())
            {
                //Delete the blank row
                sheet.deleteRow(i + 1); 
            }
        }
         
        //Save the result file
         //Worksheet worksheet = workbook.getWorksheets().get("Evaluation Warning");
         //workbook.getWorksheets().remove(worksheet);
        workbook.saveToFile("C://Users//deepak.agrawal//Desktop//TestingA.xlsx", ExcelVersion.Version2013);
		return null;
    }
    
   
//    public String acb() {
//        // Load the Excel file
//        Workbook workbook = new Workbook();
//        workbook.loadFromFile("C://Users//deepak.agrawal//Desktop//TestingA.xlsx");
//
//        // Get the worksheet to delete
//        Worksheet worksheet = workbook.getWorksheets().get("Evaluation Warning");
//
//        // Delete the worksheet
//        workbook.getWorksheets().remove(worksheet);
//
//        // Save the changes to the Excel file
//        workbook.saveToFile("C://Users//deepak.agrawal//Desktop//TestingA - Copy.xlsx");
//        //workbook.dispose();
//		return null;
//    
//}

public String asd() {
        String filePath = "C://Users//deepak.agrawal//Desktop//TestingA.xlsx";
        String sheetNameToDelete = "Evaluation Warning";

        try {
            // Load the Excel workbook
            FileInputStream fileInputStream = new FileInputStream(filePath);
            org.apache.poi.ss.usermodel.Workbook workbook = WorkbookFactory.create(fileInputStream);

            // Check if the sheet exists
            int sheetIndexToDelete = workbook.getSheetIndex(sheetNameToDelete);
            if (sheetIndexToDelete != -1) {
                // Remove the sheet
                workbook.removeSheetAt(sheetIndexToDelete);

                // Write the changes back to the Excel file
                FileOutputStream fileOutputStream = new FileOutputStream(filePath);
                workbook.write(fileOutputStream);
                fileOutputStream.close();

                //System.out.println("Sheet '" + sheetNameToDelete + "' deleted successfully.");
            } else {
                //System.out.println("Sheet '" + sheetNameToDelete + "' does not exist in the workbook.");
            }

            // Close workbook and input stream
            workbook.close();
            fileInputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
		return sheetNameToDelete;
    }
			
}
