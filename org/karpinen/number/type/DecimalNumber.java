package org.karpinen.number.type;

import org.karpinen.number.core.BaseConvert;
import org.karpinen.number.core.Number;

public class DecimalNumber extends Number implements BaseConvert {
    private BinaryNumber bn;

    public DecimalNumber(String s) {
        super(s, 10);
        bn = new BinaryNumber(base2());
    }

    @Override
    public String base2() {
        StringBuilder bin = new StringBuilder();
        int dividend = Integer.parseInt(getInput()) * 2;
        while(dividend > 1) {
            dividend /= 2;
            bin.append(dividend % 2);
        }
        return bin.reverse().toString();
    }

    @Override
    public String base8() {
        return bn.base8();
    }

    @Override
    public int base10() {
        return Integer.valueOf(getInput());
    }

    @Override
    public String base16() {
        return bn.base16();
    }
}
