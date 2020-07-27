package org.karpinen.nst.number.calc.operation;

public class Operation
{
    public Operation() {}

    public int add(int num1, int num2)
    {
        return num1 + num2;
    }

    public int sub(int num1, int num2)
    {
        return num1 - num2;
    }

    public int mul(int num1, int num2)
    {
        return num1 * num2;
    }

    public int div(int num1, int num2)
    {
        return num1 / num2;
    }

    public int mod(int num1, int num2)
    {
        return num1 % num2;
    }

    public double exp(double num, double exp)
    {
        return Math.pow(num, exp);
    }

    public void par()
    {

    }
}
