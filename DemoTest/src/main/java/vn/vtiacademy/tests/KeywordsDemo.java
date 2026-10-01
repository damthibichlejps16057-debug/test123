package vn.vtiacademy.tests;

//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import vn.vtiacademy.common.keywords.WebUI;

public class KeywordsDemo {

  private static WebUI webUI;

  //  @BeforeAll
  //  public static void setup(){
  //    webUI = new WebUI();
  //    webUI.openBrowser("Chrome");
  //  }
  private static final String TXT_SELECT_VALUE = "//div[@id='withOptGroup']//div[contains(@class,'placeholder') or contains(@class,'singleValue')]/following-sibling::div";
  private static final String LBL_SELECT_VALUE = "//div[@id='withOptGroup']//div[contains(@class,'placeholder') or contains(@class,'singleValue')]";
  private static final String DDL_SELECT_OPTIONS = "//div[@role='option' and starts-with(@id, 'react-select') and  contains(@id,'-option-')]";

  @BeforeAll
  public static void setup() {
    webUI = new WebUI();
    webUI.openBrowser("Chrome");
  }

  @AfterAll
  public static void tearDown() {
    webUI.closeBrowser();
  }

  @Disabled
  @Test
  public void web_browser_command_demo() throws InterruptedException {
    webUI.navigateTo("https://demoqa.com/webtables");
    webUI.maximizeWindow();
    Thread.sleep(5000);
    webUI.getTitle();
    webUI.getCurrentUrl();
    webUI.getPageSource();
    webUI.navigateTo("https://vnexpress.net");
    Thread.sleep(3000);
    webUI.back();
    Thread.sleep(3000);
    webUI.forward();
    Thread.sleep(3000);
    webUI.refresh();
    Thread.sleep(3000);
  }

  @Disabled
  @Test
  public void web_elements_commands_demo() {
    webUI.navigateTo("https://demoqa.com/text-box");
    webUI.maximizeWindow();
    webUI.delayInSeconds(3);
    webUI.inputText("//input[@id='userName']", "John Doe");
    webUI.delayInSeconds(3);
    webUI.copyText("//input[@id='userName']");
    webUI.delayInMilliSeconds(3000);
    webUI.pasteText("//input[@id='userEmail']");
    webUI.delayInSeconds(3);
    webUI.clearText("//input[@id='userName']");
    webUI.delayInSeconds(3);
    webUI.navigateTo("https://demoqa.com/buttons");
    webUI.delayInSeconds(3);
    webUI.click("//button[normalize-space()='Click Me']");
    webUI.delayInSeconds(3);
  }

  @Disabled
  @Test
  public void not_clickable_then_clickable() {
    webUI.navigateTo("https://demoqa.com/dynamic-properties");
    webUI.maximizeWindow();
    boolean notClickable = webUI.verifyElementNotClickable("//button[@id='enableAfter']");
    webUI.showMessage("Nút chưa thể click được. " + notClickable);
    webUI.delayInSeconds(6);
    webUI.click("//button[@id='enableAfter']");
    webUI.delayInSeconds(2);
    boolean clickable = webUI.verifyElementClickable("//button[@id='enableAfter']");
    webUI.showMessage("Nút đã click được " + clickable);
    webUI.delayInSeconds(2);
  }

  @Disabled
  @Test
  public void invisible_then_visible() {
    webUI.navigateTo("https://demoqa.com/tabs");
    webUI.maximizeWindow();
    boolean invisible = webUI.verifyElementInvisible("//div[@id='demo-tabpane-origin']");
    webUI.showMessage("Nội dung tab Origin đang bị ẩn. " + invisible);
    webUI.delayInSeconds(2);
    webUI.click("//button[@id='demo-tab-origin']");
    webUI.delayInSeconds(2);
    boolean visible = webUI.verifyElementVisible("//div[@id='demo-tabpane-origin']");
    webUI.showMessage("Nội dung tab Origin đã hiển thị. " + visible);
    webUI.delayInSeconds(3);
  }

  @Disabled
  @Test
  public void not_selected_then_selected() {
    webUI.navigateTo("https://demoqa.com/radio-button");
    webUI.maximizeWindow();
    boolean not_selected = webUI.verifyElementNotSelected("//input[@id='yesRadio']");
    webUI.showMessage("Yes chưa ở trạng thái đã chọn." + not_selected);
    webUI.delayInSeconds(2);
    webUI.click("//input[@id='yesRadio']");
    boolean selected = webUI.verifyElementSelected("//input[@id='yesRadio']");
    webUI.showMessage("Yes ở trạng thái đã chọn." + selected);
    webUI.delayInSeconds(3);
  }

