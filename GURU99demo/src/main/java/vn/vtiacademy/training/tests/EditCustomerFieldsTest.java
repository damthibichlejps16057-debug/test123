package vn.vtiacademy.training.tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

// The edit fields (Address, City, State, PIN, Telephone, Email) only appear after a valid
// Customer ID has been submitted once. Unlike the Customer-ID screen itself (see
// EditCustomerTest), none of these field-level checks touch that screen or each other's data,
// so the form is opened ONCE for the whole class instead of being reloaded before every test.
public class EditCustomerFieldsTest extends BaseTest {

  private static final String EDIT_CUSTOMER_URL =
      "https://demo.guru99.com/V4/manager/editCustomerPage.php";
  private static final String NEW_CUSTOMER_URL =
      "https://demo.guru99.com/V4/manager/addcustomerpage.php";

  private String customerId;

  @BeforeClass
  public void setUp() {
    loginAsManager();
    customerId = createCustomerAndGetId();
    openEditCustomerForm(customerId);
  }

  private String createCustomerAndGetId() {
    String uniqueEmail = "g" + (System.currentTimeMillis() % 1000000) + "@mailinator.com";
    webUI.navigateTo(NEW_CUSTOMER_URL);
    objNewCustomer.inputCustomerName("Nguyen Van A");
    objNewCustomer.selectGenderMale();
    objNewCustomer.inputDateOfBirth("12121990");
    objNewCustomer.inputAddress("123 Nguyen Trai");
    objNewCustomer.inputCity("Can Tho");
    objNewCustomer.inputState("Can Tho");
    objNewCustomer.inputPin("123456");
    objNewCustomer.inputTelephone("0987654321");
    objNewCustomer.inputEmail(uniqueEmail);
    objNewCustomer.inputPassword("Guru099@123");
    objNewCustomer.clickSubmit();
    webUI.delayInSeconds(2);
    return objNewCustomer.getGeneratedCustomerId();
  }

  private void openEditCustomerForm(String customerId) {
    objEditCustomer.clickEditCustomerMenuLink();
    objEditCustomer.inputCustomerId(customerId);
    objEditCustomer.clickSubmitButton();
  }

  // ============================= Verify Address Field =============================

  @Test(description = "EC8 - Address cannot be empty")
  public void EC008_Verify_that_the_Edit_Customer_page_show_error_message_if_address_is_blank() {
    objEditCustomer.inputAddress("");

    assertTrue(objEditCustomer.shouldBeToShowAddressErrorMessage(
        "Address Field must not be blank"));
  }

  // ============================== Verify City Field ===============================

  @Test(description = "EC10 - City cannot be empty")
  public void EC010_Verify_that_the_Edit_Customer_page_show_error_message_if_city_is_blank() {
    objEditCustomer.inputCity("");

    assertTrue(objEditCustomer.shouldBeToShowCityErrorMessage("City Field must not be blank"));
  }

  @DataProvider(name = "cityNumericDataProvider")
  public Object[][] cityNumericDataProvider() {
    return new Object[][]{{"1234"}, {"city123"}};
  }

  @Test(description = "EC11 - City cannot be numeric", dataProvider = "cityNumericDataProvider")
  public void EC011_Verify_that_the_Edit_Customer_page_show_error_message_if_city_is_numeric(
      String city) {
    objEditCustomer.inputCity(city);

    assertTrue(objEditCustomer.shouldBeToShowCityErrorMessage("Numbers are not allowed"));
  }

  @DataProvider(name = "citySpecialDataProvider")
  public Object[][] citySpecialDataProvider() {
    return new Object[][]{{"City!@#"}, {"!@#"}};
  }

  @Test(description = "EC12 - City cannot have special character", dataProvider = "citySpecialDataProvider")
  public void EC012_Verify_that_the_Edit_Customer_page_show_error_message_if_city_has_special_characters(
      String city) {
    objEditCustomer.inputCity(city);

    assertTrue(objEditCustomer.shouldBeToShowCityErrorMessage("Special characters are not allowed"));
  }

  // ============================== Verify State Field ==============================

  @Test(description = "EC13 - State cannot be empty")
  public void EC013_Verify_that_the_Edit_Customer_page_show_error_message_if_state_is_blank() {
    objEditCustomer.inputState("");

    assertTrue(objEditCustomer.shouldBeToShowStateErrorMessage("State must not be blank"));
  }

  @DataProvider(name = "stateNumericDataProvider")
  public Object[][] stateNumericDataProvider() {
    return new Object[][]{{"1234"}, {"State123"}};
  }

  @Test(description = "EC14 - State cannot be numeric", dataProvider = "stateNumericDataProvider")
  public void EC014_Verify_that_the_Edit_Customer_page_show_error_message_if_state_is_numeric(
      String state) {
    objEditCustomer.inputState(state);

    assertTrue(objEditCustomer.shouldBeToShowStateErrorMessage("Numbers are not allowed"));
  }

  @DataProvider(name = "stateSpecialDataProvider")
  public Object[][] stateSpecialDataProvider() {
    return new Object[][]{{"State!@#"}, {"!@#"}};
  }

  @Test(description = "EC15 - State cannot have special character", dataProvider = "stateSpecialDataProvider")
  public void EC015_Verify_that_the_Edit_Customer_page_show_error_message_if_state_has_special_characters(
      String state) {
    objEditCustomer.inputState(state);

    assertTrue(
        objEditCustomer.shouldBeToShowStateErrorMessage("Special characters are not allowed"));
  }

