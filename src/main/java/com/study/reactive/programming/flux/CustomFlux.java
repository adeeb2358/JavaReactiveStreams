package com.study.reactive.programming.flux;

import com.study.reactive.programming.utils.FakeNameGenerator;
import com.study.reactive.programming.utils.StreamUtils;
import java.time.Duration;
import java.util.Arrays;
import reactor.core.publisher.Flux;

public class CustomFlux {

  public void createFluxFromList() {
    var strings = Arrays.asList("a", "b", "c");
    Flux.fromIterable(strings).subscribe(StreamUtils.onNext());
  }

  public void arrayVsFlux(){
    System.out.println(FakeNameGenerator.getNameAsList(5));
    FakeNameGenerator.getNameAsFlux(5).subscribe(StreamUtils.onNext());
  }

  // period jobs can be done this way.
  public void createPeriodicFlux(){
    Flux.interval(Duration.ofSeconds(1)).subscribe(StreamUtils.onNext());
  }

}
