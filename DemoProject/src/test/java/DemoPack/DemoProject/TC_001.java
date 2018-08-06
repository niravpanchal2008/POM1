package DemoPack.DemoProject;

import org.testng.annotations.Test;

import DemoPack.DemoProject.LoginPage.LoginPageUI;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;

public class TC_001 extends BasePage {

	public static final Logger log = Logger.getLogger(TC_001.class.getName());
	
	LoginPageUI page;
	
	@BeforeMethod
	@Parameters("browser")
	  public void startProcess() throws Exception {
		BrowserLaunch("chrome",getData("url"));
	  }
	  
	  @Test
	  public void customerRegistration() throws Exception {
		  
		  log.info("------Starting TC_001 Test------");
		  
		  page=new LoginPageUI(driver);
		  page.customerRegistration();
		  
		  log.info("------Ending TC_001 Test------");
	  }
	  
	  @AfterMethod
	  public void endProcess() {
	  }

}
