/*1. You are given a number n, representing the number of friends.
2. Each friend can stay single or pair up with any of it's friends.
3. You are required to print the number of ways in which these friends can stay single or pair up.
E.g.
1 person can stay single or pair up in 1 way.
2 people can stay singles or pair up in 2 ways. 12 => 1-2, 12.
3 people (123) can stay singles or pair up in 4 ways. 123 => 1-2-3, 12-3, 13-2, 23-1.

Constraints
0 <= n <= 20 */
package DSA.DynamicProgramming;

import java.util.Scanner;

public class friendsPairing {
    public static void main(String[] args) {
        //images/friendsPairing.png
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int [] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3;i<=n;i++){
            dp[i] = dp[i-1] + (i-1)*dp[i-2];//i mn se 1 ko single kar liya bache hue i-1 tarike se pair up 
            //ho jayenge + 1 ko pair up kar liye sab ke sath bache hue i-2 ways mn pair up ho jynge and sare
            //1 i-1 ke sath pair up kr sakta h and sabke pair up ways count same hi honge isliye i-1*f(i-2)
        }

        System.out.println(dp[n]);
    }
    
}
/*Sample Input

4

Sample Output
10 */