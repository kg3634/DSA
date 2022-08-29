/*1. You are given an array(arr) containing only 0's and 1's.
2. You have to sort the given array in increasing order and in linear time.

Constraints
1 <= N <= 10000
arr[i] = 0,1*/
package DSA.TimeandSpace;

import java.util.*;

public class sort01 {

  public static void sort01(int[] arr){
    /*images/sort01.png: like partition, segreegate 1 to right and zeroes to left */
    int i=0;
    int j=0;

    while(i<arr.length){
        if(arr[i] == 1){
            i++;
        }else if(arr[i] ==0){
            swap(arr,i,j);
            i++;
            j++;
        }
    }
    
  }

  // used for swapping ith and jth elements of array
  public static void swap(int[] arr, int i, int j) {
    System.out.println("Swapping index " + i + " and index " + j);
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void print(int[] arr){
    for(int i = 0 ; i < arr.length; i++){
      System.out.println(arr[i]);
    }
  }
  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i = 0 ;i < n; i++){
      arr[i] = scn.nextInt();
    }
    sort01(arr);
    print(arr);
    scn.close();
  }

}
/*Sample Input

5
0
1
0
1
0

Sample Output
Swapping index 0 and index 0
Swapping index 2 and index 1
Swapping index 4 and index 2
0
0
0
1
1 */