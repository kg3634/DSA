/*1. You are given a number n.
2. You are required to print the number of binary strings of length n with no consecutive 0's.

Constraints
0 < n <= 45 */
package DSA.DynamicProgramming;

import java.util.Scanner;

public class countBinaryString {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
    
        /*array method - more space usage
        int [] dp0 = new int[n+1];
        int [] dp1 = new int[n+1];
    
        dp0[1] = 1;
        dp1[1] = 1;
    
        for(int i =2;i<=n;i++){
            dp0[i] = dp1[i-1];
            dp1[i] = dp0[i-1]+dp1[i-1];
        }
        
        System.out.println(dp0[n]+dp1[n]);*/

        /* images/countBinaryString.png: Storage and meaning: count of appropriate bs of length 3 ending 
        in zeros in one row and ones in second row */
        
        int oczeroes = 1;//old count zeroes
        int ocones = 1;//old count ones

        for(int i =2;i<=n;i++){
            int nczeroes = ocones;
            int ncones = oczeroes+ocones;

            ocones = ncones;
            oczeroes = nczeroes;
        }

        System.out.println(oczeroes+ocones);

    }

}
/*Sample Input

6

Sample Output
21 */
