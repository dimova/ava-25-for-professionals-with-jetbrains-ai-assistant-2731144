package com.linkedin.customgatherers.solution;

import java.util.List;
import java.util.stream.Gatherers;

public class BatchingWithGatherer {
    void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers.stream()
                .gather(Gatherers.windowFixed(3))
                .forEach(System.out::println);
    }
}
