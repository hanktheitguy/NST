package org.karpinen.nst.number.calc;

import java.util.Arrays;
import java.util.List;

public enum Operator
{
    Add (1, Arrays.asList('+')),
    Sub (1, Arrays.asList('-')),
    Mul (2, Arrays.asList('*')),
    Div (2, Arrays.asList('/')),
    Mod (2, Arrays.asList('%')),
    Exp (3, Arrays.asList('^')),
    Par (4, Arrays.asList('(', ')'));

    private int             weight;
    private List<Character> operator;

    private Operator(int weight, List<Character> operator)
    {
        this.operator = operator;
        this.weight = weight;
    }
}
