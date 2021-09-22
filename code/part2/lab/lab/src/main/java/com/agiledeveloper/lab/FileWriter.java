package com.agiledeveloper.lab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.util.Arrays;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.joining;

public class FileWriter implements Writer {
  private String fileName;
  private boolean isOpen = true;

  public FileWriter(String theFileName) throws IOException {
    fileName = theFileName;
  }

  @Override
  public String getContents() throws IOException {
    return
      Files.exists(Paths.get(fileName)) ?
      Files.lines(Paths.get(fileName))
      .collect(joining("")) : "";
  }

  @Override
  public void write(String text) throws IOException {
    if(isOpen) {
      Files.write(Paths.get(fileName), Arrays.asList(text), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }
  }

  @Override
  public void close() {
    isOpen = false;
  }
}
