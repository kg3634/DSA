/*1. You are given a partially written LinkedList class.
2. You are required to complete the body of findIntersection function. The function is passed two 
linked lists which start separately but merge at a node and become common thereafter. The function is 
expected to find the point where two linked lists merge. You are not allowed to use arrays to solve the problem.
3. Input and Output is managed for you.
Constraints
1. Time complexity -> O(n)
2. Space complexity -> constant  
images/intersectionPointOfLLQuestion.png*/
package DSA.linkedlist;

import java.io.*;
import DSA.linkedlist.addLastElement.Node;

public class intersectionPointOfLL {

  public static class LinkedList extends addTwoLL.LinkedList{

    public static int findIntersection(LinkedList one, LinkedList two){
        //creating nodes with heads of LL
        Node t1 = one.head;
        Node t2 = two.head;

        //calculating delta b/w LL size
        int delta = Math.abs(one.size - two.size);

        //run delta times exta to large list
        if(one.size > two.size ){
            for (int i=0 ;i< delta;i++){
                t1 = t1.next;
            }
        }else{
            for (int i=0 ;i< delta;i++){
                t2 = t2.next;
            }            
        }

        //run both LL to next untill we get intersection point
        while(t1 != t2){
            t1= t1.next;
            t2= t2.next;
        }

        return t1.data;
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

    int n2 = Integer.parseInt(br.readLine());
    LinkedList l2 = new LinkedList();
    String[] values2 = br.readLine().split(" ");
    for (int i = 0; i < n2; i++) {
      int d = Integer.parseInt(values2[i]);
      l2.addLast(d);
    }

    int li = Integer.parseInt(br.readLine());
    int di = Integer.parseInt(br.readLine());
    if(li == 1){
      Node n = l1.getNodeAt(di);
      l2.tail.next = n;
      l2.tail = l1.tail;
      l2.size += l1.size - di;
    } else {
      Node n = l2.getNodeAt(di);
      l1.tail.next = n;
      l1.tail = l2.tail;
      l1.size += l2.size - di;
    }

    int inter = LinkedList.findIntersection(l1, l2);
    System.out.println(inter);
  }
}
/*Sample Input

5
1 2 3 4 5
8
11 22 33 44 55 66 77 88
2
3

Sample Output
44 */