package vn.vtiacademy.training.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import vn.vtiacademy.training.object_repository.LoginRepo;
import vn.vtiacademy.training.utils.keywords.WebUI;

public class Login extends BasePage {

  public Login(WebUI webUI) {
    super(webUI);
  }

  @Step("Input User ID: {0}")
  public void inputUserId(String userId) {
    if (userId.isBlank()) {
      webUI.inputText(LoginRepo.TXT_USER_ID, Keys.chord(Keys.TAB));
    } else {
      webUI.inputText(LoginRepo.TXT_USER_ID, userId);
    }
    webUI.takeScreenshotWithHighlight(LoginRepo.TXT_USER_ID);
  }

  @Step("Input Password: {0}")
  public void inputUserPassword(String password) {
    if (password.isBlank()) {
      webUI.inputText(LoginRepo.TXT_USER_PASSWORD, Keys.chord(Keys.TAB));
    } else {
      webUI.inputText(LoginRepo.TXT_USER_PASSWORD, password);
    }
    webUI.takeScreenshotWithHighlight(LoginRepo.TXT_USER_PASSWORD);
  }

  @Step("Click Login button")
  public Manager clickLoginButton() {
    webUI.takeScreenshotWithHighlight(LoginRepo.BTN_LOGIN);
    webUI.click(LoginRepo.BTN_LOGIN);
    if (webUI.verifyAlertPresent(2)) {
      webUI.acceptAlert();
    }
    webUI.delayInSeconds(3);
    webUI.takeScreenshot();
    return new Manager(webUI);
  }

  @Step("Should show User ID error message '{0}'")
  public boolean shouldBeToShowUserIdErrorMessage(String expectedErrorMessage) {
    return shouldSeeErrorMessage(LoginRepo.LBL_USER_ID_ERROR_MESSAGE, expectedErrorMessage);
  }

  @Step("Should show Password error message '{0}'")
  public boolean shouldBeToShowUserPasswordErrorMessage(String expectedErrorMessage) {
    return shouldSeeErrorMessage(LoginRepo.LBL_USER_PASSWORD_ERROR_MESSAGE, expectedErrorMessage);
  }

  private boolean shouldSeeErrorMessage(String locator, String expectedErrorMessage) {
    if (webUI.verifyElementText(locator, expectedErrorMessage)) {
      webUI.takeScreenshotWithHighlight(locator);
      return true;
    }
    webUI.takeScreenshot();
    return false;
  }
}