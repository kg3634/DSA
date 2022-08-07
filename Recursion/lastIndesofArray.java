/*1. You are given a number n, representing the count of elements.
2. You are given n numbers.
3. You are given a number x. 
4. You are required to find the last index at which x occurs in array a.
5. If x exists in array, print the last index where it is found otherwise print -1.

Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is. 
Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.

Constraints
1 <= n <= 10^4
0 <= n1, n2, .. n elements <= 10 ^ 3
0 <= x <= 10 ^ 3 */
package DSA.Recursion;

import java.util.Scanner;

public class lastIndesofArray {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int [] arr = new int[n];

        for(int i = 0;i<arr.length;i++){
            arr[i] = scn.nextInt();
        }

        int d = scn.nextInt();
        //System.out.println(lastIndex(arr,arr.length - 1,d));//approach 1
        System.out.println(lastIndex(arr,0,d));
    }

    public static int lastIndex(int[] arr, int idx, int x){

        /*approach 1 
        if( idx < 0){
            return -1;
        }
        if (arr[idx] == x){
            return idx;
        }else{
            int lisa = lastIndex(arr,idx -1,x);
            return lisa;
        }*/

        //Logic: images/lastIndexOfArray.png: aappoach 2 : for understanding how to return back from recursion
        if( idx == arr.length ){
            return -1;
        }
        int liisa = lastIndex(arr,idx+1,x);
        if( liisa == -1){//apne baad walo se nahi mila
            if(arr[idx] == x){//khud se check kiya
                return idx;
            }else{
                return -1;
            }
        }else {//mil gya to wahi return kar diya kyuki vapas ate hue hi check kar reh
            return liisa;
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
4 */