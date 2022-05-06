package com.study.reactive.programming.services;

import org.junit.jupiter.api.BeforeEach;

class StockPricePublisherTest {

  private StockPricePublisher stockPricePublisher;

  @BeforeEach
  void setUp() {
    stockPricePublisher = new StockPricePublisher();
  }
}