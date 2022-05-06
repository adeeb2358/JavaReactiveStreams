package com.study.reactive.programming.services;

import com.study.reactive.programming.utils.StreamUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StockPriceSubscriberTest {

  private StockPriceSubscriber subscriber;

  @BeforeEach
  void setUp() {
    subscriber = new StockPriceSubscriber();
  }

  @AfterEach
  void tearDown() {
  }

  @Test
  void subscribe() {
    subscriber.subscribe();
    StreamUtils.sleepSeconds(8);
  }
}