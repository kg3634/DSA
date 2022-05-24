/*1. You are given a partially written GenericTree class. 2. You are required to complete the body of max function. 
The function is expected to find the node with maximum value and return it. 3. Input and Output is managed for you.

Constraints
None */
package DSA.GenericTree;

import java.io.*;

import java.util.*;

public class maxInGTree {
  public static class Node {
    int data;
    ArrayList< Node> children = new ArrayList< >();
    
    Node(){
    }
    Node(int data){
      this.data = data;
    }    
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

  public static int size(Node node) {
    int s = 0;

    for (Node child : node.children) {
      s += size(child);
    }
    s += 1;

    return s;
  }

  //images/maxInGTree.png
  // E of max(root10) = F of max[max(20),max(30),max(40)]
  //final max = max of (root10,max(20),max(30),max(40))
  //analyse euler path and keep in mind that outer value is max value and node.data is different, so in the end we also have to compare
  // max with node.data
  public static int max(Node node) {
      int max = Integer.MIN_VALUE;// -infinite man liya h 

      for(Node child:node.children){
          int cm = max (child);//faith ki ye max nikal ke layega for childs
          if(cm > max){
              max = cm;
          }
      }

      if(node.data > max){//final max = max of node, max(got it from recursion)
          max = node.data;
      }

      return max;

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
    int m = max(root);
    System.out.println(m);
    // display(root);
  }

}
/*Sample Input

12
10 20 -1 30 50 -1 60 -1 -1 40 -1 -1

Sample Output
60 */