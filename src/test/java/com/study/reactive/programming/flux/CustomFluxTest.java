package com.study.reactive.programming.flux;

import com.study.reactive.programming.utils.StreamUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomFluxTest {

  private CustomFlux customFlux;

  @BeforeEach
  void setup() {
    customFlux = new CustomFlux();
  }


  @Test
  void arrayVsFlux() {
    customFlux.arrayVsFlux();
  }


  @Test
  void createFluxFromList() {
    customFlux.createFluxFromList();
  }

  @Test
  void createPeriodicFlux() {
    customFlux.createPeriodicFlux();
    StreamUtils.sleepSeconds(5);
  }
}