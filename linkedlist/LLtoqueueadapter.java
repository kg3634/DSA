/*1. You are required to complete the code of our LLToQueueAdapter class. 
2. As data members, you've a linkedlist available in the class.
3. Here is the list of functions that you are supposed to complete
     3.1. add -> Should accept new data in FIFO manner
     3.2. remove -> Should remove and return data in FIFO manner. If not available, 
     print "Queue underflow" and return -1.
     3.3. peek -> Should return data in FIFO manner. If not available, print "Queue 
     underflow" and return -1.
     3.4. size -> Should return the number of elements available in the queue
4. Input and Output is managed for you.

Note -> The intention is to use linked list functions to achieve the purpose of a queue. 
All the functions should work in [constant time].
 */
package DSA.linkedlist;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
//Logic: LLtoqueueadapter.png
// hum [addLast,removeFirst] or [addFirst,removeLast] ka combo use kar sakte h, but removeLast is O(n) in our case,
// so using [aL,rF]
public class LLtoqueueadapter {
    public static class LLToQueueAdapter {
        LinkedList<Integer> list;
    
        public LLToQueueAdapter() {
          list = new LinkedList<>();
        }
    
        int size() {
          // write your code here
          return list.size();
        }
    
        void add(int val) {
          // write your code here
          list.addLast(val);
        }
    
        int remove() {
          // write your code here
          if(size() ==0){
            System.out.println("Queue underflow");
            return -1;
          }else{
              return list.removeFirst();
          }
        }
    
        int peek() {
          // write your code here
          if(size() ==0){
            System.out.println("Queue underflow");
            return -1;
          }else{
              return list.getFirst();
          }          
        }
      }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LLToQueueAdapter qu = new LLToQueueAdapter();
    
        String str = br.readLine();
        while (str.equals("quit") == false) {
          if (str.startsWith("add")) {
            int val = Integer.parseInt(str.split(" ")[1]);
            qu.add(val);
          } else if (str.startsWith("remove")) {
            int val = qu.remove();
            if (val != -1) {
              System.out.println(val);
            }
          } else if (str.startsWith("peek")) {
            int val = qu.peek();
            if (val != -1) {
              System.out.println(val);
            }
          } else if (str.startsWith("size")) {
            System.out.println(qu.size());
          }
          str = br.readLine();
        }        
    }
    
}
