package org.karpinen.nst.number.core;

public class Number
{
    private Base       base;
    private String     input;
    private int        lenLimit = 128;
    private boolean    usable = true;
    private char[]     chars;

    public Number (String input, int baseID)
    {
        create (input, baseID);
    }

    private void create (String input, int ID)
    {
        setInput  (input);
        setBaseType (ID);
        validate();
    }

    private boolean obeyLengthLimit ()
    {
        return input.length() < lenLimit;
    }

    private boolean obeyCharRule (String s)
    {
        for ( char c : chars ) {
            if (!base.getChars().contains(c))
            {
                return false;
            }
        }
        return true;
    }

    private void validate ()
    {
        if (!obeyLengthLimit())
        {
            usable = false;
        }
        if (!obeyCharRule(input))
        {
            usable = false;
        }
    }

    public String getInput ()
    {
        return input;
    }

    public Base getBase ()
    {
        return base;
    }

    public boolean isUsable ()
    {
        return usable;
    }

    private void setBaseType ( int baseID )
    {
        switch (baseID) {
            case 2:  base = Base.BASE2;  break;
            case 8:  base = Base.BASE8;  break;
            case 10: base = Base.BASE10; break;
            case 16: base = Base.BASE16; break;
        }
    }

    public void setUsable (boolean b)
    {
        usable = b;
    }

    public void setInput (String s)
    {
        input = s;
        chars = s.toCharArray();
    }

    public void setLengthLimit (int limit)
    {
        lenLimit = limit;
        validate();
    }

    public void update (String input, int baseID)
    {
        create (input, baseID);
    }
}
