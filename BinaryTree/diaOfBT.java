/*Easy

1. You are given a partially written BinaryTree class.
2. You are required to complete the body of diameter1 function. The function is expected to return the number of 
edges between two nodes which are farthest from each other in terms of edges.
3. Input and Output is managed for you.

Constraints
None */
package DSA.BinaryTree;

import java.io.*;
import java.util.*;

public class diaOfBT {
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

  public static int height(Node node) {
    if (node == null) {
      return -1;
    }

    int lh = height(node.left);
    int rh = height(node.right);

    int th = Math.max(lh, rh) + 1;
    return th;
  }

  /*Inefficient Approach:images/diameter1.png
  Logic: max of (left ka dia,right ka dia, dia endpoints on eightside)
  below approach is O(n*n), as in post order one more euler(height) is running,so inefficient approach*/
  public static int diameter1(Node node) {
      if(node == null){
          return 0;
      }  

      int ld = diameter1(node.left);
      int rd = diameter1(node.right);

      int fes = height(node.left) + height(node.right) + 2;//factor eight side

      int dia = Math.max(fes,Math.max(ld,rd));

      return dia;
  }

  //Efficient approach: create a class DiaPair which return dia and ht both. So we are combining both euler into one  
  static class DiaPair{
      int ht;
      int dia;
  }

  public static DiaPair diameter2(Node node){
    if(node == null){
        DiaPair bp = new DiaPair();//base pair
        bp.ht = -1;
        bp.dia = 0;
        return bp;
    }

    DiaPair lp = diameter2(node.left);//left pair faith
    DiaPair rp = diameter2(node.right);//right pair faith

    //in post Order there is no use of euler as we are calculating ht and dia together
    DiaPair mp = new DiaPair();//my pair
    mp.ht = Math.max(lp.ht,rp.ht)+ 1;//height logic,khud ki height calculate kar re h kyuki humare parent ko 
    //dia nikalne ke liye jarurt hogi 

    int fes  = lp.ht + rp.ht + 2;//factor of either side

    mp.dia = Math.max(fes,Math.max(lp.dia,rp.dia));//final dia

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

    // int diameter = 0;
    // diameter = diameter1(root);
    // System.out.println(diameter);
    DiaPair p = diameter2(root);
    System.out.println(p.dia);
  }

}
/*Sample Input

19
50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n

Sample Output
6 */