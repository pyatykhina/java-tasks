package com.company;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Класс для работы с двумя матрицами.
 */
public class Matrix
{
    public double[][] Matrix;
    int rows, columns;

    /**
     * Выделение памяти под матрицу.
     * @param rows
     * @param columns
     */
    Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        Matrix = new double[rows][columns];
    }

    /**
     * Инициализация матрицы.
     * @return
     */
    public Matrix Init()
    {
        for (int r = 0; r < this.RowLength(); r++)
            for (int c = 0; c < this.ColumnLength(); c++)
            {
                this.SetValue(r, c, ThreadLocalRandom.current().nextInt(10,100));

            }
        return this;
    }

    /**
     * Количество элементов в строке.
     * @return
     */
    public int RowLength()
    {
        return rows;
    }

    /**
     * Количество элементов в столбце.
     * @return
     */
    public int ColumnLength()
    {
        return columns;
    }

    /**
     * Получить значение элемента матрицы по индексу {i,j}
     * @param i
     * @param j
     * @return
     */
    public double GetValue(int i, int j)
    {
        return Matrix[i][j];
    }

    /**
     * Записать значение в элемент матрицы по индексу {i,j}
     * @param i
     * @param j
     * @param value
     */
    public void SetValue(int i, int j, double value)
    {
        Matrix[i][j] = value;
    }

    /**
     * Отображение матриц.
     */
    public void Display()
    {
        System.out.println("--------");
        for (int i = 0; i < this.RowLength(); i++){
            for(int j=0; j < this.ColumnLength(); j++){
                System.out.print((this.GetValue(i, j)) + " ");
            }
            System.out.println();
        }
        System.out.println("--------");
    }

    /**
     * Сумма матриц A и B.
     * @param B
     * @return
     */
    public Matrix Sum(Matrix B)
    {
        int row = RowLength();
        int col = ColumnLength();
        Matrix result = new Matrix(row, col);


        if(this.RowLength() == B.RowLength() && this.ColumnLength() == B.ColumnLength() )
        {
            for (int i = 0; i < row; i++){
                for(int j=0; j < col; j++){
                    result.SetValue(i, j, this.GetValue(i,j) + B.GetValue(i,j));
                }
            }
            return result;
        }
        else
        {
            System.out.print("Нельзя сложить две матрицы с разной размерностью.");
            return null;
        }
    }

    /**
     * Разность матриц A-B.
     * @param B Матрица B.
     * @return Результирующая матрица.
     */
    public Matrix Subtraction(Matrix B)
    {

        int row = RowLength();
        int col = ColumnLength();
        Matrix result = new Matrix(row, col);


        if(this.RowLength() == B.RowLength() && this.ColumnLength() == B.ColumnLength() )
        {
            for (int i = 0; i < row; i++){
                for(int j=0; j < col; j++){
                    result.SetValue(i, j, this.GetValue(i,j) - B.GetValue(i,j));
                }
            }
            return result;
        }
        else
        {
            System.out.print("Нельзя вычитать две матрицы с разной размерностью.");
            return null;
        }
    }

    /**
     * Умножение матрицы A на матрицу B.
     * @param B Вторая матрица.
     * @return Матрица C=A*B.
     */
    public Matrix Multiplication(Matrix B) {
        int row = RowLength();
        int col = B.ColumnLength();
        Matrix result = new Matrix(row, col);

        if(this.ColumnLength() == B.RowLength())
        {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    result.SetValue(i, j, 0);
                }
            }

            for (int i = 0; i < this.RowLength(); i++) {
                for (int j = 0; j < col; j++) { //
                    for (int k = 0; k < this.ColumnLength(); k++) { // aColumn
                        result.SetValue(i,j, result.GetValue(i,j) + this.GetValue(i,k) * B.GetValue(k,j));
                    }
                }
            }
            return result;
        }
        else
        {
            System.out.print("Нельзя умножить данные матрицы. Перепроверьте их размерность.");
            return null;
        }
    }

    /**
     * Умножение матрицы на число.
     * @param number
     * @return
     */
    public Matrix Multiplication(int number)
    {
        int row = RowLength();
        int col = ColumnLength();
        Matrix result = new Matrix(row, col);

        for (int i = 0; i < row; i++){
            for(int j=0; j < col; j++){
                result.SetValue(i, j, this.GetValue(i,j) * number);
            }
        }
        return result;
    }

    /**
     * Транспонирование матрицы.
     * @return
     */
    public Matrix Transposition()
    {
        int row = RowLength();
        int col = ColumnLength();
        Matrix result = new Matrix(row, col);

        for (int i = 0; i < row; i++){
            for(int j=0; j < col; j++){
                result.SetValue(i, j, this.GetValue(j, i));
            }
        }
        return result;
    }

    /**
     * Определитель матрицы.
     * @return
     */
    public double Det()
    {
        int row = RowLength();
        int col = ColumnLength();
        double result = 0;

        int s;

        for(int i=0; i<row; i++)
        {
            Matrix smaller = new Matrix(row-1, col-1);

            if (row == 1) {
                return (this.GetValue(0,0));
            }

            for(int a=1; a<row; a++) {
                for (int b = 0; b < col; b++) {
                    if (b < i) {
                        smaller.SetValue(a - 1, b, this.GetValue(a, b));
                    } else if (b > i) {
                        smaller.SetValue(a - 1, b - 1, this.GetValue(a, b));
                    }
                }
            }

            if (i % 2 == 0) {
                s = 1;
            } else {
                s = -1;
            }

            result = result + (this.GetValue(0,i) * smaller.Det() * s);

        }

        return result;
    }


    /**
     * Обратная матрица.
     * @return
     */
    public Matrix Inverse()
    {
        int row = RowLength();
        int col = ColumnLength();
        Matrix result = new Matrix(row, col);

        if(row!=col)
        {
            System.out.print("Нельзя вычислить обратную матрицу для неквадратной.");
            return null;
        }

        if(this.Det() == 0)
        {
            System.out.print("Нельзя вычислить обратную матрицу при нулевом определителе.");
            return null;
        }

        Matrix additions = new Matrix(row, col);

        int M = row;

        for(int I=0; I<M; I++)
        {
            for(int J=0; J<M; J++)
            {
                Matrix addition = new Matrix(M-1, M-1);
                for(int i=0; i<I; i++)
                {
                    for(int j=0; j<J; j++)
                    {
                        addition.SetValue(i, j, this.GetValue(i, j));
                    }
                    for(int j=J+1; j<M; j++)
                    {
                        addition.SetValue(i, j-1, this.GetValue(i, j));
                    }
                }
                for(int i=I+1; i<M; i++)
                {
                    for (int j = 0; j < J; j++)
                    {
                        addition.SetValue(i - 1, j, this.GetValue(i, j));
                    }
                    for (int j = J + 1; j < M; j++)
                    {
                        addition.SetValue(i - 1, j - 1, this.GetValue(i, j));
                    }
                }
                additions.SetValue(I, J, addition.Det());
            }
        }

        additions.Transposition();

        for(int i=0; i<row; i++)
        {
            for(int j=0; j<col; j++)
            {
                result.SetValue(i, j, (1.0/this.Det())*additions.GetValue(i,j));
            }
        }

        return result;
    }
}
