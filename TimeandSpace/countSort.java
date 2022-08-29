/*1. You are given an array(arr) of integers.
2. You have to sort the given array in increasing order using count sort.

Constraints
1 <= N <= 10000
-10^8 <= arr[i] <= 10^8 */
package DSA.TimeandSpace;

import java.util.*;

public class countSort {

  public static void countSort(int[] arr, int min, int max) {
   /*Logic:images/countSort.png: when sort range is small like sorts marks for students(they can be large) which could be 0 to 340
   there we can apply countSort, 1) cal range 2) cal frequncy array which stores arr elem frequency at 
   (elem - min) index of farr 3) cal sum of prefix array by adding last prefix  4) reverse loop in main arr
   and fill value in ans array  from farr like for value 9 ,farr[6] = 15(means 14 index), 14th index per 9 ko 
   put karo and then farr[6]--; 5) fill array with ans array
   why: as this is stable, as in case of same values, old order will be preserved 
   */
    
   int range = max - min+1;
   int [] farr = new int[range];//frequency array: farr[1] = 2 means 4[idx=4-3(min)], 2 baar aya h 
   for( int i=0;i<arr.length;i++){
      int idx = arr[i] - min;//idx = 4 -3 
      farr[idx]++;//farr[1]=farr[1]+1            
    }

    for(int i=1;i<farr.length;i++){//farr[1] = farr[1] + farr[0] = 2+3=5 means 5th position tak 4 h
        farr[i] = farr[i] + farr[i-1];
    }

    int [] ans = new int[arr.length];
    for(int i=ans.length -1;i>=0;i--){
        int val = arr[i];
        int pos = farr[val - min];//farr[6(9-min)]=15,15th tak 9 h
        int idx = pos -1;//14th index per 9 h
        ans[idx] = val;
        farr[val - min] --;//ye dhyan rakhe 

    }

    //fill the array

    for( int i=0;i<arr.length;i++){
        arr[i] = ans[i];
    }
   
  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
      max = Math.max(max, arr[i]);
      min = Math.min(min, arr[i]);
    }
    countSort(arr,min,max);
    print(arr);
    scn.close();
  }

}
/*Sample Input

5
7 
-2 
4 
1 
3

Sample Output
-2
1
3
4
7 */