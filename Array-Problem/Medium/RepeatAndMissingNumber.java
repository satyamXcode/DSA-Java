/*
 * 
You are given a read only array of n integers from 1 to n.

Each integer appears exactly once except A which appears twice and B which is missing.

Return A and B.

Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Note that in your output A should precede B.

Example:

Input:[3 1 2 5 3] 

Output:[3, 4] 

A = 3, B = 4
 
 */

import java.util.Scanner;

public class RepeatAndMissingNumber {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] repeatedNumber(final int[] A) {
        int[] res = new int[2];
        
        for (int i = 0; i < A.length; i++) {
            int index = Math.abs(A[i]) - 1;
            if (A[index] < 0) {
                res[0] = Math.abs(A[i]); // Repeated number
            } else {
                A[index] = -A[index];
            }
        }
        
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0) {
                res[1] = i + 1; // Missing number
                break;
            }
        }
        
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RepeatAndMissingNumber sol = new RepeatAndMissingNumber();

        // Input for array
        System.out.println("Enter array elements separated by spaces (1 to n):");
        String[] input = sc.nextLine().split(" ");
        int[] A = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            A[i] = Integer.parseInt(input[i]);
        }

        int[] result = sol.repeatedNumber(A);
        System.out.println("Repeated number: " + result[0]);
        System.out.println("Missing number: " + result[1]);
    }

}
