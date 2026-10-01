package vn.vtiacademy.training.pages;

import io.qameta.allure.Step;
import vn.vtiacademy.training.object_repository.ManagerRepo2;
import vn.vtiacademy.training.utils.keywords.WebUI;

public class Manager2 extends BasePage2 {

  public Manager2(WebUI webUI) {
    super(webUI);
  }

  @Step("Should show text as '{0}'")
  public boolean shouldBeToShowManagerIdAs(String expectedManagerIdText) {
    if (webUI.verifyElementText(ManagerRepo2.LBL_MANAGER_ID, expectedManagerIdText)) {
      webUI.takeScreenshotWithHighlight(ManagerRepo2.LBL_MANAGER_ID);
      return true;
    }
    webUI.takeScreenshot();
    return false;
  }
}