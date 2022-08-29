/*reduce TC from nlongn to n for priority queue constructor */
package DSA.HashmapandHeap;

import java.io.*;
import java.util.*;

public class linearTCConstructorHeap {

  public static class PriorityQueue {
    ArrayList<Integer> data;
    /*why nlong TC: images/linearTCConstructor1.png: as here for more no of nodes more work is done: for last level nodes
    (n/2 = 8 for 15 nodes), TC = n/2*h and for first level,TC = 1*0 
    how reduces TC to n: images/linearTCConstructor2.png,images/linearTCConstructor3.png: will downheapify from n/2 to last 
    (in place of upheapify), here for more no of nodes ,ess work will be there: for last level nodes,TC = n/2*0 and for first
    =1*h: so Tc reduced to n. comaprison: images/linearTCCOnstructor4.png*/
    public PriorityQueue(int [] arr) {
      data = new ArrayList<>();
      for(int val:arr){
        //this.add(val);/*TC-O(nlong) constructor if use this.add which used upheapify */
        data.add(val);//normal add
      }

      //downheapyfy from n/2 to 1: reducs TC to O(n)
      for(int i = data.size()/2 -1;i>=0;i--){
        downheapify(i);
      }
    }

    public void add(int val) {
      data.add(val);
      upheapify(data.size() - 1);
    }

    private void upheapify(int i){
      if(i ==0){
        return;
      }
      int pi = (i - 1)/2;
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

    public int remove() {
      if(this.size() ==0){
        System.out.println("Underflow");
        return -1;
      }

      swap(0,data.size() -1);
      int p = data.remove(data.size() -1);
      downheapify(0);
      return p;

    }

    private void downheapify(int pi){
      int mini = pi;

      int li = 2*pi +1;
      if(li < data.size() && data.get(li) < data.get(mini) ){
        mini = li;
      }
      int ri = 2*pi +2;
      if(ri < data.size() && data.get(ri) < data.get(mini) ){
        mini = ri;
      }

      if(mini !=pi){
        swap(pi,mini);
        downheapify(mini);
      }      
    }
    public int peek() {
      if(this.size() ==0){
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
    int[] arr = {10,2,17,3,18,9,22};
    PriorityQueue pq = new PriorityQueue(arr);

    while(pq.size() >0){
        System.out.println(pq.peek());
        pq.remove();
    }
  }
}
