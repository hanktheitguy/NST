package org.karpinen.nst.number.util;

public class OctUtil
{
    private BinUtil binUtil;

    public OctUtil()
    {
        binUtil = new BinUtil();
    }

    public String convert (String s, int id)
    {
        String c = null;
        String base2 = base2 (s);
        switch (id)
        {
            case 2:  c = base2;                               break;
            case 8:  c = s;                                   break;
            case 10: c = binUtil.convert (base2, 10); break;
            case 16: c = binUtil.convert (base2, 16); break;
        }
        return c;
    }

    private String base2 (String s)
    {
        StringBuilder oct = new StringBuilder();
        for (char c : s.toCharArray())
        {
            switch (c)
            {
                case '0': break;
                case '1': oct.append ("001"); break;
                case '2': oct.append ("10");  break;
                case '3': oct.append ("11");  break;
                case '4': oct.append ("100"); break;
                case '5': oct.append ("101"); break;
                case '6': oct.append ("110"); break;
                case '7': oct.append ("111"); break;
            }
        }
        return oct.toString();
    }
}
