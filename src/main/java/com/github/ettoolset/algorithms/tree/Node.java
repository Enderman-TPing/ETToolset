package com.github.ettoolset.algorithms.tree;


import java.util.ArrayList;
import java.util.List;

public class Node{
    private Object value;
    private List<Node> children;

    /**
     * Constructor for a Node instance representing a node in the tree
     * @author Enderman-Teleporting
     * @param value (Object) -> The value of the node
     */
    public Node(Object value) {
        this.value = value;
        this.children = new ArrayList<>();
    }

    /**
     * Set the value of the node
     * @author Enderman-Teleporting
     * @param value (Object) -> The value you want to set the node as
     */
    public void setValue(Object value) {
        this.value = value;
    }

    /**
     * Get the value of the node
     * @author Enderman-Teleporting
     * @return The value of the node
     */

    public Object getValue() {
        return value;
    }

    /**
     * Add a child for the Node
     * @author Enderman-Teleporting
     * @param node (Node) -> The child node you want to add to the current node
     */
    public void addChildren(Node node) {
        this.children.add(node);
    }

    /**
     * Get all the children of the Node
     * @author Enderman-Teleporting
     * @return A Node array of all the children of the current node
     */
    public Node[] getChildren() {
        return this.children.toArray(new Node[0]);
    }
}