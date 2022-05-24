/*Easy

1. You are given a partially written GenericTree class. 2. You are required to complete the body of nodeToRootPath function. 
The function is expected to return in form of linked list the path from element to root, if the element with data is found. 
3. Input and Output is managed for you.


Constraints
None */
package DSA.GenericTree;

import java.io.*;
import java.util.*;

public class nodeToRootPath extends maxInGTree{

 //Logic: same like find , bas false ki jgh emty arraylist return kar dnge
 //child apne tak ka path dega , so finally usme node khud ko add krke return kr dega   
 public static ArrayList<Integer> nodeToRootPath(Node node, int data){
     if(node.data == data){
         ArrayList<Integer> list = new ArrayList<Integer>();
         list.add(node.data);//node ko khud ka hi path return karna h
         return list;
     }

     for(Node child:node.children){
         ArrayList ptc = nodeToRootPath(child, data);//path to child
         if(ptc.size() > 0){
             ptc.add(node.data);//node khud ko add kar dega then pura path mil jayega
             return ptc;
         }
     }

     return new ArrayList<>();//empty list
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
    ArrayList<Integer> path = nodeToRootPath(root, data);
    System.out.println(path);
    // display(root);
  }
}
/*Sample Input

24
10 20 50 -1 60 -1 -1 30 70 -1 80 110 -1 120 -1 -1 90 -1 -1 40 100 -1 -1 -1
120

Sample Output
[120, 80, 30, 10] */