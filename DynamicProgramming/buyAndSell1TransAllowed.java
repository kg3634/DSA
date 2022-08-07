/*1. You are given a number n, representing the number of days.
2. You are given n numbers, where ith number represents price of stock on ith day.
3. You are required to print the maximum profit you can make if you are allowed a single transaction.

Constraints
0 <= n <= 20
0 <= n1, n2, .. <= 10 */
package DSA.DynamicProgramming;

import java.util.Scanner;

public class buyAndSell1TransAllowed {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        //Logic: past ka least point nikal le, present ka profit least point ke respect mn nikal le(buy- sell)
        //sake profit mn jo sabse jyada hoga use print

        int [] prices = new int[n];
        for(int i =0;i<prices.length;i++){
            prices[i] = scn.nextInt();
        }

        int lsf = Integer.MAX_VALUE;//least fo far
        int pist = 0;//profit if sold today
        int op = 0;//overall profit

        for( int i =0;i<prices.length;i++){
            if(prices[i] < lsf){
                lsf = prices[i];
            }

            pist = prices[i] - lsf;
            if(pist > op){
                op = pist;
            }
        }

        System.out.println(op);
    }
    
}
/*Sample Input

9
11
6
7
19
4
1
6
18
4

Sample Output
17 */