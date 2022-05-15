/*1. You are given a partially written LinkedList class.
2. You are required to complete the body of addLast function. This function is supposed to add an 
element to the end of LinkedList. You are required to update head, tail and size as required.
3. Input and Output is managed for you. Just update the code in addLast function. */
package DSA.linkedlist;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class addLastElement {

    public static class Node {
        int data;
        Node next;
    }
    public static class LinkedList extends Node {
        Node head;
        Node tail;
        int size;
     
        public void addLast(int val) {
          // Write your code here
          Node temp = new Node();
          temp.data = val;
          temp.next = null;        
          if (size == 0){
              //create Node and set data and next(common code)
            //   Node temp = new Node();
            //   temp.data = val;
            //   temp.next = null;

              //set head and tail node reference
              head = tail = temp;

              //increase size
            //   size++;(common code)
          }else{
            //create Node and set data and next(common code)
            // Node temp = new Node();
            // temp.data = val;
            // temp.next = null;

            //set old tail next to null and assign tail to this element reference
            tail.next = temp;
            tail = temp;

            //increase size
            //   size++;(common code)
          }

          size++;
        }
    }
    public static void testList(LinkedList list) {
        for (Node temp = list.head; temp != null; temp = temp.next) {
          System.out.println(temp.data);
        }
        System.out.println(list.size);
    
        if (list.size > 0) {
          System.out.println(list.tail.data);
        } 
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList list = new LinkedList();
    
        String str = br.readLine();
        while(str.equals("quit") == false){
          if(str.startsWith("addLast")){
            int val = Integer.parseInt(str.split(" ")[1]);
            list.addLast(val);
          } 
          str = br.readLine();
        }
    
        testList(list);        
    }
    
}
/*Sample Input

addLast 10
addLast 20
addLast 30
addLast 40
addLast 50
quit

Sample Output
10
20
30
40
50
5
50 */