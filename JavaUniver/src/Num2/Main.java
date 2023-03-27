package Num2;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Matrix m = new Matrix(5);
        System.out.println(m.toString());
        System.out.println("Sum: " + m.sum());

        int[][] mat = createMatrix(3);
        printMatrix(mat);
        multiplyMatrix(mat);
    }

    public static int[][] createMatrix(int x) {
        int[][] array = new int[x][x];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                Random rand = new Random();
                array[i][j] = rand.nextInt(9 + 1);
            }
        }
        return array;
    }

    public static void printMatrix(int[][] c) {
        for (int[] ints : c) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    public static void multiplyMatrix(int[][] a) {
        int summ = 0;
        int residual = 0;
        int multiply = 1;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (i < j) {
                    summ += a[i][j];
                } else if (i > j) {
                    residual -= a[i][j];
                } else {
                    multiply *= a[i][j];
                }
            }
        }
        System.out.println("Сумма чисел: " + summ);
        System.out.println("Произведение чисел: " + multiply);
        System.out.println("Разность:" + residual);
    }

}