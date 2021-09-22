package com.agiledeveloper.lab;

public class StringWriter implements Writer {
  private StringBuilder contents = new StringBuilder();
  private boolean isOpen = true;

  @Override
  public String getContents() {
    return contents.toString();
  }

  @Override
  public void write(String text) {
    if(isOpen) {
      contents.append(text);
    }
  }

  @Override
  public void close() {
    isOpen = false;
  }
}
