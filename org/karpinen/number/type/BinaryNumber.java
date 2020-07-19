package org.karpinen.number.type;

import org.karpinen.number.core.BaseConvert;
import org.karpinen.number.core.Number;
import org.karpinen.number.util.BinaryUtil;

public class BinaryNumber extends Number implements BaseConvert {
    private BinaryUtil util = new BinaryUtil();

    public BinaryNumber(String s) {
        super(s, 2);
    }

    @Override
    public String base2() {
        return getInput();
    }

    @Override
    public String base8() {
        return util.convertByBitGroups(3, getInput());
    }

    @Override
    public int base10() {
        return util.base10(getInput());
    }

    @Override
    public String base16() {
        return util.convertByBitGroups(4, getInput());
    }
}
