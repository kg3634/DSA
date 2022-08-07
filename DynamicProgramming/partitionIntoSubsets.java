/*1. You are given a number n, representing the number of elements.
2. You are given a number k, representing the number of subsets.
3. You are required to print the number of ways in which these elements can be partitioned in k non-empty subsets.
E.g.
For n = 4 and k = 3 total ways is 6
12-3-4
1-23-4
13-2-4
14-2-3
1-24-3
1-2-34

Constraints
0 <= n <= 20
0 <= k <= n */
package DSA.DynamicProgramming;

import java.util.Scanner;

public class partitionIntoSubsets {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();

        /*images/partitionIntoSubsets.png: n ko chod ke n-1 logo ko k-1 teams mn bata ==>dp[n-1][k-1](no mutiply
        as nth bnda k vi team mn same ways mn hi batega),then n-1 ko k teams mn bata ==> dp[n-1][k]*k (multiply
        as nth banda k team mn k ways mn bat sakta h )*/

        //base cases
        if(n==0||k==0||n<k){//3 logo ko 4 team mn ni bat sakte
            System.out.println(0);
            return;
        }

        long[][] dp = new long[k+1][n+1];//row -teams,col = people
        for(int t =1;t<=k;t++){
            for(int p =1;p<=n;p++){
                if(p<t){
                    dp[t][p] = 0;
                }else if(p==t){//people = teams, then only 1 way
                    dp[t][p] = 1;
                }else{//formula
                    dp[t][p] = dp[t-1][p-1] + dp[t][p-1]*t;
                }
            }
        }

        System.out.println(dp[k][n]);
    }
    
}
/*Sample Input

4
3

Sample Output
6 */