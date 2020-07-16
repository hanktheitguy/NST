package org.karpinen.numeral.systems;

import org.karpinen.numeral.core.Number;
import org.karpinen.numeral.utils.BaseConvert;
import java.util.Arrays;

public class Hexadecimal extends Number implements BaseConvert {
    Binary b;

    public Hexadecimal(String s) {
        super(s, 16 , Arrays.asList('0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'));
        init();
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
                case 'A': bin.append("1010"); break;
                case 'B': bin.append("1011"); break;
                case 'C': bin.append("1100"); break;
                case 'D': bin.append("1101"); break;
                case 'E': bin.append("1110"); break;
                case 'F': bin.append("1111"); break;
            }
        }
        return bin.toString();
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
