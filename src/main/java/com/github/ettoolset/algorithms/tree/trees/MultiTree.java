package com.github.ettoolset.algorithms.tree.trees;

import com.github.ettoolset.algorithms.tree.Node;

import java.util.ArrayList;
import java.util.List;

public class MultiTree implements Tree{
    private Node root;
    @Override
    public void setRoot(Object root) {
        if (root instanceof Node) {
            this.root = (Node) root;
        } else {
            throw new IllegalArgumentException("Invalid root node");
        }
    }
    @Override
    public Object getRoot() {
        return this.root;
    }
    @Override
    public Object[] ergodic() {
        List<Object> result = new ArrayList<>();
        preorderTraversal(this.root, result);
        return result.toArray();
    }


    private void preorderTraversal(Node node, List<Object> result) {
        if (node != null) {
            result.add(node.getValue());
            if (node.getChildren()!= null) {
                for (Node child : node.getChildren()) {
                    preorderTraversal(child, result);
                }
            }
        }
    }
}
