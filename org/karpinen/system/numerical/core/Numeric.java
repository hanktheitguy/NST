package org.karpinen.system.numerical.core;

import java.util.List;

public class Numeric {
    private Object input;
    private String IS;
    private int base;
    private int len;
    private int limit;
    private List<Character>CR;
    private boolean valid = false;

    public interface BaseConversion {
        int toDecimal();
        String toOctal();
        String toBinary();
        String toHexadecimal();
    }

    public Numeric(Object object) {
        if(object != null) {
            this.input = object;
            init();
        }
    }

    private void init() {
        setVariable();
        if(hasConformity()) {
            valid = true;
        }
    }

    private void setVariable() {
        setLength();
        setInputString();
    }

    private boolean hasConformity() {
        if(obeyStringLimit()) {
            return obeyCharRule();
        }
        return false;
    }

    private boolean obeyCharRule() {
        if(CR != null) {
            for (char c: getInputString().toCharArray()) {
                if(!(CR.contains(c))) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean obeyStringLimit() {
        if(limit > 0) {
            return len <= limit;
        }
        return true;
    }

    public int getLength() {
        return len;
    }

    public Object getInput() {
        return this.input;
    }

    public String getInputString() {
        return this.IS;
    }

    public List getCharacterRestraint() {
        return this.CR;
    }

    public void setBase(int x) {
        base = x;
    }

    private void setInputString() {
        IS = input.toString();
    }

    private void setLength() {
        len = input.toString().length();
    }

    public void setLimit(int x) {
        limit = x;
    }

    public void setCharacterConstraint(List<Character> list) {
        if(list != null) {
            this.CR = list;
        }
    }
}
