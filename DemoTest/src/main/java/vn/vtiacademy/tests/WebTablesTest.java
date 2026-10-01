package vn.vtiacademy.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import vn.vtiacademy.commonkeys.DemoTest.WebUI;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS) // dùng chung 1 instance cho cả class -> field không bị reset giữa các test
public class WebTablesTest {

  WebUI webUI = new WebUI();

  // Dữ liệu và trạng thái được chia sẻ giữa 3 test (cùng 1 dòng trong bảng)
  private WebTableRecord record;
  private String rowXpath; // xpath của dòng, tính 1 lần ở test tạo mới, tái sử dụng ở 2 test sau

  @BeforeAll
  public void setUp() {
    webUI.openBrowser("chrome", "https://demoqa.com/webtables");
    webUI.maximizeWindow();
  }

  @AfterAll
  public void tearDown() {
    webUI.closeBrowser();
  }

  // ============ 1. TẠO DATA MỚI ============
  @Test
  @Order(1)
  public void create_new_record() {
    webUI.click("id:addNewRecordButton"); //button[@id='addNewRecordButton']
    webUI.waitForElementVisible("id:firstName");//input[@id='firstName']\
    
    record = new WebTableRecord(
        "Nguyen",
        "Van A",
        "nguyenvana" + System.currentTimeMillis() + "@test.com", // email duy nhất để tìm đúng dòng
        "25",
        "10000",
        "QA");

    webUI.inputText("id:firstName", record.getFirstName());
    webUI.inputText("id:lastName", record.getLastName());
    webUI.inputText("id:userEmail", record.getEmail());
    webUI.inputText("id:age", record.getAge());
    webUI.inputText("id:salary", record.getSalary());
    webUI.inputText("id:department", record.getDepartment());
    webUI.click("id:submit");

    // Nếu modal vẫn còn hiển thị sau khi bấm Submit -> submit thất bại (thường do validate hoặc bị che)
    boolean modalClosed = webUI.waitForElementInvisible("//div[@id='registration-form-modal']", 10);
    if (!modalClosed) {
      System.out.println("=== MODAL VẪN CÒN HIỂN THỊ SAU KHI SUBMIT - PAGE SOURCE: ===");
      System.out.println(webUI.getPageSource());
    }
    assertTrue(modalClosed, "Modal không đóng sau khi bấm Submit -> submit thất bại");

    rowXpath = "//tr[td[text()='" + record.getEmail() + "']]";
    boolean rowVisible = webUI.waitForElementVisible(rowXpath, 10);
    if (!rowVisible) {
      System.out.println("=== KHÔNG TÌM THẤY DÒNG MỚI - PAGE SOURCE: ===");
      System.out.println(webUI.getPageSource());
    }
    assertTrue(rowVisible, "Dòng dữ liệu mới không xuất hiện trong bảng");

    // Kiểm tra dữ liệu hiển thị trên bảng đúng, đủ với thông tin đã nhập
    assertEquals(record.getFirstName(), webUI.getText(rowXpath + "/td[1]"));
    assertEquals(record.getLastName(), webUI.getText(rowXpath + "/td[2]"));
    assertEquals(record.getAge(), webUI.getText(rowXpath + "/td[3]"));
    assertEquals(record.getEmail(), webUI.getText(rowXpath + "/td[4]"));
    assertEquals(record.getSalary(), webUI.getText(rowXpath + "/td[5]"));
    assertEquals(record.getDepartment(), webUI.getText(rowXpath + "/td[6]"));
  }

  // ============ 2. SỬA DATA ============
  @Test
  @Order(2)
  public void edit_record() {
    webUI.click(rowXpath + "//span[@title='Edit']");
    webUI.waitForElementVisible("id:firstName");

    // email giữ nguyên -> rowXpath vẫn còn hợp lệ sau khi sửa
    record = new WebTableRecord(
        "Tran",
        "Thi B",
        "tranthiB" + System.currentTimeMillis() + "@test.com",
        "30",
        "20000",
        "Developer");

    webUI.clearText("id:firstName");
    webUI.inputText("id:firstName", record.getFirstName());
    webUI.clearText("id:lastName");
    webUI.inputText("id:lastName", record.getLastName());
    webUI.clearText("id:age");
    webUI.inputText("id:age", record.getAge());
    webUI.clearText("id:userEmail");
    webUI.inputText("id:userEmail", record.getEmail());
    webUI.clearText("id:salary");
    webUI.inputText("id:salary", record.getSalary());
    webUI.clearText("id:department");
    webUI.inputText("id:department", record.getDepartment());
    webUI.click("id:submit");
    webUI.delayInSeconds(5);

    // CẬP NHẬT LẠI rowXpath THEO EMAIL MỚI TRƯỚC KHI VERIFY
    rowXpath = "//tr[td[text()='" + record.getEmail() + "']]";

    // Kiểm tra dòng với XPath mới
    assertTrue(webUI.waitForElementVisible(rowXpath, 10),
        "Dòng dữ liệu không còn hiển thị sau khi sửa");

    // Kiểm tra dữ liệu hiển thị trên bảng sau khi sửa đúng, đủ
    assertEquals(record.getFirstName(), webUI.getText(rowXpath + "/td[1]"));
    assertEquals(record.getLastName(), webUI.getText(rowXpath + "/td[2]"));
    assertEquals(record.getAge(), webUI.getText(rowXpath + "/td[3]"));
    assertEquals(record.getEmail(), webUI.getText(rowXpath + "/td[4]"));
    assertEquals(record.getSalary(), webUI.getText(rowXpath + "/td[5]"));
    assertEquals(record.getDepartment(), webUI.getText(rowXpath + "/td[6]"));
  }

  // ============ 3. XÓA DATA ============
  @Test
  @Order(3)
  public void delete_record() {
    assertTrue(webUI.verifyElementVisible(rowXpath),
        "Dòng dữ liệu cần xóa không tồn tại trước khi xóa");

    webUI.click(rowXpath + "//span[@title='Delete']");
    webUI.delayInSeconds(5);
    // Kiểm tra dòng dữ liệu không còn hiển thị trong bảng
    assertTrue(webUI.waitForElementNotPresent(rowXpath, 10),
        "Dòng dữ liệu vẫn còn hiển thị trong bảng sau khi xóa");
  }
}