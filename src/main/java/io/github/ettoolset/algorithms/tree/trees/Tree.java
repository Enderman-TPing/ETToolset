package io.github.ettoolset.algorithms.tree.trees;


@SuppressWarnings("unused")
public interface Tree{
    /**
     * Set the root node of the tree
     * @author Enderman-Teleporting
     * @param root (Node) -> The root node of the tree
     */
    public void setRoot(Object root);

    /**
     * Get the root node of the tree
     * @return The root node of the tree
     */
    public Object getRoot();

    /**
     * The ergodic result of the tree (preorder for MultiTree, inorder for Binary)
     * @return An object array in the order of the ergodic result of the tree
     */
    public Object[] ergodic();
}