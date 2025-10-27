package com.claymccoy.jcalc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.claymccoy.jcalc.model.Expression;
import com.claymccoy.jcalc.model.Operand;
import com.claymccoy.jcalc.model.Operator;

public class CalculatorImplTest {
    
    @Test
    public void testAddition() {
        CalculatorImpl calculator = new CalculatorImpl();
        Expression expression = new Expression(Operator.Add, new Operand(2), new Operand(3));
        
        int result = calculator.calculate(expression);
        
        assertEquals(5, result);
    }
    
    @Test
    public void testSubtraction() {
        CalculatorImpl calculator = new CalculatorImpl();
        Expression expression = new Expression(Operator.Subtract, new Operand(5), new Operand(3));
        
        int result = calculator.calculate(expression);
        
        assertEquals(2, result);
    }
    
    @Test
    public void testMultiplication() {
        CalculatorImpl calculator = new CalculatorImpl();
        Expression expression = new Expression(Operator.Multiply, new Operand(4), new Operand(3));
        
        int result = calculator.calculate(expression);
        
        assertEquals(12, result);
    }
    
    @Test
    public void testDivision() {
        CalculatorImpl calculator = new CalculatorImpl();
        Expression expression = new Expression(Operator.Divide, new Operand(10), new Operand(2));
        
        int result = calculator.calculate(expression);
        
        assertEquals(5, result);
    }
}
