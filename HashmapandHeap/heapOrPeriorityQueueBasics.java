package DSA.HashmapandHeap;

import java.util.PriorityQueue;

public class heapOrPeriorityQueueBasics {
    public static void main(String[] args) {
        /*Periority Queue:
         TC of add,remove - logn, and for peek is O(1);
         works based on periority , by default it gives smallest value as periority, can reverse it also
         */

         PriorityQueue<Integer> pq = new PriorityQueue<>();//new PriorityQueue<>(Collections.reverseOrder()) for changing default
         int[] ranks = {22,99,3,11,88,4,1};

         for(int val: ranks){//TC : n
            pq.add(val);
         }

         while(pq.size()>0){//TC : n*logn
            System.out.println(pq.peek());
            pq.remove();
         }


    }
    
}
