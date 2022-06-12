package DSA.GenericTree;

import java.io.*;

import java.util.*;

public class kthLargest {
  private static class Node {
    int data;
    ArrayList< Node> children = new ArrayList<>();
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

    Stack< Node> st = new Stack<>();
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


  static int floor;
  public static void ceilAndFloor(Node node, int data) {
    if (node.data < data) {
      if (node.data > floor) {
        floor = node.data;
      }
    }

    for (Node child : node.children) {
      ceilAndFloor(child, data);
    }
  }

  //Logic:images/kthLargest.png
  public static int kthLargest(Node node, int k) {
    floor = Integer.MIN_VALUE;//largest amoung smaller
    int factor = Integer.MAX_VALUE;//thisi is data - would be providing largest element first
    for(int i=0 ;i<k;i++){//k times floor nikalnege, kth largest floor mil jyega
        ceilAndFloor(node, factor);//will set floor, first time it would give largest and then seconda largest and so on
        factor = floor;
        floor = Integer.MIN_VALUE;//resetting it 
    }

    return factor;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    int k = Integer.parseInt(br.readLine());

    Node root = construct(arr);
    int kthLargest = kthLargest(root, k);
    System.out.println(kthLargest);
  }
}
/*Sample Input

24
10 20 -50 -1 60 -1 -1 30 70 -1 -80 110 -1 -120 -1 -1 90 -1 -1 40 -100 -1 -1 -1
8

Sample Output
10 */