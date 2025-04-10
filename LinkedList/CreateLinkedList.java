public class CreateLinkedList {
    public static class Node{
        int data;
        Node next; // referance node

        public Node(int data){  //Constructor
            this.data = data;
            this.next = null; 
        }
    }

    public static Node head; // Head Node
    public static Node tail; // Tail Node
    public static int size;

    //addFirst() -> Add element from start of linkedlist

    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        //edge case
        if(head == null){
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    //addLast() -> Add element from end of linkedlist

    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        //edge case
        if(head == null){
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    //add() -> Add element at specific index

    public void add(int idx, int data){
        if(idx == 0){
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while(i < idx-1){
            temp = temp.next;
            i++;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    //removeFirst() -> Delete node from start of linkedlist

    public int removeFirst(){
       //edge case
       if(size == 0){
        System.out.println("LinkedList is empty");
        return Integer.MIN_VALUE;
       }else if(size == 1){
         int val = head.data;
         head = tail = null;
         size = 0;
         return val;
       }

       int val = head.data;
       head = head.next;
       size--;
       return val;
    }

    //removeLast() -> Delete node from end of linkedlist

    public int removeLast(){
        //edge case
        if(size == 0){
            System.out.println("Linkedlist is empty");
            return Integer.MIN_VALUE;
        }else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        Node temp = head;
        for(int i = 0 ; i < size -2; i++){
           temp = temp.next;
        }

        int val = tail.data;
        temp.next = null;
        tail = temp;
        size--;
        return val;
    }

    public void print(){
        if(size == 0){
            System.out.println("LinkedList is empty");
            return;
        }

        Node temp = head;
        while(temp != null){
            System.out.print(temp.data +"->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void reverseIterate(){
        //edge case
        if(head == null || head.next == null){
            return;
        }

        Node prevNode = head;
        Node currNode = head.next;

        while(currNode != null){
            Node nextNode = currNode.next;
            currNode.next = prevNode;

            //update
            prevNode = currNode;
            currNode = nextNode;
        }

        head.next = null;
        head = prevNode;
    }

    public static void main(String args[]){
        CreateLinkedList ll = new CreateLinkedList();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        // ll.print();
        // System.out.println(size);
        // ll.removeFirst();
        // ll.print();
        // System.out.println(size);
        // ll.removeLast();
        // ll.print();
        // System.out.println(size);
        // ll.addLast(4);
        // ll.print();
        // System.out.println(size);
        // ll.add(1,3);
        // ll.print();
        // System.out.println(size);
        // ll.removeFirst();
        // ll.removeLast();
        // ll.removeFirst();
        // ll.print();
        // System.out.println(size);

        ll.print();
        ll.reverseIterate();
        ll.print();

    }
}
