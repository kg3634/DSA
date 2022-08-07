/*1. You are given a number n and a number m separated by line-break representing the length and breadth of a 
m * n floor.
2. You've an infinite supply of m * 1 tiles.
3. You are required to calculate and print the number of ways floor can be tiled using tiles.

Constraints
1 <= n <= 100
1 <= m <= 50 */
package DSA.DynamicProgramming;

import java.util.Scanner;

public class tilingWithM1Tiles {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        //images/tilingWithM1Tiles.png
        int [] dp = new int[n+1];

        for(int i =1;i<=n;i++){
            if(i<m){//images/tilingM1basecases.png
                dp[i] = 1;
            }else if (i==m){
                dp[i] = 2;
            }else{
                dp[i] = dp[i-1]+dp[i-m];
            }
        }

        System.out.println(dp[n]);

    }
    
}
/*Sample Input

39
16

Sample Output
61 */