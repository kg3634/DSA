/*1. You are given a number n, representing the count of elements.
2. You are given n numbers, representing n elements.
3. You are required to find the maximum sum of a subsequence with no adjacent elements.

Constraints
1 <= n <= 1000
-1000 <= n1, n2, .. n elements <= 1000 */
package DSA.DynamicProgramming;

import java.util.Scanner;

public class maxSumNonAdjacentElem {
    public static void main(String[] args) {
        /*Logic:images/maxSumNonAdjacentElem.png: we will make trees based on level in which either will include
         or exclude element and in next stage will only exclude if previously included but if previously excluded
         then we can include and exclude both(but as per greedy we will take max of both in this case as future 
         tree and gap for both will be same)
        */

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int [] arr = new int[n];
        for(int i =0;i<arr.length;i++){
            arr[i] = scn.nextInt(); 
        }

        int inc = arr[0];
        int exc = 0;
        for(int i=1;i<arr.length;i++){
            int ninc = exc + arr[i];//purane exc + current value
            int nexc = Math.max(inc,exc);

            inc = ninc;
            exc = nexc;
        }

        int ans = Math.max(inc,exc);
        System.out.println(ans);

    }
    
}
/*Sample Input

6
5
10
10
100
5
6

Sample Output
116 */