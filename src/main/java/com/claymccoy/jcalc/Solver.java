package com.claymccoy.jcalc;

import com.claymccoy.jcalc.model.Calculator;
import com.claymccoy.jcalc.model.Expression;
import com.claymccoy.jcalc.model.SolvedExpression;
import jakarta.validation.constraints.NotNull;

import static java.util.Objects.requireNonNull;

public final class Solver
{
    private final Calculator calculator;

    public Solver(@NotNull Calculator calculator) {
        requireNonNull(calculator, "calculator is null");
        this.calculator = calculator;
    }

    public SolvedExpression solve(@NotNull Expression expression) {
        return new SolvedExpression(expression, calculator.calculate(expression));
    }
}
