package org.karpinen.number.core;

import org.karpinen.number.type.BinaryNumber;
import org.karpinen.number.type.DecimalNumber;
import org.karpinen.number.type.HexadecimalNumber;
import org.karpinen.number.type.OctalNumber;

public class NumberConverter {
    private NumberResolver resolve = new NumberResolver();
    private String result;

    public NumberConverter(String startSys, String targetSys, String input) {
        convertToTargetBase
                (resolve.getNumberType(startSys, input), resolve.getBaseIdentifier(targetSys));
    }

    private void convertToTargetBase(Object object, int targetBase) {
        String s = null;
        if(object instanceof BinaryNumber) {
            BinaryNumber bn = (BinaryNumber) object;
            switch (targetBase) {
                case 2: s = bn.getInput(); break;
                case 8: s = bn.base8(); break;
                case 10: s = String.valueOf(bn.base10()); break;
                case 16: s = bn.base16(); break;
            }
        }else if(object instanceof DecimalNumber) {
            DecimalNumber dn = (DecimalNumber) object;
            switch (targetBase) {
                case 2: s = dn.base2(); break;
                case 8: s = dn.base8(); break;
                case 10: s = dn.getInput(); break;
                case 16: s = dn.base16(); break;
            }
        }else if(object instanceof HexadecimalNumber) {
            HexadecimalNumber hn = (HexadecimalNumber) object;
            switch (targetBase) {
                case 2: s = hn.base2(); break;
                case 8: s = hn.base8(); break;
                case 10: s = String.valueOf(hn.base10()); break;
                case 16: s = hn.getInput(); break;
            }
        }else if(object instanceof OctalNumber) {
            OctalNumber on = (OctalNumber) object;
            switch (targetBase) {
                case 2: s = on.base2(); break;
                case 8: s = on.getInput(); break;
                case 10: s = String.valueOf(on.base10()); break;
                case 16: s = on.base16(); break;
            }
        }
        result = s;
    }

    public String getResult() {
        return result;
    }
}
