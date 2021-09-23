package com.agiledeveloper.lab;

import org.junit.jupiter.api.Test;

import static com.agiledeveloper.lab.PerfectNumber.isPerfect;
import static org.junit.jupiter.api.Assertions.*;

public class PerfectNumberTest {
  @Test
  void checkIsPerfect() {
    assertAll(
      () -> assertTrue(isPerfect(6)),
      () -> assertTrue(isPerfect(28))
    );
  }

  @Test
  void checkNotPerfect() {
    assertAll(
      () -> assertFalse(isPerfect(0)),
      () -> assertFalse(isPerfect(1)),
      () -> assertFalse(isPerfect(3)),
      () -> assertFalse(isPerfect(5)),
      () -> assertFalse(isPerfect(7)),
      () -> assertFalse(isPerfect(8)),
      () -> assertFalse(isPerfect(27)),
      () -> assertFalse(isPerfect(29))
    );
  }
}
