package org.karpinen.numeral.systems;

import org.karpinen.numeral.core.Number;
import org.karpinen.numeral.utils.BaseConvert;

import java.util.Arrays;

public class Octal extends Number implements BaseConvert {
    private Binary b;

    public Octal(String s) {
        super(s, 8, Arrays.asList('0','1','2','3','4','5','6','7'));
    }

    public int convertToBase10() {
        return convertToBase10(getInputString());
    }

    @Override
    public int convertToBase10(String s) {
        return b.convertToBase10();
    }

    private void init() {
        b = new Binary(convertToBase2());
    }

    @Override
    public String convertToBase2() {
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

    @Override
    public String convertToBase8() {
        return b.convertToBase8();
    }

    @Override
    public String convertToBase16() {
        return b.convertToBase16();
    }
}
