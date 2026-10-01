package vn.vtiacademy.training.tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EditCustomerTest2 extends BaseTest2 {

  private static final String NEW_CUSTOMER_URL =
      "https://demo.guru99.com/V4/manager/addcustomerpage.php";
  private String validCustomerId;

  @BeforeClass
  public void login() {
    loginAsManager();
    validCustomerId = createCustomerAndGetId();
  }

  private String createCustomerAndGetId() {

    webUI.navigateTo(NEW_CUSTOMER_URL);
    objNewCustomer.inputCustomerName("Nguyen Van A");
    objNewCustomer.selectGenderMale();
    objNewCustomer.inputDateOfBirth("12121990");
    objNewCustomer.inputAddress("123 Nguyen Trai");
    objNewCustomer.inputCity("Can Tho");
    objNewCustomer.inputState("Can Tho");
    objNewCustomer.inputPin("123456");
    objNewCustomer.inputTelephone("0987654321");
    objNewCustomer.inputEmail("lukas@gmail.com");
    objNewCustomer.inputPassword("Guru099@123");
    objNewCustomer.clickSubmit();
    webUI.delayInSeconds(2);
    return objNewCustomer.getGeneratedCustomerId();
  }

  // Reload the page before every test (and every data-provider row) so no previous input leaks in
  @BeforeMethod
  public void openEditCustomerPage() {
    objEditCustomer.clickEditCustomerMenuLink();
  }

  // Fields of the edit form are only shown after a valid Customer ID is submitted
  private void openEditCustomerForm() {
    objEditCustomer.inputCustomerId(validCustomerId);
    objEditCustomer.clickSubmitButton();
  }

  // ============================ Verify Customer id ============================

  @Test(description = "EC1 - Customer id cannot be empty")
  public void EC001_Verify_that_the_Edit_Customer_page_show_error_message_if_customer_id_is_blank() {
    objEditCustomer.inputCustomerId("");

    assertTrue(objEditCustomer.shouldBeToShowCustomerIdErrorMessage("Customer ID is required"));
  }

  @DataProvider(name = "customerIdCharacterDataProvider")
  public Object[][] customerIdCharacterDataProvider() {
    return new Object[][]{{"1234Acc"}, {"Acc123"}};
  }

  @Test(description = "EC2 - Customer id must be numeric", dataProvider = "customerIdCharacterDataProvider")
  public void EC002_Verify_that_the_Edit_Customer_page_show_error_message_if_customer_id_contains_characters(
      String customerId) {
    objEditCustomer.inputCustomerId(customerId);

    assertTrue(objEditCustomer.shouldBeToShowCustomerIdErrorMessage("Characters are not allowed"));
  }

  @DataProvider(name = "customerIdSpecialDataProvider")
  public Object[][] customerIdSpecialDataProvider() {
    return new Object[][]{{"123!@#"}, {"!@#"}};
  }

  @Test(description = "EC3 - Customer id cannot have special character", dataProvider = "customerIdSpecialDataProvider")
  public void EC003_Verify_that_the_Edit_Customer_page_show_error_message_if_customer_id_has_special_characters(
      String customerId) {
    objEditCustomer.inputCustomerId(customerId);

    assertTrue(objEditCustomer.shouldBeToShowCustomerIdErrorMessage(
        "Special characters are not allowed"));
  }

  @Test(description = "EC4 - Valid Customer Id")
  public void EC004_Verify_that_the_Edit_Customer_page_redirect_to_edit_form_if_input_valid_customer_id() {
    openEditCustomerForm();

    assertTrue(objEditCustomer.shouldBeToShowEditCustomerForm());
  }
}