package breadthfirst;

public class Tree {
    Node root;

    // make it private because it is just a vessel. It holds things, users don't need to ever interact with nodes
    private class Node {
        int value;
        Node left;
        Node right;
    }
}
    
