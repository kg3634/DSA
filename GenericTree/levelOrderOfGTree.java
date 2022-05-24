/*1. You are given a partially written GenericTree class.
2. You are required to complete the body of levelorder function. The function is expected to visit every node in 
"levelorder fashion". Please check the question video for more details.
3. Input is managed for you.

Constraints
None */
package DSA.GenericTree;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class levelOrderOfGTree extends travarsalOfGtree{
  //Logic: here we would use queue and do remove,print,add childs
  //why: as in queue we add last ,so 3 level child will be added after 2nd level child. and we have to print all level child first
  // so we can remove and print and then add child    
  public static void levelOrder(Node node){
      Queue<Node> q = new ArrayDeque<>();
      q.add(node);

      while(q.size() > 0){
          node = q.remove();//remove
          System.out.print(node.data+" ");//print
          for (Node child:node.children){
              q.add(child);//add ===> would be added at the end
          }
      }

      System.out.print(" ");
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
    levelOrder(root);
  }

}
/*Sample Input

24
10 20 50 -1 60 -1 -1 30 70 -1 80 110 -1 120 -1 -1 90 -1 -1 40 100 -1 -1 -1

Sample Output
10 20 30 40 50 60 70 80 90 100 110 120 . */