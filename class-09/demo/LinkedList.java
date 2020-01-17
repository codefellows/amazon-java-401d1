import java.util.StringJoiner;

public class LinkedList {
    Node head;
    static String description = "All linked lists are cool";

    public static void main(String[] args) {
        // countdown(5);
        LinkedList list = new LinkedList();
        list.insert(3);
        list.insert(2);
        list.insert(1);
        System.out.println(list.size() + " (should be 3)");

        LinkedList list2 = new LinkedList();
        list2.insert(14);
        list2.insert(13);
        list2.insert(12);
        list2.insert(11);
        System.out.println(list2.size() + " (should be 4)");

        LinkedList list3 = LinkedList.merge(list, list2);
        System.out.println(list3);

        // badRecursion();
        // countdown(5);
        // countdown(0);


    }

    public int size() {
        // int count = 0;
        // Node current = this.head;
        // while(current != null){
        //     count++;
        //     current = current.next;
        // }
        // return count;
        return size(this.head);
    }

    private int size(Node current){
        if(current == null){
            return 0;
        }else{
            // return 1 + size(current.next);
            int mySize = 1;
            int theRestOfMyNextNodesSize = size(current.next);
            System.out.println(mySize + theRestOfMyNextNodesSize);
            return mySize + theRestOfMyNextNodesSize;
        }
    }

    public void insert(int value) {
        this.head = new Node(value, this.head);
    }

    public String toString() {
        StringJoiner answer = new StringJoiner("->");
        Node current = head;
        while(current != null) {
            answer.add("" + current.value);
            current = current.next;
        }
        return answer.toString();
    }

    public static LinkedList merge(LinkedList list1, LinkedList list2) {
        // if (list1.head == null) {
        //     return list2;
        // }
        // Node current1 = list1.head;
        // Node current2 = list2.head;
        // while (current1 != null && current2 != null) {
        //     Node temp = current1.next;
        //     Node temp2 = current2.next;
        //     if (current1.next != null) {
        //         current2.next = current1.next;
        //     }
        //     current1.next = current2;
        //     current1 = temp;
        //     current2 = temp2;
        // }
        // return list1;
        LinkedList newList = new LinkedList();
        newList.head = merge(list1.head, list2.head);
        return newList;

        // list1.head = = merge(list1.head, list2.head);
        // return list1;
    }

    private static Node merge(Node node1, Node node2){
        if(node1 == null){
            return node2;
        } else{
            node1.next = merge(node2, node1.next);
            return node1;
        }
    }



    public static void badRecursion(){
        badRecursion();
    }

    public static void countdown(int n){
        // base case (the simplest problem we are trying to tackle)
        if(n == 0){
            // do nothing

        // recursive case (the things we do to make our problem more specific, amaller, or just simply closer to the base case)
        } else {
                System.out.println(n);
                countdown(n - 1);

        }
    }

  

}
