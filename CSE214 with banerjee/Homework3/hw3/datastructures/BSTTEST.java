package com.company.hw3.hw3.datastructures;

import java.util.LinkedList;
import java.util.List;

public class BSTTEST {
    public static void main(String[] args) {
        List<Integer> toadd = new LinkedList();
        toadd.add(1);
        toadd.add(4);
        toadd.add(6);
        toadd.add(7);
        toadd.add(9);
        toadd.add(2);
        toadd.add(0);
        BinaryTree<Integer> alpha = new BinarySearchTree<>(toadd);

        List<BinaryTreeNode<Integer>> bruh = alpha.find(4);
//        for(int i=0;i<bruh.size();i++){
//            System.out.println(bruh.get(i).element());
//        }
        alpha.remove(4);
        alpha.find(6);
        List<BinaryTreeNode<Integer>> bruh2 = alpha.find(4);
        System.out.println(bruh);
        System.out.println(bruh2);
        System.out.println(alpha.find(6));

    }
    public static void traverse(BinaryTreeNode root){
            if(root.left()!=null){
                traverse(root.left());
            }
            System.out.println(root.element());
            if(root.right()!=null){
                traverse(root.right());

        }
    }
}
