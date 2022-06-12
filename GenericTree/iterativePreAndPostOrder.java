/*1. You are given a partially written GenericTree class. 2. You are require to complete the body of function 
IterativePreandPostOrder. The function does not use recursion and prints preorder and postorder of the tree. Both 
orders are printed in separate lines (preorder first, followed by post order in next line). Elements in an order 
are separated by space. 3. Input and Output is managed for you.


Constraints
None */
package DSA.GenericTree;

import java.io.*;
import java.util.*;

public class iterativePreAndPostOrder {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }

  //Logic:images/prepostOrder.png
  //create pair class with node and state: 
  //if state == -1 ,print pre order and ++state,else if state == size of children,print post order and pop
  // for 0 to children(size) -1 , push child and ++ state;    
  static class Pair{
      Node node;
      int state;

      Pair(Node node, int state){
          this.node = node;
          this.state = state;
      }
  }
  public static void IterativePreandPostOrder(Node node) {
    Stack<Pair> st = new Stack<>();
    st.push(new Pair(node,-1));

    String pre = "";
    String post = "";
    while(st.size() >0){
        Pair top = st.peek();

        if(top.state == -1){
            pre += top.node.data + " ";
            top.state++;
        }else if (top.state == top.node.children.size()){
            post += top.node.data + " ";
            st.pop();
        }else{
            Pair cp = new Pair(top.node.children.get(top.state),-1);
            st.push(cp);
            top.state++;
        }
    }

    System.out.println(pre);
    System.out.println(post);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    Node root = construct(arr);
    IterativePreandPostOrder(root);
  }
}
/*Sample Input

24
10 20 -50 -1 60 -1 -1 30 70 -1 -80 110 -1 -120 -1 -1 90 -1 -1 40 -100 -1 -1 -1

Sample Output
10 20 -50 60 30 70 -80 110 -120 90 40 -100 
-50 60 20 70 110 -120 -80 90 30 -100 40 10 */
