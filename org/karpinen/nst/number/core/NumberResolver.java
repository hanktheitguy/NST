package org.karpinen.nst.number.core;

import org.karpinen.nst.number.type.BinaryNumber;
import org.karpinen.nst.number.type.DecimalNumber;
import org.karpinen.nst.number.type.HexadecimalNumber;
import org.karpinen.nst.number.type.OctalNumber;

public class NumberResolver {

    public NumberResolver() { }

    //Returns the @NumberType based on the inputted params.
    public Object getNumberType(String type, String input) {
        Object o = null;
        switch (type) {
            case "Binary": o = new BinaryNumber(input); break;
            case "Decimal": o = new DecimalNumber(input); break;
            case "Hexadecimal": o = new HexadecimalNumber(input); break;
            case "Octal": o = new OctalNumber(input); break;
        }
        return o;
    }

    //Returns the base identifier for the param number system.
    public int getBaseIdentifier(String type) {
        int i = -1;
        switch (type) {
            case "Binary": i = 2; break;
            case "Decimal": i = 10; break;
            case "Hexadecimal": i = 16; break;
            case "Octal": i = 8; break;
        }
        return i;
    }
}
