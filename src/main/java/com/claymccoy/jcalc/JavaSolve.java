package com.claymccoy.jcalc;

import com.google.common.collect.ImmutableList;
import com.claymccoy.jcalc.model.Expression;
import com.claymccoy.jcalc.model.Operand;
import com.claymccoy.jcalc.model.SolvedExpression;

import java.util.Comparator;
import java.util.stream.Collectors;

import static com.claymccoy.jcalc.model.Operator.*;

public final class JavaSolve
{
    public static void main(String[] args) {
        final var solver = new Solver(new CalculatorImpl());
        ImmutableList.of(
                solver.solve(new Expression(Add, new Operand(2), new Operand(3))),
                solver.solve(new Expression(Add, new Operand(7), new Operand(5))),
                solver.solve(new Expression(Subtract, new Operand(5), new Operand(3))),
                solver.solve(new Expression(Multiply, new Operand(4), new Operand(3))),
                solver.solve(new Expression(Divide, new Operand(10), new Operand(2))),
                solver.solve(new Expression(Divide, new Operand(15), new Operand(5))),
                solver.solve(new Expression(Exponent, new Operand(5), new Operand(3)))
        ).stream().filter(solvedExpression -> solvedExpression.result() < 100)
                .collect(Collectors.groupingBy(SolvedExpression::result))
                .entrySet().stream()
                .map(entry -> {
                    final var joinedExpressions = entry.getValue().stream().map(solvedExpression ->
                            solvedExpression.expression().toString()).collect(Collectors.joining(" = "));
                    return entry.getKey() + " = " + joinedExpressions;
                }).sorted(Comparator.comparing(String::length))
                .forEach(System.out::println);
    }
}
