package org.karpinen.nst.number.util;

public class DecUtil
{
    private BinUtil util;

    public DecUtil()
    {
        util = new BinUtil();
    }

    public String convert (String input, int baseID)
    {
        String c = null;
        String base2 = base2 (input);
        switch (baseID)
        {
            case 2:  c = base2;                         break;
            case 8:  c = util.convert (base2, 8);  break;
            case 10: c = input;                         break;
            case 16: c = util.convert (base2, 16); break;
        }
        return c;
    }

    private String base2 (String input)
    {
        StringBuilder base2 = new StringBuilder();
        int dividend = Integer.parseInt (input);
        while (dividend > 0)
        {
            base2.append (dividend % 2);
            System.out.println("Debug-Base2: " + base2);
            dividend /= 2;
            System.out.println("Debug-Dividend: " + dividend);
        }
        return base2.reverse().toString();
    }
}
