package com.agiledeveloper.lab;

import java.util.List;
import static java.util.stream.Collectors.joining;

public class Util {
  public static String commaSeparatedNamesOfLength(List<String> names, int length) {
    return names.stream()
      .filter(name -> name.length() == length)
      .map(String::toUpperCase)
      .collect(joining(", "));
  }

  public static double calculate(List<Integer> numbers) {
    //return numbers.stream()
    //  .filter(e -> e % 2 == 0)
    //  .filter(e -> e > 3)
    //  .filter(e -> Math.sqrt(e) < 3)
    //  .mapToDouble(e -> e * 2)
    //  .sum();

    return numbers.stream()
      .filter(Util::isEven)
      .filter(Util::isGT3)
      .filter(Util::isSQRTLessThan3)
      .mapToDouble(Util::twice)
      .sum();
  }
  
  public static boolean isEven(int number) {
    return number % 2 == 0;
  }

  public static boolean isGT3(int number) {
    return number > 3;
  }

  public static boolean isSQRTLessThan3(int number) {
    return Math.sqrt(number) < 3;
  }

  public static int twice(int number) {
    return number * 2;
  }
}
