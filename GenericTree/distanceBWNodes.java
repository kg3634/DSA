/*1. You are given a partially written GenericTree class.
2. You are required to complete the body of distanceBetweenNodes function. The function is expected to return the distance 
(in terms of number of edges) between two nodes in a generic tree.
Please watch the question video to understand what lca is.
3. Input and Output is managed for you.

Constraints
None */
package DSA.GenericTree;

import java.io.*;
import java.util.ArrayList;

public class distanceBWNodes extends lowestCommonAncester{
  //Logic:images/distanceBWNodes.png
  //same like lca , we will get the node to root path and jaha per lca mil raha hoga
  //uske index kp add kar denege. 
  public static int distanceBetweenNodes(Node node, int d1, int d2){
      ArrayList<Integer> p1 = nodeToRootPath(node, d1);
      ArrayList<Integer> p2 = nodeToRootPath(node, d2);

      int i = p1.size() - 1;
      int j = p2.size() - 1;

      while(i >= 0 && j >=0 && p1.get(i) == p2.get(j)){
        i--;
        j--;
      }

      return (i+1+j+1);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    int d1 = Integer.parseInt(br.readLine());
    int d2 = Integer.parseInt(br.readLine());

    Node root = construct(arr);
    int dist = distanceBetweenNodes(root, d1, d2);
    System.out.println(dist);
    // display(root);
  }
}
/*Sample Input

24
10 20 50 -1 60 -1 -1 30 70 -1 80 110 -1 120 -1 -1 90 -1 -1 40 100 -1 -1 -1
100
110

Sample Output
5 */
