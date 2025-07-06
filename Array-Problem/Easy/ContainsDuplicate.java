import java.util.*;

class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        // Sort the array first - O(n log n)
        Arrays.sort(nums);
        
        // Check adjacent elements - O(n)
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ContainsDuplicate sol = new ContainsDuplicate();

        // Input example: 1 2 3 1
        System.out.println("Enter array elements separated by spaces:");
        String[] input = sc.nextLine().split(" ");
        int[] nums = new int[input.length];
        
        // Convert input strings to integers
        for (int i = 0; i < input.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        boolean result = sol.containsDuplicate(nums);
        System.out.println("Contains duplicates: " + result);
    }
}