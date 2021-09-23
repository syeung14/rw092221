package com.agiledeveloper.lab;

public class PerfectNumber {
  public static boolean isPerfect(int n) {
    if(n <= 1) {
      return false;
    }

    int t = 0;

    for(int i = 1; i <= n; i++) {
      if(n % i == 0) {
        t += i;
      }
    }

    if(t == n * 2) {
      return true;
    } else {
      return false;
    }
  }
}
