/*1. You are given a number n, representing the number of days.
2. You are given n numbers, where ith number represents price of stock on ith day.
3. You are required to print the maximum profit you can make if you are allowed infinite transactions, but have 
to cooldown for 1 day after 1 transaction
i.e. you cannot buy on the next day after you sell, you have to cooldown for a day at-least before buying again.
Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) 
before opening another transaction (another buy).

Constraints
0 <= n <= 20
0 <= n1, n2, .. <= 10 */
package DSA.DynamicProgramming;

import java.util.Scanner;

public class buyandSellWithCoolDownInfTrans {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int [] prices = new int[n];

        for(int i =0;i<prices.length;i++){
            prices[i] = scn.nextInt();
        }

        int obsp = - prices[0];//old bought state profit
        int ossp = 0;//sell state
        int ocsp =0;//cool state

        for(int i =1;i<prices.length;i++){
            int nbsp =0;
            int nssp=0;
            int ncsp=0;

            if(ocsp - prices[i] > obsp){//old cool state per buy kara
                nbsp = ocsp - prices[i];
            }else{
                nbsp = obsp;
            }

            if(obsp + prices[i] > ossp){//old buy state per sell kare to
                nssp = obsp + prices[i];
            }else{
                nssp = ossp;
            }

            if(ossp > ocsp){//cheking only sell state
                ncsp = ossp;
            }else{
                ncsp = ocsp;
            }

            obsp = nbsp;
            ossp = nssp;
            ocsp = ncsp;
        }

        System.out.println(ossp);

        //buyandSellCoolDown.png
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

Sample Output
19 */