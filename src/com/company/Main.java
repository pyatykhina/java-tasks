package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        System.out.println("1. Сложить две матрицы. \n");
        System.out.println("3. Вычесть из одной матрицы другую. \n");
        System.out.println("3. Умножить две матрицы. \n");
        System.out.println("4. Умножить матрицу A на число. \n");
        System.out.println("5. Транспонирование матрицы. \n");

        // TODO: Выбор размерности


        int choice=1;

        Matrix A = new Matrix(5,5);
        A.Init();
        A.Display();

        Matrix B = new Matrix(5,5);
        B.Init();
        B.Display();

        do
        {
            Scanner in = new Scanner(System.in);
            System.out.println("Введите пункт меню.");
            choice = in.nextInt();

            switch (choice)
            {
                case 1:
                    System.out.println("");
                    System.out.println("Сложение матриц. \n");
                    Matrix C = A.Sum(B);
                    C.Display();
                    break;
                case 2:
                    System.out.println("");
                    System.out.println("Вычитание из A матрицы B. \n");
                    Matrix S = A.Subtraction(B);
                    S.Display();
                    break;
                case 3:
                    System.out.println("");
                    System.out.println("Умножение матриц. \n");
                    Matrix D = A.Multiplication(B);
                    D.Display();
                    break;
                case 4:
                    System.out.println("");
                    System.out.println("Умножение матрицы A на число. \n");
                    System.out.println("Введите число:");
                    int number = in.nextInt();
                    Matrix O = A.Multiplication(number);
                    O.Display();
                    break;
                case 5:
                    System.out.println("");
                    System.out.println(" Транспонирование матрицы A. \n");
                    Matrix E = A.Transposition();
                    E.Display();
                    System.out.println(" Транспонирование матрицы B. \n");
                    Matrix J = B.Transposition();
                    J.Display();
                    break;
                default:
                    System.exit(0);
                    break;
            }

        }while (choice > 0 && choice < 6);
    }
}
