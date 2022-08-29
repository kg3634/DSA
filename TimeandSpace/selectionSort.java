/*1. You are given an array(arr) of integers.
2. You have to sort the given array in increasing order using selection sort.

Constraints
1 <= N <= 10000
-10^9 <= arr[i] <= 10^9 */
package DSA.TimeandSpace;

import java.util.*;

public class selectionSort {

  public static void selectionSort(int[] arr) {
    /*Logic:images/selectionSort.png: minindex ko i(i loop for n-1) per rakha ,j(from i+1 to last) ko mi se compare krte rahnge
    and mi ko update krte rahenge, j loop ke baad i and mi ko swap kar dnge: isse sabse chota starting n a jyega*/
    for(int i=0;i<arr.length -1;i++){
        int mi = i;//min index
        for(int j=i+1;j<arr.length;j++){
            if(isSmaller(arr, j, mi)){
                mi = j;
            }
        }
        swap(arr, i, mi);
    }
  }

  // used for swapping ith and jth elements of array
  public static void swap(int[] arr, int i, int j) {
    System.out.println("Swapping " + arr[i] + " and " + arr[j]);
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  // return true if ith element is smaller than jth element
  public static boolean isSmaller(int[] arr, int i, int j) {
    System.out.println("Comparing " + arr[i] + " and " + arr[j]);
    if (arr[i] < arr[j]) {
      return true;
    } else {
      return false;
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
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    selectionSort(arr);
    print(arr);
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
Comparing -2 and 7
Comparing 4 and -2
Comparing 1 and -2
Comparing 3 and -2
Swapping 7 and -2
Comparing 4 and 7
Comparing 1 and 4
Comparing 3 and 1
Swapping 7 and 1
Comparing 7 and 4
Comparing 3 and 4
Swapping 4 and 3
Comparing 4 and 7
Swapping 7 and 4
-2
1
3
4
7 */