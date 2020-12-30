package com.company.hw3.hw3.datastructures;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ritwik Banerjee
 */
public class PostOrderTraversal<E> extends Traversal<E> {
    List<E> toreturn = new ArrayList<E>();

    /**
     * Postorder traversal of the tree. Puts elements in post order arrangement. Recursive. Uses helper to iterate
     * through tree recursively
     * @param tree to be traversed
     * @return
     */
    @Override
    public List<E> of(BinaryTree tree) {
        postordertraversal(tree.root());
        return toreturn;
    }
    /**
     * Helper method for above method. Traverses through the list and adds the current node. Recursion.
     * @param root the node to be iterated through
     */
    public void postordertraversal(BinaryTreeNode root){
        if(root==null){
            return;
        }
        if(root.left()!=null){
            postordertraversal(root.left());
        }
        if(root.right()!=null){
            postordertraversal(root.right());
        }
        toreturn.add((E) root.element());
    }
}
