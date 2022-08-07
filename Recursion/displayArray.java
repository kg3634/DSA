/*1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing elements of array a.
3. You are required to print the elements of array from beginning to end each in a separate line.
4. For the above purpose complete the body of displayArr function. Don't change the signature.

Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is. 
Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.

Constraints
1 <= n <= 30
0 <= n1, n2, .. n elements <= 10 */
/**
 * displayArray
 */
package DSA.Recursion;

import java.util.Scanner;

public class displayArray {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int [] arr = new int[n];

        for(int i = 0;i<arr.length;i++){
            arr[i] = scn.nextInt();
        }

        displayArr(arr,0);   
     
    }
    //Ex- idx se end tak sab print kar de
    //Faith -> idx +1 se print karna janta h 
    public static void displayArr(int[] arr, int idx){
        if( idx == arr.length){
            return;
        }
        System.out.println(arr[idx]);
        displayArr(arr, idx+1);
        
    }

}
/*Sample Input

5
3
1
0
7
5

Sample Output
3
1
0
7
5 */