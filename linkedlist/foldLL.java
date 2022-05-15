/*1. You are given a partially written LinkedList class.
2. You are required to complete the body of fold function. The function is expected to place last element after 1st element, 
2nd last element after 2nd element and so on. For more insight check the example

Example 1
1->2->3->4->5
will fold as
1->5->2->4->3

Example 2
1->2->3->4->5->6
1->6->2->5->3->4

Constraints
1. Time complexity -> O(n)
2. Space complexity -> Recursion space, O(n) */
package DSA.linkedlist;

import java.io.*;
import DSA.linkedlist.addLastElement.Node;

public class foldLL {

  public static class LinkedList extends isLLPalindrom.LinkedList{
    //Logic:images/foldLL.png
    private void foldHelper(Node right, int floor){
        if(right == null){
            return;
        }
        foldHelper(right.next,floor +1);

        if(floor > size/2){//fleft ko right se add karenge and then right ko fleft ke next se, fleft ko next bhi krte rhnge
            Node temp = fleft.next;
            fleft.next = right;
            right.next = temp;
            fleft = temp;
        }else if (floor == size/2){// last mn tail ko set karenge
            tail = right;
            tail.next = null;
        }
    }

    Node fleft;
    public void fold() {
        fleft = head;
        foldHelper(head,0);
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
    l1.fold();
    l1.display();
    l1.addFirst(a);
    l1.addLast(b);
    l1.display();
  }
}
/*Sample Input

5
1 2 3 4 5
10
20

Sample Output
1 2 3 4 5 
1 5 2 4 3 
10 1 5 2 4 3 20 */