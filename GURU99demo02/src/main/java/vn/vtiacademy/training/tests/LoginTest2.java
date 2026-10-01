package vn.vtiacademy.training.tests;

import static org.testng.Assert.assertTrue;

import io.qameta.allure.Step;
import org.testng.annotations.Test;

public class LoginTest2 extends BaseTest2 {

  @Test
  @Step("LG001 - Verify that the Login page shows User-ID error message when User-ID field is left blank")
  public void LG001_Verify_that_the_Login_page_show_user_id_error_message_if_input_blank_into_user_id_text_box() {
    objLogin.inputUserId("");

    assertTrue(objLogin.shouldBeToShowUserIdErrorMessage("User-ID must not be blank"));
  }

  @Test
  @Step("LG002 - Verify that the Login page shows Password error message when Password field is left blank")
  public void LG002_Verify_that_the_Login_page_show_user_password_error_message_if_input_blank_into_user_password_text_box() {
    objLogin.inputUserPassword("");

    assertTrue(objLogin.shouldBeToShowUserPasswordErrorMessage("Password must not be blank"));
  }

  @Test
  @Step("LG003 - Verify that the Manager page contains text as Manger Id")
  public void LG003_Verify_that_the_Manager_page_contains_text_as_Manger_Id() {
    objLogin.inputUserId(MANAGER_USER_ID);
    objLogin.inputUserPassword(MANAGER_PASSWORD);
    objManager = objLogin.clickLoginButton();

    assertTrue(objManager.shouldBeToShowManagerIdAs("Manger Id : " + "mngr666663"));
  }
}