package org.karpinen.nst.number.calc.operation;

import org.karpinen.nst.number.convert.Converter;

import java.util.*;

public class Evaluator {

    private final List<Character>                 operators;
    private final Operation                       operation;
    private final Converter                       converter;

    public Evaluator()
    {
        operators = Arrays.asList('+', '-', '*', '/', '%', '^');
        operation = new Operation();
        converter = new Converter();
    }

    public String evaluateExpression (String input)
    {
        String temp = input;
        while (hasOperator(temp))
        {
            int maxOpWeight = getMaxOpWeight (temp);
            for (int i = 0; i < temp.length(); i++)
            {
                if (operators.contains(temp.charAt(i)))
                {
                    if (getOperatorWeight(temp.charAt(i)) == maxOpWeight)
                    {
                        temp = solveExpression (temp, i);
                    }
                }
                else if (temp.charAt(i) == '(')
                {
                    int startpoint = i;
                    int endpoint = 0;
                    for (int i2 = startpoint; i2 < temp.length(); i2++)
                    {
                        if (temp.charAt(i2) == ')')
                        {
                            endpoint = i2;
                            break;
                        }
                    }
                    String replace = temp.substring (startpoint, endpoint + 1);
                    String expression = temp.substring (startpoint + 1, endpoint);
                    int opPos = getExpressionOp (expression);
                    temp = temp.replace (replace, solveExpression(expression, opPos));
                }
            }
        }
        return temp;
    }

    private int getExpressionOp (String expression)
    {
        int operatorPos = 0;
        for (int x = 0; x < expression.length(); x++)
        {
            if  (operators.contains(expression.charAt(x)))
            {
                operatorPos = x;
                break;
            }
        }
        return operatorPos;
    }

    private String solveExpression (String input, int i)
    {
        String temp = input;
        char c = temp.charAt(i);
        String arg1 =  getFirstArgument(i, temp);
        String arg2 = getSecondArgument(i, temp);
        String replace = arg1 + c + arg2;
        String solution = getSolution
                (c, convertStringToInt(arg1), convertStringToInt(arg2));
        temp = temp.replace(replace, solution);
        return temp;
    }


    private String getFirstArgument (int position, String input)
    {
        int start = 0;

        for (int i = position - 1; i > 0; i--)
        {
            if (operators.contains(input.charAt(i)))
            {
                start = i + 1;
                break;
            }
        }
        return input.substring(start, position);
    }

    private String getSecondArgument (int position, String input)
    {
        int end = input.length();
        for (int i = position + 1; i < input.length(); i++)
        {
            if (operators.contains(input.charAt(i)))
            {
                end = i;
                break;
            }
        }
        return input.substring (position + 1, end);
    }

    private int convertStringToInt (String input)
    {
        int base   = resolveBaseID (input);
        String num = removeBaseID  (input);
        return Integer.parseInt (converter.convert(num, base, 10));
    }

    private int getMaxOpWeight (String input)
    {
        int highestWeight = 0;
        for(char c : input.toCharArray())
        {
            if (getOperatorWeight(c) > highestWeight)
            {
                highestWeight = getOperatorWeight(c);
            }
        }
        return highestWeight;
    }

    private boolean hasOperator (String input)
    {
        for (char c : input.toCharArray())
        {
            if (operators.contains(c))
            {
                return true;
            }
        }
        return false;
    }


    private int getOperatorWeight (char op)
    {
        int operatorWeight = -1;
        switch (op)
        {
            case '+':
            case '-':
                operatorWeight = 1; break;
            case '*':
            case '%':
            case '/':
                operatorWeight = 2; break;
            case '^': operatorWeight = 3; break;
            case '(': operatorWeight = 4; break;
        }
        return operatorWeight;
    }

    private int resolveBaseID (String input)
    {
        int baseID;
        if      (input.contains ("h")) { baseID = 16; }
        else if (input.contains ("o")) { baseID = 8;  }
        else if (input.contains ("b")) { baseID = 2;  }
        else {                           baseID = 10; }
        return baseID;
    }

    private String removeBaseID (String input)
    {
        String temp = input;
        if      (input.contains ("h")) { temp = temp.replace("h", ""); }
        else if (input.contains ("o")) { temp = temp.replace("o", ""); }
        else if (input.contains ("b")) { temp = temp.replace("b", ""); }
        return temp;
    }

    private String getSolution(char operator, int num1, int num2)
    {
        int solution = -1;
        switch (operator)
        {
            case '+': solution = operation.add (num1, num2);                         break;
            case '-': solution = operation.sub (num1, num2);                         break;
            case '*': solution = operation.mul (num1, num2);                         break;
            case '/': solution = operation.div (num1, num2);                         break;
            case '%': solution = operation.mod (num1, num2);                         break;
            case '^': solution = (int) operation.exp(num1, num2);                    break;
        }
        return String.valueOf(solution);
    }

}
