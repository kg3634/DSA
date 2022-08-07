/*1. You are given a number n, representing the number of days.
2. You are given n numbers, where ith number represents price of stock on ith day.
3. You are required to print the maximum profit you can make if you are allowed infinite transactions.
Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) 
before opening another transaction (another buy)

Constraints
0 <= n <= 20
0 <= n1, n2, .. <= 10 */
package DSA.DynamicProgramming;

import java.util.Scanner;

public class buyAndSellInfiniteTransAllowed {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int [] prices = new int[n];

        for(int i =0;i<prices.length;i++){
            prices[i] = scn.nextInt();
        }

        int bd =0;//buy date
        int sd =0;//sell date
        int profit =0;

        //will ++ sd at every high, if low is there then first we will collect profit and then move both bd and sd
        //thus we wil lcollect profit at every upstrock

        for(int i=1;i<prices.length;i++){
            if(prices[i] >= prices[i-1]){
                sd++;
            }else{
                profit += prices[sd] - prices[bd];
                bd= sd =i; 
            }
        }
        profit += prices[sd] - prices[bd];//need to do it outside the loop to include last upstrock profit
        System.out.println(profit);

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
30 */