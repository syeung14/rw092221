package com.agiledeveloper.lab;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.DayOfWeek;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SchedulerTest {
  private Writer writer;
  private Scheduler scheduler;

  @BeforeEach
  void init() throws IOException {
    writer = new StringWriter();

    scheduler = new Scheduler(writer);
  }

  @Test
  void createScheduler() throws IOException {
    assertEquals("Schedule created:", writer.getContents());
  }

  @Test
  void createSchedulerWithoutWriter() throws IOException {
    scheduler = new Scheduler(null);

    assertEquals("Schedule created:", scheduler.getWriter().getContents());
  }

  @Test
  void writeScheduleForSunday() throws IOException {
    scheduler.writeFor(DayOfWeek.SUNDAY);

    assertEquals("Schedule created:~Sunday - Homework", writer.getContents());
  }

  @Test
  void writeScheduleForMonday() throws IOException {
    scheduler.writeFor(DayOfWeek.MONDAY);

    assertEquals("Schedule created:~Monday - Swimming", writer.getContents());
  }

  @Test
  void writeScheduleForTuesday() throws IOException {
    scheduler.writeFor(DayOfWeek.TUESDAY);

    assertEquals("Schedule created:~Tuesday - Music", writer.getContents());
  }

  @Test
  void writeScheduleForWednesday() throws IOException {
    scheduler.writeFor(DayOfWeek.WEDNESDAY);

    assertEquals("Schedule created:~Wednesday - Tennis", writer.getContents());
  }

  @Test
  void writeScheduleForThursday() throws IOException {
    scheduler.writeFor(DayOfWeek.THURSDAY);

    assertEquals("Schedule created:~Thursday - Music", writer.getContents());
  }

  @Test
  void writeScheduleForFriday() throws IOException {
    scheduler.writeFor(DayOfWeek.FRIDAY);

    assertEquals("Schedule created:~Friday - Relax", writer.getContents());
  }

  @Test
  void writeScheduleForSaturday() throws IOException {
    scheduler.writeFor(DayOfWeek.SATURDAY);

    assertEquals("Schedule created:~Saturday - Community", writer.getContents());
  }
}
