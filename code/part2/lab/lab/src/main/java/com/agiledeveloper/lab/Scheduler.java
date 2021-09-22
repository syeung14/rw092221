package com.agiledeveloper.lab;

import java.io.IOException;
import java.time.DayOfWeek;

public class Scheduler {
  private Writer writer;

  public Scheduler(Writer writer) throws IOException {
    if(writer == null) {
      writer = new StringWriter();
    }

    this.writer = writer;

    writer.write("Schedule created:");
  }

  public Writer getWriter() {
    return writer;
  }

  public void writeFor(DayOfWeek dayOfWeek) throws IOException {
    if(dayOfWeek == DayOfWeek.MONDAY) {
      writer.write("~Monday - Swimming");
    } else {
      if(dayOfWeek == DayOfWeek.TUESDAY) {
        writer.write("~Tuesday - Music");
      } else {
        if(dayOfWeek == DayOfWeek.WEDNESDAY) {
          writer.write("~Wednesday - Tennis");
        } else {
          if(dayOfWeek == DayOfWeek.THURSDAY) {
            writer.write("~Thursday - Music");
          } else {
            if(dayOfWeek == DayOfWeek.FRIDAY) {
              writer.write("~Friday - Relax");
            } else {
              if(dayOfWeek == DayOfWeek.SATURDAY) {
                writer.write("~Saturday - Community");
              } else {
                if(dayOfWeek == DayOfWeek.SUNDAY) {
                  writer.write("~Sunday - Homework");
                }
              }
            }
          }
        }
      }
    }
  }
}