  @Disabled
  @Test
  public void verify_elements_commands_demo() {
    webUI.navigateTo("https://demoqa.com/text-box");
    webUI.maximizeWindow();
    webUI.delayInSeconds(3);
    webUI.inputText("//input[@id='userName']", "John Doe");
    webUI.delayInSeconds(3);
    webUI.inputText("//input[@id='userEmail']", "john.doe@mailinator.com");
    webUI.delayInSeconds(3);
    webUI.click("//button[@id='submit']");
    webUI.delayInSeconds(5);
    assertTrue(webUI.verifyElementContainsText("//p[@id='name']", "John Doe"));
  }

  @Disabled
  @Test
  public void validate_full_name_text_box_edited() {
    webUI.navigateTo("https://demoqa.com/text-box");
    webUI.maximizeWindow();
    webUI.inputText("//input[@id='userName']", "John Doe");
    String actualValue = webUI.getAttributeValue("//input[@id='userName']", "value");
    assertEquals("John Doe", actualValue);
    webUI.clearText("//input[@id='userName']");
    actualValue = webUI.getAttributeValue("//input[@id='userName']", "value");
    assertEquals("", actualValue);
  }

  @Disabled
  @Test
  public void validate_full_name_text_box_edited_02() {
    webUI.navigateTo("https://demoqa.com/text-box");
    webUI.maximizeWindow();
    webUI.inputText("//input[@id='userName']", "John Doe");
    assertTrue(webUI.verifyElementAttributeValue("//input[@id='userName']", "value", "John Does"));
    webUI.clearText("//input[@id='userName']");
    assertTrue(webUI.verifyElementAttributeValue("//input[@id='userName']", "value", ""));
  }

  @Disabled
  @Test
  public void validate_email_text_box_with_wrong_email() {
    webUI.navigateTo("https://demoqa.com/text-box");
    webUI.maximizeWindow();
    webUI.inputText("css:input[id='userEmail']", "JohnDoe");
    webUI.click("//button[@id='submit']");
    webUI.waitForCssValue("//input[@id='userEmail']", "border", "0.8px solid rgb(255, 0, 0)", 10);
    assertTrue(
        webUI.verifyCssValue("//input[@id='userEmail']", "border", "0.8px solid rgb(255, 0, 0)"));
  }

  @Disabled
  @Test
  public void get_properties_demo() {
    webUI.navigateTo("https://demoqa.com/text-box");
    webUI.maximizeWindow();
    webUI.inputText("//input[@id='userName']", "John Doe");
    webUI.inputText("//input[@id='userEmail']", "john.doe@mailinator.com");
    webUI.click("//button[@id='submit']");
    webUI.delayInSeconds(2);

    String text = webUI.getText("//p[@id='name']");
    assertEquals("Name:John Doe", text);

    String tagName = webUI.getTagName("//p[@id='name']");
    assertEquals("p", tagName);

    String attributeValue = webUI.getAttributeValue("//p[@id='name']", "id");
    assertEquals("name", attributeValue);

    String colorCss = webUI.getCssValue("//button[@id='submit']", "background-color");
    assertNotNull(colorCss);
  }

  @Disabled
  @Test
  public void verify_element_text_demo() {
    webUI.navigateTo("https://demoqa.com/text-box");
    webUI.maximizeWindow();
    webUI.inputText("//input[@id='userName']", "John Doe");
    webUI.click("//button[@id='submit']");
    webUI.delayInSeconds(2);

    assertTrue(webUI.verifyElementText("//p[@id='name']", "Name:John Doe"));
  }

  @Disabled
  @Test
  public void submit_demo() {
    webUI.navigateTo("https://demoqa.com/automation-practice-form");
    webUI.maximizeWindow();
    webUI.inputText("//input[@id='firstName']", "John");
    webUI.inputText("//input[@id='lastName']", "Doe");
    webUI.delayInSeconds(2);

    webUI.submit("//input[@id='firstName']");
    webUI.delayInSeconds(2);
    assertEquals("https://demoqa.com/automation-practice-form", webUI.getCurrentUrl());
  }

  @Disabled
  @Test
  public void element_dimension_position_demo() {
    webUI.navigateTo("https://demoqa.com/");
    webUI.maximizeWindow();
    webUI.delayInSeconds(2);

    String logoLocator = "//img[contains(@src,'Toolsqa')]";

    assertTrue(webUI.verifyElementVisible(logoLocator), "Không tìm thấy logo");

    int width = webUI.getElementWidth(logoLocator);
    assertTrue(width > 0, "Width phải lớn hơn 0");

    int height = webUI.getElementHeight(logoLocator);
    assertTrue(height > 0, "Height phải lớn hơn 0");

    int left = webUI.getElementLeftPosition(logoLocator);
    assertTrue(left >= 0, "Left phải >= 0");

    int top = webUI.getElementTopPosition(logoLocator);
    assertTrue(top >= 0, "Top phải >= 0");
  }

