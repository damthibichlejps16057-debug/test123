package vn.vtiacademy.training.object_repository;

public class NewCustomerRepo2 {

  public static String TXT_CUSTOMER_NAME = "//input[@name='name']";
  public static String TXT_ADDRESS = "//textarea[@name='addr']";
  public static String TXT_CITY = "//input[@name='city']";
  public static String TXT_STATE = "//input[@name='state']";
  public static String TXT_PIN = "//input[@name='pinno']";
  public static String TXT_TELEPHONE = "//input[@name='telephoneno']";
  public static String TXT_EMAIL = "//input[@name='emailid']";
  public static String RAD_GENDER_MALE = "//input[@name='rad1' and @value='m']";
  public static String RAD_GENDER_FEMALE = "//input[@name='rad1' and @value='f']";
  public static String TXT_DOB = "//input[@name='dob']";
  public static String TXT_PASSWORD = "//input[@name='password']";

  public static String LBL_CUSTOMER_NAME_ERROR_MESSAGE = "//label[@id='message']";
  public static String LBL_ADDRESS_ERROR_MESSAGE = "//label[@id='message3']";
  public static String LBL_CITY_ERROR_MESSAGE = "//label[@id='message4']";
  public static String LBL_STATE_ERROR_MESSAGE = "//label[@id='message5']";
  public static String LBL_PIN_ERROR_MESSAGE = "//label[@id='message6']";
  public static String LBL_TELEPHONE_ERROR_MESSAGE = "//label[@id='message7']";
  public static String LBL_EMAIL_ERROR_MESSAGE = "//label[@id='message9']";
  public static String LBL_DOB_ERROR_MESSAGE = "//label[@id='message24']";

  // Label cell of the row that contains the telephone input (its text should be "Mobile Number")
  public static String LBL_TELEPHONE_FIELD = "//tr[td/input[@name='telephoneno']]/td[1]";


  public static String BTN_SUBMIT = "//input[@name='sub']";

  // Trang kết quả sau khi Submit
  public static String LBL_RESULT_CUSTOMER_NAME =
      "//td[normalize-space()='Customer Name']/following-sibling::td";
  public static String LBL_SUCCESS_MESSAGE = "//p[@class='heading3']";
  public static String LBL_GENERATED_CUSTOMER_ID =
      "//tr[td[contains(normalize-space(),'Customer ID')]]/td[2]";
  public static String LBL_GENERATED_CUSTOMER_NAME =
      "//tr[td[contains(normalize-space(),'Customer Name')]]/td[2]";


}
