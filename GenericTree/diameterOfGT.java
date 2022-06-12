/*1. You are given a partially written GenericTree class.
2. You are required to find and print the diameter of tree. THe diameter is defined as maximum number of edges 
between any two nodes in the tree. Check the question video for clarity.
3. Input is managed for you.

Constraints
None */
package DSA.GenericTree;

import java.io.*;
import java.util.*;

public class diameterOfGT {
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

  //calculating Dia but returning height
  //Logic:images/diaOfGT.png:calculating for every childs [deepest and seconddeept +2] as max dia also can pass only though child subtree, 
  //not always from root
  static int dia = 0;
  public static int calculateDiaReturnHeight(Node node){
    int dch = -1;//deepest child
    int sdch  = -1;//second deepest child
    for(Node child:node.children){
        int ch = calculateDiaReturnHeight(child);

        if(ch > dch){//change value of both deepest and seconda deepest
            dch = ch;
            sdch = dch;
        }else if(ch > sdch){//change only second deepest
            sdch = ch;
        }
    }

    int cand = dch +sdch +2;//both child will be 1 edge away so added 2

    if(cand > dia){//chnaging value of dia; taking max
        dia  = cand;
    }

    dch+=1;//returning 0 for single node
    return dch;
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
    calculateDiaReturnHeight(root);
    System.out.println(dia);
  }
}
/*Sample Input

20
10 20 -50 -1 60 -1 -1 30 -70 -1 80 -1 90 -1 -1 40 -100 -1 -1 -1

Sample Output
4 */