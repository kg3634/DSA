/*1. You are given a number n, representing the number of stairs in a staircase.
2. You are on the 0th step and are required to climb to the top.
3. You are given n numbers, where ith element's value represents - till how far from the step you 
     could jump to in a single move.  
     You can of course jump fewer number of steps in the move.
4. You are required to print the number of different paths via which you can climb to the top.

Constraints
0 <= n <= 20
0 <= n1, n2, .. <= 20 */
package DSA.DynamicProgramming;

import java.io.*;
import java.util.*;

public class climbStairsWithJumps {

    public static void main(String[] args) throws Exception {
        //Logic:images/climbStairsWithJumps.png
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int [] arr = new int[n];//array for per stair atmost move number
        for(int i = 0;i<arr.length;i++){
            arr[i] = scn.nextInt();
        }

        int [] dp = new int[n+1];

        dp[n] = 1;//6 se 6 per 1 step mn a jynge

        for(int i = n-1;i>=0;i--){//right to left gye h kuki right wali problem choti h()6-6 one path
            for(int j = 0;j<= arr[i]&& i+j <dp.length;j++){//i+j< dp.length for step bahar na chala jye
                dp[i]+=dp[i+j];//i+(0to atmost move)
                // System.out.println("i "+i+"and j "+j+" dp[i] is "+dp[i]);
            }
        }

        System.out.println(dp[0]);
    }   

}
/*Sample Input

10
3
3
0
2
1
2
4
2
0
0

Sample Output
5 */