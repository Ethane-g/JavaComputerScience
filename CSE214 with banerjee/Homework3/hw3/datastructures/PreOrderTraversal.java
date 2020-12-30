package com.company.hw3.hw3.datastructures;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ritwik Banerjee
 */
public class PreOrderTraversal<E> extends Traversal<E> {
    List<E> toreturn = new ArrayList<E>();

    /**
     * Returns a list of the elements gone through in a preorder traversal. Calls a helper method to add nodes to a list
     * inside the scope
     * @param tree the tree to be traversed
     * @return a list of elements in preorder traversal
     */
    @Override
    public List<E> of(BinaryTree<E> tree) {
        preorder(tree.root());
        return toreturn;
    }

    /**
     * Helper method for above method. Traverses through the list and adds the current node. Recursion.
     * @param root the node to be iterated through
     */
    public void preorder(BinaryTreeNode root){
        if(root == null){
            return;
        }
        toreturn.add((E) root.element());
        if(root.left()!=null){
            preorder(root.left());
        }
        if(root.right()!=null){
            preorder(root.right());
        }
    }

}
