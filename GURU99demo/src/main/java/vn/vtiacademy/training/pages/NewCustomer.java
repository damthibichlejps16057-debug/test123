package vn.vtiacademy.training.pages;

import io.qameta.allure.Step;
import vn.vtiacademy.training.object_repository.NewCustomerRepo;
import vn.vtiacademy.training.utils.keywords.WebUI;

public class NewCustomer extends BasePage {

  public NewCustomer(WebUI webUI) {
    super(webUI);
  }

  @Step("Input Customer Name: '{0}'")
  public void inputCustomerName(String name) {
    inputAndLeaveField(NewCustomerRepo.TXT_CUSTOMER_NAME, name);
  }

  @Step("Get generated Customer ID")
  public String getGeneratedCustomerId() {
    return webUI.getText(NewCustomerRepo.LBL_GENERATED_CUSTOMER_ID);
  }

  @Step("Select Gender: Male")
  public void selectGenderMale() {
    selectRadio(NewCustomerRepo.RAD_GENDER_MALE);
  }

  @Step("Select Gender: Female")
  public void selectGenderFemale() {
    selectRadio(NewCustomerRepo.RAD_GENDER_FEMALE);
  }

  @Step("Input Date of Birth (typed keys): '{0}'")
  public void inputDateOfBirth(String typedKeys) {
    webUI.inputText(NewCustomerRepo.TXT_DOB, typedKeys);
    webUI.takeScreenshotWithHighlight(NewCustomerRepo.TXT_DOB);
  }

  @Step("Should show Gender Male selected = '{0}'")
  public boolean shouldBeToShowGenderMaleSelected(boolean expected) {
    return shouldBeSelected(NewCustomerRepo.RAD_GENDER_MALE, expected);
  }

  @Step("Should show Gender Female selected = '{0}'")
  public boolean shouldBeToShowGenderFemaleSelected(boolean expected) {
    return shouldBeSelected(NewCustomerRepo.RAD_GENDER_FEMALE, expected);
  }

  // Giá trị của input type=date luôn có dạng yyyy-MM-dd
  @Step("Should show Date of Birth value '{0}'")
  public boolean shouldBeToShowDateOfBirthValue(String expectedValue) {
    if (webUI.verifyElementAttributeValue(NewCustomerRepo.TXT_DOB, "value", expectedValue)) {
      webUI.takeScreenshotWithHighlight(NewCustomerRepo.TXT_DOB);
      return true;
    }
    webUI.takeScreenshot();
    return false;
  }

  @Step("Input Address: '{0}'")
  public void inputAddress(String address) {
    inputAndLeaveField(NewCustomerRepo.TXT_ADDRESS, address);
  }

  @Step("Input City: '{0}'")
  public void inputCity(String city) {
    inputAndLeaveField(NewCustomerRepo.TXT_CITY, city);
  }

  @Step("Input State: '{0}'")
  public void inputState(String state) {
    inputAndLeaveField(NewCustomerRepo.TXT_STATE, state);
  }

  @Step("Input PIN: '{0}'")
  public void inputPin(String pin) {
    inputAndLeaveField(NewCustomerRepo.TXT_PIN, pin);
  }

  @Step("Input Telephone: '{0}'")
  public void inputTelephone(String telephone) {
    inputAndLeaveField(NewCustomerRepo.TXT_TELEPHONE, telephone);
  }

  @Step("Input Email: '{0}'")
  public void inputEmail(String email) {
    inputAndLeaveField(NewCustomerRepo.TXT_EMAIL, email);
  }

  @Step("Should show Customer Name error message '{0}'")
  public boolean shouldBeToShowCustomerNameErrorMessage(String expectedErrorMessage) {
    return shouldSeeText(NewCustomerRepo.LBL_CUSTOMER_NAME_ERROR_MESSAGE, expectedErrorMessage);
  }


  @Step("Should show Address error message '{0}'")
  public boolean shouldBeToShowAddressErrorMessage(String expectedErrorMessage) {
    return shouldSeeText(NewCustomerRepo.LBL_ADDRESS_ERROR_MESSAGE, expectedErrorMessage);
  }

