package com.linkedin.customgatherers.challenge;

import java.util.stream.Gatherer;
import java.util.stream.Stream;

public class DoubleIfLarger {

    public static Gatherer<Integer, ?, Integer> doubleIfLarger() {
        class State {
            boolean hasPrev = false;
            int prev = 0;
        }

        return Gatherer.ofSequential(
                State::new,
                Gatherer.Integrator.ofGreedy((state, elem, downstream) -> {
                    // TODO: Implement the logic:
                    // 1. If this is the first element, just emit it as-is
                    if(!state.hasPrev){
                        downstream.push(elem);
                    }
                    // 2. If elem > previous, emit elem * 2
                    else if(elem>state.prev){
                        downstream.push(elem * 2);
                    }
                    else{
                        downstream.push(elem);
                    }
                    state.hasPrev = true;
                    state.prev = elem;
                    // 3. Otherwise, emit elem as-is
                    // 4. Update state to remember this element

                    return true; // continue processing
                })
        );
    }

    void main() {
        Stream.of(5, 10, 3, 8, 12)
                .gather(doubleIfLarger())
                .forEach(System.out::println);
    }
}