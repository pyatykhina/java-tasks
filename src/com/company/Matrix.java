package com.company;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Класс для работы с двумя матрицами.
 */
public class Matrix
{
    public int[][] Matrix;
    int rows, columns;

    /**
     * Выделение памяти под матрицу.
     * @param rows
     * @param columns
     */
    Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        Matrix = new int[rows][columns];
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
    public int GetValue(int i, int j)
    {
        return Matrix[i][j];
    }

    /**
     * Записать значение в элемент матрицы по индексу {i,j}
     * @param i
     * @param j
     * @param value
     */
    public void SetValue(int i, int j, int value)
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
     * @param B
     * @return
     */
    public Matrix Multiplication(Matrix B) {
        int row = RowLength();
        int col = ColumnLength();
        Matrix result = new Matrix(row, col);

        if(this.RowLength() == B.RowLength() && this.ColumnLength() == B.ColumnLength())
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
            System.out.print("Нельзя умножить две матрицы с разной размерностью.");
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
}
