/*1. You are given a partially written LinkedList class.
2. Here is a list of existing functions:
   2.1 addLast - adds a new element with given value to the end of Linked List
   2.2. display - Prints the elements of linked list from front to end in a single line. All 
   elements are separated by space
  2.3. size - Returns the number of elements in the linked list.
  2.4. removeFirst - Removes the first element from Linked List. 
  2.5. getFirst - Returns the data of first element. 
  2.6. getLast - Returns the data of last element. 
  2.7. getAt - Returns the data of element available at the index passed. 
  2.8. addFirst - adds a new element with given value in front of linked list.
3. You are required to complete the body of addAt function. This function should add the element at the index 
mentioned as parameter. If the idx is inappropriate print "Invalid arguments".
4. Input and Output is managed for you. */
package DSA.linkedlist;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import DSA.linkedlist.addLastElement.Node;

public class addAt {
   
    public static class LinkedList extends addFirst.LinkedList{

        public void addAt(int idx, int val){
          //addat.png
          if (idx < 0 || idx > size) {
            System.out.println("Invalid arguments");
          }else if (idx == 0){// agar addat node first element ho to reuse the addFirst code
            addFirst(val);
          }else if (idx == size){// agar addat last element ho to reuse the addlast code
            addLast(val);
          }else{// agar add at inbetween element,tab idx - 1 wale node per jao and do
            // new node.next = (idx -1).next and (idx-1).next = new node
            Node node = new Node();
            node.data = val;
            // below code se idx -1 node per phuch jayenge
            Node temp = head;
            for(int i = 0;i< idx -1;i++){
              temp = temp.next;
            }
            
            node.next = temp.next;// new node.next = (idx -1).next 
            temp.next = node;//(idx-1).next = new node
    
            size++;
    
          }
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
        } 
        str = br.readLine();
      }        
    }
    
}
/*Sample Input

addFirst 10
getFirst
addAt 0 20
getFirst
getLast
display
size
addAt 2 40
getLast
addAt 1 50
addFirst 30
removeFirst
getFirst
removeFirst
removeFirst
addAt 2 60
display
size
removeFirst
removeFirst
getFirst
quit

Sample Output
10
20
10
20 10 
2
40
20
10 40 60 
3
60 */