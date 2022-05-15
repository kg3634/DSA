/* 1. You are given a partially written LinkedList class.
2. You are required to complete the body of removeDuplicates function. The function is called on a sorted list.
 The function must remove all duplicates from the list in linear time and constant space
3. Input and Output is managed for you. 
Constraints
1. Time complexity -> O(n)
2. Space complexity -> constant */
package DSA.linkedlist;

import java.io.*;

public class removeDuplicateInSortedLL {

  public static class LinkedList extends mergeSortLL.LinkedList{
  
    public void removeDuplicates(){
      // create new list and from old list getFirst ele and then removeFirst ele, compare with tail of new list 
      // if tail != get first element, add this element to new list
      // TC : tc is linear as in while will run upto size that is n and getFirst,removeFirst and addlast are O(1)
      // Space Complexity: as first we ar removing element and then adding into new list so no new space for node is reqired
      // new list will take (12 bytes - for head,tail and size variable), which is contant in all cases (1 lakh element /1 element)
      LinkedList res = new LinkedList();

      while(this.size() > 0){
        int val = this.getFirst();
        this.removeFirst();

        if (res.size() == 0 || res.tail.data != val){// add only when tail != this.getFirst
            res.addLast(val);
        }
        
        //can not do this = res , as this is readonly, can assign attributes
        // as current list would be null, so need to set (size ,heada and tail)
      }
      this.head = res.head;
      this.tail = res.tail;
      this.size = res.size;

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

    l1.display();
    l1.removeDuplicates();
    l1.display();
  }
}
/*Sample Input

10
2 2 2 3 3 5 5 5 5 5

Sample Output
2 2 2 3 3 5 5 5 5 5 
2 3 5 */