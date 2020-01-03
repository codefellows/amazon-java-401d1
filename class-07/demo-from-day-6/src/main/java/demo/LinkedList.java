package demo;

import java.util.NoSuchElementException;

public class LinkedList {
    private Node head;
    private Node tail;

    public boolean add (String value){
//        create a new instance of a node class and add it to head
        if(this.head == null){
            this.head = new Node(value);
            this.tail = new Node(value);
        } else {
            Node newNode = new Node(value);
            newNode.setNext(this.tail);
            this.tail = newNode;

            // this allows us to remove the setNext method, making node read-only
//            this.tail = new Node(value, this.tail);

        }

        return true;
    }

    public LinkedList(){
        this.head = null;
    }

    public String toString(){
        // iterate over values and add them together
        String newString = "";
        Node current = this.tail;
        while(current != null){
            // look at the next node and add it to the string

            newString = current.getValue() + " -> " + newString;
            current = current.getNext();
        }

        return newString + " null";
    }

    public String pop(){
        if(this.head == null){
            throw new NoSuchElementException();
        } else if(this.tail.getNext() == null) {
            this.head = null;
            String val = tail.getValue();
            this.tail = this.tail.getNext();
            return val;
        } else {
            String val = tail.getValue();
            this.tail = this.tail.getNext();
            return val;
        }
    }
}
