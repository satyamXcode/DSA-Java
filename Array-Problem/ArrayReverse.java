public class ArrayReverse { // TC : O(N) & SC : O(1)

    public static void reverseArray(int arr[]) {
        int i = 0;
        int j = arr.length - 1;
        
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    // Helper method to print the array
 public static void printArray(int[] arr) {
    for (int num : arr) {
        System.out.print(num + " ");
    }
    System.out.println();
}

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5}; // Example input array
        
        System.out.println("Original array:");
        printArray(arr);
        
        reverseArray(arr);
        
        System.out.println("Reversed array:");
        printArray(arr);
    }
}

