/*
Given an integer array nums and an integer k, return the kth largest element in the array.
Note that it is the kth largest element in the sorted order, not the kth distinct element.
Can you solve it without sorting?

Solved:) Time Complexity: O(n log k) & Space Complexity: O(k)
 */

import java.util.PriorityQueue;
import java.util.Scanner;

public class KthLargestEleement {
      public int findKthLargest(int[] nums, int k) {
        // Create a min-heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        // Add first k elements to the heap
        for (int i = 0; i < k; i++) {
            pq.offer(nums[i]);
        }
        
        // Process remaining elements
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > pq.peek()) {
                pq.poll();          // Remove smallest element
                pq.offer(nums[i]);  // Add current element
            }
        }
        
        return pq.peek();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        KthLargestEleement sol = new KthLargestEleement();

        // Input for array
        System.out.println("Enter array elements separated by spaces:");
        String[] input = sc.nextLine().split(" ");
        int[] nums = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        // Input for k
        System.out.println("Enter k:");
        int k = sc.nextInt();

        int result = sol.findKthLargest(nums, k);
        System.out.println("The " + k + "th largest element is: " + result);
    }
}
