/*1. You are given a partially written GenericTree class.
2. You are required to complete the body of height function. The function is expected to find the height of tree. 
Depth of a node is defined as the number of edges it is away from the root (depth of root is 0). Height of a tree is 
defined as depth of deepest node.
3. Input and Output is managed for you.

Constraints
None */
package DSA.GenericTree;

import java.io.*;

public class heightOfGTree extends maxInGTree{

  public static int height(Node node) {
      int ht = -1;//edges ki term mn nikal re h isliye -1 otherwise for single node it will print ht as 1 but it shoudl be zero
      // if we have to calculate in terms of node, then ht = 0 ; 
      for(Node child: node.children){
          int ch = height(child);
          ht = Math.max(ch,ht);
      }

      ht +=1;
      return ht;
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
    int h = height(root);
    System.out.println(h);
    // display(root);
  }
}
/*Sample Input

12
10 20 -1 30 50 -1 60 -1 -1 40 -1 -1

Sample Output
2 */
