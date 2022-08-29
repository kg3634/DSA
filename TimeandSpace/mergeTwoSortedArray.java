/*1. You are given two sorted arrays(a,b) of integers.
2. You have to merge them and form one sorted array.
3. You have to do it in linear time complexity.

Constraints
1 <= N <= 10^8
-10^9 <= a[i],b[i] <= 10^9 */
package DSA.TimeandSpace;

import java.util.*;

public class mergeTwoSortedArray {

  public static int[] mergeTwoSortedArrays(int[] a, int[] b){
    //Logic: images/mergeTwoSortedArray.png
    int [] res = new int[a.length+b.length];
    int i =0;
    int j =0;
    int k=0;
    //run loop jab tak i and j bacha hua h: agar koi phle khtm ho gya loop will break
    while(i<a.length && j< b.length){
        if(a[i] < b[j]){
            res[k] = a[i];
            i++;
            k++;
        }else{
            res[k] = b[j];
            j++;
            k++;
        }
    }

    //agar i bacha hua a, then i ke sare res mn as it is add kar do
    while(i<a.length){
        res[k] = a[i];
        i++;
        k++;
    }

    //agar j bacha hua h,then j ke sare res mn as it is add kar do
    while(j< b.length){
        res[k] = b[j];
        j++;
        k++;
    }
    
    return res;
  }

  public static void print(int[] arr){
    for(int i = 0 ; i < arr.length; i++){
      System.out.println(arr[i]);
    }
  }
  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] a = new int[n];
    for(int i = 0 ; i < n; i++){
      a[i] = scn.nextInt();
    }
    int m = scn.nextInt();
    int[] b = new int[m];
    for(int i = 0 ; i < m; i++){
      b[i] = scn.nextInt();
    }
    int[] mergedArray = mergeTwoSortedArrays(a,b);
    print(mergedArray);
    scn.close();
  }

}
/*Sample Input

4
-2 
5 
9 
11
3
4 
6 
8

Sample Output
-2
4
5
6
8
9
11 */