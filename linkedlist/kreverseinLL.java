/*1. You are given a partially written LinkedList class.
2. You are required to complete the body of kReverse function. The function is expected to tweak the 
list such that all groups of k elements in the list get reversed and linked. If the last set has less 
than k elements, leave it as it is (don't reverse).
3. Input and Output is managed for you.

Constraints
1. Time complexity -> O(n)
2. Space complexity -> constant */
package DSA.linkedlist;

import java.io.*;

public class kReverseInLL {

  public static class LinkedList extends oddEven.LinkedList {
    //Logic:images/kReverseInLL.png
    //2 list create karnge(prev,curr); curr mn k elements ko reverse karke store karenge by(removeFirst and addFirst)
    //agar elemnet k se kam rh ge h to unko as it is stokarenge by(removeFirst and addLast)
    // prev ki tail ko curr se add kar dnge and increase size by curr ke size se 
    // TC: linear as while loop n/k baar chlega and for loop k baar, means n
    // SC: constant as this mn remove karke current mn add karre h
    public void kReverse(int k) {
      LinkedList prev = null;
      while(this.size > 0 ){
        LinkedList curr = new LinkedList();
        if(this.size >=k ){// for this will reverse k elem will be stored in curr
          for(int i =0;i<k ;i++){
            int val = this.getFirst();
            this.removeFirst();
            curr.addFirst(val);
          }
        }else{//for this elem will be stored as it is
          int os = this.size();// alag se store kiya kyuki remove First mm size decrease hoga and hum i++ kar reh to loop size 
          // ke barabar ni chlega
          for(int i =0;i<os ;i++){
            int val = this.getFirst();
            this.removeFirst();
            curr.addLast(val);
          }          
        }

  
        if(prev == null){//intially
          prev = curr;
        }else{// adding curr to prev
          prev.tail.next = curr.head;
          prev.tail = curr.tail;
          prev.size += curr.size;
        }        
      }

      // as this is empty ,so reassiging values from prev
      this.head = prev.head;
      this.tail = prev.tail;
      this.size = prev.size;

      
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n1 = Integer.parseInt(br.readLine());
    LinkedList l1 = new LinkedList();
    String[] values1 = br.readLine().split(" ");
    for (int i = 0; i < n1; i++) {
      int d = Integer.parseInt(values1[i]);
      l1.addLast(d);
    }

    int k = Integer.parseInt(br.readLine());
    int a = Integer.parseInt(br.readLine());
    int b = Integer.parseInt(br.readLine());

    l1.display();
    l1.kReverse(k);
    l1.display();
    l1.addFirst(a);
    l1.addLast(b);
    l1.display();
  }
}
/*Sample Input

11
1 2 3 4 5 6 7 8 9 10 11
3
100
200

Sample Output
1 2 3 4 5 6 7 8 9 10 11 
3 2 1 6 5 4 9 8 7 10 11 
100 3 2 1 6 5 4 9 8 7 10 11 200 */