/*1. You are given an array(arr) of distinct integers, which is sorted and rotated around an unknown point.
2. You have to find the smallest element in O(logN) time-complexity

Constraints
1 <= N <= 10000
-10^9 <= arr[i] <= 10^9 */
package DSA.TimeandSpace;

import java.util.*;

public class pivotInSortedAndRotatedArray {

  public static int findPivot(int[] arr) {
    /*Logic:images/pivotSortedAndRotatedArray.png: odd mn left is big (lo to mid < mid+1 to hi) and in even left size = right size
    (lo to mid = mid+1 to hi), agar mid chota h high se means left mn pivot hoga,agar mid bada h high se,means right mn pivot hoga
    NOTE:binary seaarch ka concept h
     */

     int lo = 0;
     int hi = arr.length -1;
     while(lo < hi){
      int mid = (lo+hi)/2;
      if(arr[mid] < arr[hi]){//pivot left mn h lo to mid
        hi = mid;//hi ko chota kar do
      }else{//pivot right mn h
        lo = mid+1;
      }
     }

     return arr[hi];
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    int pivot = findPivot(arr);
    System.out.println(pivot);
    scn.close();
  }

}
/*Sample Input

9
15
16
19
21
23
24
1
2
12

Sample Output
1 */