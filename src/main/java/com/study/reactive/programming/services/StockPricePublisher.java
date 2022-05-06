package com.study.reactive.programming.services;

import com.study.reactive.programming.utils.StreamUtils;
import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;
import reactor.core.publisher.Flux;

public class StockPricePublisher {

  public static Flux<Integer> getPrice() {
    AtomicInteger atomicInteger = new AtomicInteger(100);
    return Flux.interval(Duration.ofSeconds(1)).map(
        i -> atomicInteger.getAndAccumulate(StreamUtils.faker().random().nextInt(-5, 5),
            Integer::sum));
  }
}
