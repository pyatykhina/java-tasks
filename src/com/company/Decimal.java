package com.company;
import java.util.*;

public class Decimal extends Integer
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
        System.out.println("Первое число в десятичной СЧ: " + a);
        System.out.println("Второе число в десятичной СЧ: " + b);
        System.out.println("Сумма двух чисел в десятичной СЧ: " + Sum(a, b));
        System.out.println("Разность двух чисел в десятичной СЧ: " + Dif(a, b));
        System.out.println("Произведение двух чисел в десятичной СЧ: " + Mul(a, b));
        System.out.println("Кратное двух чисел в десятичной СЧ: " + Div(a, b));
        System.out.println();
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
