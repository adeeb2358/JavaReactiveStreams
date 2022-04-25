package com.study.reactive.programming.stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomStreamTest {

    private CustomStream customStream;
    @BeforeEach
    void setUp() {
        customStream = new CustomStream();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createStream() {
        customStream.createStream();
    }
}