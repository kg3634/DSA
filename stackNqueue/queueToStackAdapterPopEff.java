/*1. You are required to complete the code of our QueueToStackAdapter class. 
2. As data members you've two queues available - mainQ and helperQ. mainQ is to contain data and helperQ is to assist 
in operations. (This is cryptic - take hint from video)
3. Here is the list of functions that you are supposed to complete
     3.1. push -> Should accept new data in LIFO manner.
     3.2. pop -> Should remove and return data in LIFO manner. If not available, print 
     "Stack underflow" and return -1.
    3.3. top -> Should return data in LIFO manner. If not available, print "Stack 
    underflow" and return -1.
    3.4. size -> Should return the number of elements available in the stack.
4. Input and Output is managed for you.

Note -> pop, top and size should work in constant time. push should work in linear time.

Constraints
Note -> pop, top and size should work in constant time. push should work in linear time. */
import java.io.*;
import java.util.*;

public class queueToStackAdapterPopEff {

  public static class QueueToStackAdapter {
    Queue<Integer> mainQ;
    Queue<Integer> helperQ;

    public QueueToStackAdapter() {
      mainQ = new ArrayDeque<>();
      helperQ = new ArrayDeque<>();
    }

    int size() {
        return mainQ.size();
    }

    //Logic:images/queueToStackAdapter.png- logic to store elem in reverse order first and then add new val
    //we will remove elem from mainQ and store in healperQ, then add val in mainQ
    // after that remove ele from helper and add into main.
    void push(int val) {
        while(size() > 0){
            helperQ.add(mainQ.remove());
        }
        mainQ.add(val);
        while(helperQ.size() > 0){
            mainQ.add(helperQ.remove());
        }
    }

    int pop() {// normal remove as we have reversed like stack in push
        if(size() == 0 ){
            System.out.println("Queue underflow");
            return -1;
        }else{
            return mainQ.remove();
        }
    }

    int top() {// normal peek as we have reversed like stack in push
        if(size() == 0 ){
            System.out.println("Queue underflow");
            return -1;
        }else{
            return mainQ.peek();
        }    
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    QueueToStackAdapter st = new QueueToStackAdapter();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("push")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        st.push(val);
      } else if (str.startsWith("pop")) {
        int val = st.pop();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("top")) {
        int val = st.top();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(st.size());
      }
      str = br.readLine();
    }
  }
}

/*Sample Input

push 10
push 20
push 5
push 8
push 2
push 4
push 11
top
size
pop
top
size
pop
top
size
pop
top
size
pop
top
size
pop
top
size
pop
top
size
pop
quit

Sample Output
11
7
11
4
6
4
2
5
2
8
4
8
5
3
5
20
2
20
10
1
10 */