package com.agiledeveloper.lab;

public class StringWriter extends Writer {
  private StringBuilder contents = new StringBuilder();

  @Override
  public String getContents() {
    return contents.toString();
  }

  @Override
  public void writeContents(String text) {
    contents.append(text);
  }
}

//If we are able to write, then write to string, file, etc. in the implementation
//base takes care of the open or not, derived focuses on the destination

//Separation of concerns