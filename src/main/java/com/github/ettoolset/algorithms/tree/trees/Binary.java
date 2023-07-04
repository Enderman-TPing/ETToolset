package com.github.ettoolset.algorithms.tree.trees;

import com.github.ettoolset.algorithms.tree.Node;

import java.util.ArrayList;
import java.util.List;

public class Binary implements Tree{
    private Node root;

    @Override
    public void setRoot(Object root) {
        if (root instanceof Node) {
            this.root = (Node) root;
        } else {
            throw new IllegalArgumentException("Invalid root type. Expected Node.");
        }
    }

    @Override
    public Object getRoot() {
        return root;
    }

    @Override
    public Object[] ergodic() {
        List<Object> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result.toArray();
    }


    private void inorderTraversal(Node node, List<Object> result) {
        if (node != null) {
            if (node.getChildren().length > 0) {
                inorderTraversal(node.getChildren()[0], result);
            }
            result.add(node.getValue());
            if (node.getChildren().length > 1) {
                inorderTraversal(node.getChildren()[1], result);
            }
        }
    }
}
