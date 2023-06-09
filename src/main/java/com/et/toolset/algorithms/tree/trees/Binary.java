package com.et.toolset.algorithms.tree.trees;

import com.et.toolset.algorithms.tree.Node;

public class Binary implements Tree {
    private Node root;

    @Override
    public void setRoot(Node root) {
        this.root=root;
    }
}
