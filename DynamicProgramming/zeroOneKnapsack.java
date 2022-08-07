/*1. You are given a number n, representing the count of items.
2. You are given n numbers, representing the values of n items.
3. You are given n numbers, representing the weights of n items.
3. You are given a number "cap", which is the capacity of a bag you've.
4. You are required to calculate and print the maximum value that can be created in the bag without 
     overflowing it's capacity.

Note -> Each item can be taken 0 or 1 number of times. You are not allowed to put the same item 
               again and again.

Constraints
1 <= n <= 20
0 <= v1, v2, .. n elements <= 50
0 < w1, w2, .. n elements <= 10
0 < cap <= 10 */
package DSA.DynamicProgramming;

import java.util.Scanner;

public class zeroOneKnapsack {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int [] vals = new int[n];
        int [] wts = new int [n];
        for(int i =0;i<vals.length;i++){
            vals[i] = scn.nextInt();
        }
        for(int i =0;i<wts.length;i++){
            wts[i] = scn.nextInt();
        }
        
        int cap = scn.nextInt();

        int[][] dp = new int [n+1][cap+1];

        /*images/zeroOneKnapsack.png,wts==balls, vals == runs, cap == max number of balls
        dp[i][j] rerpesents uptoith max run can be made using j balls
        1st row and 1st col value is zero as at 0 ball ,no run and 0 player also 0 run
        */
        for(int i =1;i<dp.length;i++){//starting from 1
            for(int j =1;j<dp[0].length;j++){//starting from 1
                if(j>= wts[i-1]){//if Tballs >= ith number of balls, then only i should bat   
                    int rCap = j - wts[i-1];//remaining balls after i bat
                    if(dp[i-1][rCap]+vals[i-1] > dp[i-1][j]){//if ("remaing run + ith run" > "when i does not run")
                        dp[i][j] = dp[i-1][rCap]+vals[i-1];
                    }else{
                        dp[i][j] = dp[i-1][j];
                    }
                }else{//i does not bat
                    dp[i][j] = dp[i-1][j];//immediate uper wala
                }
                
            }
        }

        System.out.println(dp[n][cap]);
    }
    
}
/*Sample Input

5
15 14 10 45 30
2 5 1 3 4
7

Sample Output
75 */