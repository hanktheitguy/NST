package org.karpinen.nst.number.core;

import org.karpinen.nst.number.type.BinaryNumber;
import org.karpinen.nst.number.type.DecimalNumber;
import org.karpinen.nst.number.type.HexadecimalNumber;
import org.karpinen.nst.number.type.OctalNumber;

public class NumberConverter {
    //Used to resolve numberType based off inputs. Used in the conversion process.
    private NumberResolver resolve = new NumberResolver();

    //Result of the conversion.
    private String result;

    //Constructor takes 4 arguments which are passed into @NumberResolver @convertToTargetBase
    public NumberConverter(String startSys, String targetSys, String input) {
        convertToTargetBase
                (resolve.getNumberType(startSys, input), resolve.getBaseIdentifier(targetSys));
    }
    /*
    In the following method we check if the inputted object is an instance of a numberType.
    If it is, we cast the object to that type to be used to convert through the @BaseConvert
    interface.
     */
    private void convertToTargetBase(Object object, int targetBase) {
        String s = null;

        //It's a @BinaryNumber here.
        if(object instanceof BinaryNumber) {
            BinaryNumber bn = (BinaryNumber) object;
            switch (targetBase) {
                case 2: s = bn.getInput(); break;
                case 8: s = bn.base8(); break;
                case 10: s = String.valueOf(bn.base10()); break;
                case 16: s = bn.base16(); break;
            }
        //Instance of a @DecimalNumber
        }else if(object instanceof DecimalNumber) {
            DecimalNumber dn = (DecimalNumber) object;
            switch (targetBase) {
                case 2: s = dn.base2(); break;
                case 8: s = dn.base8(); break;
                case 10: s = dn.getInput(); break;
                case 16: s = dn.base16(); break;
            }
        //Instance of a @HexadecimalNumber
        }else if(object instanceof HexadecimalNumber) {
            HexadecimalNumber hn = (HexadecimalNumber) object;
            switch (targetBase) {
                case 2: s = hn.base2(); break;
                case 8: s = hn.base8(); break;
                case 10: s = String.valueOf(hn.base10()); break;
                case 16: s = hn.getInput(); break;
            }
        //Instance of a @OctalNumber
        }else if(object instanceof OctalNumber) {
            OctalNumber on = (OctalNumber) object;
            switch (targetBase) {
                case 2: s = on.base2(); break;
                case 8: s = on.getInput(); break;
                case 10: s = String.valueOf(on.base10()); break;
                case 16: s = on.base16(); break;
            }
        }
        //Set the result of the conversion.
        result = s;
    }

    //Returns the result of the calculation.
    public String getResult() {
        return result;
    }
}
