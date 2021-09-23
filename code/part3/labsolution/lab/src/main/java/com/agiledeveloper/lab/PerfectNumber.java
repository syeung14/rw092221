package com.agiledeveloper.lab;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class PerfectNumber {
  public static boolean isPerfect(int number) {
    return number > 1 && sumOfFactors(number) == number * 2;
  }
  
  private static int sumOfFactors(int number) {
    return IntStream.rangeClosed(1, number)
      .filter(isDivisible(number))
      .sum();
  }
  
  private static IntPredicate isDivisible(int number) {
    return divisor -> number % divisor == 0;
  }
}
