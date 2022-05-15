/*1. You are given a partially written LinkedList class.
2. You are required to complete the body of mergeSort function. The function is static and is passed the 
head and tail of an unsorted list. The function is expected to return a new sorted list. The original list 
must not change.
3. Input and Output is managed for you. 

Note - Watch the question video for theory of merge sort.

Constraints
1. O(nlogn) time complexity required. */
package DSA.linkedlist;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import DSA.linkedlist.addLastElement.Node;

public class mergeSortLL {

    public static class LinkedList extends mergeTwoSortedLL.LinkedList{

        public static Node midNode(Node head, Node tail){
            Node slow = head;
            Node fast = head;

            while(fast !=tail && fast.next != tail){
                slow = slow.next;
                fast = fast.next.next;
            }

            return slow;
        }
    
        public static DSA.linkedlist.mergeTwoSortedLL.LinkedList mergeSort(Node head, Node tail){
          //mergesortLL.png,mergesortLL2.png
          //mid nikalenge(h,t pass karke) and then recursive call lgaynge in first half and second half
          //fst half/second half mn mid nikalte jyenge ,and jab tail = head , new list return kar denge
          // laute hue list ko merge karte hua lautnge
          if (head == tail){
              LinkedList br = new LinkedList();
              br.addLast(head.data);
              return br;
          }  

          Node mid = midNode(head,tail);// mid node nikalega
          DSA.linkedlist.mergeTwoSortedLL.LinkedList fsh =  mergeSort(head,mid);// faith ke sath first sorted half ki list nikalneg with recursion
          DSA.linkedlist.mergeTwoSortedLL.LinkedList ssh = mergeSort(mid.next,tail);//same for second half
          DSA.linkedlist.mergeTwoSortedLL.LinkedList cl = mergeTwoSortedLists(fsh, ssh);// merge 2 LL - laute hue merge karti hui ayegi.

          return cl;
        }
    }    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n1 = Integer.parseInt(br.readLine());
        LinkedList l1 = new LinkedList();
        String[] values1 = br.readLine().split(" ");
        for (int i = 0; i < n1; i++) {
          int d = Integer.parseInt(values1[i]);
          l1.addLast(d);
        }
    
        DSA.linkedlist.mergeTwoSortedLL.LinkedList sorted = LinkedList.mergeSort(l1.head, l1.tail);
        sorted.display();
        l1.display();
    }
}
/*Sample Input

6
10 2 19 22 3 7

Sample Output
2 3 7 10 19 22 
10 2 19 22 3 7 */