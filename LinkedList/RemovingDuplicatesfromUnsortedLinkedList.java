import java.util.HashSet;
import java.util.Scanner;

// Node class definition
class Node {
    int data;
    Node next;
    
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Solution {
    // Function to remove duplicates from unsorted linked list.
    public Node removeDuplicates(Node head) {
        if (head == null) return null;
        
        HashSet<Integer> seen = new HashSet<>();
        Node current = head;
        seen.add(current.data);
        
        while (current.next != null) {
            if (seen.contains(current.next.data)) {
                // Skip the duplicate node
                current.next = current.next.next;
            } else {
                seen.add(current.next.data);
                current = current.next;
            }
        }
        
        return head;
    }
    
    // Function to print the linked list
    public void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    
    // Function to create a linked list from user input
    public Node createLinkedList() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of nodes:");
        int n = sc.nextInt();
        
        if (n == 0) return null;
        
        System.out.println("Enter the elements:");
        Node head = new Node(sc.nextInt());
        Node current = head;
        
        for (int i = 1; i < n; i++) {
            current.next = new Node(sc.nextInt());
            current = current.next;
        }
        
        return head;
    }
}

public class RemovingDuplicatesfromUnsortedLinkedList {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Create linked list from user input
        Node head = solution.createLinkedList();
        
        System.out.println("Original linked list:");
        solution.printList(head);
        
        // Remove duplicates
        head = solution.removeDuplicates(head);
        
        System.out.println("Linked list after removing duplicates:");
        solution.printList(head);
    }
}
