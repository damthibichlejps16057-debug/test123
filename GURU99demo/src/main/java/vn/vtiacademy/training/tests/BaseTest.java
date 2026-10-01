package vn.vtiacademy.training.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import vn.vtiacademy.training.pages.EditCustomer;
import vn.vtiacademy.training.pages.Login;
import vn.vtiacademy.training.pages.Manager;
import vn.vtiacademy.training.pages.NewCustomer;
import vn.vtiacademy.training.utils.keywords.WebUI;

public class BaseTest {

  public static final String DEMO_URL = "https://demo.guru99.com/V4";

  protected static final String MANAGER_USER_ID = "mngr666663";
  protected static final String MANAGER_PASSWORD = "bEbUzAh";

  protected WebUI webUI;
  protected Login objLogin;
  protected Manager objManager;
  protected NewCustomer objNewCustomer;
  protected EditCustomer objEditCustomer;

  @BeforeTest
  public void beforeTest() {
    webUI = new WebUI();
    webUI.openBrowser("chrome", DEMO_URL);
    webUI.maximizeWindow();
    objLogin = new Login(webUI);
    objNewCustomer = new NewCustomer(webUI);
//    objManager = new Manager(webUI);
    objEditCustomer = new EditCustomer(webUI);
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


