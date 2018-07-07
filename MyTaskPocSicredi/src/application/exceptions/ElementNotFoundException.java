package application.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

public class ElementNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = -5004631855141985837L;

	public ElementNotFoundException(By locatorProgressBarActive){
		super("Element not found: "+ locatorProgressBarActive);
	}

	public ElementNotFoundException(By locator, TimeoutException e) {
		super("Element not found: "+ locator, e);
	}
	
	public void saveScreenshot(String fileName, WebDriver driver){
		String rootPath = "C:\\temp\\";
		String now = new SimpleDateFormat(".yyMMddHHmm").format(new Date());

		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File tgtFile = new File(rootPath + fileName + now + ".png");
			
		File file = new File(rootPath + fileName + now + ".log");
		PrintStream ps = null;
		try {
			ps = new PrintStream(file);
			
		} catch (FileNotFoundException e1) {
				System.out.println(e1);
		} finally{
			    ps.close();
		}
			
		try {
			FileUtils.copyFile(scrFile, tgtFile);
		} catch (IOException e) {
			System.out.println(e);
		}
	}	
}
