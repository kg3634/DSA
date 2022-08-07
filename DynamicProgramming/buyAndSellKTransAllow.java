/*1. You are given a number n, representing the number of days.
2. You are given n numbers, where ith number represents price of stock on ith day.
3. You are given a number k, representing the number of transactions allowed.
3. You are required to print the maximum profit you can make if you are allowed k transactions at-most.
Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) 
before opening another transaction (another buy).

Constraints
0 <= n <= 20
0 <= n1, n2, .. <= 10
0 <= k <= n / 2 */
package DSA.DynamicProgramming;

import java.util.Scanner;

public class buyAndSellKTransAllow {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int [] prices = new int[n];
        for(int i =0;i<prices.length;i++){
            prices[i] = scn.nextInt();
        }

        int k = scn.nextInt();
        /*Logic:images/buyAndSellKTrans1.png:making dp with row as trans and col as days 
        cal dp[t][d] - max profit till tth transaction till d days.(meaning)
        how: previous day t max vs (t-1 transactions till d-1 + tth transaction(prices[d] - prices[(0tod-1)] in loop) 
        */
        /*int [][] dp = new int [k+1][n];//row - transaction, col - days
        //TC(n*n*n) 
        for(int t =1;t<=k;t++){//transactions
            for(int d=1;d<n;d++){//days
                int max = dp[t][d-1];//t trasaction just previous day 

                for(int pd=0;pd<d;pd++){//previous days
                    int ptilltm1 = dp[t-1][pd];//profit till t-1 is const in previous row and loop is from 
                    //0 to d-1
                    int ptth = prices[d] - prices[pd];//profit of tth trasaction
                    if(ptilltm1 + ptth > max){
                        max = ptilltm1 + ptth ;
                    }
                }

                dp[t][d] = max;
            }
        }

        System.out.println(dp[k][n-1]);*/

        /*TC(n*n):images/buyAndSellKTrans2.png 
         we are running for loop in last row till d-1 days ,competing like v10 + p[4] - p[0],v11 +p[4] - p[1] 
         and so on, for v24, inlast row p[4] is common, so we can right like v10 - p[0],v11 -p[1] and sabka max nikal
         kar p4 add kar dnge and max + p4 vs dp[t][d-1] kar dnge,loop ni laga padega 
        */
        int[][] dp = new int [k+1][n];

        for(int t=1;t<=k;t++){//transa from 0 to k ==>k+1
            int max = Integer.MIN_VALUE;
            for(int d=1;d<n;d++){//days are 0 to d-1,not d
                if(dp[t-1][d-1]- prices[d-1] > max){//last row ka max nikal rahe h like v10 - p[0],v11 - p[1]
                    max = dp[t-1][d-1] - prices[d-1];
                }

                if(max + prices[d] > dp[t][d-1]){//max +p[4] vs tth trasanction at d-l day
                    dp[t][d] = max + prices[d];
                }else{
                    dp[t][d] = dp[t][d-1];
                }

            }
        }

        System.out.println(dp[k][n-1]);

        
    }
    
}
/*Sample Input

6
9
6
7
6
3
8
1

Sample Output
5 */