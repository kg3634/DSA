/*1. You are given a partially written LinkedList class.
2. You are required to complete the body of oddEven function. The function is expected to tweak the list 
such that all odd values are followed by all even values. The relative order of elements should not change. 
Also, take care of the cases when there are no odd or no even elements. Make sure to properly set head, tail and 
size as the function will be tested by calling addFirst and addLast.
3. Input and Output is managed for you.

Constraints
1. Time complexity -> O(n)
2. Space complexity -> constant */
package DSA.linkedlist;

import java.io.*;

public class oddEven {

  public static class LinkedList extends removeDuplicateInSortedLL.LinkedList{

    public void oddEven(){
        //oddeven.png
        // odd,even list banao and then do same like remove dup,condition would be oddeven check
        //extra would be odd ki tail ko even ke head se connect kar do and head,tail,size set 
        //handle only odd and only even case
        // Tc  - liner, sc - contant like in removedup
      LinkedList odd = new LinkedList();
      LinkedList even = new LinkedList();

      while(this.size > 0 ){
          int val = this.getFirst();
          this.removeFirst();

          if(val%2 == 0){
            even.addLast(val);
          }else{
              odd.addLast(val);
          }
      }

      if(odd.size > 0 && even.size > 0){// when both odd ,even present
          odd.tail.next = even.head;
          this.head = odd.head;
          this.tail = even.tail;
          this.size = odd.size + even.size; 
      }else if (odd.size >0 ){// only odd
        this.head = odd.head;
        this.tail = odd.tail;
        this.size = odd.size;           
      }else if (even.size > 0 ){// only even
        this.head = even.head;
        this.tail = even.tail;
        this.size = even.size;           
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
    l1.oddEven();
    l1.display();
    l1.addFirst(a);
    l1.addLast(b);
    l1.display();
  }
}
}
/*Sample Input

7
2 8 9 1 5 4 3
10
100

Sample Output
2 8 9 1 5 4 3 
9 1 5 3 2 8 4 
10 9 1 5 3 2 8 4 100 */