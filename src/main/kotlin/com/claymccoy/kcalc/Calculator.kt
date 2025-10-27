package com.claymccoy.kcalc

interface Calculator {
    fun calculate(expression: Expression) : Int
}

class SolvedExpression(val expression: Expression, val result: Int) {
    override fun toString() = "$expression = $result"
}

class Expression(val operator: Operator, val first: Operand, val second: Operand) {
    override fun toString() = "$first $operator $second"
}

class Operand(val value: Int) {
    override fun toString() = value.toString()
}

sealed class Operator(private val value: String) {
    override fun toString() = value

    object Add: Operator("+")
    object Subtract: Operator("-")
    object Multiply: Operator("*")
    object Divide: Operator("/")
    object Exponent: Operator("^")
}
