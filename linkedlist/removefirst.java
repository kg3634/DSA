/*1. You are given a partially written LinkedList class.
2. Here is a list of existing functions:
   2.1 addLast - adds a new element with given value to the end of Linked List
   2.2. display - Prints the elements of linked list from front to end in a single line. All 
     elements are separated by space
     2.3. size - Returns the number of elements in the linked list.
3. You are required to complete the body of removeFirst function 
     3.1. removeFirst - This function is required to remove the first element from 
          Linked List. Also, if there is only one element, this should set head and tail to 
          null. If there are no elements, this should print "List is empty".
4. Input and Output is managed for you. */
package DSA.linkedlist;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class removeFirst {

    public static class LinkedList extends displayAndSize.LinkedList {

        public void removeFirst(){
          if (size ==  0){
              System.out.println("List is empty");
          }else if (size == 1){
            head  = tail = null;
            size = 0;
          }else{//head ke next mn next element ka reference hotah isiye 
            //head = head.next set kar denge jisse, list head.next se start hogi 
              head = head.next;
              size--;
          }
        }
      }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList list = new LinkedList();
    
        String str = br.readLine();
        while(str.equals("quit") == false){
          if(str.startsWith("addLast")){
            int val = Integer.parseInt(str.split(" ")[1]);
            list.addLast(val);
          } else if(str.startsWith("size")){
            System.out.println(list.size());
          } else if(str.startsWith("display")){
            list.display();
          } else if(str.startsWith("removeFirst")){
            list.removeFirst();
          }
          str = br.readLine();
        }
        
    }
}
/*Sample Input

addLast 10
addLast 20
addLast 30
display
removeFirst
size
addLast 40
addLast 50
removeFirst
display
size
removeFirst
removeFirst
removeFirst
removeFirst
quit

Sample Output
10 20 30 
2
30 40 50 
3
List is empty */