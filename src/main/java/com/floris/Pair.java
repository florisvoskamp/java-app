package com.floris;

public class Pair<F, S> {
    private final F value;
    private final S secondValue;

    Pair(F value, S secondValue) {
        this.value = value;
        this.secondValue = secondValue;
    }
}
