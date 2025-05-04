import java.util.Scanner;

class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}

public class ZigZagFashion {
    // Function to convert linked list to zig-zag pattern
    Node zigZag(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        Node current = head;
        boolean lessThanExpected = true; // Flag to alternate between < and >
        
        while (current.next != null) {
            if (lessThanExpected) {
                // Current should be < next
                if (current.data > current.next.data) {
                    swapData(current, current.next);
                }
            } else {
                // Current should be > next
                if (current.data < current.next.data) {
                    swapData(current, current.next);
                }
            }
            
            current = current.next;
            lessThanExpected = !lessThanExpected; // Toggle the flag
        }
        
        return head;
    }
    
    // Helper method to swap data between two nodes
    private void swapData(Node a, Node b) {
        int temp = a.data;
        a.data = b.data;
        b.data = temp;
    }
    
    // Helper function to create linked list from array
    static Node createList(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new Node(arr[i]);
            current = current.next;
        }
        return head;
    }
    
    // Helper function to print list
    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the elements of the linked list (space separated):");
        String[] input = sc.nextLine().split(" ");
        int[] arr = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        
        // Create the linked list
        Node head = createList(arr);
        
        System.out.println("Original List:");
        printList(head);
        
        // Convert to zig-zag pattern
        ZigZagFashion solution = new ZigZagFashion();
        head = solution.zigZag(head);
        
        System.out.println("Zig-Zag List:");
        printList(head);
        
        sc.close();
    }
}
