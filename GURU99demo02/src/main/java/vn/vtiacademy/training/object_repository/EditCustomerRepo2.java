package vn.vtiacademy.training.object_repository;

public class EditCustomerRepo2 {

  // Step 1: "Edit Customer Form" - enter Customer ID
  public static String TXT_CUSTOMER_ID = "//input[@name='cusid']";
  public static String BTN_SUBMIT_CUSTOMER_ID = "//input[@name='AccSubmit']";
  public static String LBL_CUSTOMER_ID_ERROR_MESSAGE = "//label[@id='message14']";

  // Step 2: edit form shown after a valid Customer ID is submitted
  public static String TXT_ADDRESS = "//textarea[@name='addr']";
  public static String TXT_CITY = "//input[@name='city']";
  public static String TXT_STATE = "//input[@name='state']";
  public static String TXT_PIN = "//input[@name='pinno']";
  public static String TXT_TELEPHONE = "//input[@name='telephoneno']";
  public static String TXT_EMAIL = "//input[@name='emailid']";

  public static String LBL_ADDRESS_ERROR_MESSAGE = "//label[@id='message3']";
  public static String LBL_CITY_ERROR_MESSAGE = "//label[@id='message4']";
  public static String LBL_STATE_ERROR_MESSAGE = "//label[@id='message5']";
  public static String LBL_PIN_ERROR_MESSAGE = "//label[@id='message6']";
  public static String LBL_TELEPHONE_ERROR_MESSAGE = "//label[@id='message7']";
  public static String LBL_EMAIL_ERROR_MESSAGE = "//label[@id='message9']";

  // (step 2, the one under the field list) and the success message shown after saving.
  public static String BTN_SUBMIT_EDIT_FORM = "//input[@name='sub']";
  //  public static String LBL_EDIT_SUCCESS_MESSAGE = "//p[@class='heading3']";
  public static String LNK_EDIT_CUSTOMER_MENU = "//a[normalize-space()='Edit Customer']";
}