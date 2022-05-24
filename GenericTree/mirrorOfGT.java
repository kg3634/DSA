/*1. You are given a partially written GenericTree class.
2. You are required to complete the body of mirror function. The function is expected to create a mirror image of the tree. 
For more details, check out the question video.
3. Input and Output is managed for you.

Constraints
None */
package DSA.GenericTree;
import java.io.*;
import java.util.*;

public class mirrorOfGT extends levelOrderLineWiseGT {
  /*Question:mirrorGtQuestion.png
  Logic: images/mirrorGT.png
  ● Set Expectation : We expect that if we input a generic tree, then the output should be its mirror tree.
  ● Build Faith : we have faith that we can make mirror trees for the 3 highlighted sub trees with roots 20, 30 and 40.
  ● Expectation meets Faith : we need to change the positions of the children of the root node. The families of these sub trees s
  hould get reversed for getting the desired output. We had already mirrored 20, 30 and 40. By reversing their families, 
  the family of 10 will get mirrored too.*/
  public static void mirror(Node node){
      for (Node child:node.children){
          mirror(child);
      }
      Collections.reverse(node.children);
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
    display(root);
    mirror(root);
    display(root);
  }

}

/*Sample Input

24
10 20 50 -1 60 -1 -1 30 70 -1 80 110 -1 120 -1 -1 90 -1 -1 40 100 -1 -1 -1

Sample Output
10 -> 20, 30, 40, .
20 -> 50, 60, .
50 -> .
60 -> .
30 -> 70, 80, 90, .
70 -> .
80 -> 110, 120, .
110 -> .
120 -> .
90 -> .
40 -> 100, .
100 -> .
10 -> 40, 30, 20, .
40 -> 100, .
100 -> .
30 -> 90, 80, 70, .
90 -> .
80 -> 120, 110, .
120 -> .
110 -> .
70 -> .
20 -> 60, 50, .
60 -> .
50 -> . */