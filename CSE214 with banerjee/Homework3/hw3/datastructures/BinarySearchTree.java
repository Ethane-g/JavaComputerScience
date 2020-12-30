package com.company.hw3.hw3.datastructures;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Ritwik Banerjee
 */
public class BinarySearchTree<T extends Comparable<T>> implements BinaryTree<T> {
    
    private BinaryTreeNode<T> root;
    private int               size;

    /**
     * !!DO NOT MODIFY THIS CODE!!
     * Consrtucts a binary search tree consisting of items from the given collection. Duplicates in the collection are
     * ignored, i.e., every item will be considered only once for the tree being constructed.
     *
     * @param collection the given collection
     */
    public BinarySearchTree(Collection<T> collection) {
        this();
        for (T t : collection)
            add(t);
    }
    
    /**
     * !!DO NOT MODIFY THIS CODE!!
     * Constructs an empty binary search tree.
     */
    private BinarySearchTree() {
        root = null;
        size = 0;
    }

    /**
     * adds the element to the binary tree in accordance to lecture algorithm. Uses the compareTo method to ascertain
     * whether the element is lesser or greater than the current node, we traverse until the node has been placed. If
     * the element is found, we throw an error that shows that we have a copy of the element that is being added.
     * Assigns parent nodes to the added item.
     * @param t the element to be added.
     */
    @Override
    public void add(T t) {
        BinaryTreeNode<T> toAdd = new BinaryTreeNode(t);
        if(root == null){
            root= toAdd;
            root.setParent(null);
        }
        else{
            boolean beenAdded = false;
            BinaryTreeNode<T> pointer = root;
            while(!beenAdded) {
                int a = t.compareTo(pointer.element());
                if(a==-1){
                    if(pointer.left()==null){
                        pointer.setLeft(toAdd);
                        toAdd.setParent(pointer);
                        beenAdded = true;
                        size+=1;
                    }
                    else{
                        pointer = pointer.left();
                    }

                }
                if(a==1){
                    if(pointer.right()==null){
                        pointer.setRight(toAdd);
                        toAdd.setParent(pointer);
                        beenAdded = true;
                        size+=1;
                    }
                    else{
                        pointer = pointer.right();
                    }
                }
                if(a == 0){
                    throw new IllegalArgumentException("you cannot have two elements with the same price");
                }
            }
        }
    }

    /**
     * Uses the findhelp method to locate the desired item. Once it is found, use one of three methods of deletion
     * depending on the number of children. If no children, then remove parent's reference to given node. If one child,
     * attach the removed node's children to the parent. if 2 children, then replace removed with strictly greater node
     * and delete the node that is being swapped.
     * reattached
     * @param t node to be removed
     */
    @Override
    public void remove(T t) {
        Boolean isthere = findhelperhelper(t);
        if(isthere==false){
            return;
        }
        BinaryTreeNode<T> item = findhelper(t);
        if(item.left()==null&&item.left()==null&&item.parent()!=null){
            if(item.parent().element().compareTo(item.element())==1){
                item.parent().setLeft(null);
                size--;
            }
            if(item.parent().element().compareTo(item.element())==-1){
                item.parent().setRight(null);
                size--;
            }
            return;
        }
        else if((item.left()!=null||item.right()!=null)&&!(item.left()!=null&&item.right()!=null)&&item.parent()!=null){
            BinaryTreeNode parent = item.parent();
            if(parent.right().element().equals(item.element())){
                if(item.right()!=null){
                    parent.setRight(item.right());
                    item.right().setParent(item.parent());
                    size--;
                }
                if(item.left()!=null){
                    parent.setRight(item.left());
                    item.left().setParent(item.parent());
                    size--;
                }
            }
            else if(parent.left().element().equals(item.element())&&item.parent()!=null){
                if(item.right()!=null){
                    parent.setLeft(item.right());
                    item.right().setParent(item.parent());
                    size--;
                }
                if(item.left()!=null){
                    parent.setLeft(item.left());
                    item.left().setParent(item.parent());
                    size--;
                }
            }
        }
        else{
            //find min in right subtree replace node that is being deleted with said node
            //item will be removed
            BinaryTreeNode<T> temp = item;
            if(item.right()!=null){
                temp = temp.right();
            }
            while(temp.left()!=null){
                temp = temp.left();
            }
            item.setElement(temp.element());
            if(item.left()==null&&item.left()==null&&item.parent()!=null){
                if(item.parent().element().compareTo(item.element())==1){
                    item.parent().setLeft(null);
                    size--;
                }
            }
            else{
                BinaryTreeNode parent = item.parent();
                parent.setLeft(item.right());
                item.right().setParent(item.parent());
                size--;
            }
            item = temp;
        }
    }
    public boolean findhelperhelper(T t){
        BinaryTreeNode<T> pointer = this.root;
        boolean finding=false;
        while(!finding) {
            int a = t.compareTo(pointer.element());
            if(a < 0){
                pointer = pointer.left();
            }
            if(a > 0){
                pointer = pointer.right();
            }
            if(a == 0){
                finding = true;
            }
        }
        return finding;
    }
    public BinaryTreeNode findhelper(T t){
        BinaryTreeNode<T> pointer = this.root;
        boolean finding=false;
        while(!finding) {
            int a = t.compareTo(pointer.element());
            if(a < 0){
                pointer = pointer.left();
            }
            if(a > 0){
                pointer = pointer.right();
            }
            if(a == 0){
                finding = true;
            }
        }
        return pointer;
    }
    
    /**
     * Returns the search path that starts at the root node of the tree, and ends at the node containing the specified
     * item. If such a node exists in the tree, it is the last object in the returned list. Otherwise, this method will
     * still return the path corresponding to the search for this item, but append a <code>null</code> element at the
     * end of the list.
     *
     * @param t the specified item
     * @return the search path, with a node containing the specified item as the last object in the list if the item is
     * found in the tree, and the <code>null</code> node if item is not found in the tree.
     */
    @Override
    public List<BinaryTreeNode<T>> find(T t) {
        List<BinaryTreeNode<T>> elements =new LinkedList<BinaryTreeNode<T>>();
        BinaryTreeNode<T> pointer = root;
        boolean looking = false;
        while(!looking){
            elements.add(pointer);
            if(pointer== null){
                break;
            }
            int a = pointer.element().compareTo(t);
            if(a > 0){
                pointer = pointer.left();
                continue;
            }
            if(a < 0){
                pointer = pointer.right();
                continue;
            }
            if(a==0){
                looking = true;
            }
        }
        return elements;
    }
    
    /**
     * !!DO NOT MODIFY THIS CODE!!
     */
    @Override
    public void print() {
        root.print();
    }
    
    /**
     * !!DO NOT MODIFY THIS CODE!!
     *
     * @return the root node of this tree
     */
    @Override
    public BinaryTreeNode<T> root() {
        return root;
    }
    
    /**
     * !!DO NOT MODIFY THIS CODE!!
     *
     * @return the size, i.e., the number of nodes in this tree
     */
    @Override
    public int size() {
        return size;
    }
}