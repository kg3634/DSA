/*1. You are given an array(arr) containing only 0's, 1's, and 2's.
2. You have to sort the given array in increasing order and in linear time.

Constraints
1 <= N <= 10000
arr[i] = 0,1,2 */
package DSA.TimeandSpace;

import java.util.*;

public class sort012 {

  public static void sort012(int[] arr){
    /*Logic: images/sort012.png: j se phle 0's and j to i-1 1's and k+1 to end 2's ka area h 
    jab 0 ata h to i,j ko swap karte h and i,j ko ++ krte h kyuki j, 1 se hi start hota h and 0 ko apne piche dhkel deta h
    in swaping i per confirm 1 ata h isiliye use bhi badhate h as j, i apne se piche tak 1 rakhta h, agar 2 ata h then i,k
    ko swap krte h , and only k ko -- krte h ,kyuki i swaping we dont know what we will get from k*/
    int j =0;//0 to j-1 -> 0's area
    int i = 0;//j to i-1 -> 1;s area
    int k = arr.length -1;//k+1 to end -> 2's area

    //i to k is unknown
    while(i<=k){
      if(arr[i] == 1){
        i++;
      }else if(arr[i] == 0){
        swap(arr, i, j);
        i++;
        j++;
      }else if(arr[i] == 2){
        swap(arr, i, k);
        k--;
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
    sort012(arr);
    print(arr);
    scn.close();
  }

}
/*Sample Input

10
1
0
2
2
1
0
2
1
0
2

Sample Output
Swapping index 1 and index 0
Swapping index 2 and index 9
Swapping index 2 and index 8
Swapping index 2 and index 1
Swapping index 3 and index 7
Swapping index 5 and index 2
Swapping index 6 and index 6
0
0
0
1
1
1
2
2
2
2 */