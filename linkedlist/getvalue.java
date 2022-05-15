/*1. You are given a partially written LinkedList class.
2. Here is a list of existing functions:
    2.1 addLast - adds a new element with given value to the end of Linked List
    2.2. display - Prints the elements of linked list from front to end in a single line. 
     All elements are separated by space.
2.3. size - Returns the number of elements in the linked list.
2.4. removeFirst - Removes the first element from Linked List. 
3. You are required to complete the body of getFirst, getLast and getAt function 
3.1. getFirst - Should return the data of first element. If empty should return -1 and print "List is empty".
3.2. getLast - Should return the data of last element. If empty should return -1 and print "List is empty".
3.3. getAt - Should return the data of element available at the index passed. If empty should return -1 and print 
"List is empty". If invalid index is passed, should return -1 and print "Invalid arguments".
4. Input and Output is managed for you. */
package DSA.linkedlist;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import DSA.linkedlist.addLastElement.Node;

public class getValue {
    
    public static class LinkedList extends removeFirst.LinkedList {
   
        public int getFirst(){
          if (size == 0 ){
              System.out.println("List is empty");
              return -1;
          }else{
            return head.data;
          }
        }
    
        public int getLast(){
          if (size == 0 ){
            System.out.println("List is empty");
            return -1;
        }else{
            return tail.data;
        }          
        }
    
        public int getAt(int idx){
          if (size == 0 ){
            System.out.println("List is empty");
            return -1;
        }else if (idx < 0 || idx >= size){
            System.out.println("Invalid arguments");
            return -1;
        }else{// agar idx = 0 , to head return ho jata and agar 1 , to loop 1 baar chalta aur ye
            //next element return kar deta ....
            Node temp = head;
            for(int i=0; i< idx;i++){
                temp = temp.next;
            }
            return temp.data;
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
          } else if(str.startsWith("getFirst")){
            int val = list.getFirst();
            if(val != -1){
              System.out.println(val);
            }
          } else if(str.startsWith("getLast")){
            int val = list.getLast();
            if(val != -1){
              System.out.println(val);
            }
          } else if(str.startsWith("getAt")){
            int idx = Integer.parseInt(str.split(" ")[1]);
            int val = list.getAt(idx);
            if(val != -1){
              System.out.println(val);
            }
          }
          str = br.readLine();
        }
        
    }
}
/*Sample Input

addLast 10
getFirst
addLast 20
addLast 30
getFirst
getLast
getAt 1
addLast 40
getLast
addLast 50
removeFirst
getFirst
removeFirst
removeFirst
getAt 3
removeFirst
removeFirst
getFirst
quit

Sample Output
10
10
30
20
40
20
Invalid arguments
List is empty */