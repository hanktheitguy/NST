package org.karpinen.system.numerical.type;

import org.karpinen.system.numerical.core.Numeric;

import java.util.Arrays;

public class Binary extends Numeric implements Numeric.BaseConversion {

    public Binary(Object object) {
        super(object);
        setBase(2);
        setLimit(64);
        setCharacterConstraint(Arrays.asList('0', '1'));
    }

    @Override
    public int toDecimal() {
        return toDecimal(getInputString());
    }

    //Used to convert Binary to Decimal.
    public int toDecimal(String s) {
        int bitValue = 1;
        int total = 0;
        char[] bin = new StringBuilder(s).reverse().toString().toCharArray();
        for (char c : bin) {
            bitValue *= 2;
            if (c == '1') {
                total += bitValue;
            }
        }
        return total / 2;
    }

    @Override
    public String toOctal() {
        StringBuilder oct = new StringBuilder();
        int ph = getLength();
        for (int i = 0; i < getLength() / 3; i++) {
            int x = toDecimal(getInputString().substring(ph - 3, ph));
            oct.append(x);
            ph -= 3;
        }
        if ((getLength() % 3) > 0) {
            String remainder = getInputString().substring(ph - (getLength() % 3), ph);
            oct.append(toDecimal(remainder));
        }
        return oct.reverse().toString();
    }

    @Override
    public String toHexadecimal() {
        StringBuilder hex = new StringBuilder();
        int ph = getLength();
        for (int i = 0; i < getLength() / 4; i++) {
            int x = toDecimal(getInputString().substring(ph - 4, ph));
            ph -= 4;
            if (x <= 9) {
                hex.append(x);
            } else {
                switch (x) {
                    case 10: hex.append('A'); break;
                    case 11: hex.append('B'); break;
                    case 12: hex.append('C'); break;
                    case 13: hex.append('D'); break;
                    case 14: hex.append('E'); break;
                    case 15: hex.append('F'); break;
                }
            }
        }
        if ((getLength() % 4) > 0) {
            String remainder = getInputString().substring(ph - (getLength() % 4), ph);
            hex.append(toDecimal(remainder));
        }
        return hex.reverse().toString();
    }

    @Override
    public String toBinary() {
        return getInputString();
    }
}
