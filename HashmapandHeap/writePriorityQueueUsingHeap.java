/*1. You are required to complete the code of our Priority Queue class using the heap data structure. 
Please watch the question video carefully. The theoretical details of required functionality is explained in detail there. 
Implement the functions to achieve what is explained in the theoretical discussion in question video.
2. Here is the list of functions that you are supposed to complete:
    2.1. add -> Should accept new data.
    2.2. remove -> Should remove and return smallest value, if available or print 
     "Underflow" otherwise and return -1.
     2.3. peek -> Should return smallest value, if available or print "Underflow" 
     otherwise and return -1.
     2.4. size -> Should return the number of elements available.
3. Input and Output is managed for you.

Constraints
None */
package DSA.HashmapandHeap;

import java.io.*;
import java.util.*;

public class writePriorityQueueUsingHeap {

  public static class PriorityQueue {
    ArrayList<Integer> data;

    public PriorityQueue() {
      data = new ArrayList<>();
    }
    /*we need o do add and remove in log(n) and peak in O(1) by followng below properties:
    ** Heap Order Property: parents pririty is greater than childs,why: peak can be O(1)
    ** Complete Binary tree(images/writePriorityQueue.png): if h-1 levels should be completed beore filling h level and on 
    h levels elements would be added from left to right: we are analysing arraylist as a binary tree in which we can even 
    reach from child to parent but in BT not.why CBT[ --AL--idx formulas can be used--can go to parent--upheapify--logn]
    */
    public void add(int val) {
        data.add(val);
        upheapify(data.size() -1);
    
    }

    private void upheapify(int i )  {
        if(i == 0){
            return;
        }
        int pi = (i-1)/2;// left/right index to parent index formula
        if(data.get(i) < data.get(pi)){
            swap(i,pi);
            upheapify(pi);
        }
    }

    private void swap(int i ,int j){
        int ith = data.get(i);
        int jth = data.get(j);
        data.set(i,jth);
        data.set(j,ith);
    }

    public int remove() {//swap,remove,downheapify
        if(data.size() ==0){
            System.out.println("Underflow");
            return -1;
        }else{//swapping 0 and last and removing last which is O(1) as removing 0th would shift 
            //other elements and will become o(n)
            swap(0,data.size()-1);
            int val = data.remove(data.size() -1);
            downheapify(0);//need to do it as Heap Order property needs to be validated
            return val;
        } 
    
    }

    private void downheapify(int pi){
        //in this need to check for both left and right child
        int mini = pi;//pararent index

        int li = 2* pi +1;// parent index to left index formula
        if(li < data.size() && data.get(li) < data.get(mini)){
            mini = li;
        }
        int ri = 2* pi +2;
        if(ri< data.size() && data.get(ri) < data.get(mini)){
            mini = ri;
        }

        if( mini!=pi){
            swap(mini,pi);
            downheapify(mini);
        }
    }

    public int peek() {
        if(data.size() ==0){
            System.out.println("Underflow");
            return -1;
        }
        return data.get(0);
    }

    public int size() {
        return data.size();
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PriorityQueue qu = new PriorityQueue();

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
/*Sample Input

add 10
add 20
add 30
add 40
peek
add 50
peek
remove
peek
remove
peek
remove
peek
remove
peek
quit

Sample Output
10
10
10
20
20
30
30
40
40
50 */