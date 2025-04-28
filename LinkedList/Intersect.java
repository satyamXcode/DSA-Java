import java.util.Scanner;

class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}

class Intersect {
    // Function to find intersection point in Y shaped Linked Lists
    static Node intersectPoint(Node head1, Node head2) {
        if (head1 == null || head2 == null) return null;
        
        // Traverse both lists to get lengths and last nodes
        Node tail1 = head1, tail2 = head2;
        int len1 = 1, len2 = 1;
        
        while (tail1.next != null) {
            tail1 = tail1.next;
            len1++;
        }
        
        while (tail2.next != null) {
            tail2 = tail2.next;
            len2++;
        }
        
        // If tails don't match, no intersection
        if (tail1 != tail2) return null;
        
        // Reset pointers to heads
        Node longer = len1 > len2 ? head1 : head2;
        Node shorter = len1 > len2 ? head2 : head1;
        
        // Advance the longer pointer by the length difference
        int diff = Math.abs(len1 - len2);
        while (diff-- > 0) {
            longer = longer.next;
        }
        
        // Move both pointers until they meet
        while (longer != shorter) {
            longer = longer.next;
            shorter = shorter.next;
        }
        
        return longer; // intersection node
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
        
        // Input for first list
        System.out.println("Enter first list (space separated):");
        String[] input1 = sc.nextLine().split(" ");
        int[] arr1 = new int[input1.length];
        for (int i = 0; i < input1.length; i++) {
            arr1[i] = Integer.parseInt(input1[i]);
        }
        
        // Input for second list
        System.out.println("Enter second list (space separated):");
        String[] input2 = sc.nextLine().split(" ");
        int[] arr2 = new int[input2.length];
        for (int i = 0; i < input2.length; i++) {
            arr2[i] = Integer.parseInt(input2[i]);
        }
        
        // Create lists
        Node head1 = createList(arr1);
        Node head2 = createList(arr2);
        
        // Input for intersection point (index in first list)
        System.out.println("Enter intersection index in first list (-1 for no intersection):");
        int intersectIndex = sc.nextInt();
        
        // Create intersection if specified
        if (intersectIndex >= 0 && intersectIndex < arr1.length) {
            Node temp1 = head1;
            for (int i = 0; i < intersectIndex; i++) {
                temp1 = temp1.next;
            }
            
            // Find last node of second list
            Node temp2 = head2;
            while (temp2.next != null) {
                temp2 = temp2.next;
            }
            temp2.next = temp1; // create intersection
        }
        
        // Find intersection point
        Node intersection = intersectPoint(head1, head2);
        
        if (intersection != null) {
            System.out.println("Intersection point value: " + intersection.data);
        } else {
            System.out.println("No intersection found");
        }
        
        sc.close();
    }
}
