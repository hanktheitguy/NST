package org.karpinen.nst.number.core;

import java.util.Arrays;
import java.util.List;

public enum Base
{
    BASE2  (Arrays.asList('0','1'),
            Arrays.asList("Binary", "bin"),
            2 ),

    BASE8  (Arrays.asList('0','1','2','3','4','5','6','7'),
            Arrays.asList("Octal", "oct"),
            8 ),

    BASE10 (Arrays.asList('0','1','2','3','4','5','6','7','8','9'),
            Arrays.asList("Decimal", "dec"),
            10 ),

    BASE16 (Arrays.asList('0','1','2','3','4','5','6','7','8','9',
            'A', 'B','C','D','E','F'),
            Arrays.asList("Hexadecimal", "hex"),
            16 );

    private List<Character> chars;
    private List<String>    aliases;
    private int             baseID;

    private Base (List<Character> newChar, List<String> newAlias,  int ID)
    {
        chars = newChar;
        baseID = ID;
        aliases = newAlias;
    }

    //Retrieval of allowed characters by numeral base.
    public List<Character> getChars()
    {
        return chars;
    }

    public List<String> getAliases()
    {
        return aliases;
    }

    public int getBaseID()
    {
        return baseID;
    }
}
