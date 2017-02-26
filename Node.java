/*
CSCI1102 HW9
Sukwhan Youn
Due Dec. 10, 2016
This program is for HW9 Problem 3 (1/2)
*/

public class Node {
  int data;
  Node small;
  Node large;
  public Node(int data){
    this.data = data;
    small = null;
    large = null;
  }
}