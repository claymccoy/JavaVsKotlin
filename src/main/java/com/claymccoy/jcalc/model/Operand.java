package com.claymccoy.jcalc.model;

public record Operand(int value) {
    @Override
    public String toString()
    {
        return Integer.toString(value);
    }
}
