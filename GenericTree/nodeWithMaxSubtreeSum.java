/*1. You are given a partially written GenericTree class.
2. You are required to find and print the node which has the subtree with largest sum. Also print the sum of the 
concerned subtree separated from node's value by an '@'. Refer the question video for clarity.
3. Input is managed for you.

Constraints
None */
package DSA.GenericTree;

import java.io.*;
import java.util.*;

public class nodeWithMaxSubtreeSum {
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
  
  //Logic:images/nodeWithMaxSubtreeSum.png
  //Note: return sum kara re h but calculate max sum and max node rahe h ==> new technique
  static int msn = 0;
  static int ms = Integer.MIN_VALUE;
  public static int retSumWithMsnAndMs(Node node){
      int sum = 0 ;
      for(Node child:node.children){
        int cms = retSumWithMsnAndMs(child);
        sum+=cms;
      }

      sum+=node.data;//adding itself

      if(sum > ms){
          ms = sum;//changing heap varables
          msn = node.data;
      }

      return sum;

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
    retSumWithMsnAndMs(root);
    System.out.println(msn+"@"+ms);
  }
}
/*Sample Input

20
10 20 -50 -1 60 -1 -1 30 -70 -1 80 -1 90 -1 -1 40 -100 -1 -1 -1

Sample Output
30@130 */