  @Disabled
  @Test
  public void validate_select_or_deselect_options() {
    webUI.navigateTo("https://demoqa.com/select-menu");
    webUI.maximizeWindow();
    webUI.selectOptionByIndex("//select[@id='oldSelectMenu']", 5);
    assertTrue(webUI.verifyOptionSelectedByIndex("//select[@id='oldSelectMenu']", 5));
    webUI.delayInSeconds(5);
    webUI.selectOptionByValue("//select[@id='oldSelectMenu']", "1");
    assertTrue(webUI.verifyOptionSelectedByValue("//select[@id='oldSelectMenu']", "1"));
    webUI.delayInSeconds(5);
    webUI.selectOptionByText("//select[@id='oldSelectMenu']", "Indigo");
    assertTrue(webUI.verifyOptionSelectedByText("//select[@id='oldSelectMenu']", "Indigo"));
    webUI.delayInSeconds(5);
    webUI.selectAllOptions("//select[@id='cars']");
    assertTrue(webUI.verifyAllOptionsSelected("//select[@id='cars']"));
    webUI.delayInSeconds(5);
    webUI.deselectOptionByIndex("//select[@id='cars']", 2);
    assertTrue(webUI.verifyOptionNotSelectedByIndex("//select[@id='cars']", 2));
    webUI.delayInSeconds(5);
    webUI.deselectAllOptions("//select[@id='cars']");
    assertTrue(webUI.verifyAllOptionsNotSelected("//select[@id='cars']"));
    webUI.delayInSeconds(5);

  }

  @Disabled
  @Test
  public void validate_to_handle_windows() {
    webUI.navigateTo("https://demoqa.com/browser-windows");
    webUI.maximizeWindow();
    webUI.click("//button[@id='tabButton']");
    webUI.delayInSeconds(2);
    webUI.switchToWindowByIndex(1);
    assertTrue(webUI.verifyElementText("//h1[@id='sampleHeading']", "This is a sample page"));
    webUI.closeWindowByIndex(1);
    webUI.delayInSeconds(2);
    webUI.switchToWindowByIndex(0);
    webUI.delayInSeconds(2);
    webUI.click("//button[@id='windowButton']");
    webUI.delayInSeconds(2);
  }

  @Disabled
  @Test
  public void validate_select_value() {
    webUI.navigateTo("https://demoqa.com/select-menu");
    webUI.maximizeWindow();
    // Mở dropdown "Select Value"
    webUI.click("//div[@id='withOptGroup']//div[contains(@class,'-control')]");

    // Chọn "Group 1, option 2"
    webUI.click(
        "//div[contains(@id,'react-select-') and contains(@id,'-option-')][text()='Group 1, option 2']");
    webUI.delayInSeconds(2);
    assertTrue(webUI.verifyElementText(
        "//div[@class='css-1dimb5e-singleValue']", "Group 1, option 2"));

    //Chọn "Group 2, option 1"
    webUI.click("//div[@id='withOptGroup']//div[contains(@class,'-control')]");
    webUI.click(
        "//div[contains(@id,'react-select-') and contains(@id,'-option-')][text()='Group 2, option 1']");
    webUI.delayInSeconds(2);
    assertTrue(
        webUI.verifyElementText("//div[@class='css-1dimb5e-singleValue']", "Group 2, option 1"));

    //Chọn "A root option"
    webUI.click("//div[@id='withOptGroup']//div[contains(@class,'-control')]");
    webUI.click(
        "//div[contains(@id,'react-select-') and contains(@id,'-option-')][text()='A root option']");
    assertTrue(webUI.verifyElementText(
        "//div[@class='css-1dimb5e-singleValue']", "A root option"));
    webUI.delayInSeconds(2);
  }

  public void selectReactSelectOption(String controlLocator, String optionBaseLocator, String optionText) {
    webUI.click(controlLocator);
    webUI.click(optionBaseLocator + "[text()='" + optionText + "']");
    webUI.delayInSeconds(1);
  }

  @Disabled
  @Test
  public void validate_select_value_02() {
    webUI.navigateTo("https://demoqa.com/select-menu");
    webUI.maximizeWindow();

    String control = "//div[@id='withOptGroup']//div[contains(@class,'-control')]";
    String optionBase = "//div[contains(@id,'react-select-') and contains(@id,'-option-')]";
    String singleValue = "//div[@class='css-1dimb5e-singleValue']";

    selectReactSelectOption(control, optionBase, "Group 2, option 1");
    assertTrue(webUI.verifyElementText(singleValue, "Group 2, option 1"));

    selectReactSelectOption(control, optionBase, "Group 1, option 2");
    assertTrue(webUI.verifyElementText(singleValue, "Group 1, option 2"));

    selectReactSelectOption(control, optionBase, "Another root option");
    assertTrue(webUI.verifyElementText(singleValue, "Another root option"));
  }

