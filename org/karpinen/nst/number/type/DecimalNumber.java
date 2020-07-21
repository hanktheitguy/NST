package org.karpinen.nst.number.type;

import org.karpinen.nst.number.core.BaseConvert;
import org.karpinen.nst.number.core.Number;

public class DecimalNumber extends Number implements BaseConvert {
    private final BinaryNumber bn;

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
        return Integer.parseInt(getInput());
    }

    @Override
    public String base16() {
        return bn.base16();
    }
}