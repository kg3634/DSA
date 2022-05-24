/*1. You are given a partially written GenericTree class.
2. You are required to complete the body of linearize function. The function is expected to create a linear tree i.e. 
every node will have a single child only. For details check the question video.
3. Input and Output is managed for you.

Constraints
None */
package DSA.GenericTree;

import java.io.*;

public class linearizeGT extends removeLeavesInGT{
  //Logic:images/linearize.png : this approach tc is O(n*n) as two loops are there
  public static void linearize(Node node){
      //has failth that childs will linearize itself
      for(Node child:node.children){
          linearize(child);
      }

      //meet faith with expectation
      while(node.children.size() > 1){
          //last child ko remove karke seconda last child ki tail mn add karte jao jab tak 1 cild rh jaye
          Node lc = node.children.remove(node.children.size() - 1);//removing last child
          Node sl = node.children.get(node.children.size() - 1);//getting second last child
          Node slt = getTail(sl);//getting second last childs tail
          slt.children.add(lc);
      }
  }

  //below code is like linked list next 
  private static Node getTail( Node node){
      while(node.children.size() == 1){
        node = node.children.get(0);
      }
      return node;
  }

  //efficient approach: which is O(n), as in pre and post mn O(1 se jayada kam ni hua h)
  public static Node linearize2(Node node){
    //base code
    if(node.children.size() == 0){//child 0 hone node hi khud ki tail ho jyega
        return node;
    }

    //below code last ko linear kar dega aur uski tail bhi dega
    Node lkt = linearize2(node.children.get(node.children.size() - 1));

    while(node.children.size() > 1){// second last ko linear karenge and uski tail mn last ko add kar dnge
        Node last = node.children.remove(node.children.size() - 1);
        Node sl = node.children.get(node.children.size() - 1);
        Node slkt = linearize2(sl);//seconnd last linear ho jyega and apni tail bhi de dega
        slkt.children.add(last);
    }
    return lkt;
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
    // linearize(root);
    linearize2(root);
    display(root);
  }

}
/*Sample Input

24
10 20 50 -1 60 -1 -1 30 70 -1 80 110 -1 120 -1 -1 90 -1 -1 40 100 -1 -1 -1

Sample Output
10 -> 20, .
20 -> 50, .
50 -> 60, .
60 -> 30, .
30 -> 70, .
70 -> 80, .
80 -> 110, .
110 -> 120, .
120 -> 90, .
90 -> 40, .
40 -> 100, .
100 -> . */