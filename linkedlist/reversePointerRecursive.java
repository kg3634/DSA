/*1. You are given a partially written LinkedList class.
2. You are required to complete the body of reversePR and reversePRHelper functions. The functions
 are expected to reverse the linked list by using recursion and changing the "next" data member of nodes.
3. Input and Output is managed for you. 

Note -> The online judge can't force you to write recursive function, nor can it check if you changed the 
"next" data member or not. But that is what the expectation is, the intention in to help you learn.

Constraints
1. Time complexity -> O(n)
2. Space complexity -> O(n) */
package DSA.linkedlist;

import java.io.*;
import DSA.linkedlist.addLastElement.Node;

public class reversePointerRecursive {

  public static class LinkedList extends displayReverseRecursive.LinkedList{
 
    private void reversePRHelper(Node node){
      //Logic:images/displayReversePointerRecursive.png
      //
      if(node == null){//base condition
        return;
      }
      reversePRHelper(node.next);
      if (node == tail){//last wale ko ase hi chod do
      }else{// second last ko khud per hi point kar do and so on
        node.next.next = node;
      }
    }

    public void reversePR(){
      reversePRHelper(head);
      head.next = null;
      //swap
      Node temp = head;
      head = tail;
      tail = temp;
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
    l1.reversePR();
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