import java.util.*;

// Pair class definition (as provided in the problem)
class Pair<K, V> {
    private final K key;
    private final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Pair(" + key + ", " + value + ")";
    }
}

class Solution {
    public Pair<Integer, Integer> getMinMax(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (int num : arr) {
            if (num < min) min = num;
            if (num > max) max = num;
        }
        
        return new Pair<>(min, max);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        // Input example: 6 3 2 1 56 10000 5
        System.out.println("Enter array elements separated by spaces:");
        String[] input = sc.nextLine().split(" ");
        int[] arr = new int[input.length];
        
        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        Pair<Integer, Integer> result = sol.getMinMax(arr);
        System.out.println("Minimum and Maximum: " + result);
    }
}