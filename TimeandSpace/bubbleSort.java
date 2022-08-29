/*1. You are given an array(arr) of integers.
2. You have to sort the given array in increasing order using bubble sort.

Constraints
1 <= N <= 10000
-10^9 <= arr[i] <= 10^9 */
package DSA.TimeandSpace;

import java.io.*;
import java.util.*;

public class bubbleSort {

  public static void bubbleSort(int[] arr) {
    /*Logic:images/bubbleSort.png: compare adjacent element (j+1 < j) and swap,in each iteration 
    largest will come to end, loop for comapring will be executed till arr.length - iteration */
    for( int itr=1;itr<=arr.length -1;itr++){//loop for n-1 elem
        for(int j =0;j<arr.length - itr;j++){//as we will compare just before last sorted largest elem
            //if arr.length is 5 and itr =1, then j will go till 0 to 3(<5-1), as j+1 would be compared
            if(isSmaller(arr, j+1, j) == true){
                swap(arr, j+1, j);
            }
        }
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
    bubbleSort(arr);
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
Swapping -2 and 7
Comparing 4 and 7
Swapping 4 and 7
Comparing 1 and 7
Swapping 1 and 7
Comparing 3 and 7
Swapping 3 and 7
Comparing 4 and -2
Comparing 1 and 4
Swapping 1 and 4
Comparing 3 and 4
Swapping 3 and 4
Comparing 1 and -2
Comparing 3 and 1
Comparing 1 and -2
-2
1
3
4
7 */