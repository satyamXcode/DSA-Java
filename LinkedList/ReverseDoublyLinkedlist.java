// Node class for Doubly Linked List
class DLLNode {
    int data;
    DLLNode prev;
    DLLNode next;
    
    public DLLNode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}


// Main class with input handling
public class ReverseDoublyLinkedlist {

    public static DLLNode reverseDLL(DLLNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        DLLNode current = head;
        DLLNode temp = null;
        
        // Swap next and prev for all nodes
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;  // Move to next node (using prev since we swapped)
        }
        
        // Update the new head (last node becomes first)
        if (temp != null) {
            head = temp.prev;
        }
        
        return head;
    }

    public static void main(String[] args) {
        // Create a sample doubly linked list: 1 <-> 2 <-> 3 <-> 4 <-> 5
        DLLNode head = new DLLNode(1);
        DLLNode second = new DLLNode(2);
        DLLNode third = new DLLNode(3);
        DLLNode fourth = new DLLNode(4);
        DLLNode fifth = new DLLNode(5);
        
        // Link the nodes
        head.next = second;
        second.prev = head;
        second.next = third;
        third.prev = second;
        third.next = fourth;
        fourth.prev = third;
        fourth.next = fifth;
        fifth.prev = fourth;
        
        // Print original list
        System.out.println("Original List:");
        printList(head);
        
        // Reverse the list
        head = reverseDLL(head);
        
        // Print reversed list
        System.out.println("\nReversed List:");
        printList(head);
    }
    
    // Helper method to print the doubly linked list
    public static void printList(DLLNode node) {
        while (node != null) {
            System.out.print(node.data);
            if (node.next != null) {
                System.out.print(" <-> ");
            }
            node = node.next;
        }
    }
}
