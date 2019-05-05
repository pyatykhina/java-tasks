package com.company;
import java.util.*;

public class Binary extends Integer
{
    @Override
    public void Read()
    {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите первое число: ");
        a = in.nextDouble();

        System.out.println("Введите второе число: ");
        b = in.nextDouble();
    }

    @Override
    public void Display()
    {
        System.out.println("Первое число в двоичной СЧ: " + ToBinary(a));
        System.out.println("Второе число в двоичной СЧ: " + ToBinary(b));
        System.out.println("Сумма двух чисел в двоичной СЧ: " + ToBinary(Sum(a, b)));
        System.out.println("Разность двух чисел в двоичной СЧ: " + ToBinary(Dif(a, b)));
        System.out.println("Произведение двух чисел в двоичной СЧ: " + ToBinary(Mul(a, b)));
        System.out.println("Кратное двух чисел в двоичной СЧ: " + ToBinary(Div(a, b)));
        System.out.println();
    }

    private String ToBinary(double number)
    {
        long decNumber = (long) number;
        return Long.toBinaryString(decNumber);
    }

    @Override
    public double Sum(double a, double b) { return a + b; }

    @Override
    public double Dif(double a, double b) { return a - b; }

    @Override
    public double Mul(double a, double b) { return a * b; }

    @Override
    public double Div(double a, double b) { return a / b; }
}
