// Better Approach :: TC : O(n) && SC : O(1)

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class ReOrderListApproach2 {

    public void reorderList(ListNode head) {

        // edge case
        if(head == null || head.next == null || head.next.next == null){
            return;
        }

        // Find mid node
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHead = slow.next;
        slow.next = null;

        // Reverse second half of linkedlist
        ListNode curr = secondHead;
        ListNode prev = null;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Insert nodes of second list into the first list
        ListNode t1 = head;
        ListNode t2 = prev;

        while(t2 != null){
            ListNode m1 = t1.next;
            ListNode m2 = t2.next;
            t1.next = t2;
            t2.next = m1;
            t1 = m1;
            t2 = m2;
        }
    }

     // Helper method to print the list
     public void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public ListNode createList(int[] arr) {
        if (arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
        return head;
    }

    public static void main(String args[]){
        ReOrderListApproach2 solution = new ReOrderListApproach2();
        
        // Input: [1, 2, 3, 4, 5]
        int[] input = {1, 2, 3, 4, 5};
        ListNode head = solution.createList(input);

        System.out.print("Original List: ");
        solution.printList(head);

        solution.reorderList(head);

        System.out.print("Reordered List: ");
        solution.printList(head);
    }
}
