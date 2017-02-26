/*
CSCI1102 HW9
Sukwhan Youn
Due Dec. 10, 2016
This program is for HW9 Problem 3 (2/2)
*/

import java.lang.*;
import java.util.*;

class TreeList {
   static ArrayList<Integer> treeValList = new ArrayList<Integer>();
   public static void join(Node a, Node b) {
     a.large = b;
     b.small = a;
   }
   
   public static Node buildLinkedList(List<Integer> array) {
     Node first = new Node(array.get(0));
     Node firstCopy = new Node(array.get(0));
     Node theNode = first;
     Node largestNode = first;
     
     for(int i = 1; i < array.size(); i++) {
       Node oneNode = new Node(array.get(i));
       theNode.large = oneNode;
       oneNode.small = theNode;
       theNode = theNode.large;
     }
     
     for (Node x = first; x!=null; x = x.large){
       if (x.data > largestNode.data){
         largestNode=x;
       }
     }
     join(largestNode,first);   
     return first; 
   }
   
   public static void treeInsert(Node root, int newData) {
     if (root.data >= newData){
       if (root.small != null) {
         treeInsert(root.small, newData);
       }
       else root.small = new Node(newData);
     }
     else{
       if (root.large !=null){
         treeInsert(root.large, newData);
       }
       else root.large = new Node(newData);
     }
   }
   
//      if (root.data < newData){
//        while (root.large != null){
//          root = root.large;
//        }
//        root.large = new Node(newData);
//      }
//      else if (root.data >= newData){
//        while (root.small !=null){
//          root = root.small;
//        }
//        root.small = new Node(newData);
//      }
//    }
   
   public static void TraverseTree(Node root) {
     if (root==null) return;
     TraverseTree(root.small);
     String tempData = root.data + " ";
     System.out.print(tempData);
     treeValList.add(root.data);
     TraverseTree(root.large);
   }
   
   public static void printList(Node head) {
     int headData = head.data;
     do {
       String temp = head.data + " ";
       System.out.print(temp);
       head = head.large;
     } while (headData != head.data);
     
     System.out.println();
   }
   
   public static void main(String[] args) {
     Node root = new Node(4);
     treeInsert(root, 2);
     treeInsert(root, 1);
     treeInsert(root, 3);
     treeInsert(root, 5);
     
     System.out.print("Binary Tree:");
     TraverseTree(root);  
     System.out.println();
     
     System.out.print("LinkedList: ");
     Node root1 = buildLinkedList(treeValList);
     printList(root1);   
     
//        for(Node traverse = root1; traverse.large != null; traverse = traverse.large) {
//          System.out.print(traverse.data + " ");
   }
}