package com.study.reactive.programming.mono;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
}