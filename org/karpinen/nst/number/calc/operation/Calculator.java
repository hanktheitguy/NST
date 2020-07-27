package org.karpinen.nst.number.calc.operation;

import org.karpinen.nst.number.convert.Converter;

public class Calculator
{
    private Evaluator evaluator;
    private Converter converter;

    public Calculator ()
    {
        evaluator = new Evaluator();
        converter = new Converter();
    }

    public void calculate(String expression, int targetBase)
    {
        String exp = expression.replaceAll("\\s", "");
        String result = evaluator.evaluateExpression(exp);
        String output = converter.convert(result, 10, targetBase);
        System.out.println(output);
    }
}
