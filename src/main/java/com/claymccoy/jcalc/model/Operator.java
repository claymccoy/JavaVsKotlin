package com.claymccoy.jcalc.model;

public enum Operator {
    Add("+"),
    Subtract("-"),
    Multiply("*"),
    Divide("/"),
    Exponent("^");
    
    private final String value;

    Operator(String value) {
        this.value = value;
    }

    public String toString() {
        return value;
    }
}
