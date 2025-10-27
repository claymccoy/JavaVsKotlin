package com.claymccoy.jcalc.model;

import jakarta.validation.constraints.NotNull;

import static java.util.Objects.requireNonNull;

public record SolvedExpression(
        @NotNull Expression expression,
        @NotNull int result)
{
    public SolvedExpression
    {
        requireNonNull(expression, "expression is null");
    }

    @Override
    public String toString()
    {
        return expression + " = " + result;
    }
}
