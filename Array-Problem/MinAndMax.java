import java.util.AbstractMap;

class Solution {
    public AbstractMap.SimpleEntry<Integer, Integer> getMinMax(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < arr.length; i++){
            if(min > arr[i]){
                min = arr[i];
            }
            if(max < arr[i]){
                max = arr[i];
            }
        }
        return new AbstractMap.SimpleEntry<>(min, max);
    }
}

public class MinAndMax {
    public static void main(String[] args) {
        Solution solution = new Solution(); // Create an instance of Solution, not MinAndMax
        int[] arr = {3, 5, 1, 8, 6, 2, 7, 4}; // Example input array
        
        AbstractMap.SimpleEntry<Integer, Integer> result = solution.getMinMax(arr);
        
        System.out.println("Minimum value: " + result.getKey());
        System.out.println("Maximum value: " + result.getValue());
    }
}