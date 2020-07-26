package org.karpinen.nst.number.util;

public class BinUtil
{
    public BinUtil () {}

    public String convert (String input, int baseID) {
        String c = null;
        switch (baseID)
        {
            case 2:  c = input;                                   break;
            case 8:  c = convertByBitGroups(3, input); break;
            case 10: c = String.valueOf(base10(input));           break;
            case 16: c = convertByBitGroups(4, input); break;
        }
        return c;
    }

    private String getSubstringBySize (int groupSize, int endpoint, String input)
    {
        return input.substring (endpoint - groupSize, endpoint);
    }

    private Character getHexadecimalEquivalent (int i)
    {
        char c = '\u0020';
        switch (i)
        {
            case 10: c = 'A'; break;
            case 11: c = 'B'; break;
            case 12: c = 'C'; break;
            case 13: c = 'D'; break;
            case 14: c = 'E'; break;
            case 15: c = 'F'; break;
        }
        return c;
    }

    private String convertByBitGroups (int groupSize, String input)
    {
        StringBuilder sb = new StringBuilder();
        int iterations = input.length() / groupSize;
        int endpoint = input.length();

        for(int i = 0; i < iterations; i++)
        {
            String substring = getSubstringBySize (groupSize, endpoint, input);
            int conversion = base10 (substring);
            if (conversion > 9 && conversion < 16)
            {
                sb.append (getHexadecimalEquivalent(conversion));
            }
            else
                {
                sb.append (conversion);
                }
            endpoint -= groupSize;
        }
        return concatRemaining (endpoint, groupSize, sb, input).reverse().toString();
    }

    private StringBuilder concatRemaining (int endpoint, int groupSize, StringBuilder sb, String input)
    {
        boolean hasRemainder = input.length() % groupSize > 0;
        if (hasRemainder)
        {
            String remainder = input.substring (endpoint - (input.length() % groupSize), endpoint);
            sb.append (base10(remainder));
        }
        return sb;
    }

    private int base10 (String s)
    {
        char[] chars = new StringBuilder(s).reverse().toString().toCharArray();
        int iteration = 0;
        int sum = 0;
        for (char c: chars)
        {
            if (c == '1')
            {
                sum += Math.pow (2, iteration);
            }
            iteration++;
        }
        return sum;
    }
}
