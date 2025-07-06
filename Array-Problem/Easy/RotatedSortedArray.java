import java.util.*;

class RotatedSortedArray {
    public int search(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;  // Prevents integer overflow
            
            if (arr[mid] == target) {
                return mid;
            }
            
            // Check if left half is sorted
            if (arr[low] <= arr[mid]) {
                if (arr[low] <= target && target < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } 
            // Right half must be sorted
            else {
                if (arr[mid] < target && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RotatedSortedArray sol = new RotatedSortedArray();

        // Input for rotated sorted array
        System.out.println("Enter rotated sorted array elements separated by spaces:");
        String[] input = sc.nextLine().split(" ");
        int[] arr = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        // Input for target value
        System.out.println("Enter target value to search:");
        int target = sc.nextInt();

        int result = sol.search(arr, target);
        System.out.println("Target found at index: " + result);
    }
}