package com.study.reactive.programming.services;

import static java.nio.file.Files.readString;
import static java.nio.file.Files.writeString;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import reactor.core.publisher.Mono;

public class FileService {

  private static final Path PATH = Paths.get("src/main/resources/file-service/files");

  public static Mono<String> read(String fileName) {
    return Mono.fromSupplier(() -> readFile(fileName));
  }

  public static Mono<Void> write(String fileName, String contents) {
    return Mono.fromRunnable(() -> writeFile(fileName, contents));
  }

  public static Mono<Void> delete(String fileName) {
    return Mono.fromRunnable(() -> deleteFile(fileName));
  }

  private static String readFile(String fileName) {
    try {
      return readString(PATH.resolve(fileName));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private static void writeFile(String fileName, String contents) {
    try {
      writeString(PATH.resolve(fileName), contents);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private static void deleteFile(String fileName) {
    try {
      Files.delete(PATH.resolve(fileName));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
