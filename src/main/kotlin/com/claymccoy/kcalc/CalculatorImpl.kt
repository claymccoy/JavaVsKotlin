package com.claymccoy.kcalc

import com.claymccoy.kcalc.Operator.*

class CalculatorImpl: Calculator {
    override fun calculate(expression: Expression) : Int {
        return when (expression.operator) {
            Add -> expression.run { first.value + second.value }
            Subtract ->  expression.run { first.value - second.value }
            Multiply ->  expression.run { first.value * second.value }
            Divide ->  expression.run { first.value / second.value }
            Exponent -> expression.run { calculateExp(first.value, second.value) }
        }
    }

    private tailrec fun calculateExp(base: Int, exponent: Int, acc: Int = 1): Int {
        if (exponent == 0) return acc
        return calculateExp(base, exponent - 1, acc * base)
    }
}
