package vn.vtiacademy.training.pages;

import io.qameta.allure.Step;
import vn.vtiacademy.training.object_repository.EditCustomerRepo2;
import vn.vtiacademy.training.utils.keywords.WebUI;

public class EditCustomer2 extends BasePage2 {

  public EditCustomer2(WebUI webUI) {
    super(webUI);
  }

  // ---------------------- Step 1: enter Customer ID ----------------------

  @Step("Input Customer ID: '{0}'")
  public void inputCustomerId(String customerId) {
    inputAndLeaveField(EditCustomerRepo2.TXT_CUSTOMER_ID, customerId);
  }

  @Step("Click Submit button")
  public void clickSubmitButton() {
    webUI.takeScreenshotWithHighlight(EditCustomerRepo2.BTN_SUBMIT_CUSTOMER_ID);
    webUI.click(EditCustomerRepo2.BTN_SUBMIT_CUSTOMER_ID);
    // An unknown Customer ID makes the site show a native JS alert. Check briefly (2s) and
    // accept it so the test fails on its assertion instead of an UnhandledAlertException.
    if (webUI.verifyAlertPresent(2)) {
      webUI.acceptAlert();
    }
    webUI.delayInSeconds(3);
    webUI.takeScreenshot();
  }

  @Step("Should show Customer ID error message '{0}'")
  public boolean shouldBeToShowCustomerIdErrorMessage(String expectedErrorMessage) {
    return shouldSeeText(EditCustomerRepo2.LBL_CUSTOMER_ID_ERROR_MESSAGE, expectedErrorMessage);
  }

  @Step("Should show the Edit Customer form")
  public boolean shouldBeToShowEditCustomerForm() {
    if (webUI.verifyElementVisible(EditCustomerRepo2.TXT_ADDRESS)) {
      webUI.takeScreenshotWithHighlight(EditCustomerRepo2.TXT_ADDRESS);
      return true;
    }
    webUI.takeScreenshot();
    return false;
  }

  // ---------------------- Step 2: edit form fields ----------------------

  @Step("Input Address: '{0}'")
  public void inputAddress(String address) {
    inputAndLeaveField(EditCustomerRepo2.TXT_ADDRESS, address);
  }

  @Step("Input City: '{0}'")
  public void inputCity(String city) {
    inputAndLeaveField(EditCustomerRepo2.TXT_CITY, city);
  }

  @Step("Input State: '{0}'")
  public void inputState(String state) {
    inputAndLeaveField(EditCustomerRepo2.TXT_STATE, state);
  }

  @Step("Input PIN: '{0}'")
  public void inputPin(String pin) {
    inputAndLeaveField(EditCustomerRepo2.TXT_PIN, pin);
  }

  @Step("Input Telephone: '{0}'")
  public void inputTelephone(String telephone) {
    inputAndLeaveField(EditCustomerRepo2.TXT_TELEPHONE, telephone);
  }

  @Step("Input Email: '{0}'")
  public void inputEmail(String email) {
    inputAndLeaveField(EditCustomerRepo2.TXT_EMAIL, email);
  }

  @Step("Should show Address error message '{0}'")
  public boolean shouldBeToShowAddressErrorMessage(String expectedErrorMessage) {
    return shouldSeeText(EditCustomerRepo2.LBL_ADDRESS_ERROR_MESSAGE, expectedErrorMessage);
  }

  @Step("Should show City error message '{0}'")
  public boolean shouldBeToShowCityErrorMessage(String expectedErrorMessage) {
    return shouldSeeText(EditCustomerRepo2.LBL_CITY_ERROR_MESSAGE, expectedErrorMessage);
  }

  @Step("Should show State error message '{0}'")
  public boolean shouldBeToShowStateErrorMessage(String expectedErrorMessage) {
    return shouldSeeText(EditCustomerRepo2.LBL_STATE_ERROR_MESSAGE, expectedErrorMessage);
  }

  @Step("Should show PIN error message '{0}'")
  public boolean shouldBeToShowPinErrorMessage(String expectedErrorMessage) {
    return shouldSeeText(EditCustomerRepo2.LBL_PIN_ERROR_MESSAGE, expectedErrorMessage);
  }

  @Step("Should show Telephone error message '{0}'")
  public boolean shouldBeToShowTelephoneErrorMessage(String expectedErrorMessage) {
    return shouldSeeText(EditCustomerRepo2.LBL_TELEPHONE_ERROR_MESSAGE, expectedErrorMessage);
  }

  @Step("Should show Email error message '{0}'")
  public boolean shouldBeToShowEmailErrorMessage(String expectedErrorMessage) {
    return shouldSeeText(EditCustomerRepo2.LBL_EMAIL_ERROR_MESSAGE, expectedErrorMessage);
  }

  // ---------------------- Step 2: save the edit form ----------------------

  @Step("Click Submit button on the edit form")
  public void clickSubmitEditForm() {
    webUI.takeScreenshotWithHighlight(EditCustomerRepo2.BTN_SUBMIT_EDIT_FORM);
    webUI.click(EditCustomerRepo2.BTN_SUBMIT_EDIT_FORM);
    if (webUI.verifyAlertPresent(2)) {
      webUI.acceptAlert();
    }
    webUI.delayInSeconds(3);
    webUI.takeScreenshot();
  }

  //  @Step("Should show Edit success message '{0}'")
  //  public boolean shouldBeToShowEditSuccessMessage(String expectedMessage) {
  //    return shouldSeeText(EditCustomerRepo.LBL_EDIT_SUCCESS_MESSAGE, expectedMessage);
  //  }

  // ------------- Read back saved values (e.g. after reopening the form) -------------

  @Step("Should show Address as '{0}'")
  public boolean shouldBeToShowAddressAs(String expectedValue) {
    return shouldSeeInputValue(EditCustomerRepo2.TXT_ADDRESS, expectedValue);
  }

  @Step("Should show City as '{0}'")
  public boolean shouldBeToShowCityAs(String expectedValue) {
    return shouldSeeInputValue(EditCustomerRepo2.TXT_CITY, expectedValue);
  }

  @Step("Should show State as '{0}'")
  public boolean shouldBeToShowStateAs(String expectedValue) {
    return shouldSeeInputValue(EditCustomerRepo2.TXT_STATE, expectedValue);
  }

  @Step("Should show PIN as '{0}'")
  public boolean shouldBeToShowPinAs(String expectedValue) {
    return shouldSeeInputValue(EditCustomerRepo2.TXT_PIN, expectedValue);
  }

  @Step("Should show Telephone as '{0}'")
  public boolean shouldBeToShowTelephoneAs(String expectedValue) {
    return shouldSeeInputValue(EditCustomerRepo2.TXT_TELEPHONE, expectedValue);
  }

  @Step("Should show Email as '{0}'")
  public boolean shouldBeToShowEmailAs(String expectedValue) {
    return shouldSeeInputValue(EditCustomerRepo2.TXT_EMAIL, expectedValue);
  }

  private static final String MANAGER_ANCHOR_URL =
      "https://demo.guru99.com/V4/manager/addcustomerpage.php";

  @Step("Click Edit Customer menu link")
  public void clickEditCustomerMenuLink() {
    webUI.navigateTo(MANAGER_ANCHOR_URL);
    webUI.click(EditCustomerRepo2.LNK_EDIT_CUSTOMER_MENU);
    webUI.delayInSeconds(1);
    webUI.takeScreenshotWithHighlight(EditCustomerRepo2.TXT_CUSTOMER_ID);
  }
}