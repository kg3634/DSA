/*1. You are given a partially written GenericTree class.
2. You are required to complete the body of IsSymmetric function. The function is expected to check if the tree is symmetric, 
if so return true otherwise return false. For knowing symmetricity think of face and hand. Face is symmetric while palm is not. 
Also, we are check only smmetricity of shape and not content. Check the question video for clarity.
3. Input and Output is managed for you.

Constraints
None */
package DSA.GenericTree;

import java.io.*;

public class isGTSymmetric extends areTreesMirrors{

  public static boolean IsSymmetric(Node node) {
    return areMirror(node, node);
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
    boolean sym = IsSymmetric(root);
    System.out.println(sym);
    // display(root);
  }
}
/*Sample Input

20
10 20 50 -1 60 -1 -1 30 70 -1 80 -1 90 -1 -1 40 100 -1 110 -1 -1 -1

Sample Output
true */
