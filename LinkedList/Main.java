//Detect & Remove Cycle in LinkedList

class Node {
    int data;
    Node next;
    
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Solution {
    // Function to remove a loop in the linked list.
    public static void removeLoop(Node head) {
        // Edge case: If linked list has size 0 or 1, return.
        if (head == null || head.next == null) {
            return;
        }
        
        Node slow = head;
        Node fast = head;
        boolean isCycle = false;
        
        // Detect the loop using Floyd's algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                isCycle = true;
                break;
            }
        }
        
        // If no loop, return.
        if (!isCycle) {
            return;
        }
        
        // Find the start of the loop
        slow = head;
        Node prev = null;
        
        // If slow and fast meet at head, then the entire list is a loop.
        // We need to find the node before fast in the loop.
        if (slow == fast) {
            while (fast.next != slow) {
                fast = fast.next;
            }
        } else {
            while (slow != fast) {
                slow = slow.next;
                prev = fast;
                fast = fast.next;
            }
        }
        
        // Break the loop
        if (prev != null) {
            prev.next = null;
        } else {
            // This handles the case where the loop starts at the head
            fast.next = null;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Example 1: Linked list with a loop
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = head1.next; // Loop at node with value 2
        
        System.out.println("Before removing loop:");
        printLinkedList(head1, 5); // Print first 5 nodes to avoid infinite loop
        
        Solution.removeLoop(head1);
        
        System.out.println("After removing loop:");
        printLinkedList(head1, 4); // Print all nodes
        
        // Example 2: Linked list without a loop
        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(3);
        head2.next.next.next = new Node(4);
        
        System.out.println("Before removing loop (no loop):");
        printLinkedList(head2, 4);
        
        Solution.removeLoop(head2);
        
        System.out.println("After removing loop (no loop):");
        printLinkedList(head2, 4);
    }
    
    // Helper function to print the linked list (limited to 'limit' nodes to avoid infinite loops)
    public static void printLinkedList(Node head, int limit) {
        Node current = head;
        int count = 0;
        while (current != null && count < limit) {
            System.out.print(current.data + " ");
            current = current.next;
            count++;
        }
        System.out.println();
    }
}