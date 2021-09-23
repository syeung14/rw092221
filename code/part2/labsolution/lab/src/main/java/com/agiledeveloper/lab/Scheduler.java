package com.agiledeveloper.lab;

import java.io.IOException;
import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.Map;

public class Scheduler {
  private Writer writer;

  private Scheduler(Writer writer) throws IOException {
    this.writer = writer;
  }

  public static Scheduler create() throws IOException {
    return create(new StringWriter());
  }

  public static Scheduler create(Writer writer) throws IOException {
    Scheduler scheduler = new Scheduler(writer);
    writer.write("Schedule created:");
    return scheduler;
  }

  public Writer getWriter() {
    return writer;
  }

  public void writeFor(DayOfWeek dayOfWeek) throws IOException {
    /*
    A few options:
    1. We could use a Map
    1a. Map.of if using Java 9
    2. We could use the switch expression of modern Java
     */

    Map<DayOfWeek, String> activities =
      new HashMap<DayOfWeek, String>() {
        {
          put(DayOfWeek.SUNDAY, "Homework");
          put(DayOfWeek.MONDAY, "Swimming");
          put(DayOfWeek.TUESDAY, "Music");
          put(DayOfWeek.WEDNESDAY, "Tennis");
          put(DayOfWeek.THURSDAY, "Music");
          put(DayOfWeek.FRIDAY, "Relax");
          put(DayOfWeek.SATURDAY, "Community");
        }
      };

    String lowerCaseDayOfWeek = dayOfWeek.name().toLowerCase();
    String titleCase = lowerCaseDayOfWeek.substring(0, 1).toUpperCase() + lowerCaseDayOfWeek.substring(1);
    writer.write(String.format("~%s - %s", titleCase, activities.get(dayOfWeek)));
  }
}
