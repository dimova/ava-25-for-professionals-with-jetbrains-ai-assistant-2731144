package com.linkedin.customgatherers.solution;

import java.util.stream.Gatherer;
import java.util.stream.Stream;

public class DoubleIfLarger {
    public static Gatherer<Integer, ?, Integer> doubleIfLarger() {
        class State {
            //  Track if we have a previous element and what it was
            boolean hasPrev = false;
            int prev = 0;
        }

        return Gatherer.ofSequential(
                State::new,
                Gatherer.Integrator.ofGreedy((state, elem, downstream) -> {

                    // 1. Check if this is the first element
                    if (!state.hasPrev) {
                        // First element: just emit it as-is
                        downstream.push(elem);
                    } else {
                        // Not first element: compare with previous
                        if (elem > state.prev) {
                            // Larger than previous: double it
                            downstream.push(elem * 2);
                        } else {
                            // Not larger: emit as-is
                            downstream.push(elem);
                        }
                    }

                    // 2. Update state for next iteration
                    state.prev = elem;
                    state.hasPrev = true;

                    return true; // continue processing
                })
        );
    }

    void main(String[] args) {
        System.out.println("=== Task 2: Double If Larger ===");
        Stream.of(5, 10, 3, 8, 12)
                .gather(doubleIfLarger())
                .forEach(System.out::println);
    }
}
