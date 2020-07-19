package org.karpinen.number.util;

public class BinaryUtil {

    public BinaryUtil() { }

    //Retrieve a substring by size and length. This is for @inputString that's inherited.
    private String getSubstringBySize(int groupSize, int endpoint, String s) {
        return s.substring(endpoint - groupSize, endpoint);
    }

    //Returns hexadecimal equivalents based on integer value.
    private Character getHexadecimalEquivalent(int i) {
        char c = '\u0020';
        switch (i) {
            case 10: c = 'A'; break;
            case 11: c = 'B'; break;
            case 12: c = 'C'; break;
            case 13: c = 'D'; break;
            case 14: c = 'E'; break;
            case 15: c = 'F'; break;
        }
        return c;
    }

    //Can convert groups of bit's into decimal and append them to a string. Works for Hex.
    public String convertByBitGroups(int groupSize, String s) {
        StringBuilder sb = new StringBuilder();
        int iterations = s.length() / groupSize;
        int endpoint = s.length();

        for(int i = 0; i < iterations; i++) {
            String substring = getSubstringBySize(groupSize, endpoint, s);
            int conversion = base10(substring);
            if(conversion > 9 && conversion < 16)  {
                sb.append(getHexadecimalEquivalent(conversion));
            }else{
                sb.append(conversion);
            }
            endpoint -= groupSize;
        }
        return concatRemaining(endpoint, groupSize, sb, s).reverse().toString();
    }

    private StringBuilder concatRemaining(int endpoint, int groupSize, StringBuilder s, String input) {
        boolean hasRemainder = input.length() % groupSize > 0;
        if(hasRemainder) {
            String remainder = input.substring(endpoint - (input.length() % groupSize), endpoint);
            s.append(base10(remainder));
        }
        return s;
    }

    public int base10(String s) {
        char[] binary = new StringBuilder(s).reverse().toString().toCharArray();
        int iteration = 0;
        int sum = 0;
        for(char c: binary) {
            if(c == '1') { sum += Math.pow(2, iteration); }
            iteration++;
        }
        return sum;
    }
}
