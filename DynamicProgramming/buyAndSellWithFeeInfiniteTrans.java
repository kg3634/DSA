/*1. You are given a number n, representing the number of days.
2. You are given n numbers, where ith number represents price of stock on ith day.
3. You are give a number fee, representing the transaction fee for every transaction.
4. You are required to print the maximum profit you can make if you are allowed infinite transactions, but has 
to pay "fee" for every closed transaction.
Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) 
before opening another transaction (another buy).

Constraints
0 <= n <= 20
0 <= n1, n2, .. <= 10
0 <= fee <= 5 */
package DSA.DynamicProgramming;

import java.util.Scanner;


public class buyAndSellWithFeeInfiniteTrans {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n  = scn.nextInt();
        int [] prices = new int[n];
        for(int i =0;i<prices.length;i++){
            prices[i] = scn.nextInt();
        }

        int fee = scn.nextInt();
        /*Logic:images/buyandSellWithFee.png
        buying set profit mn 1 shares buy kar re h(net extra buy), selling set profit mn share sell kar re
        (net zero buy sell): for bsp, we are comparing (old ssp-buying curent share value) and old bsp.
        for ssp, old ssp with (old bsp +selling current share -fee).whinchever is higher, updaing it accordingly
        */
        int obsp = -prices[0];//old buying set profit
        int ossp = 0;//old selling set profit
        
        for(int i =1;i<prices.length;i++){
            int nbsp =0;
            int nssp =0;

            if(ossp-prices[i] > obsp){
                nbsp = ossp - prices[i];
            }else{
                nbsp = obsp;
            }

            if(obsp +prices[i] - fee > ossp){
                nssp = obsp + prices[i] -fee;
            }else{
                nssp = ossp;
            }

            //relevel
            obsp = nbsp;
            ossp = nssp;
        }

        System.out.println(ossp);
    }
    
}

/*Sample Input

12
10
15
17
20
16
18
22
20
22
20
23
25
3

Sample Output
13 */