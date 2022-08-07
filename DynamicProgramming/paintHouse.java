/*1. You are given a number n, representing the number of houses.
2. In the next n rows, you are given 3 space separated numbers representing the cost of painting nth house with 
red or blue or green color.
3. You are required to calculate and print the minimum cost of painting all houses without painting any 
consecutive house with same color.

Constraints
1 <= n <= 1000
0 <= n1red, n1blue, .. <= 1000 */
package DSA.DynamicProgramming;

import java.util.Scanner;

public class paintHouse {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();//no of houses
        int [][] arr = new int[n][3];//row houses,col-color

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                arr[i][j] = scn.nextInt();
            }
        }

        long [][] dp = new long[n][3];
        /*Logic: images/paintHouse.png
        dp[1][0] - 2 ghar tak paint krne ka min cost 2sre ghar per red painted hi ho(rule follow krte hue)
        dp[2][1] - 3 ghar tak paint karne ka min cost 3sre ghar per green painted hi ho(rule follow krte hue)
        like mincostadjques ,dp[il[j] = last row mn other two ka min + arr[i][j]
        final ans = last row ka min
         */

         dp[0][0] = arr[0][0];
         dp[0][1] = arr[0][1];
         dp[0][2] = arr[0][2];

         for(int i=1;i<arr.length;i++){
            dp[i][0] = arr[i][0]+Math.min(dp[i-1][1],dp[i-1][2]);
            dp[i][1] = arr[i][1]+Math.min(dp[i-1][0],dp[i-1][2]);
            dp[i][2] = arr[i][2]+Math.min(dp[i-1][1],dp[i-1][0]);
         }

         long ans = Math.min(dp[n-1][0],Math.min(dp[n-1][1],dp[n-1][2]));
         System.out.println(ans);



        
    }
    
}
/*Sample Input

4
1 5 7
5 8 4
3 2 9
1 2 4

Sample Output
8 */