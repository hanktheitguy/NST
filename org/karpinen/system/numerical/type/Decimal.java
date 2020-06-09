package org.karpinen.system.numerical.type;

import org.karpinen.system.numerical.core.Numeric;

import java.util.Arrays;
import java.util.List;

public class Decimal extends Numeric implements Numeric.BaseConversion {
    List<Character> charRule = Arrays.asList('0','1','2','3','4','5','6','7','8','9');

    public Decimal(Object object) {
        super(object);
        setBase(10);
        setCharacterConstraint(charRule);
        setLimit(64);
    }

    @Override
    public String toBinary() {
        StringBuilder bin = new StringBuilder();
        int dividend = Integer.parseInt(getInputString()) * 2;
        while(dividend > 1) {
            dividend /= 2;
            bin.append(dividend % 2);
        }
        return bin.reverse().toString();
    }

    @Override
    public String toOctal() {
        Binary b = new Binary(toBinary());
        return b.toOctal();
    }

    @Override
    public String toHexadecimal() {
        Binary b = new Binary(toBinary());
        return b.toHexadecimal();
    }

    @Override
    public int toDecimal() {
        return Integer.parseInt(getInputString());
    }
}
