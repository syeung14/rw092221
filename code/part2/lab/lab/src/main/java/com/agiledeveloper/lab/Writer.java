package com.agiledeveloper.lab;

import java.io.IOException;

public interface Writer {
  String getContents() throws IOException;

  void write(String text) throws IOException;

  void close();
}
