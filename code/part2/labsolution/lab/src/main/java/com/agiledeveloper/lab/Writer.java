package com.agiledeveloper.lab;

import java.io.IOException;

public abstract class Writer {
  private boolean isOpen = true;

  public abstract String getContents() throws IOException;

  public void write(String text) throws IOException {
    if(isOpen) {
      writeContents(text);
    }
  }

  protected abstract void writeContents(String text) throws IOException;

  public void close() {
    isOpen = false;
  }
}
