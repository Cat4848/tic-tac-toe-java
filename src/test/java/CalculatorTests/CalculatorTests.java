package CalculatorTests;

import static org.junit.jupiter.api.Assertions.*;

import Calculator.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

@DisplayName("Test suite for the Calculator class")
public class CalculatorTests {
  private final Calculator calculator = new Calculator();

  @Test
  @DisplayName("1 + 1 = 2")
  void addsTwoNumbers() {
    assertEquals(2, calculator.add(1, 1), "1 + 1 should equal 2");

  }

  @Test
  @DisplayName("2 + 2 is not 6")
  void addsTwoNumbers1() {
    assertNotEquals(6, calculator.add(2, 2), "2 + 2 should not equal 6");
  }

  @Test
  @DisplayName("Throws error when one of the operands is zero")
  void throwsErrorWhenOperandIsZero() {
    Error error = assertThrows(Error.class, () -> {
      calculator.add(0, 2);
    });
    assertEquals("Operands cannot be zero", error.getMessage());
  }
}
