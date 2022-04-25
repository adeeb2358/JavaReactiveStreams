package com.study.reactive.programming.mono;

import reactor.core.publisher.Mono;

public class CustomMono {
    public void createMono() {
        Mono<Integer> integerMono = Mono.just(1);

        // rule no 1 : Nothing happens until we subscribe
    }
}
