package vn.vtiacademy.training.pages;

import org.openqa.selenium.Keys;
import vn.vtiacademy.training.utils.keywords.WebUI;

public class BasePage2 {

  protected WebUI webUI;

  public BasePage2(WebUI webUI) {
    this.webUI = webUI;
  }

  protected void inputAndLeaveField(String locator, String value) {
    webUI.inputText(locator, value + Keys.TAB);
    webUI.takeScreenshotWithHighlight(locator);
  }

  protected boolean shouldSeeText(String locator, String expectedText) {
    if (webUI.verifyElementText(locator, expectedText)) {
      webUI.takeScreenshotWithHighlight(locator);
      return true;
    }
    webUI.takeScreenshot();
    return false;
  }

  protected boolean shouldSeeInputValue(String locator, String expectedValue) {
    if (webUI.verifyElementAttributeValue(locator, "value", expectedValue)) {
      webUI.takeScreenshotWithHighlight(locator);
      return true;
    }
    webUI.takeScreenshot();
    return false;
  }
}
