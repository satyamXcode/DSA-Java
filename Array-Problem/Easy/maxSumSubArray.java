import java.util.*;

class maxSumSubArray {
    public int maxSubArray(int[] nums) {
        // Kadane's Algorithm
        int maxSum = Integer.MIN_VALUE;
        int maxVal = Integer.MIN_VALUE; // To handle all-negative arrays
        int currSum = 0;

        for (int num : nums) {
            currSum = Math.max(currSum + num, 0);
            maxSum = Math.max(maxSum, currSum);
            maxVal = Math.max(maxVal, num);
        }

        // If all numbers are negative, return the maximum single element
        if (maxSum == 0) {
            maxSum = maxVal;
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        maxSumSubArray sol = new maxSumSubArray();

        // Input example: -2 1 -3 4 -1 2 1 -5 4
        System.out.println("Enter array elements separated by spaces:");
        String[] input = sc.nextLine().split(" ");
        int[] nums = new int[input.length];
        
        // Convert input strings to integers
        for (int i = 0; i < input.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        int result = sol.maxSubArray(nums);
        System.out.println("Maximum subarray sum: " + result);
    }
}