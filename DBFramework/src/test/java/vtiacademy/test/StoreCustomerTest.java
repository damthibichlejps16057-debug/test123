package vtiacademy.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import org.junit.jupiter.api.Test;
import vtiacademy.common.DBKeywords;
import vtiacademy.common.DBType;

public class StoreCustomerTest {

  @Test
  public void SC001_customer_table_is_not_empty() {
    // Arrange
    DBKeywords dbKeywords = new DBKeywords();
    Connection connection = dbKeywords.createConnection(DBType.MYSQL, "127.0.0.1", "3306",
        "sql_store", "root", "lesql123@");
    // Act
    ResultSet resultSet = dbKeywords.executeQuery(connection, "SELECT * FROM customers");
    List<String> customerIds = dbKeywords.getCellValues(resultSet, "customer_id");

    // Assert
    assertNotEquals(0, customerIds.size());
  }

  @Test
  public void SC002_found_a_record_successfully() {
    // Arrange
    DBKeywords dbKeywords = new DBKeywords();
    Connection connection = dbKeywords.createConnection(DBType.MYSQL, "127.0.0.1", "3306",
        "sql_store", "root", "lesql123@");
    // Act
    ResultSet resultSet = dbKeywords.executeQuery(connection, "SELECT * FROM customers");
    List<String> customerIds = dbKeywords.getCellValues(resultSet, "customer_id");
    List<String> fistNames = dbKeywords.getCellValues(resultSet, "first_name");
    List<String> lastNames = dbKeywords.getCellValues(resultSet, "last_name");

    String actualCustomerId = customerIds.get(4);
    String actualFirstName = fistNames.get(4);
    String actualLastName = lastNames.get(4);

    // Assert
    assertEquals("5", actualCustomerId);
    assertEquals("Clemmie", actualFirstName);
    assertEquals("Betchley", actualLastName);
  }

}

