package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        System.out.println("1. Сложить две матрицы. \n");
        System.out.println("2. Вычесть из одной матрицы другую. \n");
        System.out.println("3. Умножить две матрицы. \n");
        System.out.println("4. Умножить матрицу A на число. \n");
        System.out.println("5. Транспонирование матрицы. \n");
        System.out.println("6. Матрица на вектор.\n");
        System.out.println("7. Возведение матрицы A в степень.\n");
        System.out.println("8. Обратная матрица A.\n");

        int choice;

        Matrix A = new Matrix(3,3);
        A.Init();
        A.Display();

        Matrix B = new Matrix(3,3);
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
                    C = A.Subtraction(B);
                    C.Display();
                    break;
                case 3:
                    System.out.println("");
                    System.out.println("Умножение матриц. \n");
                    C = A.Multiplication(B);
                    C.Display();
                    break;
                case 4:
                    System.out.println("");
                    System.out.println("Умножение матрицы A на число. \n");
                    System.out.println("Введите число:");
                    int number = in.nextInt();
                    C = A.Multiplication(number);
                    C.Display();
                    break;
                case 5:
                    System.out.println("");
                    System.out.println(" Транспонирование матрицы A. \n");
                    C = A.Transposition();
                    C.Display();
                    System.out.println(" Транспонирование матрицы B. \n");
                    C = B.Transposition();
                    C.Display();
                    break;
                case 6:
                    Matrix Vector = new Matrix(2,1);
                    Vector.Init();
                    System.out.println("");
                    System.out.println("Вектор: ");
                    Vector.Display();
                    System.out.println("");
                    System.out.println("Умножение матрицы A на вектор. \n");
                    C = A.Multiplication(Vector);
                    C.Display();
                    break;
                case 7:
                    System.out.println("");
                    System.out.println("Умножение матрицы A на число. \n");
                    System.out.println("Введите степень:");
                    int pow = in.nextInt();
                    Matrix D = new Matrix(2,2);
                    for (int i=0; i<pow; i++){
                        D = A.Multiplication(pow);
                    }
                    D.Display();
                    break;
                case 8:
                    System.out.println("");
                    System.out.println("Нахождение обратной матрицы для матрицы A. \n");
                    C = A.Inverse();
                    C.Display();
                    break;
                default:
                    System.exit(0);
                    break;
            }

        }while (choice > 0 && choice < 9);
    }
}