  @Step("Should show City error message '{0}'")
  public boolean shouldBeToShowCityErrorMessage(String expectedErrorMessage) {
    return shouldSeeText(NewCustomerRepo.LBL_CITY_ERROR_MESSAGE, expectedErrorMessage);
  }

  @Step("Should show State error message '{0}'")
  public boolean shouldBeToShowStateErrorMessage(String expectedErrorMessage) {
    return shouldSeeText(NewCustomerRepo.LBL_STATE_ERROR_MESSAGE, expectedErrorMessage);
  }

  @Step("Should show PIN error message '{0}'")
  public boolean shouldBeToShowPinErrorMessage(String expectedErrorMessage) {
    return shouldSeeText(NewCustomerRepo.LBL_PIN_ERROR_MESSAGE, expectedErrorMessage);
  }

  @Step("Should show Telephone error message '{0}'")
  public boolean shouldBeToShowTelephoneErrorMessage(String expectedErrorMessage) {
    return shouldSeeText(NewCustomerRepo.LBL_TELEPHONE_ERROR_MESSAGE, expectedErrorMessage);
  }

  @Step("Should show Email error message '{0}'")
  public boolean shouldBeToShowEmailErrorMessage(String expectedErrorMessage) {
    return shouldSeeText(NewCustomerRepo.LBL_EMAIL_ERROR_MESSAGE, expectedErrorMessage);
  }

  @Step("Should show Telephone field label '{0}'")
  public boolean shouldBeToShowTelephoneLabelAs(String expectedLabel) {
    return shouldSeeText(NewCustomerRepo.LBL_TELEPHONE_FIELD, expectedLabel);
  }
  

  // ============================ Helper Methods ============================
  private void selectRadio(String locator) {
    webUI.click(locator);
    webUI.takeScreenshotWithHighlight(locator);
  }

  private boolean shouldBeSelected(String locator, boolean expected) {
    boolean result = expected
        ? webUI.verifyElementSelected(locator)
        : webUI.verifyElementNotSelected(locator);
    if (result) {
      webUI.takeScreenshotWithHighlight(locator);
    } else {
      webUI.takeScreenshot();
    }
    return result;
  }

  @Step("Click Submit button")
  public void clickSubmit() {
    webUI.click(NewCustomerRepo.BTN_SUBMIT);
  }

  @Step("Should show success message '{0}'")
  public boolean shouldBeToShowSuccessMessage(String expectedMessage) {
    return shouldSeeText(NewCustomerRepo.LBL_SUCCESS_MESSAGE, expectedMessage);
  }

  @Step("Should show registered Customer Name '{0}'")
  public boolean shouldBeToShowRegisteredCustomerName(String expectedName) {
    return shouldSeeText(NewCustomerRepo.LBL_RESULT_CUSTOMER_NAME, expectedName);
  }

  // Không dùng inputAndLeaveField vì Password không có validation khi mất focus
  @Step("Input Password")
  public void inputPassword(String password) {
    webUI.inputText(NewCustomerRepo.TXT_PASSWORD, password);
    webUI.takeScreenshotWithHighlight(NewCustomerRepo.TXT_PASSWORD);
  }

  @Step("Should show Password value '{0}'")
  public boolean shouldBeToShowPasswordValue(String expectedValue) {
    return shouldSeeAttribute(NewCustomerRepo.TXT_PASSWORD, "value", expectedValue);
  }

  @Step("Should show Password field type '{0}'")
  public boolean shouldBeToShowPasswordFieldTypeAs(String expectedType) {
    return shouldSeeAttribute(NewCustomerRepo.TXT_PASSWORD, "type", expectedType);
  }

  private boolean shouldSeeAttribute(String locator, String attribute, String expected) {
    if (webUI.verifyElementAttributeValue(locator, attribute, expected)) {
      webUI.takeScreenshotWithHighlight(locator);
      return true;
    }
    webUI.takeScreenshot();
    return false;
  }
}
