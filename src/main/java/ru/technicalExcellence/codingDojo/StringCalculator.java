package ru.technicalExcellence.codingDojo;

public class StringCalculator {

  public static final String DELIMITER_REGEX = "[,]";

  public int add(String queryString) {
    if (queryString == null || queryString.isEmpty()) {
      return 0;
    }

    String[] values = queryString.split(DELIMITER_REGEX);
    int sum = 0;
    for (String value : values) {
      sum += Integer.parseInt(value);
    }
    return sum;
  }
}
