package org.karppinen.systems.number;

import java.util.Arrays;

public class Hexadecimal extends Number {

    public Hexadecimal(String x) {
        super(
                x,
                Arrays.asList('0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'),
                64
        );
    }

    public String convertToBinary() {
        StringBuilder convert = new StringBuilder();
        for(int i = 0; i < getLength(); i++) {
            switch (getString().charAt(i)) {
                case '0': convert.append("0000"); break;
                case '1': convert.append("0001"); break;
                case '2': convert.append("0010"); break;
                case '3': convert.append("0011"); break;
                case '4': convert.append("0100"); break;
                case '5': convert.append("0101"); break;
                case '6': convert.append("0110"); break;
                case '7': convert.append("0111"); break;
                case '8': convert.append("1000"); break;
                case '9': convert.append("1001"); break;
                case 'A': convert.append("1010"); break;
                case 'B': convert.append("1011"); break;
                case 'C': convert.append("1100"); break;
                case 'D': convert.append("1101"); break;
                case 'E': convert.append("1110"); break;
                case 'F': convert.append("1111"); break;
            }
        }
        return convert.toString();
    }

    public String convertToOctal() {
        Binary b = new Binary(convertToBinary());
        return b.convertToOctal();
    }

    public String convertToDecimal() {
        Binary b = new Binary(convertToBinary());
        return b.convertToDecimal(getString());
    }
}
