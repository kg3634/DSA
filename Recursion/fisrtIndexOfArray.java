/*1. You are given a number n, representing the count of elements.
2. You are given n numbers.
3. You are given a number x. 
4. You are required to find the first index at which x occurs in array a.
5. If x exists in array, print the first index where it is found otherwise print -1.

Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is. 
Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.

Constraints
1 <= n <= 10^4
0 <= n1, n2, .. n elements <= 10 ^ 3
0 <= x <= 10 ^ 3 */
package DSA.Recursion;

import java.util.Scanner;

public class fisrtIndexOfArray {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int [] arr = new int[n];

        for(int i = 0;i<arr.length;i++){
            arr[i] = scn.nextInt();
        }

        int d = scn.nextInt();
        System.out.println(firstIndex(arr,0,d));          
    }

    public static int firstIndex(int[] arr, int idx, int x){
        
        if( idx == arr.length ){
            return -1;
        }
        /* Bad Logic: images/badLogicFirstIndex.png slow code and wrong way of doing as it will check while returning out of recursion
        int fisa = firstIndex(arr, idx+1, x);//first index in small array
        if(arr[idx] == x){
            return idx;
        }else{
            return fisa;
        }*/

        //Good Logic: images/goodLogicFisrtIndex.png correct way: we can check first and then go into recursion
        if(arr[idx] == x){
            return idx;
        }else {
            int fisa = firstIndex(arr, idx+1, x);
            return fisa;
        }

    }

}
/*Sample Input

6
15
11
40
4
4
9
4

Sample Output
3 */