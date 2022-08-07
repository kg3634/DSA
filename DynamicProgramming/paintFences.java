/*1. You are given a number n and a number k in separate lines, representing the number of fences and number of 
colors.
2. You are required to calculate and print the number of ways in which the fences could be painted so that not 
more than two consecutive  fences have same colors.

Constraints
1 <= n <= 10
1 <= k <= 10 */
package DSA.DynamicProgramming;

import java.util.Scanner;

public class paintFences {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();//no of fences
        int k = scn.nextInt();// no of colors

        /*images/paintFences.png: for n=1,no combina, for n=2
        same means -- n=3, upto 3 how many ways we can paint with no more than 2 consecutives but last 2 consecutives
        diff means -- upto 3 how many ways we can paint with no more than 2 consecutives but last 2 different
        */

        long same = k*1;//first k times then second ke pass only 1 option to match the same
        long diff = k*(k-1);//first k times * second apne ko chod kar k-1 times ways to make it diff
        long total = same + diff;

        for( int i =3;i<=n;i++){
            same = diff*1;//last ka diferent value as cant take same otherwise 3 consecutive same color
            diff = total*(k-1);//total walo men last wala chhod kar sare laga sakte
            total = same + diff;
        }

        System.out.println(total);
    }
}
/*Sample Input

8
3

Sample Output
3672 */