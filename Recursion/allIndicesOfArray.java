/*1. You are given a number n, representing the count of elements. 
2. You are given n numbers.
3. You are given a number x. 
4. You are required to return the all indices at which x occurs in array a. 
5. Return an array of appropriate size which contains all indices at which x occurs in array 
6. If no such element exist print "NO OUTPUT" a. 
Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is. 
Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.
Constraints
1 <= n <= 10^4 0 <= n1, n2, .. n elements <= 10 ^ 3 0 <= x <= 10 ^ 3 */
package DSA.Recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class allIndicesOfArray {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int x = Integer.parseInt(br.readLine());
        int[] iarr = allIndices(arr, x, 0, 0);

        if(iarr.length == 0){
            System.out.println();
            return;
        }

        for(int i = 0; i < iarr.length; i++){
            System.out.println(iarr[i]);
        }
    }

    public static int[] allIndices(int[] arr, int x, int idx, int fsf) {
        /*logic:images/allIndicesOfArray.png
         fsf is found so far previuosly, it wont count current idx value, it would be added in next call
         first we have to identify size of iarr, with the help of deep recursion we will count (fsf) and in base case will return  arr
         of size fsf.
         if x is found then make call with increased fsf value and add idx it in iarr and return arr,else return iarr as it is without 
         sfs +.    
        */
        if(idx == arr.length){
            return new int[fsf];
        }

        if(arr[idx] == x){//we will not compare again while returning for recursion
            int [] iarr = allIndices(arr, x, idx+1, fsf+1);
            iarr[fsf] = idx;
            return iarr;
        }else{
            int [] iarr = allIndices(arr, x, idx+1, fsf);
            return iarr;
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
3
4 */