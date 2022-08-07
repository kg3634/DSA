/*1. You are given a number n representing the length of a floor space which is 2m wide. It's a 2 * n board.
2. You've an infinite supply of 2 * 1 tiles.
3. You are required to calculate and print the number of ways floor can be tiled using tiles.

Constraints
1 <= n <= 100 */
package DSA.DynamicProgramming;

import java.util.Scanner;

public class tilingWith21tiles {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        /*images/tilingWth21tiles.png 
        source destination problem: source - khali floor ,des - tiled floor: 
        tile ko vertical(f(n-1 ways)) or horizontal(f(n-2) ways)rakh sakte h , total ways add both
        */

        int [] dp = new int[n+1];
        //base cases:
        dp[1] = 1;//single tiles ways
        dp[2] = 2;//2 tiles 2 ways(h,v)

        for(int i =3;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];//became febonnacci
        }

        System.out.println(dp[n]);
    }
    
}
/*Sample Input

8

Sample Output
34 */