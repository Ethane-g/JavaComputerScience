package com.company.hw3.hw3.datastructures;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ritwik Banerjee
 */

public class InOrderTraversal<E> extends Traversal<E> {
    List<E> toreturn = new ArrayList<E>();

    /**
     * Inorder traversal of the parameter tree. Puts elements into a List which is then returned. Calls a helper method
     * to recursively add elements to the list
     * @param tree to travers
     * @return a list of nodes in inorder order
     */
    @Override
    public List<E> of(BinaryTree<E> tree) {
        if(tree.root()!=null){
            inorder(tree.root());
        }
        return toreturn;
    }


    /**
     * Helper method for above method. Traverses through the list and adds the current node. Recursion.
     * @param root the node to be iterated through
     */
    public void inorder(BinaryTreeNode root){
        if(root.left()!=null){
            inorder(root.left());
        }
        toreturn.add((E) root.element());
        if(root.right()!=null){
            inorder(root.right());
        }
    }
}
