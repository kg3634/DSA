package DSA.GenericTree;

import java.io.*;

public class removeLeavesInGT extends mirrorOfGT{

  public static void removeLeaves(Node node) {
    /*check 3 mistakes given below:
    mistake 1:
    we can not remove elment from arrylist while iterating though it- called concoorrent modification exception
    for(Node child:node.children){
        if(child.children.size() == 0){
            node.children.remove(child);
        }        
    }
    mistake 2:
    can not use loop starting with i =0 and remove, as we remove elm from srray list it shifts the elemnts, to avoid this
    use loop from reverse,in this if it shifts then also it is checking all elements
    mistake 3:
    we can not remove elements post recursion as it should remove some nodes which are not leaves as for those leaves are already 
    removed images/removeLeavesPostOrder.png
    */
    for(int i = node.children.size() - 1;i >= 0;i--){
        Node child = node.children.get(i);
        if(child.children.size() == 0){
            node.children.remove(child);
        }
    }
    for(Node child:node.children){
        removeLeaves(child);//assuming that all child can remove its leaves
    }
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
    removeLeaves(root);
    display(root);
  }
}
/*Sample Input

24
10 20 50 -1 60 -1 -1 30 70 -1 80 110 -1 120 -1 -1 90 -1 -1 40 100 -1 -1 -1

Sample Output
10 -> 20, 30, 40, .
20 -> .
30 -> 80, .
80 -> .
40 -> . */