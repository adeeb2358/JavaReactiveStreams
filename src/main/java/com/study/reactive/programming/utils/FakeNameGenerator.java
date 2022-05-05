package com.study.reactive.programming.utils;

import java.util.ArrayList;
import java.util.List;
import reactor.core.publisher.Flux;

public class FakeNameGenerator {

  public static List<String> getNameAsList(int count) {
    var list = new ArrayList<String>(count);
    for (int i = 0; i < count; i++) {
      list.add(getName());
    }
    return list;
  }

  public static Flux<String> getNameAsFlux(int count) {
    return Flux.range(0, count).map(i -> getName());
  }

  public static String getName() {
    StreamUtils.sleepSeconds(1);
    return StreamUtils.faker().name().fullName();
  }
}
