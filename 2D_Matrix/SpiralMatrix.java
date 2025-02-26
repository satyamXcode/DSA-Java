
/* Problem: 54. Spiral Matrix

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
*/ 
// ===================================(Code)=========

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void printMatrix(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j] +" ");
            }
            System.out.println();
        }
    }

    public static List<Integer> spiralOrder(int[][] matrix){
      List<Integer> result = new ArrayList<>();
      
      if(matrix == null || matrix.length == 0){
        return result;
      }
      
      int startRow = 0, endRow = matrix.length-1;
      int startCol = 0, endCol = matrix[0].length-1;

      while(startRow <= endRow && startCol <= endCol){

      //Traverse from left to right along the top row
      for(int j = startCol; j <= endCol; j++){
        result.add(matrix[startRow][j]);
      }
      startRow++;

      //Traverse from top to bottom along the right column
      for(int i = startRow; i <= endRow; i++){
        result.add(matrix[i][endCol]);
      }
      endCol--;

      //Traverse from right to left along the bottom row (if still within bounds)
      if(startRow <= endRow){
        for(int j = endCol; j >= startCol; j--){
            result.add(matrix[endRow][j]);
        }
        endRow--;
      }

      //Traverse from bottom to top along the left column (if still within bounds)
      if(startCol <= endCol){
        for(int i = endRow; i >= startRow; i--){
            result.add(matrix[i][startCol]);
        }
        startCol++;
      }
      }

      return result;
    }

    public static void main(String args[]){
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println("Before logic ::");
        printMatrix(matrix);
        
        List<Integer> res = spiralOrder(matrix);

        System.out.println("After logic ::");
        
        for(int num : res){
            System.out.print(num +" ");
        }
    }
}
