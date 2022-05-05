package com.study.reactive.programming.services;

import com.study.reactive.programming.utils.StreamUtils;
import org.junit.jupiter.api.Test;

class FileServiceTest {

  @Test
  void read() {
    FileService.read("file1.txt")
        .subscribe(StreamUtils.onNext(), StreamUtils.onError(), StreamUtils.onComplete());
  }

  @Test
  void write() {
    FileService.write("file3.txt", "This is file3 contents")
        .subscribe(StreamUtils.onNext(), StreamUtils.onError(), StreamUtils.onComplete());
  }

  @Test
  void delete() {
    FileService.delete("file3.txt")
        .subscribe(StreamUtils.onNext(), StreamUtils.onError(), StreamUtils.onComplete());
  }
}