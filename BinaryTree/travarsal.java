/*travarsal - pre,inbetween and post */
package DSA.BinaryTree;

import java.io.*;
import java.util.*;

public class travarsal {
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
  //Logic:images/travarsal.png
  public static void travarsal(Node node){
      if(node == null){
          return;
      }
      System.out.println(node.data+" in Preorder");
      travarsal(node.left);
      System.out.println(node.data+" in Inorder");
      travarsal(node.right);
      System.out.println(node.data+" in Postorder");
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
    travarsal(root);

  }

}
/*Sample Input

19
50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n

Sample Output
50 in Preorder
25 in Preorder
12 in Preorder
12 in Inorder
12 in Postorder
25 in Inorder
37 in Preorder
30 in Preorder
30 in Inorder
30 in Postorder
37 in Inorder
37 in Postorder
25 in Postorder
50 in Inorder
75 in Preorder
62 in Preorder
62 in Inorder
70 in Preorder
70 in Inorder
70 in Postorder
62 in Postorder
75 in Inorder
87 in Preorder
87 in Inorder
87 in Postorder
75 in Postorder
50 in Postorder
 */
