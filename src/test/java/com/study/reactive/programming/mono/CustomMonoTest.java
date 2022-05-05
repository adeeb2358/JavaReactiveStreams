package com.study.reactive.programming.mono;

import com.study.reactive.programming.utils.StreamUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomMonoTest {

    public CustomMono customMono;

    @BeforeEach
    void setUp() {
        customMono = new CustomMono();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createMono() {
        customMono.createMono();
    }

    @Test
    void buildAndExecutePipeLine() {
        customMono.buildAndExecutePipeLine();
    }

    @Test
    void createFromFuture() {
        customMono.createFromFuture();
        StreamUtils.sleepSeconds(1);
    }

    @Test
    void executeTimeConsumingProcess() {
        customMono.executeTimeConsumingProcess();
    }
}