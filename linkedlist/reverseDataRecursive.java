/*1. You are given a partially written LinkedList class.
2. You are required to complete the body of reverseDR and reverseDRHelper functions. The functions 
are expected to reverse the linked list by using recursion and changing the "data" data member of nodes.
3. Input and Output is managed for you. 

Note -> The online judge can't force you to write recursive function, nor can it check if you changed 
the "data" data member or not. But that is what the expectation is, the intention in to help you learn.

Constraints
1. Time complexity -> O(n)
2. Space complexity -> O(n) */
package DSA.linkedlist;

import java.io.*;
import DSA.linkedlist.addLastElement.Node;

public class reverseDataRecursive {

  public static class LinkedList extends reversePointerIterative.LinkedList{
    
    //Logic for Even Nodes:images/reverseDReven.png, for odd:images/reverseDRodd.png
    private void reverseDRHelper(Node right, int floor){
      if(right == null){
        return;
      }
      reverseDRHelper(right.next,floor +1);//right.next would come from right to left

      // floor isliye liya taki double baar swap na ho jaye - isliye size/2 tak hi swap karna h 
      if(floor >= size/2){ // = is for odd number of nodes
        //swap of right and rleft data
        int temp = right.data;
        right.data = rleft.data;
        rleft.data = temp;
        //next from left
        rleft = rleft.next;
      }

    }

    Node rleft;// would be created in heap ===> to move from left to right
    public void reverseDR(){
      rleft = head;
      reverseDRHelper(head,0);

    }
  }
//Note: jis variable(right) ko hume backtrack karana h use stack(as a param) mn rakhe, aur jise backtrack ni karana use heap mn(like rleft)
// as a data member. rleft ko hume age badhana h
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
    l1.reverseDR();
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
200 11 10 9 8 7 6 5 4 3 2 1 100 */