package com.company;
import java.util.*;

public abstract class Integer
{
    public double a;
    public double b;

    public abstract void Display();
    public abstract void Read();

    public abstract double Sum(double a, double b);  // сумма
    public abstract double Dif(double a, double b);  // разность
    public abstract double Mul(double a, double b);  // умножение
    public abstract double Div(double a, double b);  // деление
}
