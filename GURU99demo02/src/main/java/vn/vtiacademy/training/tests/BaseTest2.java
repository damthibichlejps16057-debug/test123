package vn.vtiacademy.training.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import vn.vtiacademy.training.pages.EditCustomer2;
import vn.vtiacademy.training.pages.Login2;
import vn.vtiacademy.training.pages.Manager2;
import vn.vtiacademy.training.pages.NewCustomer2;
import vn.vtiacademy.training.utils.keywords.WebUI;

public class BaseTest2 {

  public static final String DEMO_URL = "https://demo.guru99.com/V4";

  protected static final String MANAGER_USER_ID = "mngr666663";
  protected static final String MANAGER_PASSWORD = "bEbUzAh";

  protected WebUI webUI;
  protected Login2 objLogin;
  protected Manager2 objManager;
  protected NewCustomer2 objNewCustomer;
  protected EditCustomer2 objEditCustomer;

  @BeforeTest
  public void beforeTest() {
    webUI = new WebUI();
    webUI.openBrowser("chrome", DEMO_URL);
    webUI.maximizeWindow();
    objLogin = new Login2(webUI);
    objNewCustomer = new NewCustomer2(webUI);
//    objManager = new Manager(webUI);
    objEditCustomer = new EditCustomer2(webUI);
  }

  @AfterTest
  public void afterTest() {
    webUI.closeBrowser();
  }

  protected void loginAsManager() {
    webUI.navigateTo(DEMO_URL);
    objLogin.inputUserId(MANAGER_USER_ID);
    objLogin.inputUserPassword(MANAGER_PASSWORD);
    objLogin.clickLoginButton();
  }
}


