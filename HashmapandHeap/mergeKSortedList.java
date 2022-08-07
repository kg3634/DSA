/*1. You are given a list of lists, where each list is sorted.
2. You are required to complete the body of mergeKSortedLists function. The function is expected to merge k sorted lists 
to create one sorted list.

Constraints
Space complextiy = O(k)
Time complexity = nlogk
where k is the number of lists and n is number of elements across all lists. */
package DSA.HashmapandHeap;

import java.io.*;
import java.util.*;

public class mergeKSortedList {
   /*Comaparable Basics:
   ** is interface: Contract of functions - only has name and sign of functions - 
   ** class which implements interface: says I will provide body of all functions anmed in interface
   ** why important: PQ class depends on comparable: it typecase object into comaparable and then decides.
   ** If pair1 and pair2 needs to be compared: C object1 = (C) p1;C object2 = (C) p2 
      if(object1.compareTo(object2) > 0) ==> this.val - o.val (agar +ve then this is greater,-ve then this is smaller)
    */
   public static class Pair implements Comparable<Pair>{
      int li;
      int di;
      int val;

      Pair(int li,int di,int val){
         this.li = li;
         this.di=di;
         this.val = val;
      }

      public int compareTo(Pair o) {//if(object1.compareTo(object2) > 0) ==> this.val - o.val (agar +ve then this is greater,-ve then this is smaller)
         return this.val - o.val;
      }

      
   }
   public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists){
      ArrayList<Integer> rv = new ArrayList<>();
      PriorityQueue<Pair> pq  = new PriorityQueue<>();
      for(int i =0;i<lists.size();i++){//adding fist element of all list in pq
         Pair p = new Pair(i,0,lists.get(i).get(0));
         pq.add(p);
      }

      /*images/mergeKSortedList.png,removig smallest element and then increasing index of that list only and then removing next smallest and
      then again increasing index of that list*/
      while(pq.size()>0){
         Pair p = pq.remove();//will remove the smallest
         rv.add(p.val);
         p.di++;//increasing the data index of list

         if(p.di < lists.get(p.li).get(p.di)){//checking if next index is valid 
            p.val = lists.get(p.li).get(p.di);//setting value 
            pq.add(p);//adding next index elem to pq and repeating the process
         }

      }




      return rv;
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int k = Integer.parseInt(br.readLine());
      ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
      for(int i = 0; i < k; i++){
         ArrayList<Integer> list = new ArrayList<>();

         int n = Integer.parseInt(br.readLine());
         String[] elements = br.readLine().split(" ");
         for(int j = 0; j < n; j++){
            list.add(Integer.parseInt(elements[j]));
         }

         lists.add(list);
      }

      ArrayList<Integer> mlist = mergeKSortedLists(lists);
      for(int val: mlist){
         System.out.print(val + " ");
      }
      System.out.println();
   }

}
/*Sample Input

4
5
10 20 30 40 50
7
5 7 9 11 19 55 57
3
1 2 3
2
32 39

Sample Output
1 2 3 5 7 9 10 11 19 20 30 32 39 40 50 55 57  */