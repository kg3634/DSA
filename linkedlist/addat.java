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

public class addat {
    public static class Node {
        int data;
        Node next;
      }
    
    public static class LinkedList {
        Node head;
        Node tail;
        int size;
    
        void addLast(int val) {
          Node temp = new Node();
          temp.data = val;
          temp.next = null;
    
          if (size == 0) {
            head = tail = temp;
          } else {
            tail.next = temp;
            tail = temp;
          }
    
          size++;
        }
    
        public int size() {
          return size;
        }
    
        public void display() {
          for (Node temp = head; temp != null; temp = temp.next) {
            System.out.print(temp.data + " ");
          }
          System.out.println();
        }
    
        public void removeFirst() {
          if (size == 0) {
            System.out.println("List is empty");
          } else if (size == 1) {
            head = tail = null;
            size = 0;
          } else {
            head = head.next;
            size--;
          }
        }
    
        public int getFirst() {
          if (size == 0) {
            System.out.println("List is empty");
            return -1;
          } else {
            return head.data;
          }
        }
    
        public int getLast() {
          if (size == 0) {
            System.out.println("List is empty");
            return -1;
          } else {
            return tail.data;
          }
        }
    
        public int getAt(int idx) {
          if (size == 0) {
            System.out.println("List is empty");
            return -1;
          } else if (idx < 0 || idx >= size) {
            System.out.println("Invalid arguments");
            return -1;
          } else {
            Node temp = head;
            for (int i = 0; i < idx; i++) {
              temp = temp.next;
            }
            return temp.data;
          }
        }
        
        public void addFirst(int val) {
          Node temp = new Node();
          temp.data = val;
          temp.next = head;
          head = temp;
          
          if(size == 0){
            tail = temp;
          }
    
          size++;
        }
    
        public void addAt(int idx, int val){
          // write your code here
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
        
    }
    
}
