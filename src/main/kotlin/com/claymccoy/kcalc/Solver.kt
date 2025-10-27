package com.claymccoy.kcalc

import com.claymccoy.kcalc.Operator.*

class Solver(private val calculator: Calculator) {

    class SolverDsl(private val calculator: Calculator) {
        val solveExpression = { exp: Expression -> SolvedExpression(exp, calculator.calculate(exp)) }

        operator fun Operand.plus(other: Int) = solveExpression(Expression(Add,this, Operand(other)))
        operator fun Operand.minus(other: Int) = solveExpression(Expression(Subtract,this, Operand(other)))
        operator fun Operand.times(other: Int) = solveExpression(Expression(Multiply,this, Operand(other)))
        operator fun Operand.div(other: Int) = solveExpression(Expression(Divide,this, Operand(other)))
        infix fun Operand.exp(other: Int) = solveExpression(Expression(Exponent,this, Operand(other)))
    }

    fun solve(exp: SolverDsl.() -> Unit) {
        exp(SolverDsl(calculator))
    }
}
