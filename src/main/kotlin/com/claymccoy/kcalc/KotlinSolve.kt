package com.claymccoy.kcalc

fun main() {
    Solver(CalculatorImpl()).solve {
        listOf(
            Operand(2) + 3,
            Operand(7) + 5,
            Operand(5) - 3,
            Operand(4) * 3,
            Operand(10) / 2,
            Operand(15) / 5,
            Operand(5) exp 3
        ).filter { it.result < 100 }
            .groupBy { it.result }
            .map { (result, solvedExpressions) ->
                val joinedExpressions = solvedExpressions.map { it.expression }.joinToString(" = ")
                "$result = $joinedExpressions"
            }.sortedBy { it.length }
            .forEach(::println)
    }
}
