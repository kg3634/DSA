package DSA.GenericTree;

import java.io.*;
import java.util.ArrayList;

public class lowestCommonAncester extends nodeToRootPath{
  //Logic:images/lca.png
  //node to root path nikal lenge dono nodes ke liye then loop chlayenge upar se niche and jab first time unequal element ayenge 
  // usse phle wala hi lca hoga  
  public static int lca(Node node, int d1, int d2) {
      ArrayList<Integer> p1 = nodeToRootPath(node, d1);
      ArrayList<Integer> p2 = nodeToRootPath(node, d2);

      int i = p1.size() - 1;
      int j = p2.size() - 1;

      while( i >=0 && j>=0 && p1.get(i) == p2.get(j)){
          i--;
          j--;
      }
      i++;//unequal se phle wale equal per jane ke liye ++ kar re h
      j++;

      return p1.get(i);
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
    int lca = lca(root, d1, d2);
    System.out.println(lca);
    // display(root);
  }
}
/*Sample Input

24
10 20 50 -1 60 -1 -1 30 70 -1 80 110 -1 120 -1 -1 90 -1 -1 40 100 -1 -1 -1
120
80

Sample Output
80 */