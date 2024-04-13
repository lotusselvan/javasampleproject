package Package1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	

	WebDriver driver;

	public void switchToFrameByIdName(String idName) {
		driver.switchTo().frame(idName);
	}

	
	public void switchToFrameByIndex(int index) {
		driver.switchTo().frame(index);
	}

	public void switchToFrameByWebElement(WebElement element) {
		driver.switchTo().frame(element);
	}
	
	//switchToChildWindow
	public void switchToChildWindow() {
		String pWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		for (String eachWindow : allWindows) {
			if (!pWindow.equals(eachWindow)) {
				driver.switchTo().window(eachWindow);
			}

		}
	}
	
	//getAllOptionsText
	public List<String> getAllOptionsTextDD(WebElement element) {
		List<String> allOptionsText = new ArrayList<>();
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		for (WebElement webElement : options) {
			String text = webElement.getText();
			allOptionsText.add(text);

		}
		return allOptionsText;
	}
	
	//url
	public String getProjectPath() {
		String property = System.getProperty("user.dir");
		return property;
	}
	
	//takescreen shoot
	public void screenshot(String name) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotAs, new File(getProjectPath() + "\\screenshot\\" + name + ".png"));
	}

	public void visiblityOf(WebElement element) {
		WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driverWait.until(ExpectedConditions.visibilityOf(element));

	}

	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}

	public void implicitWait(int secs) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(secs));

	}
	
	
	public void elementSendKeysJS(WebElement element, String data) {
		visiblityOf(element);

		if (isEnabled(element) && isDisplayed(element)) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].setAttribute('value','" + data + "')", element);
		}
	}

	public void selectOptionByText(WebElement element, String text) {
		visiblityOf(element);
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public void selectOptionByIndex(WebElement element, int index) {
		visiblityOf(element);
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void browserLaunch(String browserType) {
		switch (browserType) {
		case "CHROME":
			driver = new ChromeDriver();
			break;
		case "IE":
			driver = new InternetExplorerDriver();
			break;
		case "EDGE":
			driver = new FirefoxDriver();
			break;
		case "FIREFOX":
			driver = new ChromeDriver();
			break;

		default:
			break;
		}

	}

	public void enterApplnUrl(String url) {
		driver.get(url);

	}

	public void maximizeWindow() {
		driver.manage().window().maximize();
	}

	public void elementSendKeys(WebElement element, String data) {
		visiblityOf(element);

		if (isEnabled(element) && isDisplayed(element)) {
			element.sendKeys(data);
		}
	}

	public void elementClick(WebElement element) {
		visiblityOf(element);
		if (isEnabled(element) && isDisplayed(element)) {

			element.click();
		}
	}

	public String getApplnTitle() {
		String title = driver.getTitle();
		return title;
	}

	public WebElement findLocatorById(String attributeValue) {
		WebElement element = driver.findElement(By.id(attributeValue));
		return element;
	}

	public WebElement findLocatorByName(String attributeValue) {
		WebElement element = driver.findElement(By.name(attributeValue));
		return element;
	}

	public WebElement findLocatorByClassName(String attributeValue) {
		WebElement element = driver.findElement(By.className(attributeValue));
		return element;
	}

	public WebElement findLocatorByXpath(String xpathExp) {
		WebElement element = driver.findElement(By.xpath(xpathExp));
		return element;
	}

	public boolean isDisplayed(WebElement element) {
		visiblityOf(element);
		boolean displayed = element.isDisplayed();
		return displayed;
	}

	public boolean isEnabled(WebElement element) {
		visiblityOf(element);
		boolean displayed = element.isEnabled();
		return displayed;
	}

	public String elementGetText(WebElement element) {
		visiblityOf(element);
		String text = null;
		if (isDisplayed(element)) {
			text = element.getText();
		}
		return text;
	}

	public String elementGetAttribute(WebElement element) {
		visiblityOf(element);
		String attribute = null;
		if (isDisplayed(element)) {
			attribute = element.getAttribute("value");
		}
		return attribute;
	}

	public String elementGetAttribute(WebElement element, String attributeName) {
		visiblityOf(element);
		String attribute = element.getAttribute(attributeName);
		return attribute;
	}
	public void closeBrowser() {
	driver.close();
	}
	
}
