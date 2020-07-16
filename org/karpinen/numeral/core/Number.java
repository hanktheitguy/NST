package org.karpinen.numeral.core;

import java.util.List;

public class Number {
    private String inputString;
    private int baseID;
    private int lenLimit = 64; //Default string length limit for @param.
    private List<Character> charConstraint;
    private boolean valid = true;

    public Number(String input, int baseID, List<Character> list) {
        if(input != null && baseID > 0 && list != null) {
            initiate(input, baseID, list);
        }
    }

    private void initiate(String input, int baseID, List<Character> list) {
        setVariable(input, baseID, list);
        checkConformity();
    }

    private void setVariable(String input, int baseID, List<Character> list) {
        this.inputString = input;
        this.baseID = baseID;
        setCharConstraint(list);
    }

    private void checkConformity() {
        if(!obeyLengthLimit()) { valid = false; }
        if(!obeyCharConstraint()) { valid = false; }
    }

    private boolean obeyLengthLimit() {
        return inputString.length() <= lenLimit;
    }

    private boolean obeyCharConstraint()  {
        char[] input = inputString.toCharArray();
        for(char c: input) {
            if(!charConstraint.contains(c)) {
                return false;
            }
        }
        return true;
    }

    public boolean isValid() {
        return this.valid;
    }

    public String getInputString() {
        return this.inputString;
    }

    public int getBaseID() { return this.baseID; }

    public int getLenLimit() { return this.getLenLimit(); }

    public List<Character> getCharConstraint() { return charConstraint; }

    public void setLenLimit(int i) {
        this.lenLimit = i;
    }

    public void setCharConstraint(List<Character> list) {
        if(list != null) {
            this.charConstraint = list;
        }
    }
}
