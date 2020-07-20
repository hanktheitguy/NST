package org.karpinen.number.core;

import org.karpinen.number.type.BinaryNumber;
import org.karpinen.number.type.DecimalNumber;
import org.karpinen.number.type.HexadecimalNumber;
import org.karpinen.number.type.OctalNumber;

public class NumberResolver {

    public NumberResolver() { }

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
