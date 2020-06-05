package org.karppinen.systems.number;

import java.util.Arrays;

public class Octal extends Number {

    public Octal(String x) {
        super(x, Arrays.asList('0','1','2','3','4','5','6','7'), 64);
    }

    public String convertToBinary() {
        StringBuilder convert = new StringBuilder();
        for(int i = 0; i < getLength(); i++) {
            switch (getString().charAt(i)) {
                case '1': convert.append("001"); break;
                case '2': convert.append("010"); break;
                case '3': convert.append("011"); break;
                case '4': convert.append("100"); break;
                case '5': convert.append("101"); break;
                case '6': convert.append("110"); break;
                case '7': convert.append("111"); break;
            }
        }
        return convert.toString();
    }

    public String convertToHexadecimal() {
        Binary b = new Binary(convertToBinary());
        return b.convertToHexadecimal();
    }

    public String convertToDecimal() {
        Binary b = new Binary(convertToBinary());
        return b.convertToDecimal(getString());
    }
}
