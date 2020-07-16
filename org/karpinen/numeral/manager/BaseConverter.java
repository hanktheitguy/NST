package org.karpinen.numeral.manager;

import org.karpinen.numeral.systems.Binary;
import org.karpinen.numeral.systems.Decimal;
import org.karpinen.numeral.systems.Hexadecimal;
import org.karpinen.numeral.systems.Octal;

public class BaseConverter {

    private Binary convertToBinary(int startBase, String s) {
        Binary b = null;
        switch (startBase) {
            case 2:
                b = new Binary(s);
                break;
            case 8:
                Octal o = new Octal(s);
                b = new Binary(o.convertToBase2());
                break;
            case 10:
                Decimal d = new Decimal(s);
                b = new Binary(d.convertToBase2());
                break;
            case 16:
                Hexadecimal h = new Hexadecimal(s);
                b = new Binary(h.convertToBase2());
                break;
        }
        return b;
    }

    private Decimal convertToDecimal(int startBase, String s) {
        Decimal d = null;
        switch (startBase) {
            case 2:
                Binary b = new Binary(s);
                d = new Decimal(String.valueOf(b.convertToBase10()));
                break;
            case 8:
                Octal o = new Octal(s);
                d = new Decimal(String.valueOf(o.convertToBase10()));
                break;
            case 10:
                d = new Decimal(s);
                break;
            case 16:
                Hexadecimal h = new Hexadecimal(s);
                d = new Decimal(String.valueOf(h.convertToBase10()));
                break;
        }
        return d;
    }

    private Hexadecimal convertToHexadecimal(int startBase, String s) {
        Hexadecimal h = null;
        switch (startBase) {
            case 2:
                Binary b = new Binary(s);
                h = new Hexadecimal(b.convertToBase16());
                break;
            case 8:
                Octal o = new Octal(s);
                h = new Hexadecimal(o.convertToBase16());
                break;
            case 10:
                Decimal d = new Decimal(s);
                h = new Hexadecimal(String.valueOf(d.convertToBase16()));
                break;
            case 16:
                h = new Hexadecimal(s);
                break;
        }
        return h;
    }

    private Octal convertToOctal(int startBase, String s) {
        Octal o = null;
        switch (startBase) {
            case 2:
                Binary b = new Binary(s);
                o = new Octal(b.convertToBase8());
                break;
            case 8:
                o = new Octal(s);
                break;
            case 10:
                Decimal d = new Decimal(s);
                o = new Octal(d.convertToBase8());
                break;
            case 16:
                Hexadecimal h = new Hexadecimal(s);
                o = new Octal(h.convertToBase8());
                break;
        }
        return o;
    }
}
