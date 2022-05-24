package DSA.GenericTree;

/*1. You are given a partially written GenericTree class.
2. You are required to complete the body of find function. The function is expected to find the given data in the tree, 
if found it should return true or return false.
3. Input and Output is managed for you.

Constraints
None */
import java.io.*;

public class findInGT extends maxInGTree{

  //Logic: images/findInGT.png==> adha euler chalega,jiase hi ans milega ghar ki taraf bhagega
  public static boolean find(Node node, int data) {
    if(node.data == data){
        return true;
    }

    for(Node child:node.children){
        boolean fic = find(child,data);
        if(fic){
            return true;
        }
    }

    return false;//agar khud mn and child mn data ni h then post it will return false
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    int data = Integer.parseInt(br.readLine());

    Node root = construct(arr);
    boolean flag = find(root, data);
    System.out.println(flag);
    // display(root);
  }
}
/*Sample Input

24
10 20 50 -1 60 -1 -1 30 70 -1 80 110 -1 120 -1 -1 90 -1 -1 40 100 -1 -1 -1
120

Sample Output
true */