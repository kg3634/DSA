/*1. You are given a partially written BinaryTree class.
2. You are required to complete the body of iterativePrePostInTraversal function. The function 
is expected to print pre order, in order and post order of the tree in separate lines (first pre, 
then in and finally post order). All elements in an order must be separated by a space.
3. Input is managed for you.

Constraints
None */
package DSA.BinaryTree;

import java.io.*;
import java.util.*;

public class iterativePreInPost {
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

  public static void iterativePrePostInTraversal(Node node) {
      Stack<Pair> st = new Stack<>();
      Pair rtp = new Pair(node,1);
      st.push(rtp);

      String pre ="";
      String in = "";
      String post = "";

      while(st.size()>0){
          Pair top = st.peek();
          if(top.state == 1){//pre,s++,left
            pre += top.node.data +" ";
            top.state++;

            if(top.node.left != null){
                Pair lp = new Pair(top.node.left,1);
                st.push(lp);
            }
          }else if (top.state == 2){//in,s++,right ==> left mn hoke a chuka
            in += top.node.data +" ";
            top.state++;

            if(top.node.right != null){
                Pair rp = new Pair(top.node.right,1);
                st.push(rp);
            }
          }else{//post,pop ==> left right mn hokar a chuka
            post += top.node.data+" ";  
            st.pop();
          }
      }

      System.out.println(pre);
      System.out.println(in);
      System.out.println(post);

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
    iterativePrePostInTraversal(root);
  }

}
/*Sample Input

19
50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n

Sample Output
50 25 12 37 30 75 62 70 87 
12 25 30 37 50 62 70 75 87 
12 30 37 25 70 62 87 75 50 */