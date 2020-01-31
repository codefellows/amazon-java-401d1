package stacksAndQueues;

import java.util.EmptyStackException;
import java.util.StringJoiner;

// my stack of ints
public class Stack <Potato> {
    Node<Potato> top; // int value, Node next

    public <Potato> Stack (){
        this.top = null;
    }

    public void add(Potato value){
        if(this.top == null){
            this.top = new Node<Potato>(value);
        } else {
//            Node oldTop = this.top;
//            this.top = new Node(value);
//            this.top.next = oldTop;
            this.top = new Node<Potato>(value, this.top);
        }
    }

    public Potato pop(){
        // returns the top things on the stack
        Potato val = this.top.value;
        top = top.next;
        return val;
    }

    public String toString(){
        Node current = this.top;
//        StringBuilder stringy = new StringBuilder();
        StringJoiner joinerStringy = new StringJoiner(" -> ");
        while(current != null){
            // Between Here ->
            joinerStringy.add(current.value.toString());
            // <- and here we can do work just like in the  {} of a for loop
            // and expect that current.value will be every value in the linked list once
            // just like we expect arr[i] in a for loop will be every value once
            current = current.next;
        }
        return joinerStringy.toString();
    }

    public Potato peek(){
        // if this.top is null
        if( this.top == null){
            throw new EmptyStackException();
        }
        return this.top.value;
    }
}
