package org.karpinen.number.core;

import java.util.List;

public class NumberValidator {
    private boolean valid;

    //Constructor for @NumberValidator
    public NumberValidator(String input, NumberBase base) {
        valid = hasConformity(input, base);
    }

    //Method checks to see if the String @input meets the constraints set by @base
    private boolean hasConformity(String input, NumberBase base) {

        //Statement resolving if the String length limit is met
        if(!obeyLengthLimit(input, base.getLengthLimit())) {
            return false;
        }

        //If the limit is met, we return a boolean representing obeyCharConstraint.
        return obeyCharConstraint(input, base.getCharRule());
    }

    //Validates string meeting character constraints.
    private boolean obeyCharConstraint(String s, List<Character> charConstraint) {
        //Convert input string into a iterable char array.
        char[] c = s.toCharArray();

        //Loop through the character array
        for(char c2 : c) {

            //Validates whether the current character in array is a part of the @charConstraint list
            if(!charConstraint.contains(c2)) {

                //If it isn't, we return false.
                return false;
            }
        }
        return true;
    }

    //Validates the length limit constraint on @input
    private boolean obeyLengthLimit(String s, int limit) {
        return s.length() <= limit;
    }

    //Returns whether the number met all constraints.
    public boolean isValid() {
        return valid;
    }
}
