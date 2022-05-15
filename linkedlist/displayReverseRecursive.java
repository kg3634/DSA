/*1. You are given a partially written LinkedList class.
2. You are required to complete the body of displayReverse and displayReverseHelper functions. 
The function are expected to print in reverse the linked list without actually reversing it. 
3. Input and Output is managed for you. 

Note -> The online judge can't force you to write recursive function. But that is what the expectation is, 
the intention in to help you learn.

Constraints
1. Time complexity -> O(n)
2. Space complexity -> O(n) */
package DSA.linkedlist;

import java.io.*;
import DSA.linkedlist.addLastElement.Node;

public class displayReverseRecursive {

  public static class LinkedList extends kReverseInLL.LinkedList {

    private void displayReverseHelper(Node node){
        //Logic:images/displayRevRec.png
        //in recursion details:
        /*High level thinking: 3 stages
        1. Expectation from our function
        2. Faith that our function will work for some value K
        3. Establish relationship b/w faith and expectation
        Now Low level thinking
        1. Justify your above assumption by making a recursion stack
        2. Check for base condition where your recursive calls must end*/
        if(node == null){//base condition
            return;
        }
        displayReverseHelper(node.next);
        System.out.print(node.data+" ");//we will printe while returning
    }

    public void displayReverse(){
      displayReverseHelper(head);
      System.out.println();
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n1 = Integer.parseInt(br.readLine());
    LinkedList l1 = new LinkedList();
    String[] values1 = br.readLine().split(" ");
    for (int i = 0; i < n1; i++) {
      int d = Integer.parseInt(values1[i]);
      l1.addLast(d);
    }
    
    int a = Integer.parseInt(br.readLine());
    int b = Integer.parseInt(br.readLine());

    l1.display();
    l1.displayReverse();
    l1.addLast(a);
    l1.addFirst(b);
    l1.display();
  }
}
/*Sample Input

11
1 2 3 4 5 6 7 8 9 10 11
100
200

Sample Output
1 2 3 4 5 6 7 8 9 10 11 
11 10 9 8 7 6 5 4 3 2 1 
200 1 2 3 4 5 6 7 8 9 10 11 100  */