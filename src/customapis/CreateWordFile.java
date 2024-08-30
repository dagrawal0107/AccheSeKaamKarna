package customapis;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Logger;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import com.provar.core.model.base.api.ValueScope;
import com.provar.core.testapi.ITestExecutionContext;
import com.provar.core.testapi.annotations.TestApi;
import com.provar.core.testapi.annotations.TestApiExecutor;
import com.provar.core.testapi.annotations.TestApiParameter;
import com.provar.core.testapi.annotations.TestApiParameterGroup;
import com.provar.core.testapi.annotations.TestApiParameterGroups;
import com.provar.core.testapi.annotations.TestExecutionContext;
import com.provar.core.testapi.annotations.TestLogger;

@TestApi(title = "Create Word File", summary = "", remarks = "", iconBase = "", defaultApiGroups = { "Custom" })
@TestApiParameterGroups(parameterGroups = { @TestApiParameterGroup(groupName = "inputs", title = "Inputs"),
		@TestApiParameterGroup(groupName = "result", title = "Result"), })
public class CreateWordFile {

	@TestApiParameter(seq = 1, summary = "Path of the file", remarks = "", mandatory = true, parameterGroup = "inputs")
	public String filePath;

	@TestApiParameter(seq = 2, summary = "Do you want to make fonts Bold", remarks = "", mandatory = false, parameterGroup = "inputs")
	public boolean setBold;

	@TestApiParameter(seq = 3, summary = "Do you want to make fonts Italic", remarks = "", mandatory = false, parameterGroup = "inputs")
	public boolean setItalic;

	@TestApiParameter(seq = 4, summary = "Enter the size of font you want", remarks = "", mandatory = true, parameterGroup = "inputs")
	public int fontSize;

	@TestApiParameter(seq = 5, summary = "Enter the text you want in your word file", remarks = "", mandatory = true, parameterGroup = "inputs")
	public String text;

	@TestApiParameter(seq = 6, summary = "", remarks = "", mandatory = true, parameterGroup = "inputs")
	public String fontName;

	@TestApiParameter(seq = 7, summary = "", remarks = "", mandatory = true, parameterGroup = "inputs")
	public String paragraphAlignment;

	@TestApiParameter(seq = 10, summary = "The name that the result will be stored under.", remarks = "", mandatory = true, parameterGroup = "result")
	public String resultName;

	@TestApiParameter(seq = 11, summary = "The lifespan of the result.", remarks = "", mandatory = true, parameterGroup = "result", defaultValue = "Test")
	public ValueScope resultScope;

	/**
	 * Used to write to the test execution log.
	 */
	@TestLogger
	public Logger testLogger;

	/**
	 * Provides access to facilities, mainly to set and get variable values.
	 */
	@TestExecutionContext
	public ITestExecutionContext testExecutionContext;

	@TestApiExecutor
	public void createWordFile() throws FileNotFoundException, IOException {
		String fileName = filePath;
		XWPFParagraph paragraph;

		try (XWPFDocument doc = new XWPFDocument()) {

			// create a paragraph
			paragraph = doc.createParagraph();

			// Setting Alignment
			if (paragraphAlignment.equalsIgnoreCase("left")) {
				paragraph.setAlignment(ParagraphAlignment.LEFT);
			}
			if (paragraphAlignment.equalsIgnoreCase("center")) {
				paragraph.setAlignment(ParagraphAlignment.CENTER);
			}
			if (paragraphAlignment.equalsIgnoreCase("right")) {
				paragraph.setAlignment(ParagraphAlignment.RIGHT);
			}

			// set font
			XWPFRun run = paragraph.createRun();
			run.setBold(setBold);
			run.setItalic(setItalic);
			run.setFontSize(fontSize);
			run.setFontFamily(fontName);
			run.setText(text);

			// Create new File
			File file = new File(fileName);
			if (!file.exists()) {
				file.getParentFile().mkdirs();
				file.createNewFile();
			}

			// save it to .docx file
			try (FileOutputStream out = new FileOutputStream(file)) {
				doc.write(out);
			}

		}

		testExecutionContext.setValue(resultName, fileName, resultScope);

	}
}
