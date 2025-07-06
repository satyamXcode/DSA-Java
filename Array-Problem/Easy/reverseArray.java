import java.util.*;

class reverseArray {
    public void reverseArr(int arr[]) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            // Swap elements at start and end indices
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        reverseArray sol = new reverseArray();

        // Input example: 1 2 3 4 5
        System.out.println("Enter array elements separated by spaces:");
        String[] input = sc.nextLine().split(" ");
        int[] arr = new int[input.length];
        
        // Convert input strings to integers
        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        System.out.println("Original array: " + Arrays.toString(arr));
        sol.reverseArr(arr);
        System.out.println("Reversed array: " + Arrays.toString(arr));
    }
}