class Intersect {
    // Function to find intersection point in Y shaped Linked Lists.
    static Node intersectPoint(Node head1, Node head2) {
        // Get the lengths of both lists
        int size1 = getLength(head1);
        int size2 = getLength(head2);
        
        // Calculate the difference in lengths
        int sizeDiff = Math.abs(size1 - size2);
        
        // Move the longer list's pointer forward by the difference
        if (size1 > size2) {
            head1 = movePointer(head1, sizeDiff);
        } else {
            head2 = movePointer(head2, sizeDiff);
        }
        
        // Find the intersection point
        return findIntersection(head1, head2);
    }
    
    // Helper function to get the length of a linked list
    static int getLength(Node head) {
        int length = 0;
        Node temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }
    
    // Helper function to move a pointer forward by 'steps' steps
    static Node movePointer(Node head, int steps) {
        Node temp = head;
        for (int i = 0; i < steps && temp != null; i++) {
            temp = temp.next;
        }
        return temp;
    }
    
    // Helper function to find the intersection point of two lists of equal length
    static Node findIntersection(Node head1, Node head2) {
        Node temp1 = head1;
        Node temp2 = head2;
        
        while (temp1 != temp2) {
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        
        return temp1; // This will be either the intersection point or null
    }
}