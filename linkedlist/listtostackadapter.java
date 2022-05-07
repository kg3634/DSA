/*1. You are required to complete the code of our LLToStackAdapter class. 
2. As data members, you've a linkedlist available in the class.
3. Here is the list of functions that you are supposed to complete
    3.1. push -> Should accept new data in LIFO manner
    3.2. pop -> Should remove and return data in LIFO manner. If not 
     available, print "Stack underflow" and return -1.
    3.3. top -> Should return data in LIFO manner. If not available, print 
    "Stack underflow" and return -1.
    3.4. size -> Should return the number of elements available in the 
    stack
4. Input and Output is managed for you.

Note -> The intention is to use linked list functions to achieve the purpose of a stack. 
All the functions should work in [constant time].
 */
package DSA.linkedlist;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

//logic: LLtostackapdapter.png
// hum [addFirst,getFirst,removeFirst] or [addLast,getLast,removeLast] combination use kar sakte h , but karenge first wala
// kyuki constant time mn karna h aur humne removeLast O(n) time mn likha ,halaki in java ye O(1) hi hota h 
// kewal first / last ka combination isliye kyui stack mn 1 hi end per push/pop/top hota h .
public class listtostackadapter {
    public static class LLToStackAdapter {
        LinkedList<Integer> list;
    
        public LLToStackAdapter() {
          list = new LinkedList<>();
        }
    
    
        int size() {
          // write your code here
          return list.size();
        }
    
        void push(int val) {
          // write your code here
          list.addFirst(val);
          
        }
    
        int pop() {
          // write your code here
          if(size() == 0){
              System.out.println("Stack underflow");
              return -1;
          }else{
            return list.removeFirst();
          }
        }
    
        int top() {
          // write your code here
          if(size() == 0){
            System.out.println("Stack underflow");
            return -1;
        }else{
          return list.getFirst();
        }          
  
        }
      }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LLToStackAdapter st = new LLToStackAdapter();
    
        String str = br.readLine();
        while(str.equals("quit") == false){
          if(str.startsWith("push")){
            int val = Integer.parseInt(str.split(" ")[1]);
            st.push(val);
          } else if(str.startsWith("pop")){
            int val = st.pop();
            if(val != -1){
              System.out.println(val);
            }
          } else if(str.startsWith("top")){
            int val = st.top();
            if(val != -1){
              System.out.println(val);
            }
          } else if(str.startsWith("size")){
            System.out.println(st.size());
          }
          str = br.readLine();
        }        
    }
    
}
