package vn.vtiacademy.training.pages;

import io.qameta.allure.Step;
import vn.vtiacademy.training.object_repository.ManagerRepo;
import vn.vtiacademy.training.utils.keywords.WebUI;

public class Manager extends BasePage {

  public Manager(WebUI webUI) {
    super(webUI);
  }

  @Step("Should show text as '{0}'")
  public boolean shouldBeToShowManagerIdAs(String expectedManagerIdText) {
    if (webUI.verifyElementText(ManagerRepo.LBL_MANAGER_ID, expectedManagerIdText)) {
      webUI.takeScreenshotWithHighlight(ManagerRepo.LBL_MANAGER_ID);
      return true;
    }
    webUI.takeScreenshot();
    return false;
  }
}