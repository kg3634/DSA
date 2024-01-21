/*1. You are given a number n, representing the number of stairs in a staircase.
2. You are on the 0th step and are required to climb to the top.
3. In one move, you are allowed to climb 1, 2 or 3 stairs.
4. You are required to print the number of different paths via which you can climb to the top.

Constraints
0 <= n <= 20 */
package DSA.DynamicProgramming;

import java.io.*;
import java.util.*;

public class climbingStairs {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        // int cp = countPaths(n,new int[n+1]);
        int cp = countPathsTab(n);
        System.out.println(cp);
    }

    //Memoization method
    public static int countPaths(int n, int [] qb){
        if(n ==0){//1 path hoga for this 0 se 0
            return 1;
        }else if(n <0){
            return 0;
        }
        if(qb[n]!=0){
            return qb[n];
        }
        int cpnm1 = countPaths(n-1, qb);
        int cpnm2 = countPaths(n-2, qb);
        int cpnm3 = countPaths(n-3, qb);
        int cp = cpnm1 + cpnm2 + cpnm3;

        qb[n] = cp;

        return cp;
    }

    //tabulation method:images/climbingStairs.png
    //just like fibonacci( if only 1 ,2 were allowed), in 
    // below case we will add last three.
    public static int countPathsTab(int n){
        int [] dp = new int[n+1];
         dp[0] = 1;

         for(int i=1;i<=n;i++){
            if(i ==1){
                dp[i] = dp[i-1];

            }else if(i ==2){
                dp[i] = dp[i-1]+dp[i-2];

            }else {
                dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
            }
         }

         return dp[n];

    }

}
/*Sample Input

4

Sample Output
7 */