  @Disabled
  @Test
  public void validate_select_value_03() {
    webUI.navigateTo("https://demoqa.com/select-menu");
    webUI.maximizeWindow();

    String control3 = "//div[@id='selectOne']//div[contains(@class,'-control')]";
    String optionBase3 = "//div[contains(@id,'react-select-') and contains(@id,'-option-')]";
    String singleValue3 = "//div[@class='css-1dimb5e-singleValue']";

    selectReactSelectOption(control3, optionBase3, "Ms.");
    assertTrue(webUI.verifyElementText(singleValue3, "Ms."));

    selectReactSelectOption(control3, optionBase3, "Other");
    assertTrue(webUI.verifyElementText(singleValue3, "Other"));

    webUI.inputText("//input[@id='react-select-3-input']", "Dr.");
    webUI.click(optionBase3 + "[text()='Dr.']");
    webUI.delayInSeconds(1);
    assertTrue(webUI.verifyElementText(singleValue3, "Dr."));
  }

  @Test
  public void alert_demo() {
    webUI.navigateTo("https://demoqa.com/alerts");
    webUI.maximizeWindow();

    webUI.click("id:alertButton");
    assertTrue(webUI.verifyAlertPresent());
    webUI.acceptAlert();
    assertTrue(webUI.verifyAlertNotPresent());

    webUI.click("id:timerAlertButton");
    assertTrue(webUI.verifyAlertNotPresent());
    assertTrue(webUI.waitForAlertPresent(5));
    assertTrue(webUI.verifyAlertPresent());
    webUI.acceptAlert();
  }

  @Test
  public void confirm_demo() {
    webUI.navigateTo("https://demoqa.com/alerts");

    // Dismiss -> "Cancel"
    webUI.click("id:confirmButton");
    assertTrue(webUI.verifyAlertPresent());
    webUI.DismissAlert();
    assertTrue(webUI.verifyAlertNotPresent());
    assertTrue(webUI.verifyElementContainsText("id:confirmResult", "Cancel"));

    // Accept -> "Ok"
    webUI.click("id:confirmButton");
    assertTrue(webUI.verifyAlertPresent());
    webUI.acceptAlert();
    assertTrue(webUI.verifyAlertNotPresent());
    assertTrue(webUI.verifyElementContainsText("id:confirmResult", "Ok"));
  }

  @Test
  public void prompt_demo() {
    webUI.navigateTo("https://demoqa.com/alerts");

    webUI.click("id:promtButton");
    assertTrue(webUI.verifyAlertPresent());
    webUI.sendTexttoAlert("Hello");
    webUI.acceptAlert();
    assertTrue(webUI.verifyAlertNotPresent());
    assertTrue(webUI.verifyElementContainsText("id:promptResult", "Hello"));
  }

  @Test
  public void frame_demo() {
    webUI.navigateTo("https://demoqa.com/frames");
    webUI.maximizeWindow();

    webUI.switchToFrame("//iframe[@id='frame1']");
    assertTrue(webUI.verifyElementText("//h1[@id='sampleHeading']", "This is a sample page"));
    webUI.switchToDefaultContent();
    webUI.delayInSeconds(4);

    webUI.switchToFrame("//iframe[@id='frame2']");
    assertTrue(webUI.verifyElementText("//h1[@id='sampleHeading']", "This is a sample page"));
    webUI.scrollToElement("id:sampleHeading");   // cuộn tới heading bên trong frame2
    webUI.delayInSeconds(4);
    // hoặc
    webUI.scrollBy(20, 30);                      // cuộn xuống 200px trong document của frame2
    webUI.delayInSeconds(4);

    webUI.switchToParentFrame();
    assertTrue(webUI.verifyElementVisible("//span[normalize-space()='Frames']"));
  }

  @Test
  public void select_value_in_dropdown_with_new_style() {
    webUI.navigateTo("https://demoqa.com/select-menu");
    webUI.maximizeWindow();
    webUI.click(TXT_SELECT_VALUE);
    webUI.delayInSeconds(5);
    selectOptionValue("Group 2, option 2");
    webUI.delayInSeconds(5);
    assertTrue(webUI.verifyElementText(LBL_SELECT_VALUE, "Group 2, option2"));
    webUI.click(TXT_SELECT_VALUE);
    selectOptionValue("Group 1, option 1");
    webUI.delayInSeconds(5);
    assertTrue(webUI.verifyElementText(LBL_SELECT_VALUE, "Group 1, option1"));
  }

  private void selectOptionValue(String option) {
    List<WebElement> lblSelectOptions = webUI.findWebElements(DDL_SELECT_OPTIONS);
    for (WebElement lblSelectOption: lblSelectOptions) {
      if (webUI.verifyElementText(lblSelectOption, option)) {
        webUI.click(lblSelectOption);
        break;
      }
    }
  }

}
