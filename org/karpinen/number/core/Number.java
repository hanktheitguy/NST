package org.karpinen.number.core;

public class Number {
    private NumberBase base;
    private String input;
    private NumberValidator validator;

    //Constructor method for Number.
    public Number(String input, int baseIdentifier) {
        init(input, baseIdentifier);
    }

    //Sets the variable values, then validates the number off constraints.
    private void init(String input, int baseIdentifier) {
        setVariableValue(input, baseIdentifier);
        startValidation();
    }

    //Sets the class variables to their appropiate values.
    private void setVariableValue(String input, int baseIdentifier) {
        setBase(baseIdentifier);
        setInput(input);
    }

    //Sets @base value to the proper NumberBase enum value.
    private void setBase(int baseIdentifier) {
        switch (baseIdentifier) {
            case 2: base = NumberBase.Binary; break;
            case 8: base = NumberBase.Octal; break;
            case 10: base = NumberBase.Decimal; break;
            case 16: base = NumberBase.Hexadecimal; break;
        }
    }

    //Set's the input variable value.
    private void setInput(String s) {
        this.input = s;
    }

    //Instantiates @NumberValidator which is used to validate the number.
    private void startValidation() {
        validator = new NumberValidator(input, base);
    }

    //Returns whether the number is valid based off constraints.
    public boolean isValid() {
        return validator.isValid();
    }

    //Returns the original input string value.
    public String getInput() {
        return input;
    }
}
