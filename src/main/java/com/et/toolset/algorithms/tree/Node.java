package com.et.toolset.algorithms.tree;

import com.et.toolset.algorithms.tree.trees.Tree;

public class Node {
    private Object originalObjValue;
    public Node(Object obj){this.originalObjValue=obj;}

    public static void addSon(Node son){

    }
    public static void addSons(Node[] sons){

    }
    public Node[] getSons(){
        return new Node[]{};
    }
    public Node getFather(Tree tree){
        return new Node("");
    }

    public Object getValue(){
        return originalObjValue;
    }

    @Override
    public String toString(){
        return getValue().toString();
    }

}
