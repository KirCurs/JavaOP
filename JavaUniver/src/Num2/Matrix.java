package Num2;

import java.util.Arrays;

import java.util.Random;

public class Matrix {
    private int[][] m;

    Matrix(int size) {
        m = new int[size][size];
        Random rand = new Random();

        for (var i = 0; i < m.length; i++) {
            for (var y = 0; y < m.length; y++) {
                m[i][y] = rand.nextInt(9 + 1);
            }
        }
    }

    public int sum() {
        int summ = 0;
        for (int[] ints : m) {
            for (int i = 0; i < m.length; i++) {
                summ += ints[i];
            }
        }
        return summ;
    }

    @Override
    public String toString() {
        return "Num2.Matrix{" +
                "m=" + Arrays.deepToString(m) +
                '}';
    }
}
