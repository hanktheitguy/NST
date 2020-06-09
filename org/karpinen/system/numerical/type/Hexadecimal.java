package org.karpinen.system.numerical.type;

import org.karpinen.system.numerical.core.Numeric;

import java.util.Arrays;
import java.util.List;

public class Hexadecimal extends Numeric implements Numeric.BaseConversion {
    List<Character> constraint = Arrays.asList
            ('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F');

    public Hexadecimal(Object object) {
        super(object);
        setBase(16);
        setCharacterConstraint(constraint);
        setLimit(64);
    }

    @Override
    public int toDecimal() {
        Binary b = new Binary(toBinary());
        return b.toDecimal();
    }

    @Override
    public String toOctal() {
        Binary b = new Binary(toBinary());
        return b.toOctal();
    }

    @Override
    public String toHexadecimal() {
        return getInputString();
    }

    @Override
    public String toBinary() {
        StringBuilder bin = new StringBuilder();
        for (char c : getInputString().toCharArray()) {
            switch (c) {
                case '0': bin.append("0000"); break;
                case '1': bin.append("0001"); break;
                case '2': bin.append("0010"); break;
                case '3': bin.append("0011"); break;
                case '4': bin.append("0100"); break;
                case '5': bin.append("0101"); break;
                case '6': bin.append("0110"); break;
                case '7': bin.append("0111"); break;
                case '8': bin.append("1000"); break;
                case '9': bin.append("1001"); break;
                case 'A': bin.append("0010"); break;
                case 'B': bin.append("1011"); break;
                case 'C': bin.append("1100"); break;
                case 'D': bin.append("1101"); break;
                case 'E': bin.append("1110"); break;
                case 'F': bin.append("1111"); break;
            }
        }
        return bin.toString();
    }
}
