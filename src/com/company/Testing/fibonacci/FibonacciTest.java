package com.company.Testing.fibonacci;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FibonacciTest {

  @Test
  void fibonacci() {
    Assertions.assertAll(() -> assertEquals(2, Fibonacci.fibonacci(3)),
        () -> assertEquals(3, Fibonacci.fibonacci(4)),
        () -> assertEquals(5, Fibonacci.fibonacci(5)),
        () -> assertEquals(377, Fibonacci.fibonacci(14)),
        () -> assertEquals(0, Fibonacci.fibonacci(0)));
  }
}