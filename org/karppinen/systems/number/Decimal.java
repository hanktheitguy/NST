package org.karppinen.systems.number;

import java.util.Arrays;

public class Decimal extends Number {

    public Decimal(String x) {
        super(x, Arrays.asList('0','1','2','3','4','5','6','7','8','9'), 64);
    }

    public String convertToBinary(String z) {
        StringBuilder convert = new StringBuilder();
        int dividend = Integer.parseInt(z) * 2;
        while (true) {
            dividend /= 2;
            System.out.println();
            if(dividend < 1) {
                break;
            }
            convert.append(dividend % 2);
        }
        return convert.reverse().toString();
    }

    public String convertToHexadecimal() {
        Binary binary = new Binary(convertToBinary(getString()));
        return binary.convertToHexadecimal();
    }

    public String convertToOctal() {
        Binary binary = new Binary(convertToBinary(getString()));
        return binary.convertToOctal();
    }
}
