package org.contract.api.util.matrix;

import java.util.Arrays;
import java.util.Random;

public class Matrix extends Thread {

    private final int[][] mainMatrix;
    private final int[] line;
    private int[] resultLine;
    private final static Random rnd = new Random();

    public Matrix(int[][] mainMatrix, int[] line) {
        this.mainMatrix = mainMatrix;
        this.line = line;
    }

    @Override
    public void run() {
        resultLine = multiplyMatrix(mainMatrix, line);
        show(resultLine);
    }

    public static int[] multiplyMatrix(int[][] mainMatrix, int[] line){
        int[] result = new int[mainMatrix.length];

        for (int i = 0; i < mainMatrix.length; i++) {
            for (int j = 0; j < mainMatrix.length; j++) {
                result[i] += line[j] * mainMatrix[j][i];
            }
        }
        return result;
    }

    public static int[][] initRandomMatrix(int size){
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = rnd.nextInt(10);
            }
        }
        return matrix;
    }

    private void show(int[] line){
        System.out.println(Arrays.toString(line));
    }
}
