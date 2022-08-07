/*1. You will be given an Array with its length
 2. You will also be given an integral value k
 3. You need to find k largest elements from the given array
 4. Input is handled for you
 5. It is a functional problem ,please do not modify main()

Constraints
1 <= N <= 100
 K <= N
 -1000 <= C[i] <= 1000 */
package DSA.HashmapandHeap;

import java.util.*;
import java.lang.*;
import java.io.*;
public class kLargestElement {
 	 public static void main (String[] args) throws IOException
 	  {
 	 	 Scanner scn= new Scanner(System.in);
         int n = scn.nextInt();
 	 	 int[] num = new int[n];
 	 	 for (int i = 0; i < n; i++) {
 	 	 	 	 num[i] = scn.nextInt();
 	 	 	 }
 	 	 int k = scn.nextInt();
 	 	 solve(n,num,k);
 	  }
 	 // -----------------------------------------------------
 	 // This is a functional problem. Only this function has to be written.
 	 // This function takes as input an array,n length of array and k.
 	 // It should print required output.
 	  public static void solve(int n,int[] arr,int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0;i<arr.length;i++){
            if( i< k){
                pq.add(arr[i]); // klogk
            }else {
                if(arr[i] > pq.peek()){//adds deserving to pq and discard non-deserving
                    pq.remove();//(n-k)logk
                    pq.add(arr[i]);//(n-k)logk
                }
            }

        }

        while(pq.size()>0){
            System.out.println(pq.remove());//klogk
        }
        //Total TC: k log(k) + 2((n-k) log(k))+k log(k) = 2nlog(k) = O(n log(k))
     }
 }
/*Sample Input

8
44 -5 -2 41 12 19 21 -6 
2

Sample Output
44 41 */