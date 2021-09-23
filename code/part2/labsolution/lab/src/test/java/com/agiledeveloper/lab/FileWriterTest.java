package com.agiledeveloper.lab;

import org.junit.jupiter.api.AfterEach;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWriterTest extends WriterTest {
  protected Writer create() throws IOException {
    return new FileWriter("sample.txt");
  }

  @AfterEach
  void tearDown() throws IOException {
    Files.deleteIfExists(Paths.get("sample.txt"));
  }
}
