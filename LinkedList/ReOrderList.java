// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}


public class ReOrderList{

    public void reorderList(ListNode head) {
        // Brute force approach
        ListNode temp = head;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        int[] arr = new int[size];
        temp = head;
        int i = 0;
        while (temp != null) {
            arr[i] = temp.val;
            temp = temp.next;
            i++;
        }

        ListNode ans = head;
        i = 0;
        int j = size - 1;
        boolean toggle = true;
        while (i <= j) {
            if (toggle) {
                ans.val = arr[i];
                i++;
            } else {
                ans.val = arr[j];
                j--;
            }
            ans = ans.next;
            toggle = !toggle;
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
        ReOrderList solution = new ReOrderList();
        
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