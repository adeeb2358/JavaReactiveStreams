package com.study.reactive.programming.mono;

import com.study.reactive.programming.utils.StreamUtils;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class CustomMono {

    public static String getName() {
        return StreamUtils.faker().name().fullName();
    }

    public static Mono<String> getSomeResult() {
        System.out.println("Entered the method getSomeResult()");
        return Mono.fromSupplier(() -> {
            System.out.println("Generating name");
            StreamUtils.sleepSeconds(3);
            return getName();
        }).map(String::toUpperCase);
    }

    public void buildAndExecutePipeLine() {
        getSomeResult();
        // only subscribe onNext will execute the pipeline,
        // otherwise only the pipeline is build.
        getSomeResult().subscribeOn(Schedulers.boundedElastic()).subscribe(StreamUtils.onNext());
        getSomeResult();
        // for getting the result
        //StreamUtils.sleepSeconds(4);
    }


    public static CompletableFuture<String> getNameFromCompletableFuture() {
        return CompletableFuture.supplyAsync(CustomMono::getName);
    }

    public void createFromFuture() {
        Mono.fromFuture(getNameFromCompletableFuture()).subscribe(StreamUtils.onNext());
    }

    public void createMono() {
        Mono<Integer> integerMono = Mono.just(1);
        integerMono.subscribe(integer -> System.out.println("Received:" + integer));
        // rule no 1 : Nothing happens until we subscribe

        Mono<String> stringMono = Mono.just("ball");
        stringMono.subscribe(System.out::println, err -> System.out.println(err.getMessage()),
            () -> System.out.println("Completed"));

        Mono<Integer> anotherIntegerMono = Mono.just("ball").map(String::length).map(l -> l / 0);
        anotherIntegerMono.subscribe(System.out::println,
            err -> System.out.println(err.getMessage()),
            () -> System.out.println("Hey Its Completed"));

        // using utility class
        Mono<Integer> newIntegerMono = Mono.just("newBall").map(String::length).map(l -> l / 0);
        newIntegerMono.subscribe(StreamUtils.onNext(), StreamUtils.onError(),
            StreamUtils.onComplete());

        // if we don't have data , don't use Just.
        Supplier<String> stringSupplier = CustomMono::getName;
        Mono.fromSupplier(stringSupplier).subscribe(StreamUtils.onNext());

        Callable<String> stringCallable = CustomMono::getName;
        Mono.fromCallable(stringCallable).subscribe(StreamUtils.onNext());

    }

    // executing a series of time-consuming process

    private static Runnable timeConsumingProcess() {
        return () -> {
            StreamUtils.sleepSeconds(3);
            System.out.println("Operation completed");
        };
    }

    public void executeTimeConsumingProcess() {
        Mono.fromRunnable(timeConsumingProcess())
            .subscribe(StreamUtils.onNext(), StreamUtils.onError(), () -> {
                System.out.println("process is done. Sending emails...!");
            });
    }
}
