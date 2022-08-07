/*1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing elements of array a.
3. You are required to print the longest sequence of consecutive elements in the array (ignoring duplicates).

Note -> In case there are two sequences of equal length (and they are also the longest), then print the one for which the 
starting point of which occurs first in the array.

Constraints
1 <= n <= 30
0 <= n1, n2, .. n elements <= 15 */
package DSA.HashmapandHeap;

import java.io.*;
import java.util.*;

public class longestConsecutiveSequenceOfEle{

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int [] arr = new int[n];
    for(int i =0;i<arr.length;i++){
        arr[i] = scn.nextInt();
    }

    HashMap<Integer,Boolean> hm = new HashMap<>();
    //adding true to all in hm
    for(int val:arr){
        hm.put(val,true);
    }

    //check val-1,if present make them false
    for(int val:arr){
        if(hm.containsKey(val-1)){
            hm.put(val,false);
        }
    }

    //main logic(images/longestConsSeqOfEle.png): take true values and check all consecutive values along with length of the sequence
    int msp =0;//max starting point
    int ml =0;//max length
    for( int val: arr){
        if(hm.get(val) == true){
            int tl = 1;
            int tsp = val;
            while(hm.containsKey(tsp+tl)){
                tl++;
            }
            if(tl > ml){
                msp = tsp;
                ml = tl;
            }
        }
    }

    for( int i = 0;i<ml;i++){
        System.out.println(msp+i);
    }
 }  

}
/*Sample Input

17
12
5
1
2
10
2
13
7
11
8
9
11
8
9
5
6
11

Sample Output
5
6
7
8
9
10
11
12
13 */