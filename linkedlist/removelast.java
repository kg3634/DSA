package DSA.linkedlist;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import DSA.linkedlist.addLastElement.Node;

public class removeLast {

    public static class LinkedList extends addAt.LinkedList{
    
        public void removeLast(){
          if (size == 0){
            System.out.println("List is empty");
          }else if (size == 1){
            head = tail = null;
            size = 0;
          }else {//second last elemnt pe phuchna h , to size - 2 tak temp.next karenge
            Node temp = head;
            for(int i = 0; i< size - 2; i++){
              temp = temp.next;
            }
            tail = temp;
            temp.next = null;
            size --;
          }
        }
      }
    
    public static void main(String[] args) throws Exception {
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
removeLast
removeLast
addAt 2 60
display
size
removeFirst
removeLast
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
20 50 60 
3
50 */