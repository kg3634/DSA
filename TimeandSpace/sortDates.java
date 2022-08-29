/*1. You are given an array(arr) of different dates in format DD-MM-YYYY.
2. You have to sort these dates in increasing order.

Constraints
1 <= N <= 10000
All dates are between year 0 to year 2500 */
package DSA.TimeandSpace;

import java.util.*;

public class sortDates {

  public static void sortDates(String[] arr) {
    /*Logic: images/sortDates1.png: count sort from left to right(date,month and year): 
    to cal date div = 1000000, mod = 100 and so on*/
    countSort(arr, 1000000, 100, 32);//count sort dates
    countSort(arr, 10000, 100, 13);//month
    countSort(arr, 1, 10000, 2501);//year
  }

  public static void countSort(String[] arr,int div, int mod, int range) {
    String [] ans = new String[arr.length];//string array
    int [] farr = new int[range];

    //frequency arr
    for(int i=0;i<arr.length;i++){
        farr[Integer.parseInt(arr[i],10) / div % mod]++;//05 ko by deafult octal samajh leta h ,isliye base 10 bataya h string 
        //ko int mn convirt karte hue : images/sortDate2.png
    }

    //prefix sum of arr
    for( int i=1;i<farr.length;i++){
        farr[i]+= farr[i-1];
    }

    //fill ans array
    for(int i=arr.length -1;i>=0;i--){
        int pos = farr[Integer.parseInt(arr[i],10) / div % mod] - 1;
        ans[pos] = arr[i];
        farr[Integer.parseInt(arr[i],10) / div % mod]--;        
    }

    //assign arr 
    for(int i=0;i<arr.length;i++){
        arr[i] = ans[i];
    }
  }

  public static void print(String[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    String[] arr = new String[n];
    for (int i = 0; i < n; i++) {
      String str = scn.next();
      arr[i] = str;
    }
    sortDates(arr);
    print(arr);
  }

}
/*Sample Input

5
12041996
20101996
05061997
12041989
11081987

Sample Output
11081987
12041989
12041996
20101996
05061997 */