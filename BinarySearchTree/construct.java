/*Binary Search Tree Basics:
 a)Condition to be BST: 1• It should be a Binary Tree, i.e. each node can have at most 2 children. 
 2• The data of all the nodes to the left of any node should be lesser than the data of that node. 
 3• The data of all the nodes to the right of any node should be greater than the data of that node.

b) search faster: images/BSTSearch.png
c) TC- O(log n ): n ==> n/2 ==> n/4 ==>n/8
d) BST vs BT
images/BSTVSBT.png
Note: for construct based questions both are same but for value based questions they are different. for Dia they are same
 */
package DSA.BinarySearchTree;

import java.util.*;

public class construct {
  public static class Node {
    int data;
    Node left;
    Node right;


    Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

  }
 
  public static Node construct(int[] arr,int lo,int hi) {
    //Logic:images/construct.png
    if(lo > hi){
        return null;
    }

    int mid = ( lo + hi ) / 2;
    
    int data  = arr[mid];
    Node lc = construct(arr, lo , mid-1);
    Node rc = construct(arr, mid+1, hi);

    Node node = new Node(data,lc,rc);

    return node;

  }

  public static void display(Node node) {
    if (node == null) {
      return;
    }

    String str = " <- " + node.data + " -> ";

    String left = (node.left == null) ? "." :  "" + node.left.data;
    String right = (node.right == null) ? "." : "" + node.right.data;

    str = left + str + right;

    System.out.println(str);

    display(node.left);
    display(node.right);
  }

  public static void main(String[]args) {
    int [] arr = {12,25,37,50,62,75,87};

    Node root = construct(arr,0,arr.length -1);
    display(root);

  }
}
