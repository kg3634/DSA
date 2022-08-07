/*1. You are given a partially written BST class.
2. You are required to complete the body of remove function. "remove" function is expected to remove a new node 
with given data to the tree and return the new root.
3. Input and Output is managed for you. 

Note -> Please watch the question video to figure out the algorithm required for deletion. It specifies some 
requirements of the question as well.

Constraints
None */
package DSA.BinarySearchTree;

import java.io.*;
import java.util.*;

public class removeNode {
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

  public static int max (Node node){
    if(node.right != null){
        return max(node.right);
    }else{
        return node.data;
    }
  }
  public static Node remove(Node node, int data) {
    if( node == null){
        return null;
    }
    if( data > node.data){
        node.right = remove(node.right, data);
    }else if(data < node.data){
        node.left = remove(node.left, data);
    }else{//when we found the node,there coudl be 3 cases:
        if(node.left != null && node.right != null ){/*case:1, when node has 2 child
            we will find max of left and replace the node with it, then remove same max from node left, 
            which max we are removing it wont be containing any node to its right beacuse it is max itself 
            which itself wound be on right*/ 
            int lmax = max(node.left);
            node.data = lmax;
            node.left = remove(node.left,lmax);
            return node;
        }else if(node.left != null){//single child case: remove indirectly by (node = node.left)
            return node.left;
        }else if(node.right!=null){//single child case
            return node.right;
        }else {//0 child case: direct remove by node = null
            return null;
        }
    }

    return node;
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

    int data = Integer.parseInt(br.readLine());

    Node root = construct(arr);
    root = remove(root, data);

    display(root);
  }

}
/*Sample Input

15
50 25 12 n n 37 n n 75 62 n n 87 n n
62

Sample Output
25 <- 50 -> 75
12 <- 25 -> 37
. <- 12 -> .  
. <- 37 -> .  
. <- 75 -> 87 
. <- 87 -> .   */