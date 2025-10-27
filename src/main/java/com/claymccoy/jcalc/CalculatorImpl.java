package com.claymccoy.jcalc;

import com.claymccoy.jcalc.model.Calculator;
import com.claymccoy.jcalc.model.Expression;
import jakarta.validation.constraints.NotNull;

import static java.util.Objects.requireNonNull;

final public class CalculatorImpl implements Calculator
{
    @Override
    public int calculate(@NotNull Expression expression)
    {
        requireNonNull(expression, "expression is null");
        return switch (expression.operator()) {
            case Add -> expression.first().value() + expression.second().value();
            case Subtract -> expression.first().value() - expression.second().value();
            case Multiply -> expression.first().value() * expression.second().value();
            case Divide -> expression.first().value() / expression.second().value();
            case Exponent -> calculateExp(expression.first().value(), expression.second().value());
        };
    }

    private int calculateExp(int base, int exponent) {
        var acc = 1;
        for (int i = exponent; i > 0; i--) {
            acc = acc * base;
        }
        return acc;
    }
}
