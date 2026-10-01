package vn.vtiacademy.training.tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NewCustomerTest2 extends BaseTest2 {

  private static final String NEW_CUSTOMER_URL =
      "https://demo.guru99.com/V4/manager/addcustomerpage.php";



  @BeforeClass
  public void login() {
    loginAsManager();
  }

  // Reload the form before every test (and every data-provider row) so no previous input leaks in
  @BeforeMethod
  public void openNewCustomerPage() {
    webUI.navigateTo(NEW_CUSTOMER_URL);
  }

  // ============================== Verify Name Field ==============================

  @Test(description = "NC1 - Name cannot be empty")
  public void NC001_Verify_that_the_New_Customer_page_show_error_message_if_customer_name_is_blank() {
    objNewCustomer.inputCustomerName("");

    assertTrue(objNewCustomer.shouldBeToShowCustomerNameErrorMessage(
        "Customer name must not be blank"));
  }

  @DataProvider(name = "customerNameNumericDataProvider")
  public Object[][] customerNameNumericDataProvider() {
    return new Object[][]{{"1234"}, {"name123"}};
  }

  @Test(description = "NC2 - Name cannot be numeric", dataProvider = "customerNameNumericDataProvider")
  public void NC002_Verify_that_the_New_Customer_page_show_error_message_if_customer_name_is_numeric(
      String name) {
    objNewCustomer.inputCustomerName(name);

    assertTrue(objNewCustomer.shouldBeToShowCustomerNameErrorMessage("Numbers are not allowed"));
  }

  @DataProvider(name = "customerNameSpecialDataProvider")
  public Object[][] customerNameSpecialDataProvider() {
    return new Object[][]{{"name!@#"}, {"!@#"}};
  }

  @Test(description = "NC3 - Name cannot have special characters", dataProvider = "customerNameSpecialDataProvider")
  public void NC003_Verify_that_the_New_Customer_page_show_error_message_if_customer_name_has_special_characters(
      String name) {
    objNewCustomer.inputCustomerName(name);

    assertTrue(objNewCustomer.shouldBeToShowCustomerNameErrorMessage(
        "Special characters are not allowed"));
  }

  @Test(description = "NC4 - Name cannot have first character as blank space")
  public void NC004_Verify_that_the_New_Customer_page_show_error_message_if_customer_name_starts_with_blank_space() {
    objNewCustomer.inputCustomerName(" name");

    assertTrue(objNewCustomer.shouldBeToShowCustomerNameErrorMessage(
        "First character can not have space"));
  }

  // ============================= Verify Gender Field =============================

  @Test(description = "NC5 - Can select Male")
  public void NC005_Verify_that_the_New_Customer_page_allow_to_select_gender_male() {
    // Male là mặc định, nên chọn Female trước để chắc chắn việc click Male có tác dụng
    objNewCustomer.selectGenderFemale();
    objNewCustomer.selectGenderMale();

    assertTrue(objNewCustomer.shouldBeToShowGenderMaleSelected(true));
    assertTrue(objNewCustomer.shouldBeToShowGenderFemaleSelected(false));
  }

  @Test(description = "NC6 - Can select Female")
  public void NC006_Verify_that_the_New_Customer_page_allow_to_select_gender_female() {
    objNewCustomer.selectGenderFemale();

    assertTrue(objNewCustomer.shouldBeToShowGenderFemaleSelected(true));
    assertTrue(objNewCustomer.shouldBeToShowGenderMaleSelected(false));
  }

  // =========================== Verify Date of Birth Field ========================

  @Test(description = "NC7 - Can input Date of Birth")
  public void NC007_Verify_that_the_New_Customer_page_allow_to_input_date_of_birth() {
    objNewCustomer.inputDateOfBirth("12122001");

    assertTrue(objNewCustomer.shouldBeToShowDateOfBirthValue("2001-12-12"));
  }

  // ============================= Verify Address Field ============================

  @Test(description = "NC8 - Address cannot be empty")
  public void NC008_Verify_that_the_New_Customer_page_show_error_message_if_address_is_blank() {
    objNewCustomer.inputAddress("");

    assertTrue(objNewCustomer.shouldBeToShowAddressErrorMessage(
        "Address Field must not be blank"));
  }

  @Test(description = "NC9 - Address cannot have first blank space")
  public void NC009_Verify_that_the_New_Customer_page_show_error_message_if_address_starts_with_blank_space() {
    objNewCustomer.inputAddress(" address");

    assertTrue(objNewCustomer.shouldBeToShowAddressErrorMessage(
        "First character can not have space"));
  }

  // ============================== Verify City Field ==============================

  @Test(description = "NC10 - City cannot be empty")
  public void NC010_Verify_that_the_New_Customer_page_show_error_message_if_city_is_blank() {
    objNewCustomer.inputCity("");

    assertTrue(objNewCustomer.shouldBeToShowCityErrorMessage("City Field must not be blank"));
  }

  @DataProvider(name = "cityNumericDataProvider")
  public Object[][] cityNumericDataProvider() {
    return new Object[][]{{"1234"}, {"city123"}};
  }

  @Test(description = "NC11 - City cannot be numeric", dataProvider = "cityNumericDataProvider")
  public void NC011_Verify_that_the_New_Customer_page_show_error_message_if_city_is_numeric(
      String city) {
    objNewCustomer.inputCity(city);

    assertTrue(objNewCustomer.shouldBeToShowCityErrorMessage("Numbers are not allowed"));
  }

  @DataProvider(name = "citySpecialDataProvider")
  public Object[][] citySpecialDataProvider() {
    return new Object[][]{{"City!@#"}, {"!@#"}};
  }

  @Test(description = "NC12 - City cannot have special character", dataProvider = "citySpecialDataProvider")
  public void NC012_Verify_that_the_New_Customer_page_show_error_message_if_city_has_special_characters(
      String city) {
    objNewCustomer.inputCity(city);

    assertTrue(objNewCustomer.shouldBeToShowCityErrorMessage("Special characters are not allowed"));
  }

  @Test(description = "NC13 - City cannot have first blank space")
  public void NC013_Verify_that_the_New_Customer_page_show_error_message_if_city_starts_with_blank_space() {
    objNewCustomer.inputCity(" city");

    assertTrue(objNewCustomer.shouldBeToShowCityErrorMessage("First character can not have space"));
  }

  // ============================= Verify State Field ==============================

  @Test(description = "NC14 - State cannot be empty")
  public void NC014_Verify_that_the_New_Customer_page_show_error_message_if_state_is_blank() {
    objNewCustomer.inputState("");

    assertTrue(objNewCustomer.shouldBeToShowStateErrorMessage("State must not be blank"));
  }

  @DataProvider(name = "stateNumericDataProvider")
  public Object[][] stateNumericDataProvider() {
    return new Object[][]{{"1234"}, {"State123"}};
  }

  @Test(description = "NC15 - State cannot be numeric", dataProvider = "stateNumericDataProvider")
  public void NC015_Verify_that_the_New_Customer_page_show_error_message_if_state_is_numeric(
      String state) {
    objNewCustomer.inputState(state);

    assertTrue(objNewCustomer.shouldBeToShowStateErrorMessage("Numbers are not allowed"));
  }

  @DataProvider(name = "stateSpecialDataProvider")
  public Object[][] stateSpecialDataProvider() {
    return new Object[][]{{"State!@#"}, {"!@#"}};
  }

  @Test(description = "NC16 - State cannot have special character", dataProvider = "stateSpecialDataProvider")
  public void NC016_Verify_that_the_New_Customer_page_show_error_message_if_state_has_special_characters(
      String state) {
    objNewCustomer.inputState(state);

    assertTrue(
        objNewCustomer.shouldBeToShowStateErrorMessage("Special characters are not allowed"));
  }

  @Test(description = "NC17 - State cannot have first blank space")
  public void NC017_Verify_that_the_New_Customer_page_show_error_message_if_state_starts_with_blank_space() {
    objNewCustomer.inputState(" state");

    assertTrue(
        objNewCustomer.shouldBeToShowStateErrorMessage("First character can not have space"));
  }

  // ============================== Verify PIN Field ===============================

  @Test(description = "NC18 - PIN must be numeric")
  public void NC018_Verify_that_the_New_Customer_page_show_error_message_if_pin_contains_characters() {
    objNewCustomer.inputPin("1234PIN");

    assertTrue(objNewCustomer.shouldBeToShowPinErrorMessage("Characters are not allowed"));
  }

  @Test(description = "NC19 - PIN cannot be empty")
  public void NC019_Verify_that_the_New_Customer_page_show_error_message_if_pin_is_blank() {
    objNewCustomer.inputPin("");

    assertTrue(objNewCustomer.shouldBeToShowPinErrorMessage("PIN Code must not be blank"));
  }

  @DataProvider(name = "pinInvalidLengthDataProvider")
  public Object[][] pinInvalidLengthDataProvider() {
    return new Object[][]{{"12"}, {"123"}};
  }

  @Test(description = "NC20 - PIN must have 6 digits", dataProvider = "pinInvalidLengthDataProvider")
  public void NC020_Verify_that_the_New_Customer_page_show_error_message_if_pin_does_not_have_6_digits(
      String pin) {
    objNewCustomer.inputPin(pin);

    assertTrue(objNewCustomer.shouldBeToShowPinErrorMessage("PIN Code must have 6 Digits"));
  }

  @DataProvider(name = "pinSpecialDataProvider")
  public Object[][] pinSpecialDataProvider() {
    return new Object[][]{{"!@#"}, {"123!@#"}};
  }

  @Test(description = "NC21 - PIN cannot have special character", dataProvider = "pinSpecialDataProvider")
  public void NC021_Verify_that_the_New_Customer_page_show_error_message_if_pin_has_special_characters(
      String pin) {
    objNewCustomer.inputPin(pin);

    assertTrue(objNewCustomer.shouldBeToShowPinErrorMessage("Special characters are not allowed"));
  }

  @Test(description = "NC22 - PIN cannot have first blank space")
  public void NC022_Verify_that_the_New_Customer_page_show_error_message_if_pin_starts_with_blank_space() {
    objNewCustomer.inputPin(" 12345");

    assertTrue(objNewCustomer.shouldBeToShowPinErrorMessage("First character can not have space"));
  }

  @Test(description = "NC23 - PIN cannot have blank space")
  public void NC023_Verify_that_the_New_Customer_page_show_error_message_if_pin_contains_blank_space() {
    objNewCustomer.inputPin("123 456");

    assertTrue(objNewCustomer.shouldBeToShowPinErrorMessage("Characters are not allowed"));
  }

  // =========================== Verify Telephone Field ============================

  @Test(description = "NC24 - Telephone cannot be empty")
  public void NC024_Verify_that_the_New_Customer_page_show_error_message_if_telephone_is_blank() {
    objNewCustomer.inputTelephone("");

    assertTrue(objNewCustomer.shouldBeToShowTelephoneErrorMessage(
        "Mobile no must not be blank"));
  }

  @Test(description = "NC25 - Telephone cannot have first character as blank space")
  public void NC025_Verify_that_the_New_Customer_page_show_error_message_if_telephone_starts_with_blank_space() {
    objNewCustomer.inputTelephone(" 123456");

    assertTrue(objNewCustomer.shouldBeToShowTelephoneErrorMessage(
        "First character can not have space"));
  }

  @Test(description = "NC26 - Telephone cannot have spaces")
  public void NC026_Verify_that_the_New_Customer_page_show_error_message_if_telephone_contains_blank_space() {
    objNewCustomer.inputTelephone("123 123");

    assertTrue(objNewCustomer.shouldBeToShowTelephoneErrorMessage("Characters are not allowed"));
  }

  @DataProvider(name = "telephoneSpecialDataProvider")
  public Object[][] telephoneSpecialDataProvider() {
    return new Object[][]{{"886636!@12"}, {"!@88662682"}, {"88663682!@"}};
  }

  @Test(description = "NC27 - Telephone cannot have special character", dataProvider = "telephoneSpecialDataProvider")
  public void NC027_Verify_that_the_New_Customer_page_show_error_message_if_telephone_has_special_characters(
      String telephone) {
    objNewCustomer.inputTelephone(telephone);

    assertTrue(objNewCustomer.shouldBeToShowTelephoneErrorMessage(
        "Special characters are not allowed"));
  }

  // ============================= Verify Email Field ==============================

  @Test(description = "NC28 - Email cannot be empty")
  public void NC028_Verify_that_the_New_Customer_page_show_error_message_if_email_is_blank() {
    objNewCustomer.inputEmail("");

    assertTrue(objNewCustomer.shouldBeToShowEmailErrorMessage("Email-ID must not be blank"));
  }

  @DataProvider(name = "invalidEmailDataProvider")
  public Object[][] invalidEmailDataProvider() {
    return new Object[][]{
        {"guru99@gmail "},
        {"guru99"},
        {"Guru99@"},
        {"guru99@gmail. "},
        {"guru99gmail.com"}
    };
  }

  @Test(description = "NC29 - Email must be in correct format", dataProvider = "invalidEmailDataProvider")
  public void NC029_Verify_that_the_New_Customer_page_show_error_message_if_email_is_invalid(
      String email) {
    objNewCustomer.inputEmail(email);

    assertTrue(objNewCustomer.shouldBeToShowEmailErrorMessage("Email-ID is not valid"));
  }

  // Known Issue in the sheet (Fail, "will be fixed in next phase of Project") -> disabled.
  // Set enabled = true once the site is fixed.
  @Test(description = "NC30 - Email cannot have space", enabled = false)
  public void NC030_Verify_that_the_New_Customer_page_show_error_message_if_email_contains_blank_space() {
    objNewCustomer.inputEmail("guru 99@gmail.com");

    assertTrue(objNewCustomer.shouldBeToShowEmailErrorMessage("Email-ID is not valid"));
  }

  // ============================= Verify Field Labels =============================

  @Test(description = "NC31 - Field labels match SRS (Telephone renamed to Mobile Number)")
  public void NC031_Verify_that_the_New_Customer_page_show_telephone_field_label_as_Mobile_Number() {
    assertTrue(objNewCustomer.shouldBeToShowTelephoneLabelAs("Mobile Number"));
  }

  // ============================= Verify Password Field ===========================

  @Test(description = "NC32 - Can input Password")
  public void NC032_Verify_that_the_New_Customer_page_allow_to_input_password() {
    objNewCustomer.inputPassword("Guru99@123");

    assertTrue(objNewCustomer.shouldBeToShowPasswordValue("Guru99@123"));
  }

  @Test(description = "NC33 - Password is masked")
  public void NC033_Verify_that_the_New_Customer_page_mask_the_password_field() {
    assertTrue(objNewCustomer.shouldBeToShowPasswordFieldTypeAs("password"));
  }

  // ========================== Verify Create Customer Success =====================

  @Test(description = "NC34 - Create a new customer with valid data")
  public void NC034_Verify_that_the_New_Customer_page_create_customer_successfully_with_valid_data() {
    // Email phải khác nhau mỗi lần chạy, nếu trùng site sẽ báo "Email Address Already Exist !!"
    String uniqueEmail = "guru99" + System.currentTimeMillis() + "@gmail.com";

    objNewCustomer.inputCustomerName("Nguyen Van A");
    objNewCustomer.selectGenderMale();
    objNewCustomer.inputDateOfBirth("12121990");
    objNewCustomer.inputAddress("123 Nguyen Trai");
    objNewCustomer.inputCity("Can Tho");
    objNewCustomer.inputState("Can Tho");
    objNewCustomer.inputPin("123456");
    objNewCustomer.inputTelephone("0987654321");
    objNewCustomer.inputEmail(uniqueEmail);
    objNewCustomer.inputPassword("Guru99@123");
    objNewCustomer.clickSubmit();

    assertTrue(objNewCustomer.shouldBeToShowSuccessMessage("Customer Registered Successfully!!!"));
    assertTrue(objNewCustomer.shouldBeToShowRegisteredCustomerName("Nguyen Van A"));
  }
}
