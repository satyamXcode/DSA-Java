// Java Program to sort a linked list of 0s, 1s or 2s
import java.util.*;

class Node {
    int data;
    Node next;
    Node(int new_data) {
        data = new_data;
        next = null;
    }
}


public class SortLinkedList0s1s2s { 

    // public static void sortList(Node head){ //Brute force approach : TC: O(n) && SC: O(n)
    //    int size = 0;
    //    Node temp = head;

    //    while(temp != null){
    //       size++;
    //       temp = temp.next;
    //    }
    //    int arr[] = new int[size];
    //    temp = head;
    //    int i = 0;

    //    while(temp != null){
    //      arr[i] = temp.data;
    //      i++;
    //      temp = temp.next;
    //    }

    //    Arrays.sort(arr);

    //    temp = head;
    //    for(int j = 0; j < arr.length; j++){
    //      temp.data = arr[j];
    //      temp = temp.next;
    //    }
    // }

     public static void sortList(Node head){ // Best case approach: O(n) && SC: O(1)
      int cnt[] = {0, 0, 0}; // Frequency array

      Node temp = head;

      while(temp != null){
        cnt[temp.data]++;
        temp = temp.next;
      }

      int idx = 0;
      temp = head;

      while(temp != null){
        if(cnt[idx] == 0){
            idx++;
        }else{
            temp.data = idx;
            cnt[temp.data]--;
            temp = temp.next;
        }
      }

    }

    static void printList(Node head){
        Node temp = head;

        while(temp != null){
            System.out.print(temp.data +"->");
            temp = temp.next;
        }
        System.out.println("null");
    }

   

    public static void main(String[] args) {
      
        // Create a hard-coded linked list:
        // 1 -> 1 -> 2 -> 1 -> 0 -> NULL
        Node head = new Node(2);
        head.next = new Node(0);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(0);

        System.out.print("Linked List before Sorting:");
        printList(head);

        sortList(head);

        System.out.print("Linked List after Sorting:");
        printList(head);
    }
    
}
