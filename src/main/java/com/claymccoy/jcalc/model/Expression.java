package com.claymccoy.jcalc.model;

import jakarta.validation.constraints.NotNull;

import static java.util.Objects.requireNonNull;

public record Expression(
        @NotNull Operator operator,
        @NotNull Operand first,
        @NotNull Operand second)
{
    public Expression
    {
        requireNonNull(operator, "operator is null");
        requireNonNull(first, "first is null");
        requireNonNull(second, "second is null");
    }

    @Override
    public String toString()
    {
        return first + " " + operator + " " + second;
    }
}
