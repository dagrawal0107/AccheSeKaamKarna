package customapis;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
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

@TestApi(title = "Write Word File", summary = "", remarks = "", iconBase = "", defaultApiGroups = { "Custom" })
@TestApiParameterGroups(parameterGroups = { @TestApiParameterGroup(groupName = "inputs", title = "Inputs"),
		@TestApiParameterGroup(groupName = "result", title = "Result"), })
public class WriteWordFile {

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

	@TestApiParameter(seq = 6, summary = "", remarks = "", mandatory = false, parameterGroup = "inputs")
	public int paragraphNumber;

	@TestApiParameter(seq = 7, summary = "", remarks = "", mandatory = false, parameterGroup = "inputs")
	public boolean newParagraph;

	@TestApiParameter(seq = 8, summary = "", remarks = "", mandatory = true, parameterGroup = "inputs")
	public String fontName;

	@TestApiParameter(seq = 9, summary = "", remarks = "", mandatory = true, parameterGroup = "inputs")
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
	public void execute() throws FileNotFoundException, IOException {
		try (XWPFDocument doc = new XWPFDocument(Files.newInputStream(Paths.get(filePath)))) {
			List<XWPFParagraph> paragraphList = doc.getParagraphs();
			if (newParagraph || paragraphNumber > paragraphList.size()) {
				XWPFParagraph paragraph = doc.createParagraph();
				if (paragraphAlignment.equalsIgnoreCase("left")) {
					paragraph.setAlignment(ParagraphAlignment.LEFT);
				}
				if (paragraphAlignment.equalsIgnoreCase("center")) {
					paragraph.setAlignment(ParagraphAlignment.CENTER);
				}
				if (paragraphAlignment.equalsIgnoreCase("right")) {
					paragraph.setAlignment(ParagraphAlignment.RIGHT);
				}
				XWPFRun run_new = paragraph.createRun();
				run_new.setBold(setBold);
				run_new.setItalic(setItalic);
				run_new.setFontSize(fontSize);
				run_new.setFontFamily(fontName);
				run_new.setText(text);
			} else {

				XWPFRun run = paragraphList.get(paragraphNumber - 1).createRun();
				run.setBold(setBold);
				run.setItalic(setItalic);
				run.setFontSize(fontSize);
				run.setFontFamily(fontName);
				run.setText(" " + text);
			}
			// save the docs
			try (FileOutputStream out = new FileOutputStream(filePath)) {
				doc.write(out);
			}
		}
		testExecutionContext.setValue(resultName, filePath, resultScope);
	}
}
