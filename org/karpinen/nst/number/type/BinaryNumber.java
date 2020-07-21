package org.karpinen.nst.number.type;

import org.karpinen.nst.number.core.BaseConvert;
import org.karpinen.nst.number.core.Number;
import org.karpinen.nst.number.util.BinaryUtility;

public class BinaryNumber extends Number implements BaseConvert {
    private final BinaryUtility util = new BinaryUtility();

    public BinaryNumber(String s) {
        super(s, 2);
    }

    @Override
    public String base2() { return getInput(); }

    @Override
    public String base8() { return util.convertByBitGroups(3, getInput()); }

    @Override
    public int base10() { return util.base10(getInput());
    }

    @Override
    public String base16() {
        return util.convertByBitGroups(4, getInput());
    }
}
