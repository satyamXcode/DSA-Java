//Problem: Give a N * N square matrix A, return all the elements of its anti-diagonals from top to bottom.
// Input: 
// N = 3 
// A = [[1, 2, 3],
//      [4, 5, 6],
//      [7, 8, 9]]
// Output: 
// 1 2 4 3 5 7 6 8 9

//=========================

import java.util.ArrayList;
import java.util.List;

public class AntiDiagonalPrint {

    public static List<List<Integer>> printAntiDiagonally(int[][] matrix) {
        int n = matrix.length;
        List<List<Integer>> result = new ArrayList<>();

        // Traverse the top row
        for (int col = 0; col < n; col++) {
            List<Integer> diagonal = new ArrayList<>();
            int i = 0, j = col;
            while (i < n && j >= 0) {
                diagonal.add(matrix[i][j]);
                i++;
                j--;
            }
            result.add(diagonal);
        }

        // Traverse the last column (excluding the first element which is already covered)
        for (int row = 1; row < n; row++) {
            List<Integer> diagonal = new ArrayList<>();
            int i = row, j = n - 1;
            while (i < n && j >= 0) {
                diagonal.add(matrix[i][j]);
                i++;
                j--;
            }
            result.add(diagonal);
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        List<List<Integer>> result = printAntiDiagonally(matrix);

        // Print the result
        for (List<Integer> diagonal : result) {
            for (int num : diagonal) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}