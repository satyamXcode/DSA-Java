// Save this as MaximumSubArray.java
public class MaximumSubArray {

    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
       //Kadane Algorithm :: TC -> O(N) & SC -> O(1)
       int currSum = 0;
       int maxSum = Integer.MIN_VALUE;
       int maxVal = Integer.MIN_VALUE;

       for(int i = 0; i < nums.length; i++){
           currSum = Math.max(currSum + nums[i], 0);
           maxSum = Math.max(currSum, maxSum);
           maxVal = Math.max(maxVal, nums[i]);
       }

       if(maxSum == 0){
           maxSum = maxVal;
       }

       return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        
        int result = maxSubArray(nums);
        System.out.println("Maximum subarray sum: " + result);
    }
}
 