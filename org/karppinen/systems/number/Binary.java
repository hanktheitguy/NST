package org.karppinen.systems.number;

import javax.sound.midi.SysexMessage;
import java.util.Arrays;

public class Binary extends Number {

    //Uses Superclass Constructor.
    public Binary(String x) {
        super(x, Arrays.asList('0', '1'), 64);
    }

    //Converts binary numbers into decimal numbers.
    public String convertToDecimal(String z) {
        int convert = 0;

        /*
       -  The following method works in a decrementing fashion starting at the length of the string
        which in turn evaluates the string right to left.
       - the f() z.length - x returns the amount of times the number needs to multiply by 2 to reach
       the value of it's bitwise position. The convert variable is added to the temp variable once
       the function finishes looping.
         */

        for(int x = z.length(); x>= 1; x--) {
            if(z.charAt(x - 1) == '1') {
                int temp = 1;
                for(int y = 0; y < z.length() - x; y++) {
                    temp *= 2;
                }
                //Sets the convert variable to itself + the temporary variable value.
                convert += temp;
            }
        }
        return String.valueOf(convert);
    }

    //Converts numbers into Hexidecimal
    public String convertToHexadecimal() {
        StringBuilder convert = new StringBuilder();

        //This is used as the endpoint of the subset.
        int point = getLength();

        /*For loop divides the length of the string by 4 to get octets which tell us how
        many times we need to iterate the string in octets.
         */
        for(int x=1; x <= getLength() / 4; x++) {

            //This is the current octet being evaluated.
            String substring = getString().substring(point - 4, point);

            //Parse the integer to be used in a switch
            int decimal = Integer.parseInt(convertToDecimal(substring));


           //This switch is used to append the string when A-F is used in the string itself.
            if(decimal > 9) {
                switch (decimal) {
                    case 10:
                        convert.append("A");
                        break;
                    case 11:
                        convert.append("B");
                        break;
                    case 12:
                        convert.append("C");
                        break;
                    case 13:
                        convert.append("D");
                        break;
                    case 14:
                        convert.append("E");
                        break;
                    case 15:
                        convert.append("F");
                        break;
                }
            }else{
                convert.append(convertToDecimal(substring));
            }
            //Increments the point variable by 4 to reach the next subset.
            point -= 4;
        }

        /*
        This remainder variable is used in situations when the remainder of getLength() / 4 doesn't
        divide perfectly and uses a remainder. In this case we use the remainder to calculate where
        the remainder of the string we haven't evaluated is.
         */
        int remainder = getLength() - (getLength() - point);

        //Checks if the remainder is > 0. From here we get a substring of the remaining characters.
        if(remainder > 0) {
            String substring = getString().substring(point - remainder, point);

            //We append the value of the remaining characters here.
            convert.append(convertToDecimal(substring));
        }

        //Flips the string because it's backwards due to right to left string evaluation.
        convert = new StringBuilder(new StringBuilder(convert.toString()).reverse().toString());
        return convert.toString();
    }

    //Converts the number into Octal Format.
    public String convertToOctal() {
        StringBuilder convert = new StringBuilder();
        int point = getLength();

        for(int x=1; x <= getLength() / 3; x++) {

            //This is the current octal section being evaluated.
            String substring = getString().substring(point - 3, point);
            convert.append(convertToDecimal(substring));
            point -= 3;
        }

        int remainder = getLength() - (getLength() - point);

        //Checks if the remainder is > 0. From here we get a substring of the remaining characters.
        if(remainder > 0) {
            String substring = getString().substring(point - remainder, point);

            //We append the value of the remaining characters here.
            convert.append(convertToDecimal(substring));
        }

        convert = new StringBuilder(new StringBuilder(convert.toString()).reverse().toString());
        return convert.toString();
    }
}
