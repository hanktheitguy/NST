package org.karpinen.number.type;

import org.karpinen.number.core.BaseConvert;
import org.karpinen.number.core.Number;

public class OctalNumber extends Number implements BaseConvert {
    private BinaryNumber bn;

    public OctalNumber(String s) {
        super(s, 8);
        bn = new BinaryNumber(base2());
    }

    @Override
    public String base2() {
        StringBuilder oct = new StringBuilder();
        for (char c : getInput().toCharArray()) {
            switch (c) {
                case '0': oct.append(""); break;
                case '1': oct.append("001"); break;
                case '2': oct.append("10"); break;
                case '3': oct.append("11"); break;
                case '4': oct.append("100"); break;
                case '5': oct.append("101"); break;
                case '6': oct.append("110"); break;
                case '7': oct.append("111"); break;
            }
        }
        return oct.toString();
    }

    @Override
    public String base8() {
        return getInput();
    }

    @Override
    public int base10() {
        return bn.base10();
    }

    @Override
    public String base16() {
        return bn.base16();
    }
}
