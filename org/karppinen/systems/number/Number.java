package org.karppinen.systems.number;

import java.util.List;

@SuppressWarnings("rawtypes")
public class Number {

    private Object obj;
    private String str;
    private int len;
    private int limit;
    private List charConstraint;

    public Number(Object object, List constraints, int limit) {
        if(object != null && constraints != null && limit > 0) {
            setObject(object);
            setAllowChar(constraints);
            setLimit(limit);
            init();
        }
    }

    /*
    Used to initiate the class itself and it's variables. During this process we check the input
    against it's constraints and limits, if it has any.
     */
    public void init() {
        if(hasConformity(obj)) {
            this.str = obj.toString();
            this.len = obj.toString().length();
        }
    }

    //Checks if the input obeys constraints and limits.
    private boolean hasConformity(Object o) {
        if(obeyCharRule(o.toString())) {
            return obeyLimit(o.toString().length());
        }
        return false;
    }

    /*
    Method loops through each character and checks if it's a character in the allowed
    character list. If not, it outputs an error.
     */
    private boolean obeyCharRule(String s) {
        if(charConstraint != null) {
            for(int x = 0; x < s.length(); x++) {
                if(!charConstraint.contains(s.charAt(x))) {
                    System.out.println("ERROR: CharConstraints not met > " + s.charAt(x));
                    return false;
                }
            }
        }
        return true;
    }

    //Check's if the input is within it's length bounds.
    private boolean obeyLimit(int x) {
        if(!(limit == 0)) {
            return x <= limit;
        }
        return true;
    }

    public String getString() {
        return this.str;
    }

    public int getLength() {
        return this.len;
    }

    private void setObject(Object o) {
        this.obj = o;
    }

    public void setAllowChar(List l) {
        if(l != null) {
            this.charConstraint = l;
        }
    }

    public void setLimit(int x) {
        this.limit = x;
    }

    //Used for debugging purposes.
    @Deprecated
    public void printMetaData() {
        System.out.println("+--------------------------+");
        System.out.println("String: " + str);
        System.out.println("StrLen:" + len);
        System.out.println("StrLimit: " + limit);
        System.out.println("CharConstraints: " + charConstraint.toString());
        System.out.println("+--------------------------+");
    }
}
