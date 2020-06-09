package org.karpinen.system.numerical.type;

import org.karpinen.system.numerical.core.Numeric;

import java.util.Arrays;

public class Octal extends Numeric implements Numeric.BaseConversion {
    public Octal(Object object) {
        super(object);
        setBase(8);
        setCharacterConstraint(Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7'));
        setLimit(64);
    }

    @Override
    public int toDecimal() {
        Binary b = new Binary(toBinary());
        return b.toDecimal();
    }

    @Override
    public String toHexadecimal() {
        Binary b = new Binary(toBinary());
        return b.toHexadecimal();
    }

    @Override
    public String toOctal() {
        return getInputString();
    }

    @Override
    public String toBinary() {
        StringBuilder oct = new StringBuilder();
        for (char c : getInputString().toCharArray()) {
            switch (c) {
                case '0': oct.append("000"); break;
                case '1': oct.append("001"); break;
                case '2': oct.append("010"); break;
                case '3': oct.append("011"); break;
                case '4': oct.append("100"); break;
                case '5': oct.append("101"); break;
                case '6': oct.append("110"); break;
                case '7': oct.append("111"); break;
            }
        }
        return oct.toString();
    }
}

