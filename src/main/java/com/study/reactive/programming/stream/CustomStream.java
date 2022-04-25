package com.study.reactive.programming.stream;

import java.util.stream.Stream;

public class CustomStream {
    public void createStream() {
        Stream<Integer> integerStream = Stream.of(1).map(integerNumber -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return integerNumber * 2;
        });
        System.out.println(integerStream); // this will return immediately
        integerStream.forEach(System.out::println); // this will block the output

    }
}
