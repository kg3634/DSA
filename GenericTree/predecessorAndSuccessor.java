/*1. You are given a partially written GenericTree class.
2. You are required to find the preorder predecessor and successor of a given element. Use the "travel and change" 
strategy explained in the earlier video. The static properties have been declared for you. You can declare more if 
you want.
3. Input and Output is managed for you.

Constraints
None */
package DSA.GenericTree;

import java.io.*;

import java.util.*;

public class predecessorAndSuccessor {
  private static class Node {
    int data;
    ArrayList< Node> children = new ArrayList< >();
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

    Stack< Node> st = new Stack< >();
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

  static Node predecessor;
  static Node successor;
  static int state;
  //Logic:images/predecessorAndSuccessor.png
  public static void predecessorAndSuccessor(Node node, int data) {
    //pre order mn state ka use karke prede and succes nikalnge
    if(state ==0){
        if(node.data == data){
            state = 1;
        }else{
            predecessor = node;//jab state first time 1 hogi to pre order mn last value predece hogi
        }
    }else if(state ==1){
        successor = node;//state 1 mn pre order mn data ka next 
        state = 2;//state 2 mn kabi ayega ni
    }
    for(Node child: node.children){
        predecessorAndSuccessor(child, data);
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    int data = Integer.parseInt(br.readLine());

    Node root = construct(arr);
    predecessor = null;
    successor = null;
    state = 0;
    predecessorAndSuccessor(root, data);
    if (predecessor == null) {
      System.out.println("Predecessor = Not found");
    } else {
      System.out.println("Predecessor = " + predecessor.data);
    }

    if (successor == null) {
      System.out.println("Successor = Not found");
    } else {
      System.out.println("Successor = " + successor.data);
    }
  }
}
/*Sample Input

24
10 20 -50 -1 60 -1 -1 30 70 -1 -80 110 -1 -120 -1 -1 90 -1 -1 40 -100 -1 -1 -1
-120

Sample Output
Predecessor = 110
Successor = 90 */
