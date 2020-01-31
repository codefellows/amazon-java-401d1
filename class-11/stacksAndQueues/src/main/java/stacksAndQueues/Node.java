package stacksAndQueues;

public class Node <WonderWoman> {
    WonderWoman value;
    Node<WonderWoman> next;


    // overload the constructor to get multiple different behaviors
    public Node(WonderWoman value, Node<WonderWoman> next) {
        this.value = value;
        this.next = next;
    }

    public Node(WonderWoman value){
        this(value, null);
    }

    public Node(){

    }
}


