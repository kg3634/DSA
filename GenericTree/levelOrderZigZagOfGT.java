/*  1. You are given a partially written GenericTree class.
2. You are required to complete the body of levelorderLineWiseZZ function. The function is expected to visit every node in 
"levelorder fashion" but in a zig-zag manner i.e. 1st level should be visited from left to right, 2nd level should be visited 
from right to left and so on. All nodes on same level should be separated by a space. Different levels should be on separate lines. 
Please check the question video for more details.
3. Input is managed for you.  */
package DSA.GenericTree;

import java.io.*;
import java.util.*;

public class levelOrderZigZagOfGT extends travarsalOfGtree {
   
  //Logic:images/levelOrderZigZag.png
  //for odd levels(1,3,5,...), children would be added from left to right and for even it would be added from right to left
  //would use stack as need to print last first and use new variable to track level
  //same remove,print and add child
  public static void levelOrderLinewiseZZ(Node node){
    Stack<Node> ms = new Stack<>();
    Stack<Node> cs = new Stack<>();
    int level = 1;//mistake here if value is zero then incorrect
    ms.push(node);

    while(ms.size() > 0){
        node = ms.pop();
        System.out.print(node.data+" ");
        if( level%2 == 0){//even levels
            for(int i = node.children.size() - 1;i >=0;i-- ){//right to left
                Node child = node.children.get(i);
                cs.push(child);
            }
        }else{
            for(int i = 0;i < node.children.size();i++ ){//left to right
                Node child = node.children.get(i);
                cs.push(child);
            }            
        }

        if(ms.size() == 0){
            ms = cs;
            cs = new Stack<>();
            System.out.println();
            level++;
        }
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
    levelOrderLinewiseZZ(root);
  }

}

/*Sample Input

24
10 20 50 -1 60 -1 -1 30 70 -1 80 110 -1 120 -1 -1 90 -1 -1 40 100 -1 -1 -1

Sample Output
10 
40 30 20 
50 60 70 80 90 100 
120 110 */