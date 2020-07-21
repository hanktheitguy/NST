package org.karpinen.nst.number.core;

import java.util.Arrays;
import java.util.List;

public enum NumberBase {

    //These enum values are used later in @NumberValidator.
    Binary( 128,
            Arrays.asList('0','1')),
    Octal( 128,
            Arrays.asList('0','1','2','3','4','5','6','7')),
    Decimal( 128,
            Arrays.asList('0','1','2','3','4','5','6','7','8','9')),
    Hexadecimal(128,
            Arrays.asList('0','1','2','3','4','5','6','7','8','9','A', 'B','C','D','E','F'));

    //Length limit for the numberType itself.
    private int lenLimit;

    //Allowed character list for the numberType.
    private List<Character> allowedChar;

    //Set the enum value(s).
    private NumberBase(int lengthLimit, List<Character> charConstraint)  {
        lenLimit = lengthLimit;
        allowedChar = charConstraint;
    }

    //Returns set length limit.
    public int getLengthLimit() { return lenLimit; }

    //Returns the allowed characters for input.
    public List getCharRule() {
        return allowedChar;
    }
}
