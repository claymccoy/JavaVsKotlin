package com.claymccoy.kcalc

import kotlin.test.Test
import kotlin.test.assertEquals

class CalculatorImplTest {
    
    @Test
    fun testAddition() {
        val calculator = CalculatorImpl()
        val expression = Expression(Operator.Add, Operand(2), Operand(3))
        
        val result = calculator.calculate(expression)
        
        assertEquals(5, result)
    }
    
    @Test
    fun testSubtraction() {
        val calculator = CalculatorImpl()
        val expression = Expression(Operator.Subtract, Operand(5), Operand(3))
        
        val result = calculator.calculate(expression)
        
        assertEquals(2, result)
    }
    
    @Test
    fun testMultiplication() {
        val calculator = CalculatorImpl()
        val expression = Expression(Operator.Multiply, Operand(4), Operand(3))
        
        val result = calculator.calculate(expression)
        
        assertEquals(12, result)
    }
    
    @Test
    fun testDivision() {
        val calculator = CalculatorImpl()
        val expression = Expression(Operator.Divide, Operand(10), Operand(2))
        
        val result = calculator.calculate(expression)
        
        assertEquals(5, result)
    }
    
    @Test
    fun testExponent() {
        val calculator = CalculatorImpl()
        val expression = Expression(Operator.Exponent, Operand(2), Operand(3))
        
        val result = calculator.calculate(expression)
        
        assertEquals(8, result)
    }
}
