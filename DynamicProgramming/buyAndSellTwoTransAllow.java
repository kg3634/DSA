/*1. You are given a number n, representing the number of days.
2. You are given n numbers, where ith number represents price of stock on ith day.
3. You are required to print the maximum profit you can make if you are allowed two transactions at-most.
Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) 
before opening another transaction (another buy).

Constraints
0 <= n <= 20
0 <= n1, n2, .. <= 10 */
package DSA.DynamicProgramming;

import java.util.Scanner;

public class buyAndSellTwoTransAllow {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] prices = new int[n];
        for(int i =0;i<prices.length;i++){
            prices[i] = scn.nextInt();
        }
        
        /*Logic:images/buyAndSellTwoTransAllow.png:
        at every point calculate two things : 1) maximum profit if sold upto today(to the left): first calc 
        max profit if sold today(by calc least buying in the past) and compare it with max profit if sold today 
        in the past values(dp imidiate last value): output is max of both
        2) maximum profit if buy from today to end (to the right): first cal max profit if bought today(by cal 
        max selling in the future) and compare it with max profit if bought today in  all future values(dp 
        immediate future value):output is max of both
        add 1) and 2) at evrypoint and max of it will be answer
        */
        //max profit to the the left at each point calculation(point included)
        int mpist = 0;//max profit if sold today
        int leastsf = prices[0];//least so far
        int [] dpl = new int [n];//dp storing max profit to the left

        for(int i =1;i<prices.length;i++){
            if(prices[i] < leastsf){
                leastsf = prices[i];
            }

            mpist = prices[i] - leastsf;
            if(dpl[i-1]> mpist){
                dpl[i] = dpl[i-1];
            }else{
                dpl[i]= mpist;
            }
        }

        //max profit to the right at each point calculation(point inlcuded)
        int mpibt = 0;//max profit if boughht today
        int maxat = prices[n-1];//max after today
        int [] dpr = new int[n];//dp storing max profit to the right

        for(int i=n-2;i>=0;i--){
            if(prices[i] > maxat){
                maxat = prices[i];
            }

            mpibt = maxat - prices[i];
            if(dpr[i+1] > mpibt){
                dpr[i] = dpr[i+1];
            }else{
                dpr[i] = mpibt;
            }
        }

        int op =0;
        for(int i=0;i<prices.length;i++){
            if(dpl[i] + dpr[i] > op){
                op = dpl[i] + dpr[i] ;
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
30 */