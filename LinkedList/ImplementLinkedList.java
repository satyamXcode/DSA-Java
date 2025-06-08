public class ImplementLinkedList {
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public static void addFirst(int data){
        Node newNode = new Node(data);
        
        if(size == 0){
            head = tail = newNode;
            size++;
            return;
        }
        size++;
        newNode.next = head;
        head = newNode;
    }

    public static void addLast(int data){
        Node newNode = new Node(data);
        if(size == 0){
            head = tail = newNode;
            size++;
            return;
        }
        size++;
        tail.next = newNode;
        tail = newNode;
    }

    public static int removeFirst(){
        if(size == 0){
            System.out.println("LinkedList is empty.");
            return Integer.MIN_VALUE;
        }

        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public static int removeLast(){
        if(size == 0){
            System.out.println("LinkedList is empty");
            return Integer.MIN_VALUE;
        }

        Node temp = head;
        for(int i = 0; i < size-2; i++){
           temp = temp.next;
        }

        int val = tail.data;
        temp.next = null;
        tail = temp;
        size--;
        return val;
    }

    public static void add(int idx, int data){
        
        if(idx == 0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        int i = 1;
        Node temp = head;
        while(i < idx-1){
            temp = temp.next;
            i++;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    public static void print(){
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

    public static void main(String args[]){
        addFirst(2);
        addLast(3);
        addFirst(1);
        addLast(4);
        print();
        System.out.println(size);
        add(3,5);
        print();
        // removeFirst();
        // removeLast();
        // print();
     System.out.println(size);
      add(4,6);
      print();
       System.out.println(size);
    }
}
