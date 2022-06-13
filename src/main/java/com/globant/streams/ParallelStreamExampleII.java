package com.globant.streams;

import java.util.stream.IntStream;
import java.util.stream.Stream;
/**
 *The intention of this class is showing how parallelStream is more benefit under certain criteria
 */
public class ParallelStreamExampleII {
  public static void main(String[] args) {
    long initialTime = System.currentTimeMillis();
    long count = Stream.iterate(0, n -> n + 1)
        .limit(1_000_000)
        .parallel()   //parallel 80450 ms, normal/sequential 127991 ms
        .filter(ParallelStreamExampleII::isPrime)
        .peek(x -> System.out.format("%s\t", x))
        .count();

    long finalTime = System.currentTimeMillis();
    System.out.println(finalTime - initialTime);

  }

  public static boolean isPrime(int number) {
    if (number <= 1) return false;
    return IntStream.rangeClosed(2, number / 2).noneMatch(i -> number % i == 0);
  }
}
