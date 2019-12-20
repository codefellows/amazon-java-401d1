package demo;

public class Node {
    private String value;
    private Node next;

    public Node(String value){
        this.value = value;
        this.next = null;
    }

    public Node(String value, Node nextNode){
        this.value = value;
        this.next = nextNode;
    }

    // this could be removed because of the overloaded constructor
    public void setNext(Node nextNode){
        this.next = nextNode;
    }

    public String getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }
}
