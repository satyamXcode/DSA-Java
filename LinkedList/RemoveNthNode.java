public class RemoveNthNode {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // Edge case: empty list or single node being removed
        if (head == null) {
            return null;
        }

        // Calculate the size of the list
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        // Calculate the position to remove (0-based index from start)
        int positionToRemove = size - n;

        // Special case: removing the head node
        if (positionToRemove == 0) {
            return head.next;
        }

        // Move to the node just before the one to be removed
        temp = head;
        for (int i = 1; i < positionToRemove; i++) {
            temp = temp.next;
        }

        // Remove the node by skipping it
        temp.next = temp.next.next;

        return head;
    }
        public static void main(String[] args) {
            // Create a list: 1 -> 2 -> 3 -> 4 -> 5
            ListNode head = new ListNode(1);
            head.next = new ListNode(2);
            head.next.next = new ListNode(3);
            head.next.next.next = new ListNode(4);
            head.next.next.next.next = new ListNode(5);
    
            // Solution solution = new Solution();
            
            // Remove 2nd node from end (node with value 4)
            ListNode result = removeNthFromEnd(head, 3);
            
            // Print the result: 1 -> 2 -> 3 -> 5
            while (result != null) {
                System.out.print(result.val + " ");
                result = result.next;
            }
        }
    }