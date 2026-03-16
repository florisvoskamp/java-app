package com.floris.generics;

public class Pair<F, S> {
    private final F value;
    private final S secondValue;

    public Pair(F value, S secondValue) {
        this.value = value;
        this.secondValue = secondValue;
    }
}

