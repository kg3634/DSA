/*1. You are given a partially written BinaryTree class.
2. You are required to find the root of largest sub-tree which is a BST. Also, find the number of nodes in that sub-tree.
3. Input is managed for you. 
Note -> Please refer the question video for clarity.
Constraints
Time complexity must be O(n)
Space should not be more than required for recursion (call-stack) */
package DSA.BinaryTree;

import java.io.*;
import java.util.*;


public class largestBSTSubtree {
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

  public static class Pair {
    Node node;
    int state;

    Pair(Node node, int state) {
      this.node = node;
      this.state = state;
    }
  }

  public static Node construct(Integer[] arr) {
    Node root = new Node(arr[0], null, null);
    Pair rtp = new Pair(root, 1);

    Stack<Pair> st = new Stack<>();
    st.push(rtp);

    int idx = 0;
    while (st.size() > 0) {
      Pair top = st.peek();
      if (top.state == 1) {
        idx++;
        if (arr[idx] != null) {
          top.node.left = new Node(arr[idx], null, null);
          Pair lp = new Pair(top.node.left, 1);
          st.push(lp);
        } else {
          top.node.left = null;
        }

        top.state++;
      } else if (top.state == 2) {
        idx++;
        if (arr[idx] != null) {
          top.node.right = new Node(arr[idx], null, null);
          Pair rp = new Pair(top.node.right, 1);
          st.push(rp);
        } else {
          top.node.right = null;
        }

        top.state++;
      } else {
        st.pop();
      }
    }

    return root;
  }

  public static void display(Node node) {
    if (node == null) {
      return;
    }

    String str = "";
    str += node.left == null ? "." : node.left.data + "";
    str += " <- " + node.data + " -> ";
    str += node.right == null ? "." : node.right.data + "";
    System.out.println(str);

    display(node.left);
    display(node.right);
  }
  
  
  public static class BTSPair2{
    int min;
    int max;
    boolean isBST;
    Node root;
    int size;
  }

  public static BTSPair2 largestBSTSubtree(Node node){
    if(node == null){
        BTSPair2 bp = new BTSPair2();
        bp.min = Integer.MAX_VALUE;
        bp.max = Integer.MIN_VALUE;
        bp.isBST = true;
        bp.root  = null;
        bp.size = 0;
        return bp;
    }
    BTSPair2 lp = largestBSTSubtree(node.left);
    BTSPair2 rp = largestBSTSubtree(node.right);
    BTSPair2 mp = new BTSPair2();
    mp.isBST = lp.isBST && rp.isBST &&
               (node.data >= lp.max && node.data <= rp.min);
    mp.min = Math.min(node.data,Math.min(lp.min,rp.min));
    mp.max = Math.max(node.data,Math.max(lp.max,rp.max));
    if(mp.isBST){
        mp.root = node;
        mp.size = lp.size + rp.size +1;
    }else if(lp.size > rp.size){
        mp.root = lp.root;
        mp.size = lp.size;
    }else{
        mp.root = rp.root;
        mp.size = rp.size;
    }

    return mp;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Integer[] arr = new Integer[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      if (values[i].equals("n") == false) {
        arr[i] = Integer.parseInt(values[i]);
      } else {
        arr[i] = null;
      }
    }

    Node root = construct(arr);
    BTSPair2 gp = largestBSTSubtree(root);
    System.out.println(gp.root.data+"@"+gp.size);
    
  }

}
/*Sample Input

15
50 25 12 n n 37 n n 75 62 n n 87 n n

Sample Output
50@7 */