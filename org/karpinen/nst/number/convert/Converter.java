package org.karpinen.nst.number.convert;

import org.karpinen.nst.number.core.Base;
import org.karpinen.nst.number.core.Number;
import org.karpinen.nst.number.util.BinUtil;
import org.karpinen.nst.number.util.DecUtil;
import org.karpinen.nst.number.util.HexUtil;
import org.karpinen.nst.number.util.OctUtil;

public class Converter
{
    private final BinUtil binUtil;
    private final DecUtil decUtil;
    private final HexUtil hexUtil;
    private final OctUtil octUtil;
    private Number        number;

    public Converter()
    {
        binUtil = new BinUtil();
        decUtil = new DecUtil();
        hexUtil = new HexUtil();
        octUtil = new OctUtil();
    }
    public String convert (String s, int beginID, int endID)
    {
        String c = null;
        if (isValidNumber(s, beginID))
        {
            c = doConversion (s, beginID, endID);
        }
        return c;
    }

    private String doConversion (String s, int beginID, int endID)
    {
        String c = null;
        switch (beginID)
        {
            case 2:  c = binUtil.convert (s, endID); break;
            case 8:  c = octUtil.convert (s, endID); break;
            case 10: c = decUtil.convert (s, endID); break;
            case 16: c = hexUtil.convert (s, endID); break;
        }
        return c;
    }

    private boolean isValidNumber (String s, int id)
    {
        if (number != null)
        {
            number.update (s, id);
        }
        number = new Number (s, id);
        return number.isUsable();
    }

    public int resolveBaseID (Object object)
    {
        int id = 0;
        if        (Base.BASE2.getChars().contains(object)
                || Base.BASE2.getAliases().contains(object))
        {
            id = 2;
        } else if (Base.BASE8.getChars().contains(object)
                || Base.BASE8.getAliases().contains(object))
        {
            id = 8;
        } else if (Base.BASE10.getChars().contains(object)
                || Base.BASE10.getAliases().contains(object))
        {
            id = 10;
        } else if (Base.BASE16.getChars().contains(object)
                || Base.BASE16.getAliases().contains(object))
        {
            id = 16;
        }
        return id;
    }
}
