package org.karpinen.numeral.systems;

import org.karpinen.numeral.core.Number;
import org.karpinen.numeral.utils.BaseConvert;

import java.util.Arrays;

public class Decimal extends Number implements BaseConvert {
    private Binary b;

    public Decimal(String s) {
        super(s, 10, Arrays.asList('0','1','2','3','4','5','6','7', '8','9'));
        init();
    }

    private void init() {
        b = new Binary(convertToBase2());
    }

    public int convertToBase10() {
        return convertToBase10(getInputString());
    }

    @Override
    public int convertToBase10(String s) {
        return Integer.parseInt(getInputString());
    }

    @Override
    public String convertToBase2() {
        StringBuilder bin = new StringBuilder();
        int dividend = Integer.parseInt(getInputString()) * 2;
        while(dividend > 1) {
            dividend /= 2;
            bin.append(dividend % 2);
        }
        return bin.reverse().toString();
    }

    @Override
    public String convertToBase8() {
        return b.convertToBase8();
    }

    @Override
    public String convertToBase16() {
        return b.convertToBase16();
    }
}
