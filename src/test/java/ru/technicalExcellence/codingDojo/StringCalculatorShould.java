package ru.technicalExcellence.codingDojo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Принимает любое кол-во аргументов
 * \n как разделитель
 * поддержка разделителей всех видов “//;\n1;2”
 * Отрицательное число -> IllegalArgumentException
 * Несколько отрицательных чисел -> IllegalArgumentException со всеми числами
 * Числа больше 1000 -> игнорируется
 */
public class StringCalculatorShould {

  private StringCalculator stringCalculator;

  public static Stream<Arguments> oneValueProvider() {
    return Stream.of(
        Arguments.of(1, "1"),
        Arguments.of(2, "2"),
        Arguments.of(3, "3")
    );
  }

  public static Stream<Arguments> twoValueProvider() {
    return Stream.of(
        Arguments.of(3, "1,2"),
        Arguments.of(6, "3,3")
    );
  }

  @BeforeEach
  void setUp() {
    stringCalculator = new StringCalculator();
  }

  @ParameterizedTest
  @NullAndEmptySource
  void return_0_when_null_or_empty_is_given(String value) {
    assertEquals(0, stringCalculator.add(value));
  }

  @ParameterizedTest
  @MethodSource("oneValueProvider")
  void return_value_when_one_value_is_given(int expected, String value) {
    assertEquals(expected, stringCalculator.add(value));
  }

  @ParameterizedTest
  @MethodSource("twoValueProvider")
  void return_sum_when_two_value_is_given(int expected, String value) {
    assertEquals(expected, stringCalculator.add(value));
  }
}
