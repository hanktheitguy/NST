package org.karpinen.number.core;

import java.util.Arrays;
import java.util.List;

public enum NumberBase {

    Binary( 128,
            Arrays.asList('0','1')),
    Octal( 128,
            Arrays.asList('0','1','2','3','4','5','6','7')),
    Decimal( 128,
            Arrays.asList('0','1','2','3','4','5','6','7','8','9')),
    Hexadecimal(128,
            Arrays.asList('0','1','2','3','4','5','6','7','8','9','A', 'B','C','D','E','F'));


    private int lenLimit;
    private List<Character> allowedChar;

    private NumberBase(int lengthLimit, List<Character> charConstraint)  {
        lenLimit = lengthLimit;
        allowedChar = charConstraint;
    }

    public int getLengthLimit() {
        return lenLimit;
    }

    public List getCharRule() {
        return allowedChar;
    }
}
