package vn.vti.academy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MathTest {

  private static final Logger LOGGER = LoggerFactory.getLogger(MathP.class.getSimpleName());
  MathP MathP;

  @BeforeAll
  public static void beforeAll() {
    LOGGER.info("====================Starting All Tests===================");
  }

  @BeforeEach
  public void beforeEach() {
    LOGGER.info("====================Starting Test===================");
    MathP = new MathP();
  }


  @Test
  public void MP001_add_two_numbers_successfully() {
    // 3A = Arrange, Act, Assert
    // Arrange = Pre-condition
    LOGGER.info("MP001");
//    MathProvider mathProvider = new MathProvider();
    // Act = Test steps
    int actualSum = MathP.add(3, 5);

    // Assert = Expected Result
    assertEquals(8, actualSum);
  }

  @Test
  public void MP002_subtract_two_numbers_successfully() {
    LOGGER.info("MP001");
//    MathProvider mathProvider = new MathProvider();
    int actualSub = MathP.subtract(8, 4);
    assertEquals(4, actualSub);
  }

  @Test
  public void MP003_multiply_two_numbers_successfully() {
    LOGGER.info("MP001");
//    MathProvider mathProvider = new MathProvider();
    int actualMul = MathP.multiply(8, 4);

    boolean result = actualMul == 32; // true = passed, false = failed
    System.out.println(result);
    assertTrue(result);
//    assertEquals(32, actualMul);
  }

  @AfterEach
  public void afterEach() {
    LOGGER.info("====================Ended Test===================");
  }

  @AfterAll
  public static void afterAll() {
    LOGGER.info("====================Ended All Tests===================");
  }
}
