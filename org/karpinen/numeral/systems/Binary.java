package org.karpinen.numeral.systems;

import org.karpinen.numeral.core.Number;
import org.karpinen.numeral.utils.BaseConvert;

import java.util.Arrays;

/*
This class is used as a middle ground between almost all the other number systems in terms of conversion. 
 */
public class Binary extends Number implements BaseConvert {

    //Constructor.
    public Binary(String input)  {
        super(input, 2, Arrays.asList('0', '1'));
    }

    //Method Overloading.
    public int convertToBase10() {
        return convertToBase10(getInputString());
    }

    @Override
    //Converts binary to decimal by long division of 2.
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
    //Returns the input as it's already Base2
    public String convertToBase2() {
        return getInputString();
    }

    @Override
    //Converts Binary to Octal
    public String convertToBase8() {
        return convertByBitGroups(3);
    }

    @Override
    //Converts Binary to Hexadecimal.
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

    //Retrieve a substring by size and length. This is for @inputString that's inherited.
    private String getSubstringBySize(int size, int length) {
        return getInputString().substring(length - size, length);
    }

    /*
    In the following method we start at the beginning of the string. To calculate the startpoint of the substring
    we use the (f) length - size. We then decrement length by the specified grouping size. This results in being
    able to get size specific substrings of the string itself.
     */
    private String convertByBitGroups(int size) {
        StringBuilder sb = new StringBuilder();
        //@Iterations refers to how many groupings of the specified size we can fit into the original string.
        int iterations = getInputString().length() / size;
        //@length becomes decremented as the string is broken into smaller substrings by the specified size.
        int length = getInputString().length();
        for(int i = 0; i < iterations; i++) {
            String substring = getSubstringBySize(size, length);
            int currentConversion = convertToBase10(substring);

            //This following method checks to see if the substring decimal value is in the range of Hex.
            if(currentConversion > 9 && currentConversion < 16)  {
                sb.append(getHexadecimalEquivalent(currentConversion));
            }else{
                sb.append(currentConversion);
            }
            //Decrement (f) length - size.
            length -= size;
        }
        //Looks for any remaining bits. If it finds any, it will convert it to decimal and append it to the output.
        boolean hasRemainder = getInputString().length() % size > 0;
        if(hasRemainder) {
            String remainder = getInputString().substring(length - (getInputString().length() % size), length);
            sb.append(convertToBase10(remainder));
        }
        return sb.reverse().toString();
    }
}
