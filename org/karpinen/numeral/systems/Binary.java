package org.karpinen.numeral.systems;

import org.karpinen.numeral.core.Number;
import org.karpinen.numeral.utils.BaseConvert;

import java.util.Arrays;

public class Binary extends Number implements BaseConvert {

    public Binary(String input)  {
        super(input, 2, Arrays.asList('0', '1'));
    }

    public int convertToBase10() {
        return convertToBase10(getInputString());
    }

    @Override
    public int convertToBase10(String s) {
        char[] binary = new StringBuilder(s).reverse().toString().toCharArray();
        int iteration = 0;
        int sum = 0;
        for(char c: binary) {
            if(c == '1') { sum += Math.pow(2, iteration); }
            iteration++;
        }
        return sum;
    }

    @Override
    public String convertToBase2() {
        return getInputString();
    }

    @Override
    public String convertToBase8() {
        return convertByBitGroups(3);
    }

    @Override
    public String convertToBase16() {
        return convertByBitGroups(4);
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

    //Reusable method to grab a substring based on a specified size.
    private String getSubstringBySize(int size, int length) {
        return getInputString().substring(length - size, length);
    }

    /*
    This method has the capability to recognize when a number needs a hexadecimal digit, it will add it as so.
    This method takes a substring of a specified size, converts it to decimal, and appends it to the
    StringBuilder. The reason for decrementing is we start at the end of the string.
     */
    private String convertByBitGroups(int size) {
        StringBuilder sb = new StringBuilder();
        //This specifies how many times we can evenly substring a string into a certain size.
        int iterations = getInputString().length() / size;
        //This length variable becomes decremented as the string is continually broken into smaller substrings.
        int length = getInputString().length();
        for(int i = 0; i < iterations; i++) {
            //Current substring.
            String substring = getSubstringBySize(size, length);
            //Current decimal value of substring.
            int currentConversion = convertToBase10(substring);
            //Hexadecimal check on substring.
            if(currentConversion > 9 && currentConversion < 16)  {
                sb.append(getHexadecimalEquivalent(currentConversion));
            }else{
                //In this case currentConversion < 9
                sb.append(currentConversion);
            }
            //Decrement to next substring starting point.
            length -= size;
        }
        boolean hasRemainder = getInputString().length() % size > 0;
        //Looks for any remaining bits. If it finds any, it will convert it to decimal and append it.
        if(hasRemainder) {
            String remainder = getInputString().substring(length - (getInputString().length() % size), length);
            sb.append(convertToBase10(remainder));
        }
        return sb.reverse().toString();
    }
}
