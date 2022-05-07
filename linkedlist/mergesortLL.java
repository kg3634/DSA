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

public class mergesortLL {
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
    
          if (size == 0) {
            tail = temp;
          }
    
          size++;
        }
    
        public void addAt(int idx, int val) {
          if (idx < 0 || idx > size) {
            System.out.println("Invalid arguments");
          } else if (idx == 0) {
            addFirst(val);
          } else if (idx == size) {
            addLast(val);
          } else {
            Node node = new Node();
            node.data = val;
    
            Node temp = head;
            for (int i = 0; i < idx - 1; i++) {
              temp = temp.next;
            }
            node.next = temp.next;
    
            temp.next = node;
            size++;
          }
        }
    
        public void removeLast() {
          if (size == 0) {
            System.out.println("List is empty");
          } else if (size == 1) {
            head = tail = null;
            size = 0;
          } else {
            Node temp = head;
            for (int i = 0; i < size - 2; i++) {
              temp = temp.next;
            }
    
            tail = temp;
            tail.next = null;
            size--;
          }
        }
    
        public void removeAt(int idx) {
          if (idx < 0 || idx >= size) {
            System.out.println("Invalid arguments");
          } else if (idx == 0) {
            removeFirst();
          } else if (idx == size - 1) {
            removeLast();
          } else {
            Node temp = head;
            for (int i = 0; i < idx - 1; i++) {
              temp = temp.next;
            }
    
            temp.next = temp.next.next;
            size--;
          }
        }
    
        private Node getNodeAt(int idx) {
          Node temp = head;
          for (int i = 0; i < idx; i++) {
            temp = temp.next;
          }
          return temp;
        }
    
        public void reverseDI() {
          int li = 0;
          int ri = size - 1;
          while (li < ri) {
            Node left = getNodeAt(li);
            Node right = getNodeAt(ri);
    
            int temp = left.data;
            left.data = right.data;
            right.data = temp;
    
            li++;
            ri--;
          }
        }
    
        public void reversePI() {
          if (size <= 1) {
            return;
          }
    
          Node prev = null;
          Node curr = head;
          while (curr != null) {
            Node next = curr.next;
    
            curr.next = prev;
            prev = curr;
            curr = next;
          }
    
          Node temp = head;
          head = tail;
          tail = temp;
        }
    
        public int kthFromLast(int k) {
          Node slow = head;
          Node fast = head;
          for (int i = 0; i < k; i++) {
            fast = fast.next;
          }
    
          while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
          }
    
          return slow.data;
        }
    
        public int mid() {
          Node f = head;
          Node s = head;
    
          while (f.next != null && f.next.next != null) {
            f = f.next.next;
            s = s.next;
          }
    
          return s.data;
        }
    
        public static LinkedList mergeTwoSortedLists(LinkedList l1, LinkedList l2) {
          LinkedList ml = new LinkedList();
    
          Node one = l1.head;
          Node two = l2.head;
          while (one != null && two != null) {
            if (one.data < two.data) {
              ml.addLast(one.data);
              one = one.next;
            } else {
              ml.addLast(two.data);
              two = two.next;
            }
          }
    
          while (one != null) {
            ml.addLast(one.data);
            one = one.next;
          }
    
          while (two != null) {
            ml.addLast(two.data);
            two = two.next;
          }
    
          return ml;
        }

        public static Node midNode(Node head, Node tail){
            Node slow = head;
            Node fast = head;

            while(fast !=null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }

            return slow;
        }
    
        public static LinkedList mergeSort(Node head, Node tail){
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
          LinkedList fsh =  mergeSort(head,mid);// faith ke sath first sorted half ki list nikalneg with recursion
          LinkedList ssh = mergeSort(mid.next,tail);//same for second half
          LinkedList cl = mergeTwoSortedLists(fsh, ssh);// merge 2 LL - laute hue merge karti hui ayegi.

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
    
        LinkedList sorted = LinkedList.mergeSort(l1.head, l1.tail);
        sorted.display();
        l1.display();
        
    }
    
}
