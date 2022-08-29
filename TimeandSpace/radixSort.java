/*1. You are given an array(arr) of integers.
2. You have to sort the given array in increasing order using radix sort.

Constraints
1 <= N <= 10000
0 <= arr[i] <= 10^8 */
package DSA.TimeandSpace;

import java.util.*;

public class radixSort {

  public static void radixSort(int[] arr) {
    /*Logic: images/radixSort.png: cal max number of arr and countsort ones ,tenth and hundredth places till
    max */
    int max = Integer.MIN_VALUE;
    for(int val:arr){//cal max of arr
        if(val> max){
            max = val;
        }
    }

    int exp = 1;
    while(exp<=max){
        countSort(arr, exp);
        exp = exp*10;
    }

  }

  public static void countSort(int[] arr, int exp) {
    /*modified code: raneg is 0-9` and min is 0, and ones/tenth/hundred place digit(cal by num/exp%10,exp = 1
    for ones place and so on)needs to be passed in palce of arr[i] as a whole*/
    int [] farr = new int[10];
    for( int i=0;i<arr.length;i++){//frequency array
        farr[arr[i]/exp%10]++;
    }

    //sum of prefix array
    for(int i=1;i<farr.length;i++){
        farr[i]+=farr[i-1];
    }

    int [] ans = new int[arr.length];
    //fill ans array
    for(int i=0;i<arr.length;i++){
        int idx = farr[arr[i]/exp%10] - 1;
        ans[idx] = arr[i];//here it would be arr[i] only
        farr[arr[i]/exp%10]--;
    }

    //reassign arr with ans array
    for( int i=0;i<arr.length;i++){
        arr[i] = ans[i];
    }
    System.out.print("After sorting on " + exp + " place -> ");
    print(arr);
  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    radixSort(arr);
    print(arr);
    scn.close();
  }

}
/*Sample Input

5
7 
2 
4 
1 
3

Sample Output
After sorting on 1 place -> 1 2 3 4 7 
1 2 3 4 7 */