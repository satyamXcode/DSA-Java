import java.util.*;

class ChocolateDistribution {
    public int findMinDiff(ArrayList<Integer> arr, int m) {
        // Check edge cases
        if (m == 0 || arr.size() == 0 || m > arr.size()) {
            return 0;
        }
        
        // Sort the array
        Collections.sort(arr);
        
        int minDiff = Integer.MAX_VALUE;
        
        // Find the minimum difference in sliding window of size m
        for (int i = 0; i + m - 1 < arr.size(); i++) {
            int currentDiff = arr.get(i + m - 1) - arr.get(i);
            minDiff = Math.min(currentDiff, minDiff);
        }
        
        return minDiff;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ChocolateDistribution sol = new ChocolateDistribution();

        // Input for array
        System.out.println("Enter chocolate packet sizes separated by spaces:");
        String[] input = sc.nextLine().split(" ");
        ArrayList<Integer> arr = new ArrayList<>();
        for (String s : input) {
            arr.add(Integer.parseInt(s));
        }

        // Input for number of students (m)
        System.out.println("Enter number of students (m):");
        int m = sc.nextInt();

        int result = sol.findMinDiff(arr, m);
        System.out.println("Minimum difference is: " + result);
    }
}