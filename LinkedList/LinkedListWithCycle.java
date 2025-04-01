class ListNode {
    int val;
    ListNode next;
    
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class LinkedListWithCycle {
    
    public static ListNode createLinkedListWithCycle(int[] values, int cyclePos) {
        if (values == null || values.length == 0) {
            return null;
        }
        
        // Create all nodes first
        ListNode[] nodes = new ListNode[values.length];
        for (int i = 0; i < values.length; i++) {
            nodes[i] = new ListNode(values[i]);
        }
        
        // Link nodes together
        for (int i = 0; i < nodes.length - 1; i++) {
            nodes[i].next = nodes[i + 1];
        }
        
        // Create the cycle
        if (cyclePos >= 0 && cyclePos < nodes.length) {
            nodes[nodes.length - 1].next = nodes[cyclePos];
        }
        
        return nodes[0];
    }
    
    public static void printLinkedList(ListNode head, int maxNodes) {
        ListNode current = head;
        int count = 0;
        while (current != null && count < maxNodes) {
            System.out.print(current.val + " -> ");
            current = current.next;
            count++;
        }
        System.out.println(count == maxNodes ? "..." : "null");
    }
    
    public static boolean hasCycle(ListNode head) {
        if (head == null) return false;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                return true;
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        // Create a linked list with values 1->2->3->4->5 and cycle back to position 2 (value 3)
        ListNode head = createLinkedListWithCycle(new int[]{1, 2, 3, 4, 5}, 2);
        
        System.out.println("Linked list with cycle (first few nodes):");
        printLinkedList(head, 10); // Print first 10 nodes max to avoid infinite loop
        
        System.out.println("\nDoes the linked list have a cycle? " + hasCycle(head));
        
        // Additional test: find where the cycle starts
        ListNode cycleStart = detectCycleStart(head);
        if (cycleStart != null) {
            System.out.println("Cycle starts at node with value: " + cycleStart.val);
        } else {
            System.out.println("No cycle detected");
        }
         
        // Print linked list node after cycle remove
        System.out.println("Linked list with cycle (first few nodes):");
        printLinkedList(head, 10);
    }
    
    // Bonus: Method to find where the cycle starts
    public static ListNode detectCycleStart(ListNode head) {
        if (head == null) return null;
        
        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;
        
        // Detect if cycle exists
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }
        
        if (!hasCycle) return null;
        
        // Find the start of the cycle
        slow = head;
        // Logic to remove the cycle
        ListNode prev = null;
        while (slow != fast) {
            slow = slow.next;
            prev = fast;
            fast = fast.next;
        }
        
        prev.next = null;
        return slow;
    }
}