/*1. You are given a partially written LinkedList class.
2. Here is a list of existing functions:
    2.1 addLast - adds a new element with given value to the end of Linked List
    2.2. display - Prints the elements of linked list from front to end in a single line. 
    All elements are separated by space
    2.3. size - Returns the number of elements in the linked list.
    2.4. removeFirst - Removes the first element from Linked List. 
    2.5. getFirst - Returns the data of first element. 
    2.6. getLast - Returns the data of last element. 
    2.7. getAt - Returns the data of element available at the index passed. 
    2.8. addFirst - adds a new element with given value in front of linked list.
    2.9. addAt - adds a new element at a given index.
    2.10. removeLast - removes the last element of linked list.
    2.11. removeAt - remove an element at a given index
3. You are required to complete the body of reversePI function. The function should be an iterative function and 
should reverse the contents of linked list by changing the "next" property of nodes.
4. Input and Output is managed for you. */
package DSA.linkedlist;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import DSA.linkedlist.addLastElement.Node;

public class reversePointerIterative {
    
    public static class LinkedList extends reverseDatalterative.LinkedList{
     
        public void reversePI(){
          //logic:images\reversePointer.png
          //prev and curr node man liye, curr, prev ko point karega, then prev =curr, curr = curr.next
          // as curr.next prev ko point karra h isliye ise kisi aur node variable mn store kar lnge
          Node prev = null;
          Node curr = head;

          while(curr != null){
              Node next = curr.next;// curr.next ko store kar re

              curr.next = prev;
              prev = curr;
              curr = next;
          }

          // swap of head and tail
          Node temp = head;
          head = tail;
          tail = temp;
        }
      }    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList list = new LinkedList();
    
        String str = br.readLine();
        while (str.equals("quit") == false) {
          if (str.startsWith("addLast")) {
            int val = Integer.parseInt(str.split(" ")[1]);
            list.addLast(val);
          } else if (str.startsWith("size")) {
            System.out.println(list.size());
          } else if (str.startsWith("display")) {
            list.display();
          } else if (str.startsWith("removeFirst")) {
            list.removeFirst();
          } else if (str.startsWith("getFirst")) {
            int val = list.getFirst();
            if (val != -1) {
              System.out.println(val);
            }
          } else if (str.startsWith("getLast")) {
            int val = list.getLast();
            if (val != -1) {
              System.out.println(val);
            }
          } else if (str.startsWith("getAt")) {
            int idx = Integer.parseInt(str.split(" ")[1]);
            int val = list.getAt(idx);
            if (val != -1) {
              System.out.println(val);
            }
          } else if (str.startsWith("addFirst")) {
            int val = Integer.parseInt(str.split(" ")[1]);
            list.addFirst(val);
          } else if (str.startsWith("addAt")) {
            int idx = Integer.parseInt(str.split(" ")[1]);
            int val = Integer.parseInt(str.split(" ")[2]);
            list.addAt(idx, val);
          } else if (str.startsWith("removeLast")) {
            list.removeLast();
          } else if (str.startsWith("removeAt")) {
            int idx = Integer.parseInt(str.split(" ")[1]);
            list.removeAt(idx);
          } else if(str.startsWith("reverseDI")){
            list.reverseDI();
          } else if(str.startsWith("reversePI")){
            list.reversePI();
          }
          str = br.readLine();
        }
    }
}
/*Sample Input

addFirst 10
addFirst 20
addLast 30
addLast 40
addLast 50
addFirst 60
removeAt 2
display
reversePI
display
quit

Sample Output
60 20 30 40 50 
50 40 30 20 60 */
