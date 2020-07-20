package org.karpinen.number.type;

import org.karpinen.number.core.BaseConvert;
import org.karpinen.number.core.Number;

public class HexadecimalNumber extends Number implements BaseConvert {
    private final BinaryNumber bn;

    public HexadecimalNumber(String s) {
        super(s, 16);
        bn = new BinaryNumber(base2());
    }

    @Override
    public String base2() {
        StringBuilder bin = new StringBuilder();
        for (char c : getInput().toCharArray()) {
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
    public String base8() {
        return bn.base8();
    }

    @Override
    public int base10() {
        return bn.base10();
    }

    @Override
    public String base16() {
        return getInput();
    }
}
