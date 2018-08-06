package DemoPack.DemoProject;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	public static WebDriver driver;
	public static final String path="./data.properties";
	public static final String excelpath = "C:\\Users\\Quennie\\Documents\\testCase.xlsx";
	
	public static String getData(String key) throws Exception {
		File f = new File(path);
		FileInputStream fi = new FileInputStream(f);
		Properties p =new Properties();
		p.load(fi);
//		System.out.println(fi);
//		System.out.println("file :"+p.getProperty(key));
		return p.getProperty(key);
	}
	
	public static void logInitiate() {
		String log4jconf = "./log4j.properties";
		PropertyConfigurator.configure(log4jconf);
	}
	
	public String randomNumber(int range) {
		Random r = new Random();
		if(range == 5) {
			return String.valueOf(r.nextInt(90000)+10000);
		}else if(range == 10) {
			return String.valueOf(r.nextInt(900000000)+100000000);
		}else return null;
	}
	
	public void selectOption(WebElement element, int option) {
		Select s = new Select(element);
		s.selectByIndex(option);
	}
	
	public void waitForElement(WebElement element, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	@SuppressWarnings("unused")
	public void randomListLoad(List<WebElement> element) throws Exception {
		Random r = new Random();
		int listLength = element.size();
		for(int i=0; i<listLength; i++) {
			element.get(r.nextInt(listLength)).click();
			Thread.sleep(10000);
			return;
		}
	}
	
	public static void BrowserLaunch(String browser, String url) {
		logInitiate();
		if(browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromedriver.exe");
			driver = new ChromeDriver();		
		}else if(browser.equalsIgnoreCase("FIREFOX")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//drivers//geckodriver.exe");
			driver = new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"//drivers//IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		driver.get(url);
		driver.manage().window().maximize();
	}
	

}
