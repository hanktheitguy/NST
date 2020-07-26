package org.karpinen.nst.number.util;

public class HexUtil
{
    private BinUtil binUtil;

    public HexUtil()
    {
        binUtil = new BinUtil();
    }

    public String convert (String s, int id)
    {
        String c = null;
        String base2 = base2 (s);
        switch (id)
        {
            case 2:  c = base2;                             break;
            case 8:  c = binUtil.convert(base2, 8);    break;
            case 10: c = binUtil.convert(base2, 10);   break;
            case 16: c = s;                                 break;
        }
        return c;
    }

    private String base2 (String s)
    {
        StringBuilder bin = new StringBuilder();
        for (char c : s.toCharArray())
        {
            switch (c)
            {
                case '0': bin.append ("0000"); break;
                case '1': bin.append ("0001"); break;
                case '2': bin.append ("0010"); break;
                case '3': bin.append ("0011"); break;
                case '4': bin.append ("0100"); break;
                case '5': bin.append ("0101"); break;
                case '6': bin.append ("0110"); break;
                case '7': bin.append ("0111"); break;
                case '8': bin.append ("1000"); break;
                case '9': bin.append ("1001"); break;
                case 'A': bin.append ("1010"); break;
                case 'B': bin.append ("1011"); break;
                case 'C': bin.append ("1100"); break;
                case 'D': bin.append ("1101"); break;
                case 'E': bin.append ("1110"); break;
                case 'F': bin.append ("1111"); break;
            }
        }
        return bin.toString();
    }

}