  // =============================== Verify PIN Field ===============================

  @Test(description = "EC16 - PIN must be numeric")
  public void EC016_Verify_that_the_Edit_Customer_page_show_error_message_if_pin_contains_characters() {
    objEditCustomer.inputPin("1234PIN");

    assertTrue(objEditCustomer.shouldBeToShowPinErrorMessage("Characters are not allowed"));
  }

  @Test(description = "EC17 - PIN cannot be empty")
  public void EC017_Verify_that_the_Edit_Customer_page_show_error_message_if_pin_is_blank() {
    objEditCustomer.inputPin("");

    assertTrue(objEditCustomer.shouldBeToShowPinErrorMessage("PIN Code must not be blank"));
  }

  @DataProvider(name = "pinInvalidLengthDataProvider")
  public Object[][] pinInvalidLengthDataProvider() {
    return new Object[][]{{"4567"}, {"123"}};
  }

  @Test(description = "EC18 - PIN must have 6 digits", dataProvider = "pinInvalidLengthDataProvider")
  public void EC018_Verify_that_the_Edit_Customer_page_show_error_message_if_pin_does_not_have_6_digits(
      String pin) {
    objEditCustomer.inputPin(pin);
    webUI.delayInSeconds(2);
    assertTrue(objEditCustomer.shouldBeToShowPinErrorMessage("PIN Code must have 6 Digits"));
  }

  @DataProvider(name = "pinSpecialDataProvider")
  public Object[][] pinSpecialDataProvider() {
    return new Object[][]{{"!@#"}, {"123!@#"}};
  }

  @Test(description = "EC19 - PIN cannot have special character", dataProvider = "pinSpecialDataProvider")
  public void EC019_Verify_that_the_Edit_Customer_page_show_error_message_if_pin_has_special_characters(
      String pin) {
    objEditCustomer.inputPin(pin);

    assertTrue(objEditCustomer.shouldBeToShowPinErrorMessage("Special characters are not allowed"));
  }

  // ============================ Verify Telephone Field ============================

  @Test(description = "EC20 - Telephone cannot be empty")
  public void EC020_Verify_that_the_Edit_Customer_page_show_error_message_if_telephone_is_blank() {
    objEditCustomer.inputTelephone("");

    assertTrue(objEditCustomer.shouldBeToShowTelephoneErrorMessage("Mobile no must not be blank"));
  }

  @DataProvider(name = "telephoneSpecialDataProvider")
  public Object[][] telephoneSpecialDataProvider() {
    return new Object[][]{{"886636!@12"}, {"!@88662682"}, {"88663682!@"}};
  }

  @Test(description = "EC21 - Telephone cannot have special character", dataProvider = "telephoneSpecialDataProvider")
  public void EC021_Verify_that_the_Edit_Customer_page_show_error_message_if_telephone_has_special_characters(
      String telephone) {
    objEditCustomer.inputTelephone(telephone);

    assertTrue(objEditCustomer.shouldBeToShowTelephoneErrorMessage(
        "Special characters are not allowed"));
  }

  // ============================= Verify Email Field ===============================

  @Test(description = "EC22 - Email cannot be empty")
  public void EC022_Verify_that_the_Edit_Customer_page_show_error_message_if_email_is_blank() {
    objEditCustomer.inputEmail("");

    assertTrue(objEditCustomer.shouldBeToShowEmailErrorMessage("Email-ID must not be blank"));
  }

  @DataProvider(name = "invalidEmailDataProvider")
  public Object[][] invalidEmailDataProvider() {
    return new Object[][]{{"guru99@gmail"}, {"guru99"}, {"Guru99@"}, {"gurugmail.com"}};
  }

  @Test(description = "EC23 - Email must be in format career@guru99.com", dataProvider = "invalidEmailDataProvider")
  public void EC023_Verify_that_the_Edit_Customer_page_show_error_message_if_email_is_invalid(
      String email) {
    objEditCustomer.inputEmail(email);

    assertTrue(objEditCustomer.shouldBeToShowEmailErrorMessage("Email-ID is not valid"));
  }

  // Not from the sheet - the sheet never covers the happy path (submit + save + persist).
  @Test(description = "EC24 - Edit customer successfully and data persists after reload")
  public void EC024_Verify_that_the_Edit_Customer_page_save_changes_successfully_and_data_persists_after_reload() {

    String newAddress = "456 Le Loi";
    String newCity = "Ho Chi Minh";
    String newState = "HCM";
    String newPin = "700000";
    String newTelephone = "0912345678";
    String newEmail = "edit" + (System.currentTimeMillis() % 1000000) + "@mailinator.com";

    objEditCustomer.inputAddress(newAddress);
    objEditCustomer.inputCity(newCity);
    objEditCustomer.inputState(newState);
    objEditCustomer.inputPin(newPin);
    objEditCustomer.inputTelephone(newTelephone);
    objEditCustomer.inputEmail(newEmail);
    objEditCustomer.clickSubmitEditForm();

    openEditCustomerForm(customerId);

    assertTrue(objEditCustomer.shouldBeToShowAddressAs(newAddress));
    assertTrue(objEditCustomer.shouldBeToShowCityAs(newCity));
    assertTrue(objEditCustomer.shouldBeToShowStateAs(newState));
    assertTrue(objEditCustomer.shouldBeToShowPinAs(newPin));
    assertTrue(objEditCustomer.shouldBeToShowTelephoneAs(newTelephone));
    assertTrue(objEditCustomer.shouldBeToShowEmailAs(newEmail));
  }
}
