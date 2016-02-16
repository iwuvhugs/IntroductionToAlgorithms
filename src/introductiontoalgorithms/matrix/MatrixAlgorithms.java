/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package introductiontoalgorithms.matrix;

import java.util.Arrays;

/**
 *
 * @author iwuvhugs
 */
public class MatrixAlgorithms {

    public static void testMatrixs() {
        int[][] matrix = {
            {1, 3, 5},
            {10, 11, 16},
            {23, 30, 34}
        };

        for (int[] arr : matrix) {
            System.out.println(Arrays.toString(arr));
        }

        rotate(matrix);
        System.out.println("");

        for (int[] arr : matrix) {
            System.out.println(Arrays.toString(arr));
        }
    }

    /**
     *
     * You are given an n x n 2D matrix representing an image.
     *
     * Rotate the image by 90 degrees (clockwise).
     *
     * @author http://www.programcreek.com/2013/01/leetcode-rotate-image-java/
     * 
     * @param matrix
     */
    public static void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        int m = matrix.length;

        int[][] result = new int[m][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                result[j][m - 1 - i] = matrix[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = result[i][j];
            }
        }
    }
}
