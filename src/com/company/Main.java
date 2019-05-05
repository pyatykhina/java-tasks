package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args)
    {
        Decimal dec = new Decimal();
        Binary bin = new Binary();

        while (true)
        {
            System.out.println("------------------------------------");
            System.out.print("Введите 10 для выбора десятичной системы счисления или 2 для двоичной: ");
            Scanner in = new Scanner(System.in);
            int OperationType = in.nextInt();

            if (OperationType == 10)
            {
                dec.Read();
                dec.Display();
            } else if (OperationType == 2)
            {
                bin.Read();
                bin.Display();
            } else
            {
                System.out.println("Некорректный ввод. Попробуйте еще раз. ");
            }
        }
    }
}
