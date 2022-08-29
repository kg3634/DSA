/*1. You are given an array(arr) of integers.
2. You have to sort the given array in increasing order using quick-sort.

Constraints
1 <= N <= 100000
-10^9 <= arr[i] <= 10^9 */
package DSA.TimeandSpace;
import java.util.*;
public class quickSort {

  public static void quickSort(int[] arr, int lo, int hi) {
    /*Logic: quickSort.png: last element ko pivot manke partion kar lnge: then left and right recursive call
    lagaynge and ye calls actual mn same array per hi sort krke lyegi, end mn sare sort ho jynge
     */
    if(lo >= hi){//this is index, not value, lo > hi if for single element we call left and right
        //lo=0, hi = 0-1
        return;
    }
    int pivot = arr[hi];
    int pi = partition(arr,pivot,lo,hi);
    quickSort(arr, lo, pi-1);
    quickSort(arr, pi+1, hi);
    
  }

  public static int partition(int[] arr, int pivot, int lo, int hi) {
    System.out.println("pivot -> " + pivot);
    int i = lo, j = lo;
    while (i <= hi) {
      if (arr[i] <= pivot) {
        swap(arr, i, j);
        i++;
        j++;
      } else {
        i++;
      }
    }
    System.out.println("pivot index -> " + (j - 1));
    return (j - 1);
  }

  // used for swapping ith and jth elements of array
  public static void swap(int[] arr, int i, int j) {
    System.out.println("Swapping " + arr[i] + " and " + arr[j]);
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
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
    quickSort(arr, 0, arr.length - 1);
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
pivot -> 3
Swapping -2 and 7
Swapping 1 and 7
Swapping 3 and 4
pivot index -> 2
pivot -> 1
Swapping -2 and -2
Swapping 1 and 1
pivot index -> 1
pivot -> -2
Swapping -2 and -2
pivot index -> 0
pivot -> 4
Swapping 4 and 7
pivot index -> 3
pivot -> 7
Swapping 7 and 7
pivot index -> 4
-2 1 3 4 7 */