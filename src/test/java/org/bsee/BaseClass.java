package org.bsee;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
// BROWSER LAUNCH
	public static WebDriver d;
	public static void browserLaunch(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			d = new ChromeDriver();
		} else {
			if (browserName.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				d = new EdgeDriver();
			} else if (browserName.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				d = new FirefoxDriver();
			}
		}
	}
// URL LAUNCH
	public static void urlLaunch(String url) {
		d.get(url);
		d.manage().window().maximize();
	}
// WAITS
	public static void impWait(long sec) {
		d.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	}
	public static void staticWait(int i) throws InterruptedException {
		Thread.sleep(i);
	}
// WEBDRIVER METHODS
	public static String currentUrl() {
		System.out.println(d.getCurrentUrl());
		return d.getCurrentUrl();
	}
	public static String title() {
		System.out.println(d.getTitle());
		return d.getTitle();
	}
	public static void close() {
		d.close();
	}
	public static void quit() {
		d.quit();
	}
// WEBELEMENT
	public static void sendkeys(WebElement e, String value) {
		e.sendKeys(value);
	}
	public static void click(WebElement e) {
		e.click();
	}
	public static void clear(WebElement e) {
		e.clear();
	}
	public static String getText(WebElement e) {
		String gtxt = e.getText();
		System.out.println(gtxt);
		return gtxt;
	}
	public static String getAttribute(WebElement e) {
		String atribute = e.getAttribute("value");
		System.out.println(atribute);
		return atribute;
	}
	public static String getTagname(WebElement e) {
		String tag = e.getTagName();
		System.out.println(tag);
		return tag;
	}
	public static boolean displayed(WebElement e) {
		System.out.println(e.isDisplayed());
		return e.isDisplayed();
	}
	public static boolean enabled(WebElement e) {
		System.out.println(e.isEnabled());
		return e.isEnabled();
	}
	public static boolean selected(WebElement e) {
		System.out.println(e.isSelected());
		return e.isSelected();
	}
	public static Dimension getSize(WebElement e) {
		Dimension ize = e.getSize();
		System.out.println("ize");
		return ize;
	}
// ACTIONS
	public static void dragAndDrop(WebElement src, WebElement des) {
		Actions a = new Actions(d);
		a.dragAndDrop(src, des).perform();
	}
	public static void moveToElement(WebElement m) {
		Actions a = new Actions(d);
		a.moveToElement(m).perform();
	}
	public static void contextClick(WebElement e) {
		Actions a = new Actions(d);
		a.contextClick(e).perform();
	}
	public static void doubleClick(WebElement e) {
		Actions a = new Actions(d);
		a.doubleClick(e).perform();
	}
// ALERTS
	public static void accept() {
		d.switchTo().alert().accept();
	}
	public static void dismiss() {
		d.switchTo().alert().dismiss();
	}
	public static void sndkey(String value) {
		d.switchTo().alert().sendKeys(value);
	}
	public static String gtText() {
		String atxt = d.switchTo().alert().getText();
		System.out.println(atxt);
		return atxt;
	}
// DROPDOWN
	public static void sltIndex(WebElement e, int i) {
		Select s = new Select(e);
		s.selectByIndex(i);
	}
	public static void sltValue(WebElement e, String v) {
		Select s = new Select(e);
		s.selectByValue(v);
	}
	public static void sltVisibleText(WebElement e, String v) {
		Select s = new Select(e);
		s.selectByVisibleText(v);
	}
	public static void deSltIndex(WebElement e, int i) {
		Select s = new Select(e);
		s.deselectByIndex(i);
	}
	public static void deSltValue(WebElement e, String v) {
		Select s = new Select(e);
		s.deselectByValue(v);
	}
	public static void deSltVisibleText(WebElement e, String v) {
		Select s = new Select(e);
		s.deselectByVisibleText(v);
	}
	public static void deSltAll(WebElement e) {
		Select s = new Select(e);
		s.deselectAll();
	}
	public static boolean isMultiple(WebElement e) {
		Select s = new Select(e);
		System.out.println(s.isMultiple());
		return s.isMultiple();
	}
	public static void gtoptions(WebElement e, int i) {
		Select s = new Select(e);
		s.getOptions().get(i);
	}
	public static String gtAllSelected(WebElement e, int i) {
		Select s = new Select(e);
		WebElement alslt = s.getAllSelectedOptions().get(i);
		System.out.println(alslt.getText());
		return alslt.getText();
	}
	public static String gtFirstSelected(WebElement e, int i) {
		Select s = new Select(e);
		WebElement alslt = s.getFirstSelectedOption();
		System.out.println(alslt.getText());
		return alslt.getText();
	}
// SCREENSHOT
	public static void ScreenShot(String name) throws IOException {
		TakesScreenshot tk = (TakesScreenshot) d;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File des = new File(System.getProperty("user.dir") + "src//test//resources//" + name + ".jpg");
		FileUtils.copyFile(src, des);
	}
// JS EXECUTOR
	public static void jsSendkeys(WebElement e, String s) {
		JavascriptExecutor js = (JavascriptExecutor) d;
		js.executeScript("arguments[0].setAttributes('value','" + s + "')", e);
	}
	public static void jseScrollUp(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) d;
		js.executeScript("argumenets[0].scrollIntoView(true)", e);
	}
	public static void jseScrollDown(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) d;
		js.executeScript("argumenets[0].scrollIntoView(false)", e);
	}
// NAVIGATE
	public static void back() {
		d.navigate().back();
	}
	public static void forward() {
		d.navigate().forward();
	}
	public static void refresh() {
		d.navigate().refresh();
	}
// FRAMES
	public static void frameIndex(int i) {
		d.switchTo().frame(i);
	}
	public static void frameId(String id) {
		d.switchTo().frame(id);
	}
	public static void frameWebElement(WebElement w) {
		d.switchTo().frame(w);
	}
	public static void parentFrame() {
		d.switchTo().parentFrame();
	}
	public static void exitFrame() {
		d.switchTo().defaultContent();
	}
// WINDOW HANDLING
	public static String getHandle() {
		System.out.println(d.getWindowHandle());
		return d.getWindowHandle();
	}
	public static Set<String> getHandles() {
		System.out.println(d.getWindowHandles());
		return d.getWindowHandles();
	}
	public static void windowsId(String id) {
		d.switchTo().window(id);
	}
// DATE
	public static void date() {
		Date d = new Date();
		System.out.println(d);
	}
// WEBTABLE
	
//	Only for DD task purpose(=====temp=====)
public static String excel(int row,int cell) throws Exception {
		
		File f=new File("D:\\GreenTech\\Mar19\\test-data\\Login Data.xlsx");
		FileInputStream is=new FileInputStream(f);
		Workbook wbook=new XSSFWorkbook(is);
		Sheet sheet = wbook.getSheetAt(0);
		Row r = sheet.getRow(row);
		Cell c = r.getCell(cell);
		DataFormatter dft = new DataFormatter();
		String value = dft.formatCellValue(c);
	
		return value;

	}

public static String wexcel(int row,int cell,String value) throws Exception {
	
	File f=new File("D:\\GreenTech\\Mar19\\test-data\\Login Data.xlsx");
	FileInputStream is=new FileInputStream(f);
	Workbook wbook=new XSSFWorkbook(is);
	Sheet sheet = wbook.getSheetAt(0);
	Row r = sheet.getRow(row);
	Cell c1 = r.createCell(cell);
	c1.setCellValue(value);
	FileOutputStream fo=new FileOutputStream(f);
	wbook.write(fo);
	fo.close();
	return value;
}
}
