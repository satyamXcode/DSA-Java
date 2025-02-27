/* 48. Rotate Image
 * 
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
DO NOT allocate another 2D matrix and do the rotation.

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]
 */

import java.util.Scanner;

public class RotateImage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Take the size of the matrix as input
        System.out.print("Enter the size of the matrix (n x n): ");
        int n = scanner.nextInt();

        // Step 2: Initialize the matrix and take elements as input
        int[][] matrix = new int[n][n];
        System.out.println("Enter the elements of the matrix:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("Enter element at position (" + i + ", " + j + "): ");
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Step 3: Print the original matrix
        System.out.println("Original Matrix:");
        printMatrix(matrix);

        // Step 4: Rotate the matrix
        rotate(matrix);

        // Step 5: Print the rotated matrix
        System.out.println("Rotated Matrix:");
        printMatrix(matrix);

        scanner.close();
    }

    // Method to rotate the matrix 90 degrees clockwise
    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < (n + 1) / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                // Perform a four-way swap
                int temp = matrix[n - 1 - j][i]; // Save bottom-left element
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1]; // Move bottom-right to bottom-left
                matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 - i]; // Move top-right to bottom-right
                matrix[j][n - 1 - i] = matrix[i][j]; // Move top-left to top-right
                matrix[i][j] = temp; // Move saved bottom-left to top-left
            }
        }
    }

    // Method to print the matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}